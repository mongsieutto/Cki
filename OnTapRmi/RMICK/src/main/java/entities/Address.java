package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

  @Column(columnDefinition = "nvarchar(50)")
  private String city;

  @Column(columnDefinition = "nvarchar(10)")
  private String state;

  @Column(columnDefinition = "varchar(255)")
  private String street;

  @Column(columnDefinition = "nvarchar(5)", name = "zip_code")
  private String zipCode;

  public Address() {
  }

  public Address(String city, String state, String street, String zipCode) {
    this.city = city;
    this.state = state;
    this.street = street;
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "Address [city=" + city + ", state=" + state + ", street=" + street + ", zipCode=" + zipCode + "]";
  }

}
