package tbp.integration.test.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tbp.integration.test.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByAddress(String address);
}
