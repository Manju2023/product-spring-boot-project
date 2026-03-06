package com.example.kiransircrudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.kiransircrudspring.entity.Product;
import com.example.kiransircrudspring.repository.Productrepo;

@Controller
public class ProductController {

	@Autowired
	Productrepo repo;
	
	@GetMapping("/")
	public String loadMain() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addMain() {
		return "add";
	}
	
	@PostMapping("/insert")
	public String insert(RedirectAttributes redirectAttributes, Product product) {
		repo.save(product);
		
		redirectAttributes.addFlashAttribute("message", "data inserted sucessfully");
		return "redirect:/";
	}
	
	@GetMapping("/manage")
	public String addmanage(ModelMap map) {
		map.put("products", repo.findAll());
		return "view";
	}
	
	@GetMapping("/edit")
	public String loadEdit(ModelMap map,@RequestParam("id") Integer id) {
		map.put("product", repo.findById(id).orElseThrow());
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(RedirectAttributes redirectAttributes, Product product) {
		repo.save(product);
		
		redirectAttributes.addFlashAttribute("message", "data updated sucessfully");
		return "redirect:/";
	}
	
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirectAttributes, @RequestParam("id") Integer id) {
		repo.deleteById(id);
		
		redirectAttributes.addFlashAttribute("message", "data deleted sucessfully");
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
}
