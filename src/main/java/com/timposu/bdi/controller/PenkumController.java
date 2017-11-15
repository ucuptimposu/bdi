package com.timposu.bdi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.timposu.bdi.model.Penkum;
import com.timposu.bdi.model.Penomoran;
import com.timposu.bdi.property.PenkumProperty;
import com.timposu.bdi.service.KelurahanService;
import com.timposu.bdi.service.PenkumService;
import com.timposu.bdi.service.PenomoranService;

@Controller
@RequestMapping("/penkum")
public class PenkumController {
	
	@Autowired
	private PenkumService penkumService;
	@Autowired
	private PenomoranService penomoranService;
	@Autowired
	private KelurahanService kelurahanService;
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://temp//";
	
	// Konventer String ke Date
	@InitBinder
	public void initConventer(WebDataBinder binder) {
		binder.registerCustomEditor(Penkum.class, new PenkumProperty(penkumService));
        binder.registerCustomEditor(Date.class, 
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
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
	
	@GetMapping("/form")
	public String formPenkum(Model m) {
		
		m.addAttribute("daftarKelurahan", kelurahanService.list());
		m.addAttribute("penkum", new Penkum());
		
		return "penkum/form";
	}
	
	@GetMapping("/form/update")
	public String formUpdatePenkum(@RequestParam(value = "id", required = true) String id,
			Model m) {
	
			m.addAttribute("daftarKelurahan", kelurahanService.list());
			Penkum penkum = penkumService.getPenkum(id);
			if (penkum != null) {
				m.addAttribute("penkum", penkum);
			} 
		
		return "penkum/formUpdate";
	}
	
	@PostMapping("/form")
	public String prosesForm(Model m, @Valid @ModelAttribute Penkum penkum,
			BindingResult bindingResult,
			@RequestParam(name = "img1", required = false) MultipartFile file) {
			
		m.addAttribute("daftarKelurahan", kelurahanService.list());
		Penomoran p = penomoranService.getNomor(1);
		Integer currentNumber = p.getNomorPenkum() + 1;
		
		if (penkum.getNomor() == null) {
			penkum.setNomor(currentNumber);
		}

		if (bindingResult.hasErrors()) {
			return "penkum/form";
		}
				
		penkumService.save(penkum);
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		if (penkum.getNomor() == currentNumber) {
			p.setNomorPenkum(currentNumber);
			penomoranService.save(p);
		}
		return "redirect:/penkum/list?tahun=now";
	}
	
	@PostMapping("/form/update")
	public String prosesFormUpdate(Model m, @Valid @ModelAttribute Penkum penkum,
			BindingResult bindingResult, 
			@RequestParam(name = "img1", required = false) MultipartFile file) {
			
		m.addAttribute("daftarKelurahan", kelurahanService.list());
		Penomoran p = penomoranService.getNomor(1);
		Integer currentNumber = p.getNomorPenkum() + 1;
		
		if (bindingResult.hasErrors()) {
			return "penkum/formUpdate";
		}
				
		penkumService.update(penkum);
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		if (penkum.getNomor() == currentNumber) {
			p.setNomorPenkum(currentNumber);
			penomoranService.save(p);
		}
		return "redirect:/penkum/list?tahun=now";
	}
	
	@GetMapping("/hapus")
	public String hapusPenkum(@RequestParam(value = "id") String id) {
		penkumService.delete(id);
		return "redirect:/penkum/list?tahun=now";
	}
}
