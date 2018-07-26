package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;


@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/nurse")
	public String index(Model model) {
		model.addAttribute("patients", patientService.findAll());
		return "patient_list";
	}

	@GetMapping("/patient/create")
	public String create(Model model) {
		model.addAttribute("patient", new Patient());
		return "patient_form";
	}

	@GetMapping("/patient/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("patient", patientService.findById(id));
		return "patient_form";
	}

	@PostMapping("/patient/save")
	public String save(@Valid Patient patient, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "patient_form";
		}
		patientService.save(patient);
		redirect.addFlashAttribute("success", "Saved patient successfully!");
		return "redirect:/nurse";
	}

	@GetMapping("/patient/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		patientService.delete(id);
		redirect.addFlashAttribute("success", "Deleted patient successfully!");
		return "redirect:/nurse";
	}

	@GetMapping("/patient/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/nurse";
		}

		model.addAttribute("patients", patientService.search(s));
		return "patient_list";
	}
}