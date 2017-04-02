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
    
    
    @RequestMapping("/movies")
    public String index(@RequestParam(value="name", required=false, defaultValue="empty") String result, Model model) {
        
	List myList = new ArrayList();
	
	Movie myMovie = new Movie (1, "Matrix");
	myList.add(myMovie);
	
	Movie myMovie2 = new Movie (2, "Batman");
	myList.add(myMovie2);
	
	// prepare model object for HTML template
	model.addAttribute("listofmovies", myList);
        
        // dispatch via HTML template
        return "movies";
    }
    
    @RequestMapping("/json/movies")
    public @ResponseBody List index_json(@RequestParam(value="name", required=false, defaultValue="empty") String result) {
        
	List myList = new ArrayList();
	
	Movie myMovie = new Movie (1, "Matrix");
	myList.add(myMovie);
	
	Movie myMovie2 = new Movie (2, "Batman");
	myList.add(myMovie2);
        
        // dispatch as JSON directly
        return myList;
    }

    
}
