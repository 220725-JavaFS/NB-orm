package com.revature.daos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.ORMModel;
import com.revature.utils.ConnectionUtil;

public class ORMDAOImpl implements ORMDAO{
	
	ORMModel modelORM = new ORMModel();
	
	String connectionURL = modelORM.getConnectionURL();
	String connectionUN = modelORM.getConnectionUN();
	String connectionPW = modelORM.getConnectionPW();
	String driverName = modelORM.getDriverName();
	//I changed the Connection to ORMModel to test *
	@Override
	public List<Object> retrieveAllObjects(Object object1) {
		//first getting the table name 
		String tableName = object1.getClass().getSimpleName().toLowerCase();
		//Next gathering the class info. Then generating a new list for all objects
		Class<?> objectClass = object1.getClass();
		
		LinkedList<Object> objectList = new LinkedList<Object>();
	
			try {
				//calling constructor for making the new objects
				Constructor<?> objectConstructor = objectClass.getConstructor();
				
				Connection conn = ConnectionUtil.getConnection(connectionURL, connectionUN, connectionPW, driverName);
				
				String SeaQuill = new String("SELECT * FROM "+tableName+";");
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(SeaQuill);
				
				//Attempting the same thing we did in the Avenger's demo
				
				while(result.next()) {
					Object mockObject = objectConstructor.newInstance();
					Field[] fields = objectClass.getDeclaredFields();
					
					for (int i = 0; i < fields.length; i++ ) {
						//Creating the setter names to set the object info to store
						String setterName = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
					 
						//Have to make sure that the values are appropriately typed. It's a good thing I only have two types.
						
						if(fields[i].getGenericType().toString().equals("class java.lang.String")) {
							Method invokeMethods = objectClass.getMethod(setterName, String.class);
							invokeMethods.invoke(mockObject, (Object) result.getObject((String) fields[i].getName()));
						} else if (fields[i].getGenericType().toString().equals("int")) {
							Method invokeMethods = objectClass.getMethod(setterName, int.class);
							invokeMethods.invoke(mockObject, (Object) result.getObject((String) fields[i].getName()));
						}
					}
					objectList.add(mockObject);
				}
				return objectList;
				
			
			} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
				e.printStackTrace();
			}
		
