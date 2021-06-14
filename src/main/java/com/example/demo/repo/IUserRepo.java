package com.example.demo.repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository

public interface IUserRepo extends JpaRepository<User,Integer>,PagingAndSortingRepository<User,Integer>{
	
	public List<User> findByUserName(String userName);
	public List<User> findByUserSurname(String userSurname);
	public List<User> findByUserPincode(Integer userPincode);
	public Iterable<User> findAllByOrderByUserDobAsc();
	 
	public Iterable<User>findAllByOrderByUserDojAsc();
	/*
	 * @Query("DELETE User u WHERE u.userId=?1") public void deletebysoft(Integer
	 * userId);
	 * 
	 */
	
	
	
	
}

