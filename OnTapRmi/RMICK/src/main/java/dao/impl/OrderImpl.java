package dao.impl;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import dao.IOrder;
import util.DatabaseConnection;

public class OrderImpl extends UnicastRemoteObject implements IOrder {

  private Session session;

  public OrderImpl() throws RemoteException {
    session = DatabaseConnection.getInstance().getSessionFactory().openSession();
  }

  @Override
  public BigDecimal getTotalAmountByOrderNumber(String orderId) throws RemoteException {
    BigDecimal total = new BigDecimal(0);
    Transaction transaction = session.beginTransaction();
    try {
      String sql = "select sum(list_price*quantity*(1-discount)) from order_items where order_id = :orderId";
      NativeQuery<Object> query = session.createNativeQuery(sql, Object.class);
      query.setParameter("orderId", orderId);
      total = (BigDecimal) query.getSingleResult();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return total;
  }

  @Override
  public BigDecimal getTotalAmountByDate(String date) throws RemoteException {
    BigDecimal total = new BigDecimal(0);
    Transaction transaction = session.beginTransaction();
    try {
      // subquery
      // String sql = "select sum(list_price*quantity*(1-discount)) from order_items
      // where order_id in (select order_id from orders where order_date = :date)";
      // NativeQuery<Object> query = session.createNativeQuery(sql, Object.class);
      String sql = "select sum(list_price*quantity*(1-discount)) from order_items join orders ON order_items.order_id = orders.order_id where order_date = :date group by order_date";
      NativeQuery<Object> query = session
          .createNativeQuery(
              sql, Object.class);
      query.setParameter("date", date);
      total = (BigDecimal) query.getSingleResult();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return total;
  }

  @Override
  public BigDecimal getTotalAmountByMonthYear(String month, String year) throws RemoteException {
    BigDecimal total = new BigDecimal(0);
    Transaction transaction = session.beginTransaction();
    try {
      String sqlThangNam = "select sum(list_price*quantity*(1-discount)) from order_items join orders ON order_items.order_id = orders.order_id where month(order_date) = :month and year(order_date) = :year group by month(order_date), year(order_date)";
      // String sqlTheoThang = "select sum(list_price*quantity*(1-discount)) from
      // order_items join orders ON order_items.order_id = orders.order_id where
      // month(order_date) = :month group by month(order_date)";
      // String sqlTheoNam = "select sum(list_price*quantity*(1-discount)) from
      // order_items join orders ON order_items.order_id = orders.order_id where
      // year(order_date) = :year group by year(order_date)";
      NativeQuery<Object> query = session
          .createNativeQuery(
              sqlThangNam, Object.class);
      query.setParameter("month", month);
      query.setParameter("year", year);
      total = (BigDecimal) query.getSingleResult();
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
    return total;
  }

}
