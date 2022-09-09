package com.github.lsj8367.item5.before;

import com.github.lsj8367.item5.Dictionary;

public class SpellChecker {
    private static final Dictionary dictionary = new DefaultDictionary();

    private static class DefaultDictionary implements Dictionary {

        @Override
        public boolean contains(final String word) {
            return false;
        }
    }

    public static boolean isValid(final String word) {
        return dictionary.contains(word);
    }
}
