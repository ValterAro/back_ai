package ee.avastai.back_ai.ai.controller;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import ee.avastai.back_ai.ai.dto.NewAiSiteDto;
import ee.avastai.back_ai.ai.service.AiService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiService aiService;

    @GetMapping("/sites")
    @Operation(summary = "Get all sites", description = "Gets all sites from the database")
    public List<AiSiteDto> getAllSites() {return aiService.getAllSites(); }

    @PostMapping("/sites")
    @Operation(summary = "Add a new AI site", description = "Creates a new AI site entry in the directory")
    public AiSiteDto createSite(@RequestBody NewAiSiteDto newAiSiteDto) {
        return aiService.createSite(newAiSiteDto);
    }

    @GetMapping("/sites/{id}")
    @Operation(summary = "Get AI Site by ID", description = "Retrieves a specific AI site by its ID")
    public AiSiteDto getSiteById(@PathVariable int id) {
        return aiService.getSiteById(id);
    }

    @PutMapping("/sites/{id}")
    @Operation(summary = "Update AI Site", description = "Updates an existing AI site's information")
    public AiSiteDto updateSite(@PathVariable int id, @RequestBody NewAiSiteDto newAiSiteDto) {
        return aiService.updateSite(id, newAiSiteDto);
    }



}
