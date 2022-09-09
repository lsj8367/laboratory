package com.github.lsj8367.item5.after;

import com.github.lsj8367.item5.Dictionary;
import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(final Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public SpellChecker(final Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(final String word) {
        return dictionary.contains(word);
    }

}
