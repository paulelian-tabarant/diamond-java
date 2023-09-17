package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiamondTest {
    @Test
    void shouldMakeSpaceIntoLetterAccordingItsPositionInAlphabet() {
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

    @Test
    void shouldOffsetEachLetterRowAccordingToRequestedLetterPositionInAlphabet() {
        // Given
        var requestedLetter = 'D';
        var abcdTestCases = Map.of(
            'A', "   ",
            'B', "  ",
            'C', " ",
            'D', ""
        );

        // When Then
        abcdTestCases.forEach(
            (rowLetter, expectedOffset) -> {
                var actualOffset = Diamond.getRowOffset(rowLetter, requestedLetter);
                assertThat(actualOffset).isEqualTo(expectedOffset);
            }
        );
    }
}