package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
  @Id
  @Column(name = "product_id", nullable = false)
  private int id;
  @Column(columnDefinition = "decimal(10,2)", name = "list_price")
  private double listPrice;

  @Column(columnDefinition = "smallint", name = "model_year")
  private int modelYear;

  @Column(name = "product_name", columnDefinition = "nvarchar(255)")
  private String name;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "product")
  private List<OrderItem> items;

  @OneToMany(mappedBy = "product")
  private List<Stock> stocks;

  public Product() {
  }

  public Product(int id, double listPrice, int modelYear, String name) {
    this.id = id;
    this.listPrice = listPrice;
    this.modelYear = modelYear;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getListPrice() {
    return listPrice;
  }

  public void setListPrice(double listPrice) {
    this.listPrice = listPrice;
  }

  public int getModelYear() {
    return modelYear;
  }

  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  public List<Stock> getStocks() {
    return stocks;
  }

  public void setStocks(List<Stock> stocks) {
    this.stocks = stocks;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", listPrice=" + listPrice + ", modelYear=" + modelYear + ", name=" + name + "]";
  }

}
