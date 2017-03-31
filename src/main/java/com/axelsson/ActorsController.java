package com.axelsson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
         		//Retrieve by column name         		
          		myList.add(rs.getString("name"));

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
      		}//end finally try
   	}//end try

	// template processing
	model.addAttribute("listofactors", myList);

	// template processing
        return "actors"; 

    }
    
}
