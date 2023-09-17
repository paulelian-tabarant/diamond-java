package org.kata;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;
import static java.util.stream.IntStream.rangeClosed;

public class Diamond {
    private final Character letter;

    public Diamond(Character letter) {
        this.letter = letter;
    }

    public static final String SPACE = " ";
    public static final Character A = 'A';

    public List<String> getLines() {
        var side = getDiamondSide();
        var middleLine = getLine(letter);
        var otherSide = new ArrayList<>(side);
        reverse(otherSide);

        var diamond = new ArrayList<>(side);
        diamond.add(middleLine);
        diamond.addAll(otherSide);

        return diamond;
    }

    private List<String> getDiamondSide() {
        var linesCount = letter - A;

        List<Integer> linePositions = rangeClosed(0, linesCount - 1).boxed().toList();

        return linePositions.stream().map(linePosition -> {
            char lineChar = getLineChar(linePosition);
            return getLine(lineChar);
        }).toList();
    }

    public String getLine(Character rowLetter) {
        var row = getRow(rowLetter);
        var offset = getRowOffset(rowLetter);

        return addOffset(row, offset);
    }

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

    private static char getLineChar(Integer linePosition) {
        int charPosition = A + linePosition;
        return (char) charPosition;
    }
}
