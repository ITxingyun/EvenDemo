package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.Address;
import com.xingyun.architecture.ddd.dp.Name;
import com.xingyun.architecture.ddd.dp.PhoneNumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class RegistrationServiceImplTest {
	@Mock
	UserRepository userRepo;
	@InjectMocks
	RegistrationServiceImpl registrationServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegister() throws Exception {
		when(userRepo.createUser(any())).thenReturn(new User(new Name("name"), new PhoneNumber("number"), new Address("address")));

		User result = registrationServiceImpl.register(new Name("name"), new PhoneNumber("number"), new Address("address"));
		Assert.assertEquals(new User(new Name("name"), new PhoneNumber("number"), new Address("address")), result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme