package ru.shcheglov.spring.second.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractEntity {

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String middleName;

    @Nullable
    private String email;

    @Nullable
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
