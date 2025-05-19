package org.TransactionPD.Data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class OutputData {
    private final double[][] plusOutputDescr;
    private final double[][] minusOutputDescr;
    private final double[][] plusOutputCate;
    private final double[][] minusOutputCate;
    private final String[][] plusDescr;
    private final String[][] minusDescr;
    private final String[][] plusCate;
    private final String[][] minusCate;
    private final int exitMonth;
    private final PrintWriter writer;
    private final int plusMonth;
    private final int plusYears;
    private final int minusMonth;
    private final int minusYears;
    private List<String> PODescr ;
    private List<String> MODescr;
    private List<String> POCate;
    private List<String> MOCate;

    public OutputData(double[][] plusOutputDescr, double[][] minusOutputDescr, double[][] plusOutputCate,
                      double[][] minusOutputCate, String[][] plusDescr, String[][] minusDescr,
                      String[][] plusCate, String[][] minusCate,  int exitMonth, PrintWriter writerMonth,
                      PrintWriter writerQuarter, PrintWriter writerYear,
                      int plusMonth, int plusYears, int minusMonth, int minusYears,List<String> PODescr,
                      List<String> MODescr,List<String> POCate,List<String> MOCate, int identificationTime) {

        this.plusOutputDescr = plusOutputDescr;
        this.minusOutputDescr = minusOutputDescr;
        this.plusOutputCate = plusOutputCate;
        this.minusOutputCate = minusOutputCate;
        this.plusDescr = plusDescr;
        this.minusDescr = minusDescr;
        this.plusCate = plusCate;
        this.minusCate = minusCate;
        this.exitMonth = exitMonth;
        this.plusMonth = plusMonth;
        this.plusYears = plusYears;
        this.minusMonth = minusMonth;
        this.minusYears = minusYears;
        this.PODescr = PODescr;
        this.MODescr = MODescr;
        this.POCate = POCate;
        this.MOCate = MOCate;

        if (identificationTime==1) {
            this.writer = writerMonth;
        } else if (identificationTime==2) {
            this.writer = writerQuarter;
        } else this.writer = writerYear;
    }

    public void outputData() {
        String descriptionPlus = "Пополнения по описанию ";
        outputFile(plusOutputDescr, plusDescr, exitMonth, plusMonth, plusYears, descriptionPlus);
        String categoriesPlus = "Пополнения по категориям ";
        outputFile(plusOutputCate, plusCate, exitMonth, plusMonth, plusYears, categoriesPlus);

        String descriptionMinus = "Траты по описанию ";
        outputFile(minusOutputDescr, minusDescr, exitMonth, minusMonth, minusYears, descriptionMinus);

        String categoriesMinus = "Траты по категориям ";
        outputFile(minusOutputCate, minusCate, exitMonth, minusMonth, minusYears, categoriesMinus);

        PODescr = outputInterface(PODescr, plusDescr, plusOutputDescr, plusMonth, plusYears);
        MODescr = outputInterface(MODescr, minusDescr, minusOutputDescr, minusMonth, minusYears);
        POCate = outputInterface(POCate, plusCate, plusOutputCate, plusMonth, plusYears);
        MOCate = outputInterface(MOCate, minusCate, minusOutputCate, minusMonth, minusYears);
    }


    public void outputFile(double[][] outputData, String[][] outputCateDescr, int exitMonth, int month, int years, String descriptionString) {
        /* запись в файл
        String extension = ".txt";
        File file = new File(fileName + extension);
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        */
        writer.println(descriptionString);
        writer.println("Дата- "+month+"."+years);
        for (int j = 0; j < outputCateDescr.length; j++) {
            writer.print(Arrays.toString(outputCateDescr[j]));
            writer.println(Arrays.toString(outputData[j]));
        }
        writer.println();

        if (exitMonth>0) {
            writer.close();
        }

    }

    public List<String> outputInterface(List<String> PODescr, String[][] plusDescr, double[][] plusOutputDescr, int month, int years) {
        //запись данных в динамический массив
        for (int j = 0; j < plusDescr.length; j++) {
            PODescr.add(" " + month + "." + years);
            PODescr.add(plusDescr[j][0]);
            try {
                PODescr.add(plusDescr[j][1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                PODescr.add("-");
            }

        PODescr.add(String.valueOf(plusOutputDescr[j][0]));
        }
        PODescr.add("-");
        PODescr.add("-");
        PODescr.add("-");
        PODescr.add("-");

        return PODescr;

    }


}
