package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person implements Serializable {

  @Column(nullable = false, columnDefinition = "nvarchar(50)", name = "first_name")
  protected String firstName;

  @Id
  protected int id;

  @Column(columnDefinition = "nvarchar(50)", name = "last_name")
  protected String lastName;

  @Embedded
  protected Contact contact;
}
