package com.revature.services;

import java.util.List;

import com.revature.daos.ORMDAO;
import com.revature.daos.ORMDAOImpl;
import com.revature.models.ORMModel;

public class ORMService {
	
	ORMDAO ORMDAO = new ORMDAOImpl();
	ORMModel modelORM = new ORMModel();
	
	public List<Object> retrieveAllObjectsService(Object objectFromWeb){
		return ORMDAO.retrieveAllObjects(objectFromWeb);
	}
	
	public Object getObjectByIdService (Object objectFromWeb, int id) {
		return ORMDAO.getById(objectFromWeb, id);
	}
	
	public void insertObjectService(Object objectFromWeb) {
		ORMDAO.insertObject(objectFromWeb);
	}
	
	public void deleteObjectService(Object objectFromWeb, int id) {
		ORMDAO.deleteObject(objectFromWeb, id);
	}
	
	public void updateObjectService(Object objectFromWeb, int id, String fieldValue) {
		ORMDAO.updateObject(objectFromWeb, id, fieldValue);
	}

}
