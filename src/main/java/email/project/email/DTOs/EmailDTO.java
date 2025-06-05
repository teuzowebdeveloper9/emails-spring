package email.project.email.DTOs;

import java.util.UUID;

public record EmailDTO(
        UUID id,
        String subject,
        String body
) {

}
