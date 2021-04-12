package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.mts.entities.User;

class TestUser {

	@Test
	void testUser() {
		User user = new User();
		
		user.setUserName("fool");
		
		assertEquals("fool", user.getUserName(), "incorrect username");
		
	}

}
