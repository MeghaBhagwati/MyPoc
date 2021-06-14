package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.repo.IUserRepo;

@SpringBootTest
class MyPocApplicationTests {
	
	@Autowired
	IUserRepo repo;
	@Test
  public void create() {
	  User user=new User();
	  user.setUserDob(new Date(07-06-1996));
	  user.setUserId(5);
	  user.setUserDoj(new Date(05-01-2017));
	  user.setUserName("riya");
	  user.setUserSurname("parihar");
	  user.setUserPincode(5678);
	  repo.save(user);
	  assertNotNull(repo.findById(5).get());
	 
	  
	  
	  
  }
	@Test
	public void testReadAll(){
		List<User> list=repo.findAll();
	assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSingleUser() {
		User user=repo.findById(5).get();
		assertEquals("riya",user.getUserName());
	}
	@Test
	public void testUpdate() {
		User user=repo.findById(5).get();
		user.setUserName("sanny");
		repo.save(user);
		assertNotEquals("riya",repo.findById(5).get().getUserName());
	}
	
	@Test
	public void testDelete() {
		repo.deleteById(5);
		assertThat(repo.existsById(5)).isFalse();
		
	}
	@Test
	public void testFindByName() {
		List<User> user=repo.findByUserName("hari");
		assertNotEquals("sunil",repo.findById(3).get().getUserName());
	}
	
	@Test
	public void testFindBySurName() {
		List<User> user=repo.findByUserSurname("mishra");
		assertNotEquals("sharma",repo.findById(3).get().getUserName());
	}
	
	@Test
	public void testFindByPincode() {
		List<User> user=repo.findByUserPincode(9898);
		assertNotEquals("8787",repo.findById(3).get().getUserName());
	}
	
	@Test
	public void testFindAllBySortDob() {
		List<User> list=(List<User>) repo.findAllByOrderByUserDobAsc();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testFindAllBySortDoj() {
		List<User> list=(List<User>) repo.findAllByOrderByUserDojAsc();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testSoftDelete() {
		repo.findById(9);
		assertNotEquals("0",repo.findById(9).get().getActive());
	}
	
	}
	


