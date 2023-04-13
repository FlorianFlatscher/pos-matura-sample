package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "applicant_status")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class ApplicantStatus extends AbstractPersistable<Long> {
}
