package com.axelsson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

// HTML template processing
import org.springframework.ui.Model;

@Controller
public class MoviesController {
    
    @RequestMapping("/movies_json")
    public @ResponseBody List index_json(@RequestParam(value="name", required=false, defaultValue="empty") String result) {
        
	List myList = new ArrayList();
	Movie myMovie = new Movie (1, "Matrix");
	myList.add(myMovie);	
	Movie myMovie2 = new Movie (2, "Batman");
	myList.add(myMovie2);
   
        // dispatch directly as JSON, no HTML template needed
        return myList;
    }
    
    @RequestMapping("/movies")
    public String index(@RequestParam(value="name", required=false, defaultValue="empty") String result, Model model) {
        
	List myList = new ArrayList();	
	Movie myMovie = new Movie (1, "Matrix");
	myList.add(myMovie);	
	Movie myMovie2 = new Movie (2, "Batman");
	myList.add(myMovie2);
	
	// populate model with myList
	model.addAttribute("listofmovies", myList);        
        // dispatch to HTML template
        return "movies";
    }
    
}
