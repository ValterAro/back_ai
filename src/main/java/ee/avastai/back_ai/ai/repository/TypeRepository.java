package ee.avastai.back_ai.ai.repository;

import ee.avastai.back_ai.domain.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}