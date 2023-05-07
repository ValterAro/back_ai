package ee.avastai.back_ai.ai;

import ee.avastai.back_ai.ai.dto.AiSiteDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiService aiService;

    @GetMapping("/sites")
    @Operation(summary = "Get all sites", description = "Gets all sites from the database")
    public List<AiSiteDto> getAllToys() {return aiService.getAllSites(); }


}
