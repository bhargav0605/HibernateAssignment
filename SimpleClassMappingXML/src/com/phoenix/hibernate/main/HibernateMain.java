package com.phoenix.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phoenix.entities.Product;

/*
 * @author: bhargav.parmar@stltech.in
 * @Version: 1.0.0
 * @Date: 7-Jul-2021
 * @Copyright: Sterlite Technology Ltd.
 * @Discription: It is use to perform 
 * 				database operation using 
 *				hibernate framework.
 */

public class HibernateMain {

	public static void main(String[] args) {
		//Create configuration object and read hibernate configuration
		Configuration cfg = new Configuration().configure();
		
		//Build Session Factory
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Establish Database Connection
		Session ss = factory.openSession();
		
		//Obtain Hibernate Transaction
		Transaction tx = ss.beginTransaction();
		
		//code for database operations
		
		//Get Database row as object
		Product product = ss.get(Product.class, 3001);
		System.out.println(product);
		
		//Adding product
		//Product p = new Product(3011, "Mobile", "Apple", 97000.00f);
		//ss.save(p);
		
//		Product p = ss.load(Product.class, 3011);
//		System.out.println("Id: "+p.getProductId());
//		System.out.println("Name: "+p.getProductName());
//		System.out.println("Brand: "+p.getBrand());
//		System.out.println("Price: "+p.getPrice());
		
		//Update row price using obj
//		Product p = ss.get(Product.class, 3011);
//		if(p!=null) {
//			p.setPrice(p.getPrice()+10000.00f);
//			ss.update(p);
//		} else {
//			System.out.println("Sorry! No product.");
//		}
//		
//		p = ss.get(Product.class, 3011);
//		if(p!=null) {
//			System.out.println(p);
//		} else {
//			System.out.println("Sorry! No product.");
//		}
		
		// Delete Row using obj
		Product p = ss.get(Product.class, 3011);
		if(p!=null) {
			ss.delete(p);
			System.out.println("Deleted!");
		} else {
			System.out.println("Sorry! No product.");
		}
		
		//Commit transaction
		tx.commit();
		
		//Close Session
		ss.close();

	}

}
