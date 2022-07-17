package com.txt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.txt.dto.Category;

@Repository
@Transactional
public class CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}*/

	public Category get(int id) {
		return null;
	}

	public List<Category> list() {
		List<Category> categories = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "From Category";
			Query query = session.createQuery(hql);
			categories = (List<Category>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	// boolean add(Category category)
	// boolean update(Category category);
	// boolean delete(Category category);
}
