package at.spengergasse.ft2021pos1.part1.persistence;


import at.spengergasse.ft2021pos1.part1.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {

}