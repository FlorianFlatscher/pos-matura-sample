package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Applicant;
import at.spengergasse.ft2021pos1.part1.domain.ApplicantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantStatusRepository extends JpaRepository<ApplicantStatus, Long> {


}
