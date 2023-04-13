package at.spengergasse.ft2021pos1.part1.fixtures;

import at.spengergasse.ft2021pos1.part1.domain.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DomainFixtures {

    public static Applicant applicant1() {
        return Applicant.builder()
                .name(HumanName.builder().firstName("Max").lastName("Mustermann").build())
                .email("max.mustermann@gmail.com")
                .dateOfBirth(LocalDate.of(1999, 1, 1))
                .gender(Gender.MALE)
                .phoneNumber("+437123123")
                .build();
    }

    public static Task task1() {
        return Task.builder()
                .dateTo(LocalDate.of(1999, 1, 1))
                .dateFrom(LocalDate.of(1998, 1, 1))
                .build();
    }

    public static Upload upload1() {
        return Upload.builder()
                .url("https://...")
                .date(LocalDateTime.of(1998, 1, 2, 20, 1))
                .build();
    }

    public static Department department1() {
        return Department.builder()
                .name("Informatik")
                .build();
    }

}
