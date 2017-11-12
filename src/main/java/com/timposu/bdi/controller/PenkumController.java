package com.timposu.bdi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timposu.bdi.service.PenkumService;

@Controller
@RequestMapping("/penkum")
public class PenkumController {
	
	@Autowired
	private PenkumService penkumService;
	
	@GetMapping("/list")
	public String list(@RequestParam(value = "tahun", required = true) String tahun,
			Model model) throws Exception {
		
		if (tahun.equals("now")) {
			DateFormat formatter = new SimpleDateFormat("yyyy");
			tahun = formatter.format(new Date());
		}
		
		model.addAttribute("daftarPenkum", penkumService.list(tahun));
		model.addAttribute("tahun", tahun);
		return "penkum/list";
	}
}
