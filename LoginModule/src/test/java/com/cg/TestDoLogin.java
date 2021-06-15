package com.cg;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.login.dao.ILoginDao;
import com.cg.login.entity.Login;
import com.cg.login.exceptions.LoginException;
import com.cg.login.service.ILoginService;
import com.cg.login.service.LoginServiceImpl;

/*
 * Created By Titas Sarkar
 */
@SpringBootTest
class TestDoLogin {

	@Mock
	private ILoginDao logindao;
	@InjectMocks
	private ILoginService loginSer=new LoginServiceImpl();
	
	@BeforeEach
	void beforeEach()
	{
		Optional<Login> optlogin1=Optional.of(new Login(1001, loginSer.encryptString("Abcd@123"), "user"));
		Optional<Login> optlogin2=Optional.empty();
		when(logindao.findById(1001)).thenReturn(optlogin1);
		when(logindao.findById(1002)).thenReturn(optlogin2);
	}
	
	@Test
	@DisplayName(value="TestDoLogin for id 1001")
	void testDoLogin1() throws LoginException {
		assertNotNull(loginSer.doLogin(1001, "Abcd@123"));
	}
	
	@Test
	@DisplayName(value="TestDoLogin for id 1002")
	void testDoLogin2() throws LoginException {
		assertThrows(LoginException.class,()-> loginSer.doLogin(1002, "Abcd@123"));
	}
}
