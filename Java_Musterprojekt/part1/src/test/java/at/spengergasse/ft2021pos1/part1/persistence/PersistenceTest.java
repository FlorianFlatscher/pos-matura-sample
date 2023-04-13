package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.fixtures.DomainFixtures;
import at.spengergasse.ft2021pos1.part1.support.ArgumentSupport;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Getter
public class PersistenceTest {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UploadRepository uploadRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    // Provides entities with corresponding repositories
    private static Stream<Arguments> testPersistenceProvider() {
        // ArgumentSupport.functionalArgument = shorthand for treating the function as object
        return Stream.of(
                Arguments.arguments(DomainFixtures.task1(), ArgumentSupport.functionalArgument(PersistenceTest::getTaskRepository)),
                Arguments.arguments(DomainFixtures.department1(), ArgumentSupport.functionalArgument(PersistenceTest::getDepartmentRepository)),
                Arguments.arguments(DomainFixtures.applicant1(), ArgumentSupport.functionalArgument(PersistenceTest::getApplicantRepository)),
                Arguments.arguments(DomainFixtures.upload1(), ArgumentSupport.functionalArgument(PersistenceTest::getUploadRepository))
        );
    }

    @ParameterizedTest(name = "{index} for entity {0}")
    @Transactional
    @MethodSource("testPersistenceProvider")
    <T extends AbstractPersistable<ID>, ID extends Serializable> void testPersistence(T entity, Function<PersistenceTest, JpaRepository<T, ID>> repositoryProvider) {
        // need to unwrap the repository. It can't be provided directly as Arguments have to be served in static context
        var repository = repositoryProvider.apply(this);

        // empty
        assertThat(repository.findAll().size()).isEqualTo(0);

        // present
        repository.save(entity);
        assertThat(repository.findById(Objects.requireNonNull(entity.getId())).isPresent()).isTrue();

        // not present
        repository.delete(entity);
        assertThat(repository.findById(Objects.requireNonNull(entity.getId())).isPresent()).isFalse();

        // empty
        assertThat(repository.findAll().size()).isEqualTo(0);

    }
}
