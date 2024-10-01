//package com.cretasom.hrs;
//
//import static org.assertj.core.api.Assertions.assertThatNoException;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.cretasom.hrs.entity.User;
//import com.cretasom.hrs.repo.UserRepository;
//import com.cretasom.hrs.service.impl.UserServiceImpl;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//
//@ExtendWith(MockitoExtension.class)
////@MockitoSettings(strictness = Strictness.LENIENT)
//public class UserServiceUnitTest {
//	@Mock
//	UserRepository userRepo;
//
//	@InjectMocks
//	UserServiceImpl userServiceImpl;
//
//	@Mock
//	PasswordEncoder encoder;
//	private Validator validator;
//
//	@BeforeEach
//	void setup() {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		validator = factory.getValidator();
//		Mockito.when(userRepo.save(any())).thenReturn(null);
//		List<User> userList = new ArrayList<>();
//		User u1 = new User();
//		u1.setName("test user");
//		userList.add(u1);
//		Mockito.when(userRepo.findAll()).thenReturn(userList);
//		Mockito.doNothing().when(userRepo).deleteById(any());
//	}
//
//	@Test
//	void testInsertUser() {
//		User u1 = new User();
//		u1.setName("Ram");
//		u1.setPassword("test");
//		u1.setEmail("test@gmail.com");
//		userServiceImpl.addUser(u1);
//		assertThatNoException();
//	}
//
//	@Test
//	void testInsertUserFailedValidation() {
//		User u1 = new User();
//		u1.setName("Ram");
//		u1.setPassword("test");
//		u1.setEmail("test@gmail.com");
////		User u = userServiceImpl.addUser(u1);
//		Set<ConstraintViolation<User>> violations = validator.validate(u1);
//
//		assertTrue(violations.isEmpty());
////		assertThatNoException();
//	}
//
////
//	@Test
//	void testFetchUserList() {
//		List<User> userList = userServiceImpl.getAllUser();
//		assertEquals(1, userList.size());
//
//	}
//
//}
