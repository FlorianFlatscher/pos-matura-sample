package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Department extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true)
    private String name;


    @OneToMany
    private List<Task> task;

}
