package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entities.*;

public interface ICustomer extends Remote {
	// 4. Statistics of customers by state.
	public Map<String, Integer> getNumberCustomerByState() throws RemoteException;

	// 6. Statistics of customers by state
	Map<Customer, Integer> getOrdersByCustomers() throws RemoteException;

	// 10. Remove all unpurchased customers
	void removeUnpurchasedCustomers() throws RemoteException;

	// 11. List of customers with 2 or more phone numbers
	List<Customer> findCustomerWith2Phone() throws RemoteException;

	// 13. Find customers when you know the phone number.
	List<Customer> findCustomerByPhone(String phone) throws RemoteException;
}
