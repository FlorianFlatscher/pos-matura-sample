package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Enrolled;
import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ApplicantRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void addDepartmentSuccessTest() {
        var applicant = DomainFixtures.applicant1();
        var department = DomainFixtures.department1();
        var upload = DomainFixtures.upload1();

        applicant.setDepartment(department);
        applicant.addUpload(upload);

        departmentRepository.save(department);
        applicantRepository.save(applicant);

        assertThat(applicant.getId()).isNotNull();
        assertThat(department.getId()).isNotNull();
        assertThat(upload.getId()).isNotNull();

        var applicantFromDb = applicantRepository.findById(applicant.getId());
        assertThat(applicantFromDb).isPresent();
        assertThat(applicantFromDb.get().getDepartment()).isNotNull();
        assertThat(applicantFromDb.get().getUpload().size()).isEqualTo(1);
        assertThat(upload.getApplicant()).isNotNull();
        assertThat(upload.getApplicant().getId()).isEqualTo(applicant.getId());
        assertThat(applicantFromDb.get().getApplicantStatus()).isInstanceOf(Enrolled.class);

    }
}
