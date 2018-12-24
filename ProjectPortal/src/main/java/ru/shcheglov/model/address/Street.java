package ru.shcheglov.model.address;

import lombok.*;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_streets")
@EqualsAndHashCode(callSuper = true)
@NamedQueries({
        @NamedQuery(name = "Street.findAll", query = "SELECT c FROM Street c"),
        @NamedQuery(name = "Street.deleteAll", query = "DELETE FROM Street c")
})
public class Street extends AbstractEntity {

    @Column(name = "house")
    private Integer house;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_type_id")
    private StreetType streetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_name_id")
    private StreetName streetName;

    @OneToMany(mappedBy = "street", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Street=" + streetType.getShortName() + " " + getName() + ", д. " + house;
    }
}
