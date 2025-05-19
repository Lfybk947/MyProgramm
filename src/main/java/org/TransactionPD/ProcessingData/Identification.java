package org.TransactionPD.ProcessingData;

import java.util.Arrays;
import java.util.Objects;

public class Identification {
    private final String[][] dataFile;//inputData
    private final int categories;
    private final int description;
    private final int operation;
    private final int numberColumn;
    private String[][] plusDataFileCateDescr;
    private String[][] minusDataFileCateDescr;
    private String[][] plusDataFileCategories;
    private String[][] minusDataFileCategories;
    private String[][] plusInputData;
    private String[][] minusInputData;

    public Identification(String[][] dataFile, int categories, int description, int operation, int numberColumn) {
        this.dataFile=dataFile;
        this.categories=categories;
        this.description=description;
        this.operation = operation;
        this.numberColumn = numberColumn;
    }
    public void sortFile() {
        plusDataFileCateDescr = descriptio(categories, description, plusInputData);
        minusDataFileCateDescr = descriptio(categories, description, minusInputData);
        plusDataFileCategories = categorie(categories, plusInputData);
        minusDataFileCategories = categorie(categories, minusInputData);
    }
    public String[][] getPlusDataFileCateDescr() {
        return plusDataFileCateDescr;
    }
    public String[][] getMinusDataFileCateDescr() {
        return minusDataFileCateDescr;
    }
    public String[][] getPlusDataFileCategories() {
        return plusDataFileCategories;
    }
    public String[][] getMinusDataFileCategories() {
        return minusDataFileCategories;
    }

    public String[][] getPlusInputData() {
        return plusInputData;
    }
    public String[][] getMinusInputData() {
        return minusInputData;
    }



    public String[][] descriptio(int categor, int descript, String[][] dataFile) {
        int l=0;
        int n=0;
        int k=0;
        int[][] sortingArr = new int[dataFile.length][2];

        for (int j = dataFile.length - 1; j >= 0; j--) {//запись всех повторяющихся значений 'строк' под номерами строк начиная с первого попавшегося члена в массиве
            for (int i = dataFile.length - 1; i >= 0; i--) {
                if (Objects.equals(dataFile[j][categor], dataFile[i][categor])) {
                    sortingArr[i][1] = j;
                }
                if (Objects.equals(dataFile[j][descript], dataFile[i][descript])) {
                   sortingArr[i][0] = j;
                }
            }
        }
        while (l <= sortingArr.length) {//сортировка и обнуление всех повторяющихся значений
            for (int i = 1; i < sortingArr.length; i++) {
                if (sortingArr[i - 1][0] > sortingArr[i][0]) {
                    int a = sortingArr[i][0];
                    int b = sortingArr[i][1];
                    sortingArr[i][0] = sortingArr[i - 1][0];
                    sortingArr[i][1] = sortingArr[i - 1][1];
                    sortingArr[i - 1][0] = a;
                    sortingArr[i - 1][1] = b;
                } else if (sortingArr[i - 1][0] == sortingArr[i][0]) {
                    sortingArr[i][0] = 0;
                    sortingArr[i][1] = 0;
                }
            }
            l++;
        }
        l=0;
        while (l <= sortingArr.length) {//сортировка
            for (int i = 1; i < sortingArr.length; i++) {
                if (sortingArr[i - 1][1] > sortingArr[i][1]) {
                    int a = sortingArr[i][1];
                    int b = sortingArr[i][0];
                    sortingArr[i][1] = sortingArr[i - 1][1];
                    sortingArr[i][0] = sortingArr[i - 1][0];
                    sortingArr[i - 1][1] = a;
                    sortingArr[i - 1][0] = b;
                }
            }
            l++;
        }
        for (int i = 1; i < sortingArr.length; i++) {//подсчет количества строк с уникальными значениями, без нулей
            if (sortingArr[i - 1][0] != sortingArr[i][0]) {//наверно можно это интегрировать в предыдущий цыкл
                n++;
            }
        }

        int[][] sortingArr2 = new int[n][1];//массив с количеством строк равным количеству уникальных строк подсчитанных в цикле выше

        for (int i = 1; i < sortingArr.length; i++) {//запись строк с уникальными значениями в массив Arr2, чтобы массив был без пустых строк
            if (sortingArr[i - 1][0] != sortingArr[i][0]) {
                sortingArr2[k][0] = sortingArr[i - 1][0];
                k++;
            } else if (i == sortingArr.length - 1) {//запись последней строки в массив Arr2
                sortingArr2[k + 1][0] = sortingArr[i][0];
            }
        }

        String[][] dataFileCategor = new String[sortingArr2.length+1][2];
        int a;
        for (int i = 0; i < sortingArr2.length; i++) {//запись и возврат массива строками с данными основываясь на строках записанных в массиве Arr2
            a = sortingArr2[i][0];
            dataFileCategor[i][0] = dataFile[a][categor];
            dataFileCategor[i][1] = dataFile[a][descript];
        }
        dataFileCategor[sortingArr2.length][0] = "Итого";
        dataFileCategor[sortingArr2.length][1] = "Итого";
        return dataFileCategor;
    }

