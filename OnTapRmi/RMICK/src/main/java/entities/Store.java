package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store implements Serializable {

  @Id
  @Column(name = "store_id", nullable = false)
  private int id;
  @Column(name = "store_name", columnDefinition = "nvarchar(255)")
  private String name;

  @Embedded
  private Address address;

  @Embedded
  private Contact contact;

  @OneToMany(mappedBy = "store")
  private List<Stock> stocks;

  @OneToMany(mappedBy = "store")
  private List<Staff> staffs;

  public Store() {
  }

  public Store(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public List<Stock> getStocks() {
    return stocks;
  }

  public void setStocks(List<Stock> stocks) {
    this.stocks = stocks;
  }

  public List<Staff> getStaffs() {
    return staffs;
  }

  public void setStaffs(List<Staff> staffs) {
    this.staffs = staffs;
  }

  @Override
  public String toString() {
    return "Store [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + "]";
  }

}
