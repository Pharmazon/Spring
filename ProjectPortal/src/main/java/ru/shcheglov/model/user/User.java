package ru.shcheglov.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
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

}
