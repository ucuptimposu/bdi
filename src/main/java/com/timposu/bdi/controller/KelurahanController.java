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

import com.timposu.bdi.model.Kelurahan;
import com.timposu.bdi.service.KecamatanService;
import com.timposu.bdi.service.KelurahanService;

@Controller
@RequestMapping(value = "/kelurahan")
public class KelurahanController {

	@Autowired
	private KelurahanService ks;
	@Autowired
	private KecamatanService kcs;
	
	@GetMapping("/")
	public String listKelurahan(Model m) {
		m.addAttribute("daftarKelurahan", ks.list());
		return "kelurahan/daftar";
	}
	
	@GetMapping("/form")
	public String formKelurahan(@RequestParam(value = "id", required = false) Integer id,
			Model m) {
		
		m.addAttribute("daftarKecamatan", kcs.list());
		m.addAttribute("kelurahan", new Kelurahan());
		
		if (id != null) {
			Kelurahan k = ks.getKelurahan(id);
			if (k != null) {
				m.addAttribute("kelurahan", k);
			}
		}
		return "kelurahan/form";
	}
	
	@PostMapping("/form")
	public String prosesForm(Model m, @Valid @ModelAttribute Kelurahan kelurahan, 
			BindingResult bindingResult) {
		System.out.println(kelurahan.getNamaKelurahan());
		m.addAttribute("daftarKecamatan", kcs.list());
		
		if (bindingResult.hasErrors()) {
			return "kelurahan/form";
		}
		ks.save(kelurahan);
		return "redirect:/kelurahan/";
	}
	
	@GetMapping("/hapus")
	public String hapusKelurahan(@RequestParam(value = "id") Integer id) {
		ks.delete(id);
		return "redirect:/kelurahan/";
	}
}
