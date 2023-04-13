package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applicant")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Applicant extends AbstractPersistable<Long> {

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "applicant")
    private List<Upload> upload;

    @ManyToOne
    private Department department;

    @OneToOne
    private ApplicantStatus applicantStatus;

}
