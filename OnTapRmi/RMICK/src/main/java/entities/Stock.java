package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

  private int quantity;

  @Id
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  @Id
  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    result = prime * result + ((store == null) ? 0 : store.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Stock other = (Stock) obj;
    if (product == null) {
      if (other.product != null)
        return false;
    } else if (!product.equals(other.product))
      return false;
    if (store == null) {
      if (other.store != null)
        return false;
    } else if (!store.equals(other.store))
      return false;
    return true;
  }

  public Stock() {
  }

  public Stock(int quantity, Product product, Store store) {
    this.quantity = quantity;
    this.product = product;
    this.store = store;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  @Override
  public String toString() {
    return "Stock [quantity=" + quantity + "]";
  }

}
