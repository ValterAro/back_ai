package ee.avastai.back_ai.ai.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link ee.avastai.back_ai.domain.comment.Comment}
 */
@Value
public class CommentDto implements Serializable {
    @NotNull
    Integer userId;
    @NotNull
    Integer aiSiteId;
    @NotNull
    @Size(max = 255)
    String content;
    @NotNull
    Instant createdAt;
}