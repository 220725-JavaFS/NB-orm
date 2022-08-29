package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.daos.ORMDAOImpl;

class ORMServiceTest {
	
	private ORMDAOImpl mockDao = Mockito.mock(ORMDAOImpl.class);
	private ORMService ormService = new ORMService(mockDao);
	private static Object testObject;
	private static int testInt;
	private static String value;
	private static boolean result;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		testObject = null;
	}


	@Test
	void testRetrieveAllObjectsServiceReturnsNull() {
		
		fail("Not yet implemented");
	}

	@Test
	void testGetObjectByIdService() {
		testObject = 71;
		result = Mockito.when(ormService.retrieveAllObjectsService(testObject)).equals(null);
		assertEquals(result, false);
	}

	@Test
	void testInsertObjectService() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteObjectService() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateObjectService() {
		fail("Not yet implemented");
	}

}
