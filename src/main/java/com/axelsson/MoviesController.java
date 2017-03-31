package com.axelsson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// template processing
import org.springframework.ui.Model;

@Controller
public class MoviesController {
    
    @RequestMapping("/movies")
    public String index(@RequestParam(value="name", required=false, defaultValue="") String result, Model model) {
        
        result = "Not implemented yet!";
        
        // populate model 
	model.addAttribute("listofmovies", result);
        
        // dispatch to template
        return "movies";
    }
    
}
