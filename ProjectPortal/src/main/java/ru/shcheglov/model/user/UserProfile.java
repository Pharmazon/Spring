package ru.shcheglov.model.user;

import lombok.*;
import ru.shcheglov.model.Ad;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 23.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user_profiles")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "UserProfile.findAll",
                query = "SELECT up FROM UserProfile up LEFT JOIN FETCH up.company " +
                        "INNER JOIN FETCH up.role LEFT JOIN FETCH up.user"),
        @NamedQuery(name = "UserProfile.deleteAll", query = "DELETE FROM UserProfile c"),
        @NamedQuery(name = "UserProfile.findOne",
                query = "SELECT DISTINCT up FROM UserProfile up INNER JOIN FETCH up.company " +
                        "INNER JOIN FETCH up.role INNER JOIN FETCH up.user WHERE up.id = :userId")
})
public class UserProfile extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_registered")
    private LocalDateTime dateRegistered;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Ad> ads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getFormattedDateTime() {
        return dateRegistered.format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm:ss"));
    }

    public String getFormattedDate() {
        return dateRegistered.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public String getFormattedTime() {
        return dateRegistered.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
