package ee.avastai.back_ai.ai.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link ee.avastai.back_ai.domain.site.AiSite} entity
 */
@Data
public class AiSiteDto implements Serializable {
    private final Integer id;
    @Size(max = 255)
    @NotNull
    private final String name;
    @Size(max = 255)
    @NotNull
    private final String company;
    @Size(max = 255)
    @NotNull
    private final String description;
    @Size(max = 255)
    @NotNull
    private final String link;
    @Size(max = 255)
    @NotNull
    private final String typeName;
    @Size(max = 255)
    @NotNull
    private final String userUsername;
    @Size(max = 1)
    @NotNull
    private final String status;
    @NotNull
    private final Instant createdAt;
    private final Instant updatedAt;
}