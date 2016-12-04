package pens.ac.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pens.ac.id.model.Bidang;
import pens.ac.id.service.ServiceBidang;

@Controller
public class ControllerBidang {
	@Autowired
	private ServiceBidang serviceBidang;
	
	@RequestMapping(value="/bidang/list", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("bidangmodel", serviceBidang.getAll());
		return "/bidang/bidang-list";
	}
	
	
	@RequestMapping(value = "/bidang/input", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("bidang", new Bidang());
		return "/bidang/bidang-input";
	}

	@RequestMapping(value = "/bidang/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		Bidang bidang = serviceBidang.getById(Long.parseLong(id));
		model.addAttribute("bidang", bidang);
		return "/bidang/bidang-edit";
	}
	
	@RequestMapping(value = "/bidang/save", method = RequestMethod.POST)
	public String submit(@ModelAttribute Bidang bidang) {
		if(serviceBidang.update(bidang)){}
		else{serviceBidang.save(bidang);}
		return "redirect:/bidang/list";
	}
	

	@RequestMapping(value = "/bidang/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable String id) {
		serviceBidang.delete(Long.parseLong(id));
		return "redirect:/bidang/list";
	}
	
	
}
