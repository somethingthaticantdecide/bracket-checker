package org.sbt.bracketchecker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Data request scheme")
public class BracketCheckRequestDTO {

    @Schema(description = "Text to check", example = "(abc)")
    @NotNull(message = "Поле текст не может быть пустым")
    @NotBlank(message = "Поле текст не может быть пустым")
    private String text;
}
