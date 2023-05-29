package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{

}
