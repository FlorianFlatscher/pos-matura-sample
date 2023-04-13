package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Enrolled;
import at.spengergasse.ft2021pos1.part1.domain.Rated;
import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ApplicantStatusRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Transactional
    void addDepartmentSuccessTest() {
        var applicant = DomainFixtures.applicant1();
        var department = DomainFixtures.department1();
        var upload = DomainFixtures.upload1();

        applicant.setDepartment(department);
        applicant.addUpload(upload);
        applicant.setApplicantStatus(Rated.builder().date(LocalDateTime.of(2000, 1, 1, 1, 1)).passed(true).build());

        departmentRepository.save(department);
        applicantRepository.save(applicant);

        assertThat(applicant.getId()).isNotNull();

        var applicantFromDb = applicantRepository.findById(applicant.getId());
        assertThat(applicantFromDb).isPresent();
        assertThat(applicantFromDb.get().getDepartment()).isNotNull();
        assertThat(applicantFromDb.get().getDepartment().getId()).isNotNull();

        assertThat(upload.getApplicant()).isNotNull();
        assertThat(upload.getApplicant().getId()).isNotNull();
        assertThat(upload.getApplicant().getId()).isEqualTo(applicant.getId());

        assertThat(applicant.getApplicantStatus()).isInstanceOf(Rated.class);
        assertThat((Rated) applicant.getApplicantStatus()).hasFieldOrPropertyWithValue("passed", true);
        assertThat(applicant.getApplicantStatus().getId()).isNotNull();

    }
}
