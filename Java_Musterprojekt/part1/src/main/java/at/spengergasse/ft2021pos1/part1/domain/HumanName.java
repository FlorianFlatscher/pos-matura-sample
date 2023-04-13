package at.spengergasse.ft2021pos1.part1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class HumanName
{
    private String firstName;
    private String lastName;
}
