package com.github.lsj8367.item5.ioc;

import com.github.lsj8367.item5.Dictionary;

public class SpellChecker {

    private Dictionary dictionary;

    public SpellChecker(final Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(final String word) {
        return dictionary.contains(word);
    }

}
