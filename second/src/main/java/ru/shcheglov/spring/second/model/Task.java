package ru.shcheglov.spring.second.model;


import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

/**
 * @author Alexey Shcheglov
 * @version dated 16.01.2019
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_tasks")
@NamedQueries({
        @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t LEFT JOIN FETCH t.person"),
        @NamedQuery(name = "Task.removeAll", query = "DELETE FROM Task t"),
        @NamedQuery(name = "Task.findOne", query = "SELECT t FROm Task t WHERE t.id = :taskId")
})
public class Task extends AbstractEntity {

    @Nullable
    @Column(name = "name")
    private String name = "";

    @Nullable
    @Column(name = "description")
    private String description = "";

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person = null;

    public Task(@Nullable final String name) {
        this.name = name;
    }

}
