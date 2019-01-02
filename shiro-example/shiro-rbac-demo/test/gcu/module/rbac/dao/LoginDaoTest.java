package gcu.module.rbac.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import gcu.module.rbac.daomain.User;

public class LoginDaoTest {

	@Test
	public void testQueryUserByName() {
//		fail("Not yet implemented");
		User user = new LoginDao().queryUserByName("gcu");
		assertNotNull(user);
	}

}
