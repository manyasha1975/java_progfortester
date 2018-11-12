package ru.mytest.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactNickName;
    private final String contactTitle;
    private final String contactCompany;
    private final String contactAddress;
    private final String contactMobile;
    private final String contactEmail;
    private String group;

    public ContactData(int id, String contactFirstName, String contactLastName, String contactNickName, String contactTitle, String contactCompany, String contactAddress, String contactMobile, String contactEmail, String group) {
        this.id = id;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactNickName = contactNickName;
        this.contactTitle = contactTitle;
        this.contactCompany = contactCompany;
        this.contactAddress = contactAddress;
        this.contactMobile = contactMobile;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public ContactData(String contactFirstName, String contactLastName, String contactNickName, String contactTitle, String contactCompany, String contactAddress, String contactMobile, String contactEmail, String group) {
        this.id = Integer.MAX_VALUE;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactNickName = contactNickName;
        this.contactTitle = contactTitle;
        this.contactCompany = contactCompany;
        this.contactAddress = contactAddress;
        this.contactMobile = contactMobile;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactNickName() {
        return contactNickName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public String getContactCompany() {
        return contactCompany;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getGroup() {
        return group;
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
        return Objects.equals(contactFirstName, that.contactFirstName) &&
                Objects.equals(contactLastName, that.contactLastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactFirstName, contactLastName);
    }
}
