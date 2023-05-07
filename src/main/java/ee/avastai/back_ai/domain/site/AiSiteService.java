package ee.avastai.back_ai.domain.site;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static ee.avastai.back_ai.domain.Status.ACTIVE;

@Service
public class AiSiteService {
    @Resource
    private AiSiteRepository aiSiteRepository;

    public List<AiSite> findAllSites(){
        return aiSiteRepository.findActiveSites(ACTIVE);
    }
}
