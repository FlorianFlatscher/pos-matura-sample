package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Enrolled;
import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UploadRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private UploadRepository uploadRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void addDepartmentSuccessTest() {
        var applicant = DomainFixtures.applicant1();
        var task = DomainFixtures.task1();
        var upload = DomainFixtures.upload1();

        applicantRepository.save(applicant);
        taskRepository.save(task);

        upload.setApplicant(applicant);
        upload.setTask(task);

        uploadRepository.save(upload);

        assertThat(upload.getId()).isNotNull();
        assertThat(applicant.getId()).isNotNull();
        assertThat(task.getId()).isNotNull();

        var uploadFromDb = uploadRepository.findById(upload.getId());
        assertThat(uploadFromDb).isPresent();
        assertThat(uploadFromDb.get().getApplicant()).isNotNull();
        assertThat(uploadFromDb.get().getTask()).isNotNull();
        assertThat(uploadFromDb.get().getApplicant().getId()).isEqualTo(applicant.getId());
        assertThat(uploadFromDb.get().getTask().getId()).isEqualTo(task.getId());

    }
}
