package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable {

  @Column(columnDefinition = "varchar(255)")
  private String email;

  @Column(columnDefinition = "nvarchar(25)")
  private String phone;

  public Contact() {
  }

  public Contact(String email, String phone) {
    this.email = email;
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "Contact [email=" + email + ", phone=" + phone + "]";
  }

}
