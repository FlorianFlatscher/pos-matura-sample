package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Rated;
import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Transactional
    void addDepartmentSuccessTest() {
        var department = DomainFixtures.department1();

        departmentRepository.save(department);
        assertThat(department.getId()).isNotNull();
    }
}
