package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import dao.ICustomer;
import entities.*;
import util.DatabaseConnection;

public class CustomerImpl extends UnicastRemoteObject implements ICustomer {
	private Session session;

	public CustomerImpl() throws RemoteException {
		session = DatabaseConnection.getInstance().getSessionFactory().openSession();
	}

	@Override
	public Map<String, Integer> getNumberCustomerByState() throws RemoteException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Transaction transaction = session.beginTransaction();
		try {

			Query<Object[]> query = session.createNamedQuery("Customer.findCustomerByState", Object[].class);
			List<Object[]> list = query.getResultList();
			for (Object[] objects : list) {
				map.put((String) objects[0], (Integer) objects[1]);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Customer, Integer> getOrdersByCustomers() throws RemoteException {
		Map<Customer, Integer> map = new HashMap<>();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Object[]> query = session.createNamedQuery("Order.findOrderWithCustomer", Object[].class);
			List<Object[]> list = query.getResultList();
			for (Object[] objects : list) {
				int cusId = (int) objects[0];
				Customer customer = session.find(Customer.class, cusId);
				int num = (int) objects[1];
				map.put(customer, num);
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public void removeUnpurchasedCustomers() throws RemoteException {
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "delete from customers where customer_id not in (select customer_id from orders)";
			Query<Customer> query = session.createNativeQuery(sql, Customer.class);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<Customer> findCustomerWith2Phone() throws RemoteException {
		List<Customer> list = new ArrayList<Customer>();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "select * from customers where customer_id in (select customer_id from customers group by customer_id having count(customer_id) >=2)";
			// no customer have 2 phone number in database if you want to test this function
			// you can change condition to >= 1
			NativeQuery<Customer> query = session.createNativeQuery(sql, Customer.class);
			list = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Customer> findCustomerByPhone(String phone) throws RemoteException {
		List<Customer> list = new ArrayList<Customer>();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "select * from customers where phone = :phone";
			NativeQuery<Customer> query = session.createNativeQuery(sql, Customer.class);
			query.setParameter("phone", phone);
			list = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

}
