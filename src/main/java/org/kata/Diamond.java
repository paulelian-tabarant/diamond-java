package org.kata;

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
        return 2 * (rowLetter - A + 1) + 1;
    }

    public String getRowOffset(char letterOfRow) {
        var numberOfSpacesInOffset = (int) letter - letterOfRow;

        return SPACE.repeat(numberOfSpacesInOffset);
    }

    public static String addOffset(String row, String offset) {
        return offset + row + offset;
    }
}
