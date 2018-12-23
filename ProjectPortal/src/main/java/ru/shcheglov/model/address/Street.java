package ru.shcheglov.model.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.shcheglov.model.common.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexey Shcheglov
 * @version dated 18.12.2018
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_streets")
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
