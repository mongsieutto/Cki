package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue
  @Column(name = "employee_id")
  private int id;

}
