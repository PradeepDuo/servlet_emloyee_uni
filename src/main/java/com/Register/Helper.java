package com.Register;

import java.io.PrintWriter;

import com.dto.Register_Employee;
import com.dto.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Helper {
	
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction=entityManager.getTransaction();
	public static Task task= new Task();
	public static Register_Employee employee= new Register_Employee();
	
}
