package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enrolled")
@DiscriminatorValue("enrolled")

@Builder()
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Enrolled extends ApplicantStatus {
}
