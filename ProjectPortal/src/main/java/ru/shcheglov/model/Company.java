package ru.shcheglov.model;

import ru.shcheglov.model.address.Address;
import ru.shcheglov.model.user.User;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Entity
@Table(name = "company")
@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "Company.deleteAll", query = "DELETE FROM Company c")
})
public class Company extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    private User user;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + super.getName() + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }
}
