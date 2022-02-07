package orangewood.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import orangewood.demo.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
