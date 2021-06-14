package com.example.demo.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserServiceImpl;
import com.example.demo.model.User;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/rest/user")
public class UserRestController {
	@Autowired
	private UserServiceImpl usi;
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		ResponseEntity<String> resp=null; 
		try {
			Integer id=usi.saveUser(user);
			resp=new ResponseEntity<String>("user saved with"+id,HttpStatus.CREATED);
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("unable to save",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	//display all
	@GetMapping("/all")
	public ResponseEntity<?> allUser(){
		ResponseEntity<?> resp=null;
		try {
			List<User> list=usi.fetchAllUser();
			resp=new ResponseEntity<List<User>>(list,HttpStatus.OK);
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("unable to fetch data",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return   resp;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable Integer id){
		User user=usi.getOneUser(id);
		ResponseEntity<?> resp=null;
		try {
			
			resp=new ResponseEntity<User>(user,HttpStatus.OK);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeById(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			usi.deleteUser(id);
			resp=new ResponseEntity<String>("user deleted",HttpStatus.OK);
		}
		
			
			
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(" user not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	
	  
	
	/*
	 * @PutMapping("/update/{id}") public ResponseEntity<String>
	 * updateUser(@RequestBody User u,@PathVariable Integer id){
	 * ResponseEntity<String> resp=null; try { usi.updateUser(u, id); resp=new
	 * ResponseEntity<String>("user updated",HttpStatus.CREATED); }
	 * 
	 * 
	 * 
	 * catch(Exception e) { e.printStackTrace(); resp=new
	 * ResponseEntity<String>(" user not update",HttpStatus.INTERNAL_SERVER_ERROR);
	 * } return resp;
	 */
	
	
	@GetMapping("/search/{name}")
	public ResponseEntity<?> getOneUserByName(@RequestParam String userName){
		List<User> user=usi.findByUserName(userName);
		ResponseEntity<?> resp=null;
		
			
			resp=new ResponseEntity<List<User>>(user,HttpStatus.OK);
	
		return resp;
	}
	@GetMapping("/search/{surname}")
	public ResponseEntity<?> getOneUserBySurName(@RequestParam String userSurname){
		List<User> user=usi.findByUserSurname(userSurname);
		ResponseEntity<?> resp=null;
		
			
			resp=new ResponseEntity<List<User>>(user,HttpStatus.OK);
	
		return resp;
	}

@GetMapping("/search/{pincode}")
public ResponseEntity<?> getOneUserByPincode(@RequestParam Integer userPincode){
	List<User> user=usi.findByUserPincode(userPincode);
	ResponseEntity<?> resp=null;
	
		
		resp=new ResponseEntity<List<User>>(user,HttpStatus.OK);

	return resp;
}
	
	/*
	 * @PutMapping("/softDelete") public ResponseEntity<String> remove(@RequestParam
	 * User user){ ResponseEntity<String> resp=null;
	 * 
	 * usi.softDeletion(user);
	 * 
	 * 
	 * resp=new ResponseEntity<String>("user deleted",HttpStatus.OK);
	 * 
	 * return resp; }
	 */
	 
	 
	 
	 

@GetMapping("/find/all/sortByDob")
public ResponseEntity<?> getAllUserBySorting(){
	List<User> user=usi.sortAll();
	ResponseEntity<?> resp=null;
	try {
		
		resp=new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	
	catch(Exception e) {
		e.printStackTrace();
		resp=new ResponseEntity<String>("not found",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return resp;
}
@PostMapping("/update/{userid}")
public ResponseEntity<String> updateUser(@RequestBody User user,@RequestParam Integer userId){
	usi.update(userId, user);
	ResponseEntity<String> resp=null;
	
		
		resp=new ResponseEntity<String>(" record updated",HttpStatus.OK);

	return resp;
}
@GetMapping("/find/all/sortByDoj")
public ResponseEntity<?> getAllUserBySortingDoj(){
	List<User> user=usi.sortAllByDoj();
	ResponseEntity<?> resp=null;
	try {
		
		resp=new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	
	catch(Exception e) {
		e.printStackTrace();
		resp=new ResponseEntity<String>("not found",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return resp;
}
	@PostMapping("/softDelete/{userId}")
	public ResponseEntity<?> softDelete(@RequestParam Integer userId){
		usi.softDeleted(userId);
		ResponseEntity<?> resp=null;
		try {
			
			resp=new ResponseEntity<String>("deleted",HttpStatus.OK);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>("not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
}



}
