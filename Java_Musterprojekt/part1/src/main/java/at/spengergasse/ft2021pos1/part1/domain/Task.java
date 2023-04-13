package at.spengergasse.ft2021pos1.part1.domain;


import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Task extends AbstractPersistable<Long> {

    @ManyToOne
    private Department department;

}
