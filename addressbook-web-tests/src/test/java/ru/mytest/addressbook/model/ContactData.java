package ru.mytest.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String contactFirstName;
    private String contactLastName;
    private String contactNickName;
    private String contactTitle;
    private String contactCompany;
    private String contactAddress;
    private String contactHomePhone;
    private String contactMobilePhone;
    private String contactWorkPhone;
    private String contactEmail;
    private String group;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return contactFirstName;
    }

    public String getLastName() {
        return contactLastName;
    }

    public String getNickName() {
        return contactNickName;
    }

    public String getTitle() {
        return contactTitle;
    }

    public String getCompany() {
        return contactCompany;
    }

    public String getAddress() {
        return contactAddress;
    }

    public String getHomePhone() {
        return contactHomePhone;
    }

    public String getMobilePhone() {
        return contactMobilePhone;
    }

    public String getWorkPhone() {
        return contactWorkPhone;
    }

    public String getEmail() {
        return contactEmail;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
        return this;
    }

    public ContactData withLastName(String contactLastName) {
        this.contactLastName = contactLastName;
        return this;
    }

    public ContactData withNickName(String contactNickName) {
        this.contactNickName = contactNickName;
        return this;
    }

    public ContactData withTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    public ContactData withCompany(String contactCompany) {
        this.contactCompany = contactCompany;
        return this;
    }

    public ContactData withAddress(String contactAddress) {
        this.contactAddress = contactAddress;
        return this;
    }

    public ContactData withHomePhone(String contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
        return this;
    }

    public ContactData withMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
    }

    public ContactData withEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(contactFirstName, that.contactFirstName) &&
                Objects.equals(contactLastName, that.contactLastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contactFirstName, contactLastName);
    }

}
