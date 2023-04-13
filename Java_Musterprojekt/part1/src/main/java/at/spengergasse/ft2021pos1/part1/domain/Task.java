package at.spengergasse.ft2021pos1.part1.domain;


import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Task extends AbstractPersistable<Long> {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public void setDateFrom(LocalDate dateFrom) {
        if (dateFrom == null || dateFrom.isAfter(dateTo)) {
            throw new IllegalArgumentException("dateFrom must be before dateTo");
        }
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        if (dateTo == null || dateTo.isBefore(dateFrom)) {
            throw new IllegalArgumentException("dateTo must be after dateFrom");
        }
        this.dateTo = dateTo;
    }

    @ManyToOne
    private Department department;

}
