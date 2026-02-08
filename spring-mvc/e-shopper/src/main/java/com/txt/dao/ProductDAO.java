package com.txt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.txt.dto.Product;

@Repository
@Transactional
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

	/*public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}*/

    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    public List<Product> list() {
        List<Product> products = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "From Product";
            Query query = session.createQuery(hql);
            products = (List<Product>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

}
