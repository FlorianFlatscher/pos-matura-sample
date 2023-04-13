package at.spengergasse.ft2021pos1.part1.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "uploads_done")
@DiscriminatorValue("uploads_done")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class UploadsDone extends ApplicantStatus {
}
