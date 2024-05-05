package com.txt.java.pattern.solid.dn;

public class Copy {

    public Copy() {
    }

    public void doWorkKeyToPrinter(ReadKeyboard inReader, WriterPrinterText inWriter) {
        if (inReader == null || inWriter == null) {
            throw new NullPointerException();
        }

        inWriter.write(inReader.read());
    }

    public void doWorkScannerToDB(ReadScanner inReader, WriterDatabase inWriter) {
        if (inReader == null || inWriter == null) {
            throw new NullPointerException();
        }

        inWriter.write(inReader.read());
    }
}
