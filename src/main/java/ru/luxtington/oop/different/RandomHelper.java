package ru.luxtington.oop.different;

import java.util.Random;

public class RandomHelper {

    public static String swapLetters(String str) {
        Random random = new Random();
        char[] letters = str.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int randIndex = random.nextInt(letters.length);

            char tmp = letters[i];
            letters[i] = letters[randIndex];
            letters[randIndex] = tmp;
        }
        return new String(letters);
    }
}
