package com.ecommerce.login.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.login.model.User;
import com.ecommerce.login.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping(path = "/ecommerce/login")
public class LogInController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path="/allusers")
	public @ResponseBody List<User> getAllUsers() {
		System.out.println("get all users");
		List<User> users = userRepository.findAll();
		System.out.println("get all users:"+users.size());
		users.forEach(user->System.out.println(user.getUserName() + user.getPassWord()));
		return userRepository.findAll();
	}
	
	
	  @GetMapping("/getusers/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
		  System.out.println("getusers service:"+userId);
	        User user = userRepository.findOne(userId);
	        if(user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(user);
	    }

	    @PostMapping("/createusers")
	    public User createUser(@Valid @RequestBody User user )  {
	        return userRepository.save(user);
	    }

	    @PutMapping("/updateusers/{olduname}")
	    public void updateUser(@PathVariable(value = "olduname") String olduname,@Valid @RequestBody User userDetails) 
	    {
	    	System.out.println("olduname from service:"+olduname);
	    	
	    	List<User> users = userRepository.findAll();
	    System.out.println("users from service:"+users.size());
	    	for(User usr:users)
	    	{
	    		if(usr.getUserName().equals(olduname))
	    		{
	    			System.out.println("usersname is equal");
	    			 usr.setUserName(userDetails.getUserName());
	    		      usr.setPassWord(userDetails.getPassWord());
	    		       userRepository.save(usr);
	    		}
	    	}
	    }

	    @DeleteMapping("/deleteusers/{username}")
	    public ResponseEntity<User> deleteUser(@PathVariable(value = "username") String username) {	       
	     	
	    	List<User> users = userRepository.findAll();
	    System.out.println("users from service:"+users.size());
	    	for(User usr:users)
	    	{
	    		if(usr.getUserName().equals(username))
	    		{
	    			System.out.println("usersname is equal");
	    			
	    		       userRepository.delete(usr);
	    		}
	    	}
	        return ResponseEntity.ok().build();
	    }

}
