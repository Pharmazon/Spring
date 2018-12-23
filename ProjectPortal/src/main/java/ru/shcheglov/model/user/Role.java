package ru.shcheglov.model.user;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_roles")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT a FROM Role a"),
        @NamedQuery(name = "Role.deleteAll", query = "DELETE FROM Role a"),
        @NamedQuery(name = "Role.findOneByUser", query = "SELECT a FROM UserProfile a INNER JOIN a.role c WHERE c = :role")
})
public class Role extends AbstractEntity {

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserProfile> users;

    @Override
    public String toString() {
        return getName();
    }
}
