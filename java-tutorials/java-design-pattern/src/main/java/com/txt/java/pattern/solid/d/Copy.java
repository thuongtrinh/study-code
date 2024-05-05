package com.txt.java.pattern.solid.d;

public class Copy {

    /**
     * mReader
     */
    private IReader mReader;

    /**
     * mWriter
     */
    private IWriter mWriter;

    /**
     * Constructor
     */
    public Copy(IReader inReader, IWriter inWriter) {
        if (inReader == null || inWriter == null) {
            throw new NullPointerException();
        }
        mReader = inReader;
        mWriter = inWriter;
    }

    /**
     * It will take an input by using a Reader then write to an ouptut by using a Writer
     */
    public void doWork() {
        mWriter.write(mReader.read());
    }
}
