package ee.avastai.back_ai.ai.service;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import ee.avastai.back_ai.domain.site.AiSite;
import ee.avastai.back_ai.ai.mapper.AiSiteMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiService {

    @Resource
    private AiSiteService aiSiteService;
    @Resource
    private AiSiteMapper aiSiteMapper;

    public List<AiSiteDto> getAllSites() {
        List<AiSite> aiSites = aiSiteService.findAllSites();
        return aiSiteMapper.toDtos(aiSites);

    }

    public AiSiteDto getSiteById(int id) {
        AiSite aiSite = aiSiteService.findSiteById(id)
                .orElseThrow(() -> new RuntimeException("AI site not found with id: " + id));
        return aiSiteMapper.toDto(aiSite);
    }
}
