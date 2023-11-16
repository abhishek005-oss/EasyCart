package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.entities.User;
import org.hibernate.query.Query;


public class Userdao {
	private SessionFactory factory;
	
	public Userdao(SessionFactory factory) {

		this.factory=factory;
	}
	public User getUserByEmailAndPassword(String email,String password) {
    User user=null;
try {
	String query="from User where useremail=:e and password=:p";
	
	Session session=this.factory.openSession();
	Query q= session.createQuery(query);
	q.setParameter("e", email);
	q.setParameter("p", password);
	user=(User)q.uniqueResult();
	session.close();
}
catch(Exception e) {
	e.printStackTrace();
}
return user;
	}

}
