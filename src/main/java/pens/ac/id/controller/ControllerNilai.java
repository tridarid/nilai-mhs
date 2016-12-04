package pens.ac.id.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pens.ac.id.model.Nilai;
import pens.ac.id.service.ServiceNilai;

/**
 * Created by indratir on 23/11/16.
 */
@Controller
public class ControllerNilai {
    @Autowired
    private ServiceNilai serviceNilai;

    @RequestMapping(value="/nilai/list", method=RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("nilaimodel", serviceNilai.getAll());
        return "/nilai/nilai-list";
    }

    @RequestMapping(value="/nilai/input", method=RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("nilai", new Nilai());
        return "/nilai/nilai-input";
    }

    @RequestMapping(value="/nilai/edit/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable String id, Model model){
        Nilai nilai = serviceNilai.getById(Long.parseLong(id));
        model.addAttribute("nilai", nilai);
        return "/nilai/nilai-edit";
    }

    @RequestMapping(value="/nilai/save", method=RequestMethod.POST)
    public String save(@ModelAttribute Nilai nilai){
        if (serviceNilai.update(nilai)){}
        else {serviceNilai.save(nilai);}
        return "redirect:/nilai/list";
    }

    @RequestMapping(value="/nilai/delete/{id}", method=RequestMethod.POST)
    public String delete(@PathVariable String id){
        serviceNilai.delete(Long.parseLong(id));
        return "redirect:/nilai/list";
    }

}
