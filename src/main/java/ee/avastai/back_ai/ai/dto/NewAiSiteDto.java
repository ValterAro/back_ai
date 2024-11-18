package ee.avastai.back_ai.ai.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.avastai.back_ai.domain.site.AiSite}
 */
@Data
public class NewAiSiteDto implements Serializable {
    @NotNull
    @Size(max = 255)
    String name;
    @NotNull
    @Size(max = 255)
    String company;
    @NotNull
    @Size(max = 255)
    String description;
    @NotNull
    @Size(max = 255)
    String link;
    @NotNull
    Integer typeId;
    @NotNull
    Integer userId;
    @NotNull
    @Size(max = 10)
    String pricingType;
}