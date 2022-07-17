package com.txt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.txt.dto.Brand;

@Repository
@Transactional
public class BrandDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}*/

	public List<Brand> list() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		Session session = sessionFactory.getCurrentSession();
		String hql = "From Brand";
		Query query = session.createQuery(hql);
		List<Brand> groups = (List<Brand>)query.list();
//		session.close();
		return groups;
	}

}
