package ru.shcheglov.model.user;

import ru.shcheglov.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 19.12.2018
 */

@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
