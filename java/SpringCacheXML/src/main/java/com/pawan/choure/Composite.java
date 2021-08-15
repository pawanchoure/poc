package com.pawan.choure;

import java.util.List;

public class Composite {
    String publication ;
    Integer id;
    List<Customer> customers;

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Composite(String publication, List<Customer> customers) {
        this.publication = publication;
        this.customers = customers;
    }


    public Composite(String publication, List<Customer> customers,Integer id) {
        this.publication = publication;
        this.customers = customers;
        this.id=id;
    }

    public Composite() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        if (!publication.equals(composite.publication)) return false;
        return id.equals(composite.id);
    }

    @Override
    public int hashCode() {
        int result = publication.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
