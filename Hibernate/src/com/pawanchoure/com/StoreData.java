/*
package com.pawanchoure.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.security.auth.login.Configuration;

public class StoreData {
	public static void main(String[] args) {

		// creating configuration object
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// creating session factory object
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);
		// creating transaction object
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId(124);
		e1.setFirstName("Vaishnavi");
		e1.setLastName("Choure");

		session.persist(e1);// persisting the object

		t.commit();// transaction is committed
		session.close();

		System.out.println("successfully saved");

	}
}
*/
