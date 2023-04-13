package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @Embedded
    private HumanName name;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Upload> upload = new ArrayList<>();

    public void setUpload(List<Upload> upload) {
        this.upload.clear();
        this.upload.addAll(upload);
        upload.forEach(u -> u.setApplicant(this));
    }

    public void addUpload(Upload upload) {
        this.upload.add(upload);
        upload.setApplicant(this);
    }

    @ManyToOne
    private Department department;

    @OneToOne(cascade = CascadeType.PERSIST)
    @Builder.Default
    private ApplicantStatus applicantStatus = new Enrolled();

}
