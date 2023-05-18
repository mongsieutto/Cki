package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@NamedNativeQueries({
    @NamedNativeQuery(name = "Order.findOrderWithCustomer", query = "  select customer_id, num = count(*) from orders group by customer_id")
})
public class Order implements Serializable {

  @Id
  @Column(name = "order_id", nullable = false)
  private int id;

  @Column(name = "order_date")
  private LocalDate orderDate;

  @Column(name = "order_status")
  private byte orderStatus;

  @Column(name = "required_date")
  private LocalDate requiredDate;

  @Column(name = "shipped_date")
  private LocalDate shippedDate;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "staff_id")
  private Staff staff;

  @OneToMany(mappedBy = "order")
  private List<OrderItem> items;

  public Order() {
  }

  public Order(int id, LocalDate orderDate, byte orderStatus, LocalDate requiredDate, LocalDate shippedDate) {
    this.id = id;
    this.orderDate = orderDate;
    this.orderStatus = orderStatus;
    this.requiredDate = requiredDate;
    this.shippedDate = shippedDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public byte getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(byte orderStatus) {
    this.orderStatus = orderStatus;
  }

  public LocalDate getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(LocalDate requiredDate) {
    this.requiredDate = requiredDate;
  }

  public LocalDate getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(LocalDate shippedDate) {
    this.shippedDate = shippedDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", requiredDate="
        + requiredDate + ", shippedDate=" + shippedDate + "]";
  }

}
