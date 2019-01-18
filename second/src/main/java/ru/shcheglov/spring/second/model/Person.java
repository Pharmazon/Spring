package ru.shcheglov.spring.second.model;

import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_persons")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p LEFT JOIN FETCH p.tasks"),
        @NamedQuery(name = "Person.removeAll", query = "DELETE FROM Person p"),
        @NamedQuery(name = "Person.findOneByEmail", query = "SELECT p FROM Person p WHERE p.email = :personEmail"),
        @NamedQuery(name = "Person.findOne",
                query = "SELECT p FROM Person p LEFT JOIN FETCH p.tasks WHERE p.id = :personId")
})
public class Person extends AbstractEntity {

    @Nullable
    @Column(name = "first_name")
    private String firstName;

    @Nullable
    @Column(name = "last_name")
    private String lastName;

    @Nullable
    @Column(name = "middle_name")
    private String middleName;

    @Nullable
    @Column(name = "email")
    private String email;

    @Nullable
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Task> tasks;

    public Person(@Nullable final String firstName, @Nullable final String lastName, @Nullable final String middleName,
                  @Nullable final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getShort() {
        return lastName + " " + firstName;
    }

    public boolean isSelected(final String userId) {
        if (userId == null | userId.isEmpty()) return false;
        return getId().equals(userId);
    }

}
