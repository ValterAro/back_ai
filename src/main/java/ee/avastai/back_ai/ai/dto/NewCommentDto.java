package ee.avastai.back_ai.ai.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ee.avastai.back_ai.domain.comment.Comment}
 */
@Data
public class NewCommentDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer aiSiteId;
    @NotNull
    @Size(max = 255)
    private String content;
}