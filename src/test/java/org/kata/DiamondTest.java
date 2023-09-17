package org.kata;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiamondTest {
    @Test
    void shouldMakeSpaceAccordingToLetterPositionInAlphabet() {
        // Given
        var abcdTestCases = Map.of(
            'A', "A",
            'B', "B B",
            'C', "C   C",
            'D', "D     D"
        );

        // When Then
        abcdTestCases.forEach((inputLetter, expectedRow) -> assertThat(Diamond.getRow(inputLetter)).isEqualTo(expectedRow));
    }
}