package com.phoenix.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phoenix.entities.Product;

/*
 * @author: bhargav.parmar@stltech.in
 * @Version: 2.0.0
 * @Date: 08-Jul-2021
 * @Copyright: Sterlite Technology Ltd.
 * @Discription: It is use to perform 
 * 				database operation using 
 *				JPQL.
 */

public class JPQLMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		//Build Session Factory
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Establish Database Connection
		Session session = factory.openSession();
		
		//Obtain Hibernate Transaction
		Transaction tx = session.beginTransaction();
		
		//Hibernate query using jpql - object oriented query language
		//works on persistent class and it's attributes only
		//Does not understand table and column names
		
//		Query query = session.createQuery("from Product");
		//Query query = session.createQuery("from Product p where p.price>=30000.00");
		//Query query = session.createQuery("from Product p where p.brand='KTM'");
		//Query query = session.createQuery("from Product p where p.productName='Bike' and p.brand='KTM'");
		//Query query = session.createQuery("from Product p where p.price between 30000.00 and 200000.00");
		//Query query = session.createQuery("from Product p where p.productName like 'B%'");
		//Query query = session.createQuery("from Product p where p.productName like '_a%'");
		//Query query = session.createQuery("from Product p where p.brand is null");
		//Query query = session.createQuery("from Product p where p.brand is not null");
		//Query query = session.createQuery("from Product p order by p.price");
		//Query query = session.createQuery("from Product p order by p.price desc");
		//Query query = session.createQuery("from Product p order by p.productName, p.price desc");
		//Query query = session.createQuery("from Product p where p.price<=50000.00 order by p.price");
		//Query query = session.createQuery("from Product p where p.price<=50000.00 and p.brand like '%a%' order by p.price");
		
//		
//		List<Product> productList = query.getResultList();
//		
//		for(Product product : productList) {
//			System.out.println(product);
//		}
		
		
		//Projection - Selecting particular fields(column) in JPQL
		Query query = session.createQuery("select p.productName,p.brand,p.price from Product p");
		
		//Query query = session.createQuery("select p.productName,p.brand,p.price from Product p where p.price>50000.00");
		//Query query = session.createQuery("select p.productName,p.brand,p.price from Product p where p.price>50000.00 and p.price<200000.00 order by p.productName");
		
		List<Object[]> objList = query.getResultList();
		for(Object[] obArr : objList) {
			System.out.println("Product Name: "+obArr[0] + "\tBrand: "+obArr[1]+"\tPrice: "+obArr[2]);
		}
		
		//Group Functions
		//Query query = session.createQuery("select max(p.price) from Product p");
//		Query query = session.createQuery("select sum(p.price) from Product p");
//		double max = (double) query.getSingleResult();
//		System.out.println("Resultant Price: "+max);
		
//		Query query = session.createQuery("select avg(p.price) from Product p");
//		double avg = (double) query.getSingleResult();
//		System.out.println("Resultant Price: "+avg);
		
//		Query query = session.createQuery("select p.brand,count(*) as c from Product p group by p.brand order by c");
//		List<Object[]> objList = query.getResultList();
//	
//		for(Object obArr[] : objList) {
//			for(Object ob: obArr) {
//			System.out.println(ob);
//			}
//		}
		
		tx.commit();
		session.close();
		

	}

}
