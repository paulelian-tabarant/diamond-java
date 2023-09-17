package org.kata;

public class Diamond {

    public static final String SPACE = " ";
    public static final Character A = 'A';

    public static String getRow(Character letter) {
        if (letter.equals(A)) return "A";

        var numberOfSpacesIntoDiamond = getNumberOfSpacesIntoDiamondAt(letter);

        return letter + SPACE.repeat(numberOfSpacesIntoDiamond) + letter;
    }

    private static int getNumberOfSpacesIntoDiamondAt(Character letter) {
        return 2 * (letter - A + 1) + 1;
    }

    public static String getRowOffset(char letterOfRow, char letter) {
        var numberOfSpacesInOffset = (int) letter - letterOfRow;

        return SPACE.repeat(numberOfSpacesInOffset);
    }

    public static String addOffset(String row, String offset) {
        return offset + row + offset;
    }
}
