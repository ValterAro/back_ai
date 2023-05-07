package ee.avastai.back_ai.ai.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link ee.avastai.back_ai.domain.user.User} entity
 */
@Data
public class UserDto implements Serializable {
    @Size(max = 255)
    @NotNull
    private final String username;
    @NotNull
    private final Integer points;
    @Size(max = 1)
    @NotNull
    private final String status;
    @Size(max = 255)
    private final String email;
    @NotNull
    private final Instant createdAt;
}