/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvc.controllers;

import com.mycompany.springmvc.beans.Pracownik;
import com.mycompany.springmvc.dao.PracownikDao;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PracownikController {
    @Autowired
    PracownikDao dao;

    @RequestMapping("/addForm")
    public String showform(Model m){
        m.addAttribute("command", new Pracownik());
        return "addForm";
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("pr") Pracownik pr){
        dao.save(pr);
        return "redirect:/viewAll";//przekierowanie do widoku /viewAll
    }
 
    @RequestMapping("/viewAll")
    public String viewAll(Model m){
        List<Pracownik> list=dao.getAll();
        m.addAttribute("list",list);
        return "viewAll"; 
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewAll";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Pracownik pracownik = dao.getPracownikById(id);
        m.addAttribute("command", pracownik);
        return "editForm";
    }
    
    @RequestMapping(value="/edit/editSave", method=RequestMethod.POST)
    public String editSave(@ModelAttribute("pracownik") Pracownik pracownik){
        dao.update(pracownik);
         return "redirect:/viewAll";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req,
                                    Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
