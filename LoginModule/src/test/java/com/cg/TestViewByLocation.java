package com.cg;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.login.dao.IUserDao;
import com.cg.login.entity.User;
import com.cg.login.exceptions.UserNotFoundException;
import com.cg.login.service.IUserService;
import com.cg.login.service.UserServiceImpl;

/*
 * Created by Soumendu Maitra
 */
@SpringBootTest
class TestViewByLocation {

	@Mock
	private IUserDao userdao;
	
	@InjectMocks
	private IUserService userSer=new UserServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		List<User> lst= new ArrayList<>();
		lst.add(new User(1001, "abcd", "1234567890", "abcd@efg,com", LocalDate.of(2000, 01, 31), "sodpur", "kolkata"));
		lst.add(new User(1002, "hgij", "1234567890", "hgij@efg,com", LocalDate.of(2000, 05, 13), "bagbazar", "kolkata"));
		List<User> lst2= new ArrayList<>();
		when(userdao.findByLocation("kolkata")).thenReturn(lst);
		when(userdao.findByLocation("abcd")).thenReturn(lst2);
	}
	
	@Test
	@DisplayName(value = "testViewByLocation for kolkata")
	void testViewByLocation1() throws UserNotFoundException {
		assertTrue(userSer.viewByLocation("kolkata").size()>0);
	}
	
	@Test
	@DisplayName(value = "testViewByLocation for abcd")
	void testViewByLocation2() throws UserNotFoundException {
		assertThrows(UserNotFoundException.class, ()->userSer.viewByLocation("abcd"));
	}
}
