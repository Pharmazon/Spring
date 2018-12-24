package ru.shcheglov.model.user;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_users")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT c FROM User c"),
        @NamedQuery(name = "User.deleteAll", query = "DELETE FROM User c"),
        @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
})
public class User extends AbstractEntity {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserProfile userProfile;

}
