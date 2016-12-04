package pens.ac.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pens.ac.id.model.Soal;
import pens.ac.id.service.ServiceBidang;
import pens.ac.id.service.ServiceSoal;
import pens.ac.id.service.ServiceTingkat;

@Controller
public class ControllerSoal {
	@Autowired
	private ServiceBidang serviceBidang;
	@Autowired
	private ServiceTingkat serviceTingkat;
	@Autowired
	private ServiceSoal serviceSoal;
	
	@RequestMapping(value="/soal/list", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("soalmodel", serviceSoal.getAll());
		return "/soal/soal-list";
	}
	
	@RequestMapping(value = "/soal/input", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("bidangmodels", serviceBidang.getAll());
		model.addAttribute("tingkatmodels", serviceTingkat.getAll());
		model.addAttribute("soal", new Soal());
		return "/soal/soal-input";
	}
	
	@RequestMapping(value = "/soal/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, Model model) {
		Soal soal = serviceSoal.getById(Long.parseLong(id));
		model.addAttribute("soal", soal);
		model.addAttribute("bidangmodels", serviceBidang.getAll());
		model.addAttribute("tingkatmodels", serviceTingkat.getAll());
		return "/soal/soal-edit";
	}
	
	@RequestMapping(value = "/soal/save", method = RequestMethod.POST)
	public String submit(@ModelAttribute Soal soal) {
		try {
			if(serviceSoal.update(soal)){}
			else{serviceSoal.save(soal);}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/soal/list";
	}
	

	@RequestMapping(value = "/soal/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable String id) {
		serviceSoal.delete(Long.parseLong(id));
		return "redirect:/soal/list";
	}
}
