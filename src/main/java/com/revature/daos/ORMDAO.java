package com.revature.daos;

import java.util.List;

public interface ORMDAO {
	
		List<Object> retrieveAllObjects(Object object1);
		
		Object getById (Object object1, int Id);
		
		void deleteObject(Object object1, int id);
		
		void updateObject(Object object1, int id, String fieldValue);
		
		void insertObject(Object object1);

	}

