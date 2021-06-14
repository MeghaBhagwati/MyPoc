package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.IUserRepo;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;
	List<User> list=new ArrayList<User>();
	@Override
	public Integer saveUser(User u) {
		// TODO Auto-generated method stub
		Integer id=repo.save(u).getUserId();
		return id;
	}

	@Override
	public User updateUser(User u,Integer userId) {
		// TODO Auto-generated method st
		User user=repo.findById(userId).orElseGet(null);
		user.setUserName(user.getUserName());
		user.setUserName(user.getUserName());
		user.setUserSurname(user.getUserSurname());
		user.setUserPincode(user.getUserPincode());
		user.setUserDob(user.getUserDob());
		user.setUserDoj(user.getUserDoj());
		return repo.save(user);
		
	}

	@Override
	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
    repo.deleteById(id);
     return "removed from db"+id;
    
	}

	@Override
	public User getOneUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<User> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
		}
		
	@Override
	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}

	@Override
	public List<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		List<User> user=repo.findByUserName(userName);
		return user;
	}
	public List<User> findByUserSurname(String userSurname){
		List<User> user=repo.findByUserSurname(userSurname);
		return user;
	}
	public List<User> findByUserPincode(Integer userPincode){
	List<User> user=repo.findByUserPincode(userPincode);
	return user;
	}

	    @Override
	   public void update(Integer userId,User user) {
	 
	    	// TODO Auto-generated method stub
	  
	  if(user.getUserId()==userId) { user.setUserName(user.getUserName());
	  user.setUserSurname(user.getUserSurname());
	  user.setUserDob(user.getUserDob()); user.setUserDoj(user.getUserDoj());
	  user.setUserPincode(user.getUserPincode());
	  repo.save(user);
	  
	  }
	  else
		  repo.save(user);
	  
	    }

	/*
	 * @Override public List<User> findByUserDobOrderByUserDobAsc(Date dob) { //
	 * TODO Auto-generated method stub List<User>
	 * user=repo.findByUserDobOrderByUserDobAsc(dob); return user; }
	 */

		@Override
		public List<User> sortAll() {
			
			Iterable<User> user=repo.findAllByOrderByUserDobAsc();
			
			return (List<User>) user;
		}
		@Override
		public List<User> sortAllByDoj() {
			
			Iterable<User> user=repo.findAllByOrderByUserDojAsc();
			
			return (List<User>) user;
		}

		@Override
		public void softDeleted(Integer userId) {
			// TODO Auto-generated method stub
		
			User user=repo.findById(userId).get();
			
			user.setActive(true);
			
			repo.save(user);
			
			
		}

		

		


	
	
		
	
}
