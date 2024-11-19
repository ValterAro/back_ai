package ee.avastai.back_ai.ai.service;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import ee.avastai.back_ai.ai.dto.NewAiSiteDto;
import ee.avastai.back_ai.ai.repository.AiSiteRepository;
import ee.avastai.back_ai.domain.site.AiSite;
import ee.avastai.back_ai.ai.mapper.AiSiteMapper;
import ee.avastai.back_ai.domain.type.Type;
import ee.avastai.back_ai.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ee.avastai.back_ai.ai.repository.TypeRepository;
import ee.avastai.back_ai.ai.repository.UserRepository;


import java.time.Instant;
import java.util.List;

@Service
public class AiService {

    @Resource
    private AiSiteService aiSiteService;
    @Resource
    private AiSiteMapper aiSiteMapper;
    @Autowired
    private AiSiteRepository aiSiteRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AiSiteDto> getAllSites() {
        List<AiSite> aiSites = aiSiteService.findAllSites();
        return aiSiteMapper.toDtos(aiSites);

    }

    public AiSiteDto getSiteById(int id) {
        AiSite aiSite = aiSiteService.findSiteById(id)
                .orElseThrow(() -> new RuntimeException("AI site not found with id: " + id));
        return aiSiteMapper.toDto(aiSite);
    }

    public AiSiteDto createSite(NewAiSiteDto newAiSiteDto) {
        AiSite aiSite = aiSiteMapper.toEntity(newAiSiteDto);

        Type type = typeRepository.findById(newAiSiteDto.getTypeId())
                .orElseThrow(() -> new RuntimeException("Type not found with id: " + newAiSiteDto.getTypeId()));
        aiSite.setType(type);

        User user = userRepository.findById(newAiSiteDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + newAiSiteDto.getUserId()));
        aiSite.setUser(user);

        aiSite.setCreatedAt(Instant.now());
        aiSite.setUpdatedAt(Instant.now());

        AiSite savedAiSite = aiSiteRepository.save(aiSite);

        return aiSiteMapper.toDto(savedAiSite);
    }

    public AiSiteDto updateSite(int id, NewAiSiteDto newAiSiteDto) {
        AiSite existingSite = aiSiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ai site not found with id: " + id));

        aiSiteMapper.partialUpdate(newAiSiteDto, existingSite);
        existingSite.setUpdatedAt(Instant.now());
        AiSite updatedSite = aiSiteRepository.save(existingSite);
        return aiSiteMapper.toDto(updatedSite);
    }
}
