package ru.mytest.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity  //declare that ContactData linked to database
@Table(name = "address_in_groups")  //set needed table name
public class ContactInGroupData {

  @Id //this parameter is identifier
  @Column(name = "id")
  private int id;

  @Column(name = "group_id")
  private int group_id;

  public int getId() {
    return id;
  }

  public int getGroup_id() {
    return group_id;
  }

  public ContactInGroupData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactInGroupData withGroupId(int group_id) {
    this.group_id = group_id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactInGroupData that = (ContactInGroupData) o;
    return id == that.id &&
            group_id == that.group_id;
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, group_id);
  }
}
