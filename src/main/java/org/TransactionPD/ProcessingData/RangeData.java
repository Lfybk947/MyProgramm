package org.TransactionPD.ProcessingData;

import java.util.Objects;



public class RangeData {

    private final String[][] plusDataFileCateDescr;
    private final String[][] minusDataFileCateDescr;
    private final String[][] plusDataFileCategories;
    private final String[][] minusDataFileCategories;
    private final String[][] plusInputData;
    private final String[][] minusInputData;
    private final int description;
    private final int categories;
    private final int operation;
    private final int plusStartNumberMonth;
    private final int plusEndNumberMonth;
    private final int minusStartNumberMonth;
    private final int minusEndNumberMonth;
    private double[][] plusOutputDataDescription;
    private double[][] minusOutputDataDescription;
    private double[][] plusOutputDataCategories;
    private double[][] minusOutputDataCategories;

    public RangeData(String[][] plusDataFileCateDescr, String[][] minusDataFileCateDescr, String[][] plusDataFileCategories,
                     String[][] minusDataFileCategories, String[][] plusInputData, String[][] minusInputData,
                     int plusStartNumberMonth, int plusEndNumberMonth, int minusStartNumberMonth, int minusEndNumberMonth,
                     int description, int categories, int operation) {
        this.plusDataFileCateDescr = plusDataFileCateDescr;
        this.minusDataFileCateDescr = minusDataFileCateDescr;
        this.plusDataFileCategories = plusDataFileCategories;
        this.minusDataFileCategories = minusDataFileCategories;
        this.description = description;
        this.categories = categories;
        this.operation = operation;
        this.plusInputData = plusInputData;
        this.minusInputData = minusInputData;
        this.plusStartNumberMonth = plusStartNumberMonth;
        this.plusEndNumberMonth = plusEndNumberMonth;
        this.minusStartNumberMonth = minusStartNumberMonth;
        this.minusEndNumberMonth = minusEndNumberMonth;
    }
    public void dataCateDescr() {
        plusOutputDataDescription = sortRangeDescription(plusDataFileCateDescr, plusInputData, plusStartNumberMonth, plusEndNumberMonth);
        minusOutputDataDescription = sortRangeDescription(minusDataFileCateDescr, minusInputData, minusStartNumberMonth, minusEndNumberMonth);
        plusOutputDataCategories = sortRangeCategories(plusDataFileCategories, plusInputData, plusStartNumberMonth, plusEndNumberMonth);
        minusOutputDataCategories = sortRangeCategories(minusDataFileCategories, minusInputData, minusStartNumberMonth, minusEndNumberMonth);
    }
    public double[][] getPlusOutputDataDescription() {
        return plusOutputDataDescription;
    }
    public double[][] getMinusOutputDataDescription() {
        return minusOutputDataDescription;
    }
    public double[][] getPlusOutputDataCategories() {
        return plusOutputDataCategories;
    }
    public double[][] getMinusOutputDataCategories() {
        return minusOutputDataCategories;
    }


    public double[][] sortRangeDescription(String[][] dataFileCateDescr, String[][] inputData, int startNumberMonth, int endNumberMonth) {
        //подсчет и запись трат по описанию
        double[][] outputData = new double[dataFileCateDescr.length][1];
        outputData[0][0] = 0;
        for (int i = 1; i < dataFileCateDescr.length; i++) {
            for (int j = startNumberMonth; j <= endNumberMonth; j++) {//начальная строка конечная строк
                if (Objects.equals(dataFileCateDescr[i][1], inputData[j][description])) {//запись трат
                    outputData[i][0] += Double.parseDouble(inputData[j][operation]);
                }
            }
        }
        for (int j = 0; j < outputData.length-1; j++) {
            outputData[outputData.length-1][0] += outputData[j][0];
        }
        return outputData;
    }
    public double[][] sortRangeCategories(String[][] dataFileCateDescr, String[][] inputData, int startNumberMonth, int endNumberMonth) {
        //подсчет и запись трат по описанию
        double[][] outputData = new double[dataFileCateDescr.length][1];
        outputData[0][0] = 0;
        for (int i = 1; i < dataFileCateDescr.length; i++) {
            for (int j = startNumberMonth; j <= endNumberMonth; j++) {//начальная строка конечная строк
                if (Objects.equals(dataFileCateDescr[i][0], inputData[j][categories])) {//запись трат
                    outputData[i][0] += Double.parseDouble(inputData[j][operation]);
                }
            }
        }
        for (int j = 0; j < outputData.length-1; j++) {
            outputData[outputData.length-1][0] += outputData[j][0];
        }
        return outputData;
    }
}
