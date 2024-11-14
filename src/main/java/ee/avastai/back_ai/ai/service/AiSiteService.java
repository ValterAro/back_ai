package ee.avastai.back_ai.ai.service;

import ee.avastai.back_ai.ai.repository.AiSiteRepository;
import ee.avastai.back_ai.domain.site.AiSite;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.avastai.back_ai.domain.Status.ACTIVE;

@Service
public class AiSiteService {
    @Resource
    private AiSiteRepository aiSiteRepository;

    public List<AiSite> findAllSites(){
        return aiSiteRepository.findActiveSites(ACTIVE);
    }

    public Optional<AiSite> findSiteById(int id) {
        return aiSiteRepository.findById(id);
    }
}
