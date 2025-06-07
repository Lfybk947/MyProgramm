package org.TransactionPD.Data;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateOutputFile {
    private final String fileNameMonth;
    private final String fileNameQuarter;
    private final String fileNameYear;
    private static PrintWriter writerMonth;
    private static PrintWriter writerQuarter;
    private static PrintWriter writerYear;
    private File fileMonth;
    private File fileQuarter;
    private File fileYear;


    public CreateOutputFile(String fileNameMonth, String fileNameQuarter, String fileNameYear) {
        this.fileNameMonth = fileNameMonth;
        this.fileNameQuarter = fileNameQuarter;
        this.fileNameYear = fileNameYear;
    }

    public static PrintWriter getWriterMonth() {return writerMonth;}
    public static PrintWriter getWriterQuarter() {
        return writerQuarter;
    }
    public static PrintWriter getWriterYear() {
        return writerYear;
    }

    public void createOutputData() {
        try {
            String extension = ".txt";
            fileMonth = new File(fileNameMonth + extension);
            Boolean r1 = fileMonth.createNewFile();
            writerMonth = new PrintWriter(fileMonth);

            fileQuarter = new File(fileNameQuarter + extension);
            Boolean r2 = fileQuarter.createNewFile();
            writerQuarter = new PrintWriter(fileQuarter);

            fileYear = new File(fileNameYear + extension);
            Boolean r3 = fileYear.createNewFile();
            writerYear = new PrintWriter(fileYear);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
