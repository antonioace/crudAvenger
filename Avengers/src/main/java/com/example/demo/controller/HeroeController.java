package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.IEstado;
import com.example.demo.dao.IGenero;
import com.example.demo.dao.IHeroe;
import com.example.demo.model.Heroe;

@Controller
public class HeroeController {

	@Autowired
	IHeroe hDAO;
	@Autowired
	IEstado eDAO;
	@Autowired
	IGenero gDAO;


	@GetMapping({ "/", "/index" })
//@RequestMapping
	public String List(Model model) {
		model.addAttribute("listaHeroes", hDAO.findAll());
	
		return "index";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id, Model model) {
		// Optional<Heroe> heroe = hDAO.findById(id);
		hDAO.deleteById(id);
		return "redirect:/index";
	}

	@RequestMapping(value = "/crear/")
	public String crear(Model model) {
		Heroe heroe1 = new Heroe();
		model.addAttribute("heroe", heroe1);
		model.addAttribute("listaGenero", gDAO.findAll());
		model.addAttribute("listaEstado", eDAO.findAll());
		return "formularioHeroe";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Validated Heroe heroe, Model model) {
		hDAO.save(heroe);
	
		System.out.println(heroe.getHeroe());
		return "redirect:/index";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Integer id, Model model) {
		Heroe heroe = hDAO.findById(id).orElse(null);
		model.addAttribute("heroe", heroe);
		model.addAttribute("listaGenero", gDAO.findAll());
		model.addAttribute("listaEstado", eDAO.findAll());
		return "formularioHeroe";

	}
}
