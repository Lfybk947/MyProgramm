package org.TransactionPD.ProcessingData;

import java.util.Arrays;

public class DeleteNull {
    private final double[][] plusOutputDataDescription;
    private final double[][] minusOutputDataDescription;
    private final double[][] plusOutputDataCategories;
    private final double[][] minusOutputDataCategories;
    private final String[][] plusDataFileCateDescr;
    private final String[][] minusDataFileCateDescr;
    private final String[][] plusDataFileCategories;
    private final String[][] minusDataFileCategories;

    private double[][] plusOutputDescr;
    private double[][] minusOutputDescr;
    private double[][] plusOutputCate;
    private double[][] minusOutputCate;
    private String[][] plusDescr;
    private String[][] minusDescr;
    private String[][] plusCate;
    private String[][] minusCate;

    public DeleteNull(double[][] plusOutputDataDescription, double[][] minusOutputDataDescription,
                      double[][] plusOutputDataCategories, double[][] minusOutputDataCategories,
                      String[][] plusDataFileCateDescr, String[][] minusDataFileCateDescr,
                      String[][] plusDataFileCategories, String[][] minusDataFileCategories) {
        this.plusOutputDataDescription = plusOutputDataDescription;
        this.minusOutputDataDescription = minusOutputDataDescription;

        this.plusOutputDataCategories = plusOutputDataCategories;
        this.minusOutputDataCategories = minusOutputDataCategories;

        this.plusDataFileCateDescr = plusDataFileCateDescr;
        this.minusDataFileCateDescr = minusDataFileCateDescr;

        this.plusDataFileCategories = plusDataFileCategories;
        this.minusDataFileCategories = minusDataFileCategories;
    }
    public void deleteNull() {
        int descr = 2;
        DeleteNull.DeleteOutput plusOutputDescription = DeleteNull.DeleteOutput.deleteOutputData(plusOutputDataDescription, plusDataFileCateDescr, descr);
        plusOutputDescr = plusOutputDescription.outputData;
        plusDescr = plusOutputDescription.outputCateDescr;

        DeleteNull.DeleteOutput minusOutputDescription = DeleteNull.DeleteOutput.deleteOutputData(minusOutputDataDescription, minusDataFileCateDescr, descr);
        minusOutputDescr = minusOutputDescription.outputData;
        minusDescr = minusOutputDescription.outputCateDescr;


        int cate = 1;
        DeleteNull.DeleteOutput plusOutputCategories = DeleteNull.DeleteOutput.deleteOutputData(plusOutputDataCategories, plusDataFileCategories, cate);
        plusOutputCate = plusOutputCategories.outputData;
        plusCate = plusOutputCategories.outputCateDescr;

        DeleteNull.DeleteOutput minusOutputCategories = DeleteNull.DeleteOutput.deleteOutputData(minusOutputDataCategories, minusDataFileCategories, cate);
        minusOutputCate = minusOutputCategories.outputData;
        minusCate = minusOutputCategories.outputCateDescr;

    }

    public double[][] getPlusOutputDescr() {
        return plusOutputDescr;
    }
    public double[][] getMinusOutputDescr() {
        return minusOutputDescr;
    }
    public double[][] getPlusOutputCate() {
        return plusOutputCate;
    }
    public double[][] getMinusOutputCate() {
        return minusOutputCate;
    }

    public String[][] getPlusDescr() {
        return plusDescr;
    }
    public String[][] getMinusDescr() {
        return minusDescr;
    }
    public String[][] getPlusCate() {
        return plusCate;
    }
    public String[][] getMinusCate() {
        return minusCate;
    }



    public static class DeleteOutput {
        double[][] outputData;
        String[][] outputCateDescr;

        public DeleteOutput(double[][] outputData, String[][] outputCateDescr) {
            this.outputData = outputData;
            this.outputCateDescr = outputCateDescr;
        }

        public static DeleteOutput deleteOutputData(double[][] outputData, String[][] outputCateDescr, int cateDescr) {
            int k=0;
            for (double[] outputDatum : outputData) {
                if (outputDatum[0] != 0.0) {
                    k++;
                }
            }
            double[][] d = new double[k][1];
            String[][] s = new String[k][cateDescr];
            int j=0;
            for (int i = 0; i < outputData.length; i++) {
                if (outputData[i][0]!=0.0) {
                    d[j] = outputData[i];
                    s[j] = outputCateDescr[i];
                    j++;
                }
            }
            return new DeleteOutput(d,s);
        }
    }



    public void print() {
        for (int i = 0; i < plusOutputDescr.length; i++) {
            System.out.print(Arrays.toString(plusDescr[i]));
            System.out.print(Arrays.toString(plusOutputDescr[i]));
            System.out.println();
        }
        System.out.println();
    }


}
