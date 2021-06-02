package com.cognizant.server.main.user;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class UserResource   
{  
@Autowired  
private UserDaoService service;  
@GetMapping("/users")  
public List<User> retriveAllUsers()  
{  
return service.findAll();  
}  
//retrieves a specific user detail  
@GetMapping("/users/{id}")  
public User retriveUser(@PathVariable int id)  
{  
return service.findOne(id);  
}
//method that posts a new user detail using post method in postman   
@PostMapping("/users")  
public User createUser(@RequestBody User user)  
{  
User sevedUser=service.save(user); 
return user;
} 
//method that delete a user resource  
//if the user deleted successfully it returns status 200 OK otherwise 404 Not Found  
@DeleteMapping("/users/{id}")  
public void deleteUser(@PathVariable int id)  
{  
User user= service.deleteById(id);  
}
@PutMapping("/users/{id}")
public User abc(@PathVariable int id,@RequestBody User user) {
	User a=service.findOne(id);
	a.setName(user.getName());
	final User update=service.save(a);
	return a;
}
}  
  

 