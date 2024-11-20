package com.sahal.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahal.model.UserInfo;
import com.sahal.model.Users;
import com.sahal.repository.UserRepo;
import com.sahal.repository.UseraddRepo;
import com.sahal.service.UserDetails;

@Controller
public class HomeController {
	
	@Autowired
	UserDetails userDetails;
	@Autowired
	UserRepo userRepo;
	@Autowired
	UseraddRepo userAddRepo;
	@GetMapping({"","/"})
	public String home() {
		
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	  @GetMapping("/dashboard")
	    public String dashboard() {
	        return "dashboard"; // This maps to dashboard.html in the templates folder
	    }
	  @GetMapping("/add")
	    public String addHome() {
	       
		  return "addUser"; 
	    }
	  @PostMapping("/create")
	  public String createUser(
			    @RequestParam("name") String name,
			    @RequestParam("number") Long number, // Use Long for larger numbers
			    @RequestParam("installedDate") LocalDate installedDate,
			    @RequestParam("address") String address
			) {
		  
			    // Create a new UserInfo object manually
			    UserInfo user = new UserInfo();
			    user.setName(name);
			    user.setNumber(number);
			    user.setInstalledDate(installedDate);
			    user.setAddress(address);

			    // Debug to verify the data
			    System.out.println("User Object: " + user);

			    // Save the user to the database
			    userDetails.addUser(user);

			    return "redirect:/dashboard";
			}

	  @GetMapping("/getAll")
	  @ResponseBody 
	  public List<UserInfo> getAll(){
		 
		  //return userDetails.getUser();
		  return userAddRepo.findAll();		  
	  }
	  @PostMapping("/update")
	  public String updateUser(UserInfo updatedUser) {
		  //System.out.println(updatedUser);
	      userAddRepo.save(updatedUser); // JPA automatically updates the user if ID exists
	      return "redirect:/dashboard"; // Redirect back to the dashboard after updating
	  }
	  @PostMapping("/delete")
	  public String deleteUser(UserInfo deleteUser) {
		  //System.out.println(deleteUser);
	      userAddRepo.delete(deleteUser); // JPA automatically updates the user if ID exists
	      return "redirect:/dashboard"; // Redirect back to the dashboard after updating
	  }
	  
}