		return null;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Object getById(Object object1, int Id) {
		//first getting the table name 
		String tableName = object1.getClass().getSimpleName().toLowerCase();
		//Next gathering the class info
		Class<?> objectClass = object1.getClass();
		Field[] fields = objectClass.getDeclaredFields(); 
		//Getting only the field I want
		String idName = fields[0].getName().toLowerCase();
		
		StringBuilder columnNameSB = new StringBuilder();
		columnNameSB.append(idName);
		columnNameSB.insert(5,"_");
		String columnName = columnNameSB.toString();
		String seaQuillStatement = new String("SELECT * FROM "+tableName+" WHERE "+columnName+" = "+Id+";");
			try {
				//Calling a constructor (Hopeless not the No ARGS one)
				Constructor<?> objectConstructor = objectClass.getConstructor();
				//This is the object I will be returning back to the WebApp
				Object returnedObject = objectConstructor.newInstance();
				Connection conn = ORMModel.getConnection(connectionURL, connectionUN, connectionPW, driverName);
				//Hopefully connection worked.
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(seaQuillStatement);
				//Doing a for loop for the result set. Like how we did without the ORM?
				if(result.next()) {
					for (int i = 0; i < fields.length; i++) { //Fixed the unreachable code issue
					
						String setValue = "set" + fields[i].getName().substring(0,1).toUpperCase() + fields[i].getName().substring(1);
						//Getting the methods to invoke, then changing them per type. 
						if (fields[i].getGenericType().equals("int")) {
							Method ORMSetter = objectClass.getMethod(setValue, int.class);
							ORMSetter.invoke(returnedObject, (Object) result.getObject((String) fields[i].getName()));
						} else if (fields[i].getGenericType().equals("class java.lang.String")) {
							Method ORMSetter = objectClass.getMethod(setValue, String.class);
							ORMSetter.invoke(returnedObject, (Object) result.getObject((String) fields[i].getName()));
						}
					}return returnedObject;
					
				}
		
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public void deleteObject(Object object1, int id) {
		//first getting the table name 
		String tableName = object1.getClass().getSimpleName().toLowerCase();
		//creating SQL statement 
		StringBuilder objectStatementSB = new StringBuilder("DELETE * FROM "+tableName+" WHERE");
		//Looking at entire class quickly to get to fields
		Class<?> objectClass = object1.getClass();
		Field[] fields = objectClass.getDeclaredFields();
		//Getting only the field I want
		String idName = fields[0].getName().toLowerCase();
		
		StringBuilder columnNameSB = new StringBuilder();
		columnNameSB.append(idName);
		columnNameSB.insert(5,"_");
		//returning the name as string after inserting the underscore
		String columnName = columnNameSB.toString();
		//concatenating this value name to the previous builder
		objectStatementSB.append(columnName + " = "+id+";");
		String seaQuill = objectStatementSB.toString();
		//Attempting connection
			try (Connection conn = ORMModel.getConnection(connectionURL, connectionUN, connectionPW, driverName)){
				Statement statement = conn.createStatement();
				statement.execute(seaQuill);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.getErrorCode();
			}
	
		
	}

	@Override
	public void updateObject(Object object1, int id, String fieldValue) {
		//first getting the table name 
		String tableName = object1.getClass().getSimpleName().toLowerCase();
		//Now getting class for many other processes
		Class<?> tableClass = object1.getClass();
		//Declaring a field builder for my classes
		StringBuilder fieldBuilder = new StringBuilder();
		StringBuilder fieldBuilder2 = new StringBuilder();
		//Declaring another StringBuilder for later use
	
		Field[] fields = tableClass.getDeclaredFields();
		//Iterating over Array, creating field. Extracting field names into a StringBuilder to be modified later.
		
		String fieldName = fields[6].getName().toLowerCase();
		
		String fieldName2 = fields[0].getName().toLowerCase();
		
		fieldBuilder.append(fieldName);
		fieldBuilder.insert(5,"_");
		String columnName = fieldBuilder.toString();
		fieldBuilder2.append(fieldName2);
		fieldBuilder2.insert(5, "_");
		String columnName2 = fieldBuilder2.toString();
		
		
		String SeaQuill = "UPDATE "+tableName+" SET "+columnName+" = '"+fieldValue+"' WHERE "+columnName2+" = "+id+";";
						
		try (Connection conn = ORMModel.getConnection(connectionURL, connectionUN, connectionPW, driverName)){
			
			PreparedStatement statement = conn.prepareStatement(SeaQuill);
			statement.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertObject(Object object1) {
		//first getting the table name 
		String tableName = object1.getClass().getSimpleName().toLowerCase();
		//Now getting class for many other processes
		Class<?> tableClass = object1.getClass();
		//Declaring a field builder for my classes
		StringBuilder fieldBuilder = new StringBuilder();
		//Declaring another StringBuilder for later use
		StringBuilder rowValueBuilder = new StringBuilder();
		//Creating field[] to iterate over
		Field[] fields = tableClass.getDeclaredFields();
		//Iterating over Array, creating field. Extracting field names into a StringBuilder to be modified later.
			for(int i = 1; i<fields.length; i++) {
				String fieldName = fields[i].getName().toLowerCase();
				
				if (i==fields.length-1) { //If the array is close to done, will not add that last comma and space.
					fieldBuilder.append(fieldName);
				} else {
					fieldBuilder.append(fieldName + ", ");
				}
					
			}
			//creating the table column names. This part is very restrictive. I wish I changed it.
			fieldBuilder.insert(28, "_");
			fieldBuilder.insert(40, "_");
			fieldBuilder.insert(52, "_");
			//completed first part of the insert statement
			String columnNames = fieldBuilder.toString();
			//Working on getting the values to put into the database
				for(int i = 1; i<fields.length; i++) {
					String fieldName2 = fields[i].getName().substring(0,1).toUpperCase()+fields[i].getName().substring(1);
					String getterMethods = "get" + fieldName2;
					
					try {
						Method getMethod = tableClass.getMethod(getterMethods);
						
						Object objectValue = getMethod.invoke(object1);
						
						//if (objectValue.getClass().equals(objectValue))
						if (objectValue.getClass() == String.class) {
								rowValueBuilder.append("'" + objectValue+"',");
						} else {
							rowValueBuilder.append(objectValue + ",");
						}
					} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			rowValueBuilder.deleteCharAt(rowValueBuilder.length()-1);
			
			String rowValues = rowValueBuilder.toString();
			
			String SeqQuill = "INSERT INTO "+tableName+" ("+columnNames+") VALUES ("+rowValues+");";
			
			try (Connection conn = ORMModel.getConnection(connectionURL, connectionUN, connectionPW, driverName)){
				PreparedStatement statement = conn.prepareStatement(SeqQuill);
				statement.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}
				
			
	}

}
