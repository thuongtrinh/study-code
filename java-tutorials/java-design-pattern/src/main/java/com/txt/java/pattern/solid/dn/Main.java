package com.txt.java.pattern.solid.dn;

/**
 * @Comment Not DIP
 */
public class Main {

    public static void main(String[] args) {
        Copy copy = new Copy();

        //Case 1
        ReadKeyboard reader = new ReadKeyboard();
        WriterPrinterText writer = new WriterPrinterText();
        copy.doWorkKeyToPrinter(reader, writer);

        //Case 2
        ReadScanner reader1 = new ReadScanner();
        WriterDatabase writer1 = new WriterDatabase();
        copy.doWorkScannerToDB(reader1, writer1);
    }

}
