/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain.web;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gilberto
 */
@Controller
@RequestMapping(value = "tvseries")
public class MainController {
    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public String getIndex(Model model){
        model.addAttribute("msg", "Hello index");
        model.addAttribute("today", new Date());
        System.out.println("***********************************");
        return "index";
    }
}
