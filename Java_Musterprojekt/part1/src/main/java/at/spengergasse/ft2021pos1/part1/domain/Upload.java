package at.spengergasse.ft2021pos1.part1.domain;


import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Predicate;

@Entity
@Table(name = "upload")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Upload extends AbstractPersistable<Long> {

    private LocalDateTime date;

    private String url;

    private static Predicate<Upload> isInTime = u -> Optional.ofNullable(u)
            .map(upload -> upload.date.isAfter(upload.task.getDateFrom().atStartOfDay()) && upload.date.isBefore(upload.task.getDateTo().plusDays(1).atStartOfDay()))
            .orElse(false);

    @ManyToOne
    private Task task;

    @ManyToOne
    private Applicant applicant;

}
