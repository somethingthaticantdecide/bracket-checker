package org.sbt.bracketchecker.validation;

import org.junit.jupiter.api.Test;
import org.sbt.bracketchecker.validation.impl.BracketValidatorImpl;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BracketValidatorImplTest {

    @Test
    public void testValidateText_emptyString_shouldReturnFalse() {
        BracketValidator validator = new BracketValidatorImpl();
        assertFalse(validator.isTextValid(""));
    }

    @Test
    public void testValidText_betweenBrackets() {
        BracketValidatorImpl validator = new BracketValidatorImpl();
        assertTrue(validator.isTextValid("(ABC)"));
        assertTrue(validator.isTextValid("[ABC]"));
        assertTrue(validator.isTextValid("{ABC}"));
        assertTrue(validator.isTextValid("(123)"));
        assertTrue(validator.isTextValid("[456]"));
        assertTrue(validator.isTextValid("{789}"));
    }

    @Test
    public void testValidText_multipleBrackets() {
        BracketValidatorImpl validator = new BracketValidatorImpl();
        assertTrue(validator.isTextValid("((ABC))"));
        assertTrue(validator.isTextValid("[[ABC]]"));
        assertTrue(validator.isTextValid("{{ABC}}"));
        assertTrue(validator.isTextValid("(123(456))"));
        assertTrue(validator.isTextValid("[789[012]]"));
        assertTrue(validator.isTextValid("{345{678}}"));
    }

    @Test
    public void testInvalidText_missingOpeningBracket() {
        BracketValidatorImpl validator = new BracketValidatorImpl();
        assertFalse(validator.isTextValid("ABC)"));
        assertFalse(validator.isTextValid("ABC]"));
        assertFalse(validator.isTextValid("ABC}"));
        assertFalse(validator.isTextValid("123)"));
        assertFalse(validator.isTextValid("456]"));
        assertFalse(validator.isTextValid("789}"));
    }

    @Test
    public void testInvalidText_missingClosingBracket() {
        BracketValidatorImpl validator = new BracketValidatorImpl();
        assertFalse(validator.isTextValid("(ABC"));
        assertFalse(validator.isTextValid("[ABC"));
        assertFalse(validator.isTextValid("{ABC"));
        assertFalse(validator.isTextValid("(123"));
        assertFalse(validator.isTextValid("[456"));
        assertFalse(validator.isTextValid("{789"));
    }

    @Test
    public void testInvalidText_mismatchedBrackets() {
        BracketValidatorImpl validator = new BracketValidatorImpl();
        assertFalse(validator.isTextValid("(ABC]"));
        assertFalse(validator.isTextValid("[ABC)"));
        assertFalse(validator.isTextValid("{AB] C}"));
        assertFalse(validator.isTextValid("(123[456}})"));
        assertFalse(validator.isTextValid("[789{012]]"));
        assertFalse(validator.isTextValid("{345}678}"));
    }
}
