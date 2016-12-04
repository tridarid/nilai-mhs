package pens.ac.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pens.ac.id.model.Tingkat;
import pens.ac.id.service.ServiceTingkat;

@Controller
public class ControllerTingkat {
	@Autowired
	private ServiceTingkat serviceTingkat;
	
	@RequestMapping(value="/tingkat/list", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("tingkatmodel", serviceTingkat.getAll());
		return "/tingkat/tingkat-list";
	}
	
	
	@RequestMapping(value = "/tingkat/input", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tingkat", new Tingkat());
		return "/tingkat/tingkat-input";
	}
	
	@RequestMapping(value = "/tingkat/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		Tingkat tingkat = serviceTingkat.getById(Long.parseLong(id));
		model.addAttribute("tingkat", tingkat);
		return "/tingkat/tingkat-edit";
	}
	
	@RequestMapping(value = "/tingkat/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Tingkat tingkat) {
		if(serviceTingkat.update(tingkat)){}
		else{serviceTingkat.save(tingkat);}
		return "redirect:/tingkat/list";
	}
	
	@RequestMapping(value = "/tingkat/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable String id) {
		serviceTingkat.delete(Long.parseLong(id));
		return "redirect:/tingkat/list";
	}
	
	
}
