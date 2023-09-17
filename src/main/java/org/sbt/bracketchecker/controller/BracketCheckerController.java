package org.sbt.bracketchecker.controller;

import org.sbt.bracketchecker.dto.BracketCheckRequestDTO;
import org.sbt.bracketchecker.dto.BracketCheckResponseDTO;
import org.sbt.bracketchecker.service.BracketCheckerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name="Bracket Check controller")
public class BracketCheckerController {

    private final BracketCheckerService bracketCheckerService;

    @PostMapping("checkBrackets")
    @Operation(
            summary = "Checking brackets",
            description = "Allows you to understand whether they have placed the brackets correctly in the text"
    )
    public BracketCheckResponseDTO checkBrackets(@Valid @RequestBody BracketCheckRequestDTO requestDTO) {
        boolean isCorrect = bracketCheckerService.isTextValid(requestDTO);
        return new BracketCheckResponseDTO(isCorrect);
    }

}
