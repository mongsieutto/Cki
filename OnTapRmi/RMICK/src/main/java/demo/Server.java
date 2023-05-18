package demo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.*;
import dao.impl.*;

public class Server {
	public static void main(String[] args) throws RemoteException, NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put("java.security.policy", "rmi/policy.policy");
		LocateRegistry.createRegistry(9000);
		System.out.println("host on port 9000");
		Context ctx = new InitialContext(env);
		ICustomer customer = new CustomerImpl();
		IOrder order = new OrderImpl();
		IProduct product = new ProductImpl();
		ctx.bind("rmi://localhost:9000/customer", customer);
		ctx.bind("rmi://localhost:9000/order", order);
		ctx.bind("rmi://localhost:9000/product", product);
		System.out.println("server started");

	}
}
