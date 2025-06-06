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

    public static PrintWriter getWriterMonth() {
        return writerMonth;
    }
    public static PrintWriter getWriterQuarter() {
        return writerQuarter;
    }
    public static PrintWriter getWriterYear() {
        return writerYear;
    }

    public void createOutputData() throws IOException {
        String extension = ".txt";
        fileMonth = new File(fileNameMonth + extension);
        fileMonth.createNewFile();
        writerMonth = new PrintWriter(fileMonth);

        fileQuarter = new File(fileNameQuarter + extension);
        fileQuarter.createNewFile();
        writerQuarter = new PrintWriter(fileQuarter);

        fileYear = new File(fileNameYear + extension);
        fileYear.createNewFile();
        writerYear = new PrintWriter(fileYear);
    }
}
