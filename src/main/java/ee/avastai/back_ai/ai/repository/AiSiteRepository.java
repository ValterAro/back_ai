package ee.avastai.back_ai.ai.repository;

import ee.avastai.back_ai.domain.site.AiSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AiSiteRepository extends JpaRepository<AiSite, Integer> {
    @Query("select a from AiSite a where a.status = ?1 order by a.name")
    List<AiSite> findActiveSites(String status);


}