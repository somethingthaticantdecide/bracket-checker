package org.sbt.bracketchecker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Data response scheme")
public class BracketCheckResponseDTO {

    @Schema(description = "Verification result")
    private boolean isCorrect;
}
