package dao;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOrder extends Remote {
  // 5. Calculate the total amount of the order when knowing the order number
  BigDecimal getTotalAmountByOrderNumber(String orderId) throws RemoteException;

  // 8. Calculate the total amount of all bills for a given day.
  BigDecimal getTotalAmountByDate(String date) throws RemoteException;

  // 12. Statistics of total bill amount by month/year.
  BigDecimal getTotalAmountByMonthYear(String month, String year) throws RemoteException;
}
