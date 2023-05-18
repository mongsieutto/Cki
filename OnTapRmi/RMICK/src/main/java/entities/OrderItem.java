package entities;

import java.io.Serializable;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
@NamedNativeQueries({
    @NamedNativeQuery(name = "OrderItem.findOrderItemWithProduct", query = "select product_id, sum(quantity) from order_items group by product_id")
})
public class OrderItem implements Serializable {
  @Id
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  @Id
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(columnDefinition = "decimal(4,2)")
  private double discount;

  @Column(name = "list_price", columnDefinition = "decimal(10,2)")
  private double listPrice;

  @Column(nullable = false)
  private int quantity;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((order == null) ? 0 : order.hashCode());
    result = prime * result + ((product == null) ? 0 : product.hashCode());
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
    OrderItem other = (OrderItem) obj;
    if (order == null) {
      if (other.order != null)
        return false;
    } else if (!order.equals(other.order))
      return false;
    if (product == null) {
      if (other.product != null)
        return false;
    } else if (!product.equals(other.product))
      return false;
    return true;
  }

  public OrderItem() {
  }

  public OrderItem(double discount, double listPrice, int quantity) {
    this.discount = discount;
    this.listPrice = listPrice;
    this.quantity = quantity;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public double getListPrice() {
    return listPrice;
  }

  public void setListPrice(double listPrice) {
    this.listPrice = listPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "OrderItem [discount=" + discount + ", listPrice=" + listPrice + ", quantity=" + quantity + "]";
  }

}
