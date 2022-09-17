package com.github.lsj8367.item9;

import java.io.BufferedReader;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamCorruptedException;

public class ExceptionReader extends BufferedReader {

    public ExceptionReader(final Reader in, final int sz) {
        super(in, sz);
    }

    public ExceptionReader(final Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        throw new CharConversionException();
    }

    @Override
    public void close() throws IOException {
        throw new StreamCorruptedException();
    }

}
