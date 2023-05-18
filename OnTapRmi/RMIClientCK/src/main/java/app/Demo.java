package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.ICustomer;

public class Demo {
  public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
    ICustomer customer = (ICustomer) Naming.lookup("rmi://localhost:9000/customer");

    System.out.println(customer.getNumberCustomerByState());
  }
}
