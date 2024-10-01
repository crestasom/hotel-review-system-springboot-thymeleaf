package com.cretasom.hrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.cretasom.hrs.entity.User;
import com.cretasom.hrs.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HotelReviewSystemApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository repo;

	@BeforeEach
	public void setUp() {

		User u1 = new User();
		u1.setName("Ram");
		u1.setPassword("test");
		u1.setEmail("test@gmail.com");
		u1.setUserName("ram");
		u1.setUserRole("ADMIN");
		repo.save(u1);

	}

	@AfterEach
	public void removeUsers() {
		repo.deleteAll();
	}

	@Test
	@WithMockUser(username = "ram", roles = { "ADMIN" })
	void testInsertMockRecord() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/user/adduser")
				.file("image", "This is a test file".getBytes()).param("userName", "rama").param("password", "test")
				.param("email", "test1@gmail.com").param("name", "Rama1")).andReturn();
		assertEquals(302, result.getResponse().getStatus());
		assertEquals("redirect:/user/", result.getModelAndView().getViewName());

	}

	@Test
	@WithMockUser(username = "ram", roles = { "ADMIN" })
	void testInsertMockRecordValidationFailed() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/user/adduser")
				.file("image", "This is a test file".getBytes()).param("userName", "rama").param("password", "test")
				/* .param("email", "test1@gmail.com") */.param("name", "Rama1"))
//			
				.andReturn();
		// Retrieve the model and assert the BindingResult contains errors
		ModelMap modelMap = result.getModelAndView().getModelMap();
		assertTrue(modelMap.containsAttribute("org.springframework.validation.BindingResult.user"));

		// Retrieve BindingResult object from the model and assert on errors
		BindingResult bindingResult = (BindingResult) modelMap.get("org.springframework.validation.BindingResult.user");
		assertTrue(bindingResult.hasErrors());

		assertTrue(bindingResult.hasFieldErrors("email"));
		assertEquals("Email is mandatory", bindingResult.getFieldError("email").getDefaultMessage());
	}

	@Test
	@WithMockUser(username = "ram", roles = { "ADMIN" })
	void testShowUserList() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/")).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		List<User> userList = (List<User>) result.getModelAndView().getModel().get("users");
		assertNotNull(userList);
		assertEquals(1, userList.size());

	}

}
