package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.example.demo.model.User;



public interface IUserService {
	public  Integer saveUser(User u);
	//update method
	
	//delete method
	public String deleteUser(Integer id);
	//fatch employee
	public User getOneUser(Integer id);
	//particular emp fetch
	public List<User> fetchAllUser();
	public User updateUser(User u, Integer userId);
	public void softDeleted(Integer userId);
	
	public List<User> findByUserName(String userName);
	public List<User> findByUserSurname(String userSurname);
	public List<User> findByUserPincode(Integer userPincode);
	
	public void update(Integer userId,User user);
	//public List<User> findByUserDobOrderByUserDobAsc(Date dob);
	public Iterable<User> sortAll();
	public Iterable<User> sortAllByDoj();
	
}
