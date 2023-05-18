// package demo;

// import dao.CustomerDao;
// import dao.OrderDao;
// import dao.ProductDao;

// public class Demo {
// 	public static void main(String[] args) {
// 		ProductDao productDao = new ProductDao();
// 		CustomerDao customerDao = new CustomerDao();
// 		OrderDao orderDao = new OrderDao();
// 		customerDao.findCustomerByPhone("(916) 381-6003").forEach(System.out::println);

// 	}
// }
package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entities.Account;
import entities.Address;
import entities.Brand;
import entities.Category;
import entities.Contact;
import entities.Customer;
import entities.Employee;
import entities.Order;
import entities.OrderItem;
import entities.Person;
import entities.Product;
import entities.Staff;
import entities.Stock;
import entities.Store;

public class Demo {
	public static void main(String[] args) {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				// .addAnnotatedClass(Brand.class)
				// .addAnnotatedClass(Category.class)
				// .addAnnotatedClass(Product.class)
				// .addAnnotatedClass(Stock.class)
				// .addAnnotatedClass(Store.class)
				// .addAnnotatedClass(Contact.class)
				// .addAnnotatedClass(Address.class)
				// .addAnnotatedClass(Order.class)
				// .addAnnotatedClass(OrderItem.class)
				// .addAnnotatedClass(Person.class)
				// .addAnnotatedClass(Customer.class)
				// .addAnnotatedClass(Staff.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Account.class)
				.getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
				.build();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			// TODO: handle exception
		}

	}
}
