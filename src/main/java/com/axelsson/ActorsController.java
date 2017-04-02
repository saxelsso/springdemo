package com.axelsson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// template processing
import org.springframework.ui.Model;

// jdbc classes
import java.sql.*;
import org.postgresql.*;
import java.util.*;

@Controller
public class ActorsController {
    
    @RequestMapping("/actors")
    public String index(@RequestParam(value="name", required=false, defaultValue="") String result, Model model) {

	// Add data to the model object
	model.addAttribute("listofactors", this.getActorsFromDatabase());
	// Tell Thymeleaf which HTML template to use when generating the view
        return "actors"; 

    }
    
    @RequestMapping("/json/actors")
    public @ResponseBody List index_json(@RequestParam(value="name", required=false, defaultValue="") String result) {

        // generate JSON directly through Spring/JSON framework 
        return this.getActorsFromDatabase();

    }
    
    private List getActorsFromDatabase() {
    	// view-independent controller that retrieves data via JDBC and populates the List object
    
      	Connection conn = null;
   	Statement stmt = null;
   	List myList = new ArrayList();

	try {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost/demodb?user=postgres&password=newsci00&ssl=true";
		conn = DriverManager.getConnection(url);

      		stmt = conn.createStatement();
      		String sql;
      		sql = "SELECT id, name FROM demotable";
      		ResultSet rs = stmt.executeQuery(sql);

      		//Extract data from result set
      		while(rs.next()){
      		
      			Actor myActor = new Actor(rs.getString("id"), rs.getString("name"));
        		
          		myList.add(myActor);

      		}
      		//Clean-up environment
      		rs.close();
      		stmt.close();
      		conn.close();      
	
	}catch(SQLException se){
		se.printStackTrace();
  	}catch(Exception e){
      		//Handle errors for Class.forName
      		e.printStackTrace();
   	}finally{
      		//finally block used to close resources
      		try{
         		if(stmt!=null)
            			stmt.close();
      		}catch(SQLException se2){
      		}// nothing we can do
      		try{
         		if(conn!=null)
            			conn.close();
      		}catch(SQLException se){
        			se.printStackTrace();
      		}
   	}
   	
   	return myList;
    
    }
    
}
