package dao;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entities.Product;

public interface IProduct extends Remote {
  // 2. find list product have max price
  List<Product> findProductMaxPrice() throws RemoteException;

  // 3. Find a list of products that have never been sold.
  List<Product> findProductNeverSold() throws RemoteException;

  // 7. Calculate the total quantity of each product sold.
  Map<Product, Integer> getTotalProduct() throws RemoteException;

  // 9. Update the price of a product when knowing the product id.
  void updatePriceByProductId(int productId, BigDecimal price) throws RemoteException;
}
