package com.example.dao;

import com.example.model.CustomerOrder;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerOrderDAO {
    public void saveCustomerOrder(CustomerOrder customerOrder) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(customerOrder);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public CustomerOrder getOrder(int number)
    {
        Transaction transaction = null;
        CustomerOrder order = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            order = session.get(CustomerOrder.class, number);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return order;
    }
}
