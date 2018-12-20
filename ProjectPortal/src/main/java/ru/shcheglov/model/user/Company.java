package ru.shcheglov.model.user;

import lombok.*;
import ru.shcheglov.model.basic.AbstractEntity;
import ru.shcheglov.model.address.Address;

import javax.persistence.*;

/**
 * @author Alexey Shcheglov
 * @version dated 13.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "Company.deleteAll", query = "DELETE FROM Company c")
})
public class Company extends AbstractEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "company")
    private User user;

}
