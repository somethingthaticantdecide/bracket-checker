package org.sbt.bracketchecker.service;

import org.sbt.bracketchecker.dto.BracketCheckRequestDTO;

public interface BracketCheckerService {

    boolean isTextValid(BracketCheckRequestDTO requestDTO);
}
