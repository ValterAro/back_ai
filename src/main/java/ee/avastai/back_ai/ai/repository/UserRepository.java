package ee.avastai.back_ai.ai.repository;

import ee.avastai.back_ai.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}