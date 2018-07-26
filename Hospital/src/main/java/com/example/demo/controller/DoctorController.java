package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.DoctorService;
import com.example.demo.service.HistoryService;
import com.example.demo.service.PatientService;
import com.example.demo.service.UserService;
import com.example.demo.utils.CreatePdf;
import com.example.demo.utils.DownloadPdf;
import com.example.demo.utils.WebUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.demo.model.AppUser;
import com.example.demo.model.History;
import com.example.demo.model.Patient;
import com.example.demo.model.Treatment;
import com.example.demo.model.TreatmentPatient;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private UserService userService;

	@Autowired
	private HistoryService historyService;

	@GetMapping(value = { "/doctor" })
	public String index(Model model) {
		System.out.println("/doctor");
		ArrayList<Treatment> listTreatment = (ArrayList<Treatment>) doctorService.findAll();
		ArrayList<TreatmentPatient> list_result = new ArrayList<>();
		ArrayList<Patient> patients = (ArrayList<Patient>) patientService.findAll();

		for (int i = 0; i < listTreatment.size(); i++) {
			TreatmentPatient obj = new TreatmentPatient();
			Treatment treatment = listTreatment.get(i);
			Optional<Patient> p = patientService.findById(treatment.getId_patient());

			obj.setId(treatment.getId());
			obj.setId_patient(treatment.getId_patient());
			obj.setName(p.get().getName());
			obj.setHod(treatment.getHod());
			obj.setAllergic_medicine(treatment.getAllergic_medicine());
			list_result.add(obj);
		}
		model.addAttribute("list_result", list_result);
		model.addAttribute("patients", patients);
		return "doctorPage";
	}

	@RequestMapping(value = { "/doctor/create_treatment/{id_patient}" })
	public String createTreatment(@PathVariable int id_patient, Model model, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		String userName = loginedUser.getUsername();
		ArrayList<AppUser> appUser = (ArrayList<AppUser>) userService.search(userName);
		System.out.println("user id ---------------" + appUser.get(0).getUserId());

		Optional<Patient> p = patientService.findById(id_patient);
		Patient patient = p.get();
		Treatment treatment = new Treatment();
		treatment.setId_patient(patient.getId());

		model.addAttribute("treatment", treatment);
		model.addAttribute("title_page", "Create a new treatment");
		model.addAttribute("appUser", appUser.get(0));
		return "createTreatment";
	}

	@PostMapping(value = { "/doctor/saveOrUpdateTreatment/{user_id}" })
	public String save(@PathVariable int user_id, @Valid Treatment treatment, BindingResult result,
			RedirectAttributes redirect) {
		System.out.println(treatment.toString());
		if (result.hasErrors()) {
			return "redirect:/create_treatment";
		}
		doctorService.save(treatment);
		if (treatment.getId() == 0) {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			ArrayList<Treatment> treatments = (ArrayList<Treatment>) doctorService.findAll();
			historyService.save(new History(user_id, treatments.get(treatments.size() - 1).getId(), time));
		} else {
			Timestamp time = new Timestamp(System.currentTimeMillis());
			historyService.save(new History(user_id, treatment.getId(), time));
		}
		redirect.addFlashAttribute("success", "Saved treatment successfully!");
		return "redirect:/doctor";
	}

	@RequestMapping(value = { "/doctor/edit_treatment/{id_treatment}" })
	public String editTreatment(@PathVariable int id_treatment, Model model, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		String userName = loginedUser.getUsername();
		ArrayList<AppUser> appUser = (ArrayList<AppUser>) userService.search(userName);
		System.out.println("user id ---------------" + appUser.get(0).getUserId());

		Optional<Treatment> t = doctorService.findById(id_treatment);
		Treatment treatment = t.get();

		model.addAttribute("treatment", treatment);
		model.addAttribute("title_page", "Edit treatment");
		model.addAttribute("appUser", appUser.get(0));
		return "createTreatment";
	}

	@RequestMapping(value = { "/doctor/download/{id_treatment}" })
	public String downloadTreatment(@PathVariable int id_treatment, Model model, HttpServletResponse response) {
		Optional<Treatment> t = doctorService.findById(id_treatment);
		Treatment treatment = t.get();
		Optional<Patient> p = patientService.findById(treatment.getId_patient());
		Patient patient = p.get();
		try {
			CreatePdf.create(patient, treatment);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			DownloadPdf.download(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "doctorPage";
	}
}
