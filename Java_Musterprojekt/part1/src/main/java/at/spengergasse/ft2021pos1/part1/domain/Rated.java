package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "rated")
@DiscriminatorValue("rated")

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Rated extends ApplicantStatus {

    private LocalDateTime date;

    private Boolean passed;

}
