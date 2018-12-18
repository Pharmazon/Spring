package ru.shcheglov.model.user;

import ru.shcheglov.model.AbstractEntity;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.Company;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c"),
        @NamedQuery(name = "User.deleteAll", query = "DELETE FROM User c")
})
public class User extends AbstractEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "date_registered")
    private LocalDateTime dateRegistered;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne
    @MapsId
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<Ad> ads;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + super.getName() + '\'' +
                ", dateRegistered=" + dateRegistered +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", company=" + company +
                '}';
    }
    
}
