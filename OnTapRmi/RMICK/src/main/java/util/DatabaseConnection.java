package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import entities.Address;
import entities.Brand;
import entities.Category;
import entities.Contact;
import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Person;
import entities.Product;
import entities.Staff;
import entities.Stock;
import entities.Store;

public class DatabaseConnection {
  private SessionFactory sessionFactory;
  private static DatabaseConnection databaseConnection = null;

  private DatabaseConnection() {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();

    Metadata metadata = new MetadataSources(registry)
        .addAnnotatedClass(Brand.class)
        .addAnnotatedClass(Category.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Stock.class)
        .addAnnotatedClass(Store.class)
        .addAnnotatedClass(Contact.class)
        .addAnnotatedClass(Address.class)
        .addAnnotatedClass(Order.class)
        .addAnnotatedClass(OrderItem.class)
        .addAnnotatedClass(Person.class)
        .addAnnotatedClass(Customer.class)
        .addAnnotatedClass(Staff.class)
        .getMetadataBuilder()
        .build();

    this.sessionFactory = metadata.getSessionFactoryBuilder().build();

  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public synchronized static DatabaseConnection getInstance() {
    if (databaseConnection == null)
      databaseConnection = new DatabaseConnection();

    return databaseConnection;
  }
}
