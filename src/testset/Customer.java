package testset;

import java.util.Objects;

public class Customer {
    private String name;
    private Integer id;

    public Customer(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Customer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) &&
                id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
