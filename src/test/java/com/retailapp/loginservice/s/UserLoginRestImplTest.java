package com.retailapp.loginservice.s;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;

import com.retailapp.loginservice.Dao.UserDao;
import com.retailapp.loginservice.JWT.JwtFilter;
import com.retailapp.loginservice.JWT.JwtUtill;
import com.retailapp.loginservice.Services.LoginServiceImpl;

@WebMvcTest(UserLoginRestImplTest.class)
@ExtendWith(MockitoExtension.class)
public class UserLoginRestImplTest {
	
	@Mock
	private UserDao userDao;
	
	@Autowired
	MockMvc mockMvc;
	
	
	
	@Mock
	JwtUtill jwtutill;
	@Mock
	JwtFilter jwtfilter;
	
	LoginServiceImpl service;

	
	@BeforeEach
	void setUp()
	{
		this.service=new LoginServiceImpl(userDao,jwtfilter,jwtutill);
	}
	@Test
	void logintest() throws Exception
	{
		
		
		
//		Map<String,String>map;
//		map.put("email", "shivendusingh2002gmail.com");
//		map.put("password", "123456");
		
		String username= "shivendusingh2002gmail.com";
        String password= "123456";
		
		mockMvc.perform(post("/user/login")
		            .param("username",username)
		            .param("password",password))
		            .andExpect(status().isOk())
		            .andExpect(view().name("logged In Succesfully"));
		//verify(mockList).add("Pankaj");
		
	}

}
