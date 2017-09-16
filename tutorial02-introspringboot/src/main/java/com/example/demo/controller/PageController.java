package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PageController
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
	
	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value="a", required=true, defaultValue = "0") String a, Model model, @RequestParam(value = "b", required = true, defaultValue="0") String b, Model model2, Model modelHasil) {
		model.addAttribute("a", a);
		model2.addAttribute("b",b);
		int angka = Integer.parseInt(a);
		int angka2 = Integer.parseInt(b);
		int hasil = angka*angka2;
		modelHasil.addAttribute("hasil",hasil);
		return "perkalian";
	}
	
//	@RequestMapping("/greeting/{name}")
//	public String greetingPath (@PathVariable String name, Model model)
//	{
//	model.addAttribute("name", name);
//	return "greeting";
//	}

	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		
		return "greeting";
	}

//	 @RequestMapping("/greeting")
//	 public String greeting ( @RequestParam (value = "name", defaultValue="dunia") String name , Model model) {
//		 model.addAttribute ("name", name );
//		 return "greeting";
//	 }
}