package ru.shcheglov.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.basic.AbstractEntity;

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
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT a FROM Role a"),
        @NamedQuery(name = "Role.deleteAll", query = "DELETE FROM Role a")
})
public final class Role extends AbstractEntity {

    @OneToMany(mappedBy = "role")
    private List<User> users;

}
