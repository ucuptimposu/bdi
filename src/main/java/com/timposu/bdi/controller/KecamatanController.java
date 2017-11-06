package com.timposu.bdi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timposu.bdi.model.Kecamatan;
import com.timposu.bdi.service.KecamatanService;

@Controller
@RequestMapping(value = "/kecamatan")
public class KecamatanController {
	
	@Autowired
	private KecamatanService ks;

	@GetMapping("/")
	public String listKecamatan(Model model) {
		model.addAttribute("daftarKecamatan", ks.list());
		return "kecamatan/daftar";
	}
	
	@GetMapping("/form")
	public String formKecamatan(@RequestParam(value = "id", required = false) Integer id,
			Model m) {
		
		m.addAttribute("kecamatan", new Kecamatan());
		
		if (id != null) {
			Kecamatan k = ks.getKecamatan(id);
			if (k != null) {
				m.addAttribute("kecamatan", k);
			}
		}
		return "kecamatan/form";
	}
	
	@PostMapping("/form")
	public String prosesForm(@Valid @ModelAttribute Kecamatan k, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "kecamatan/form";
		}
		ks.save(k);
		return "redirect:/kecamatan/";
	}
	
	@GetMapping("/hapus")
	public String hapusKecamatan(@RequestParam(value = "id") Integer id) {
		ks.delete(id);
		return "redirect:/kecamatan/";
	}
	
}
