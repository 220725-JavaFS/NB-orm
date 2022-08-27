package com.revature.controllers;

import java.util.List;

import com.revature.models.ORMModel;
import com.revature.services.ORMService;
import com.revature.models.*;

public class ORMcontroller {
	
	ORMModel modelORM = new ORMModel();
	ORMService ormService = new ORMService();
	
	String databaseURL = "jdbc:postgresql://javafs220725.c7uqwmtdtwsg.us-east-1.rds.amazonaws.com:5432/project1";
	String databaseUN = "postgres";
	String databasePW = "password";
	String databaseDriverName = "org.postgresql.Driver";
	
	public List<Object> retrieveAllObjectsController(Object objectFromWeb,  String databaseURL, String databaseUN, String databasePW, String databaseDriverName){
		modelORM.setConnectionURL(databaseURL);
		modelORM.setConnectionUN(databaseUN);
		modelORM.setConnectionPW(databasePW);
		modelORM.setDriverName(databaseDriverName);
		return ormService.retrieveAllObjectsService(objectFromWeb);
	}
	
	public Object getObjectByIdController (Object objectFromWeb, int id, String databaseURL, String databaseUN, String databasePW, String databaseDriverName) {
		modelORM.setConnectionURL(databaseURL);
		modelORM.setConnectionUN(databaseUN);
		modelORM.setConnectionPW(databasePW);
		modelORM.setDriverName(databaseDriverName);
		return ormService.getObjectByIdService(objectFromWeb, id);
	}
	
	
	public void insertObjectController(Object objectFromWeb, String databaseURL, String databaseUN, String databasePW, String databaseDriverName) {
		modelORM.setConnectionURL(databaseURL);
		modelORM.setConnectionUN(databaseUN);
		modelORM.setConnectionPW(databasePW);
		modelORM.setDriverName(databaseDriverName);
		ormService.insertObjectService(objectFromWeb);
	}
	
	public void deleteObjectContoller (Object objectFromWeb, int id, String databaseURL, String databaseUN, String databasePW, String databaseDriverName) {
		modelORM.setConnectionURL(databaseURL);
		modelORM.setConnectionUN(databaseUN);
		modelORM.setConnectionPW(databasePW);
		modelORM.setDriverName(databaseDriverName);
		ormService.deleteObjectService(objectFromWeb, id);
	}
	
	public void updateObjectController (Object objectFromWeb, int Id, String fieldValue, String databaseURL, String databaseUN, String databasePW, String databaseDriverName) {
		modelORM.setConnectionURL(databaseURL);
		modelORM.setConnectionUN(databaseUN);
		modelORM.setConnectionPW(databasePW);
		modelORM.setDriverName(databaseDriverName);
		ormService.updateObjectService(objectFromWeb, Id, fieldValue);
	}
	
	

}
