package entities;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@NamedNativeQueries({
    @NamedNativeQuery(name = "Customer.findCustomerByState", query = "select state, num = count(*) from customers group by state")
})
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer extends Person {

  @Embedded
  private Address address;

  @OneToMany(mappedBy = "customer")
  private List<Order> orders;

  public Customer() {
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

}
