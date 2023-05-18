package dao.impl;

import java.math.BigDecimal;
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

import dao.IProduct;
import entities.*;
import util.DatabaseConnection;

public class ProductImpl extends UnicastRemoteObject implements IProduct {
  private Session session;

  public ProductImpl() throws RemoteException {
    session = DatabaseConnection.getInstance().getSessionFactory().openSession();
  }

  @Override
  public List<Product> findProductMaxPrice() throws RemoteException {
    List<Product> list = new ArrayList<Product>();
    Transaction transaction = session.beginTransaction();
    try {
      String sql = "select * from products where list_price = (select max(list_price) from products)";
      NativeQuery<Product> query = session.createNativeQuery(sql, Product.class);
      list = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public List<Product> findProductNeverSold() throws RemoteException {
    List<Product> list = new ArrayList<Product>();
    Transaction transaction = session.beginTransaction();
    try {
      String sql = "select * from products where product_id not in (select product_id from order_items)";
      NativeQuery<Product> query = session.createNativeQuery(sql, Product.class);
      list = query.getResultList();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public Map<Product, Integer> getTotalProduct() throws RemoteException {
    Map<Product, Integer> map = new HashMap<Product, Integer>();
    Transaction transaction = session.beginTransaction();
    try {
      Query<Object[]> query = session
          .createNamedQuery("OrderItem.findOrderItemWithProduct", Object[].class);
      List<Object[]> list = query.getResultList();
      for (Object[] objects : list) {
        int proId = (int) objects[0];
        Product product = session.find(Product.class, proId);
        int num = (int) objects[1];
        map.put(product, num);
      }
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return map;
  }

  @Override
  public void updatePriceByProductId(int productId, BigDecimal price) throws RemoteException {
    Transaction transaction = session.beginTransaction();
    try {
      String sql = "update products set list_price = :price where product_id = :productId";
      NativeQuery<Object> query = session.createNativeQuery(sql, Object.class);
      query.setParameter("price", price);
      query.setParameter("productId", productId);
      query.executeUpdate();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }

  }

}
