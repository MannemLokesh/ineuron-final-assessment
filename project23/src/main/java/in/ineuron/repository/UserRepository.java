package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>
{

}
