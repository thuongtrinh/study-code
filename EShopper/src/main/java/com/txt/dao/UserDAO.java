package com.txt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.txt.dto.User;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*public void setSessionFactory(SessionFactory sf) {
		// if (sessionFactory == null) {
		// throw new IllegalStateException();
		// }
		this.sessionFactory = sf;
	}*/

	public void add(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	public User getUserByUserName(String username) {
		User user = null;
		if (sessionFactory == null) {
			System.out.println("sessionFactory is null");
		} else {
			System.out.println("sessionFactory is other null");
		}
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("UserByUsername");
		query.setParameter("username", username);
		user = (User) query.list().get(0);
		if (user == null) {
			System.out.println("USER is null");
		}
		return user;
	}

	public List<User> listAllUsers() {
//		List<User> users = new ArrayList<User>();
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "From User";
//		Query query = session.createQuery(hql);
//		users = query.list();
//		return users;

		List<User> users = new ArrayList<User>();
		AtomicLong counter = new AtomicLong();
		users.add(new User((int)counter.incrementAndGet(), "Sam", "3070000"));
		users.add(new User((int)counter.incrementAndGet(), "Tom", "4050000"));
		users.add(new User((int)counter.incrementAndGet(), "Jerome", "4530000"));
		users.add(new User((int)counter.incrementAndGet(), "Silvia", "5040000"));
		return users;
	}

	public User getUserById(int id) {
//		String hql = "From User where id = :id";
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery(hql);
//		query.setParameter("id", id);
//		User user = (User) query.uniqueResult();
		return null;
	}

}
