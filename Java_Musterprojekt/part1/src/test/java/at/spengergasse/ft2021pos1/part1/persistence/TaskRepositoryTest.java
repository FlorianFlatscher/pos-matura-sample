package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Transactional
    void addDepartmentSuccessTest() {
        var department = DomainFixtures.department1();
        var task = DomainFixtures.task1();

        task.setDepartment(department);

        departmentRepository.save(department);
        taskRepository.save(task);

        assertThat(department.getId()).isNotNull();
        assertThat(task.getId()).isNotNull();

        var taskFromDb = taskRepository.findById(task.getId());
        assertThat(taskFromDb).isPresent();
        assertThat(taskFromDb.get().getDepartment()).isNotNull();
    }
}
