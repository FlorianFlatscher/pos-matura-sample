package at.spengergasse.ft2021pos1.part1.domain;


import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HumanName
{
    private String firstName;
    private String lastName;
}
