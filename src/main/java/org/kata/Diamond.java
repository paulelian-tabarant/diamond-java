package org.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class Diamond {
    private Character letter;

    public Diamond(Character letter) {
        this.letter = letter;
    }

    public static final String SPACE = " ";
    public static final Character A = 'A';

    public String getRow(Character rowLetter) {
        if (rowLetter.equals(A)) return "A";

        var numberOfSpacesIntoDiamond = getNumberOfSpacesIntoDiamondAt(rowLetter);

        return rowLetter + SPACE.repeat(numberOfSpacesIntoDiamond) + rowLetter;
    }

    private static int getNumberOfSpacesIntoDiamondAt(Character rowLetter) {
        return 2 * (rowLetter - A) - 1;
    }

    public String getRowOffset(char letterOfRow) {
        var numberOfSpacesInOffset = (int) letter - letterOfRow;

        return SPACE.repeat(numberOfSpacesInOffset);
    }

    public static String addOffset(String row, String offset) {
        return offset + row + offset;
    }

    public String getLine(Character rowLetter) {
        var row = getRow(rowLetter);
        var offset = getRowOffset(rowLetter);
        var line = addOffset(row, offset);

        return line;
    }

    public List<String> getLines() {
        var linesCount = getLinesCount();

        List<Integer> linePositions = rangeClosed(0, linesCount - 1).boxed().toList();

        return linePositions.stream().map(linePosition -> {
            char lineChar = getLineChar(linePosition);
            return getLine(lineChar);
        }).toList();
    }

    private static char getLineChar(Integer linePosition) {
        int charPosition = A + linePosition;
        return (char) charPosition;
    }

    private int getLinesCount() {
        return letter - A + 1;
    }
}
