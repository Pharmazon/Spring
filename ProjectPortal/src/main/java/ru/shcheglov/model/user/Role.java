package ru.shcheglov.model.user;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_roles")
@ToString(exclude = "users")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT a FROM Role a"),
        @NamedQuery(name = "Role.deleteAll", query = "DELETE FROM Role a"),
        @NamedQuery(name = "Role.getUserRole",
                query = "SELECT r FROM Role r WHERE r.name = :roleName"),
        @NamedQuery(name = "Role.findOneByUser",
                query = "SELECT a FROM UserProfile a INNER JOIN a.role c WHERE c = :role")
})
public class Role extends AbstractEntity {

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserProfile> users;

}
