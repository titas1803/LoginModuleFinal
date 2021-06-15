package com.cg.login.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.login.entity.User;

/*
 * Created by Soumendu Maitra
 */
@Repository
public interface IUserDao extends JpaRepository<User, Integer> {
	@Query("from User u where u.location = :location")
	public List<User> findByLocation(@Param("location") String location);
	
	@Query("from User u where u.userName like %:username%")
	public List<User> findByName(@Param("username") String userName);

	@Query("from User u where u.contactNo = :contactNo")
	public Optional<User> findByContact(@Param("contactNo") String contactNo);
	
	@Query("from User u where u.emailId = :emailId")
	public Optional<User> findByEmail(@Param("emailId") String emailId);
}
