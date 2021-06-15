package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
class TestViewAllUser {

	@Mock
	private IUserDao userdao;

	@InjectMocks
	private IUserService userSer = new UserServiceImpl();

	static List<User> lst = new ArrayList<>();

	@Test
	@DisplayName(value = "testViewAlluser 1")
	void testViewAllUser1() throws UserNotFoundException {
		lst.add(new User(1001, "abcd", "1234567890", "abcd@efg,com", LocalDate.of(2000, 01, 31), "sodpur", "kolkata"));
		lst.add(new User(1002, "hgij", "1234567890", "hgij@efg,com", LocalDate.of(2000, 05, 13), "bagbazar",
				"kolkata"));
		when(userdao.findAll()).thenReturn(lst);
		assertTrue(userSer.viewAllUser().size() > 0);
	}

	@Test
	@DisplayName(value = "testViewAlluser 2")
	void testViewAllUser2() {
		when(userdao.findAll()).thenReturn(new ArrayList<>());
		assertThrows(UserNotFoundException.class, () -> userSer.viewAllUser());
	}

}
