package org.sbt.bracketchecker.service.impl;

import lombok.RequiredArgsConstructor;
import org.sbt.bracketchecker.dto.BracketCheckRequestDTO;
import org.sbt.bracketchecker.service.BracketCheckerService;
import org.sbt.bracketchecker.validation.BracketValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BracketCheckerServiceImpl implements BracketCheckerService {
    private final BracketValidator bracketValidator;

    public boolean isTextValid(BracketCheckRequestDTO requestDTO) {
        String text = requestDTO.getText();
        return bracketValidator.isTextValid(text);
    }
}
