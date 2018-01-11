package com.ecommerce.login.client.restclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.login.client.model.User;

@RestController
@RequestMapping(path = "/ecommerce/restclient")
public class EcommerceLoginServiceRestClient {
	
	
	RestTemplate resttemplate = new RestTemplate();
	
	@RequestMapping("/getUser/{id}")
	public User getMethod(@PathVariable(value = "id") Long id)
	{		
		System.out.println("getuser client:"+id);
		String url = "http://localhost:8080/E-CommerceLogInService/ecommerce/login/getusers/{id}";		
		User user = resttemplate.getForObject(url, User.class, id);
		System.out.println("username::"+user.getUserName());
		System.out.println("password::"+user.getPassWord());
		return user;
	}
	
	@RequestMapping("/createUser/{username}/{password}")
	public User createMethod(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password)
	{		
		System.out.println("createuser"+username +"pass"+ password);
		String url = "http://localhost:8080/E-CommerceLogInService/ecommerce/login/createusers";		
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		user = resttemplate.postForObject(url, user, User.class);
		System.out.println("username::"+user.getUserName());
		System.out.println("password::"+user.getPassWord());
		return user;
	}
	
	
	@RequestMapping("/updateUser/{olduname}/{username}/{password}")
	public void updateMethod(@PathVariable(value = "olduname") String olduname,@PathVariable(value = "username") String username,@PathVariable(value = "password") String password)
	{		
		System.out.println("updateuser:"+username +"  pass:"+ password+" oldusername:"+olduname);
		String url = "http://localhost:8080/E-CommerceLogInService/ecommerce/login/updateusers/{olduname}";			
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		resttemplate.put(url, user,olduname);
	}
	
	@RequestMapping("/deleteUser/{username}")
	public void deleteMethod(@PathVariable(value = "username") String username)
	{		
		System.out.println("deleteuser:"+username);
		String url = "http://localhost:8080/E-CommerceLogInService/ecommerce/login/deleteusers/{username}";	
		 Map<String, String> params = new HashMap<String, String>();
	     params.put("username",username);
		 resttemplate.delete(url,params);
	
	}

}
