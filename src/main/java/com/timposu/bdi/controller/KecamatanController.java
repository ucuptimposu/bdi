package com.timposu.bdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timposu.bdi.service.KecamatanService;

@Controller
@RequestMapping(value = "/kecamatan")
public class KecamatanController {
	
	@Autowired
	private KecamatanService ks;

	@GetMapping("/list")
	public String listKecamatan(Model model) {
		model.addAttribute("daftarKecamatan", ks.list());
		return "kecamatan/list";
	}
	
}