    public String[][] categorie(int categor, String[][] dataFile) {
        int l=0;
        int n=0;
        int k=0;
        int[][] sortingArr = new int[dataFile.length][1];

        for (int j = dataFile.length - 1; j >= 0; j--) {//запись всех повторяющихся значений 'строк' под номерами строк начиная с первого попавшегося члена в массиве
            for (int i = dataFile.length - 1; i >= 0; i--) {
                if (Objects.equals(dataFile[j][categor], dataFile[i][categor])) {
                    sortingArr[i][0] = j;
                }
            }
        }
        while (l <= sortingArr.length) {//сортировка и обнуление всех повторяющихся значений
            for (int i = 1; i < sortingArr.length; i++) {
                if (sortingArr[i - 1][0] > sortingArr[i][0]) {
                    int a = sortingArr[i][0];
                    sortingArr[i][0] = sortingArr[i - 1][0];
                    sortingArr[i - 1][0] = a;
                } else if (sortingArr[i - 1][0] == sortingArr[i][0]) {
                    sortingArr[i][0] = 0;
                }
            }
            l++;
        }
        for (int i = 1; i < sortingArr.length; i++) {//подсчет количества строк с уникальными значениями, без нулей
            if (sortingArr[i - 1][0] != sortingArr[i][0]) {//наверно можно это интегрировать в предыдущий цыкл
                n++;
            }
        }

        int[][] sortingArr2 = new int[n][1];//массив с количеством строк равным количеству уникальных строк подсчитанных в цикле выше

        for (int i = 1; i < sortingArr.length; i++) {//запись строк с уникальными значениями в массив Arr2, чтобы массив был без пустых строк
            if (sortingArr[i - 1][0] != sortingArr[i][0]) {
                sortingArr2[k][0] = sortingArr[i - 1][0];
                k++;
            } else if (i == sortingArr.length - 1) {//запись последней строки в массив Arr2
                sortingArr2[k + 1][0] = sortingArr[i][0];
            }
        }

        String[][] dataFileCategor = new String[sortingArr2.length+1][1];
        int a;
        for (int i = 0; i < sortingArr2.length; i++) {//запись и возврат массива строками с данными основываясь на строках записанных в массиве Arr2
            a = sortingArr2[i][0];
            dataFileCategor[i][0] = dataFile[a][categor];
        }
        dataFileCategor[sortingArr2.length][0] = "Итого";
        return dataFileCategor;
    }





    public void operationInputData() {//разделение поступлений и трат
        int plus=1;
        int minus=1;
        for (int i = 1; i < dataFile.length; i++) {
            if (Double.parseDouble(dataFile[i][operation])>=0) {
                plus++;
            } else if (Double.parseDouble(dataFile[i][operation])<0) {
                minus++;
            }
        }
        plusInputData = new String[plus][numberColumn];
        minusInputData = new String[minus][numberColumn];
        int q=0;
        int w=0;
        plusInputData[q] = dataFile[0];
        minusInputData[w] = dataFile[0];
        for (int i = 1; i < dataFile.length; i++) {
            if (Double.parseDouble(dataFile[i][operation])>=0.0) {
                q++;
                plusInputData[q] = dataFile[i];
            } else if(Double.parseDouble(dataFile[i][operation])<0.0) {
                w++;
                minusInputData[w] = dataFile[i];
            }
        }
    }
    public void dataPrint() {//печать массивов с категориями и описанием
        for (int i = 0; i < plusDataFileCateDescr.length; i++) {
            System.out.println(Arrays.toString(plusDataFileCateDescr[i]));
        }
    }
    public void dataPrint2() {//печать
//        for (int i = 0; i < plusInputData.length; i++) {
//            System.out.print(i);
//            System.out.println(Arrays.toString(plusInputData[i]));
//        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < minusInputData.length; i++) {
            System.out.print(i);
            System.out.println(Arrays.toString(minusInputData[i]));
        }
    }



}
