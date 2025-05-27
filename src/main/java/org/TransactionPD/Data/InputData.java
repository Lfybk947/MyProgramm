package org.TransactionPD.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InputData {
    private String[][] inputData;
    private final String linkFile;
    private File table;
    private Scanner scan;
    private int numberString;
    private final int numberColumn;
    private int k;
    String number;
//    String[] number2;

    public String[][] getInputData() {return inputData;}

//    public void setLinkFile(String linkFile) {
//        this.linkFile=linkFile;
//    }
    public InputData(String linkFile, int numberColumn) {
        this.linkFile = linkFile;
        this.numberColumn = numberColumn;
    }
    public void inputDataFile() {
        //separator = File.separator;
//        path ="D:"+separator+"operations.csv";
//        table = new File(path);
//        table = new File("operations.csv");//случай если файл не в дирректории кода программы, прописываем ссылку
        table = new File(linkFile);//сделать добавления ссылки на файл или перемещение может файла по кнопке, чтобы не прописывать его сюда постоянно

        try {
            scan = new Scanner(table);//сделать возможность использования вайла с расширением Excel
        } catch (FileNotFoundException e) {
            System.out.println("Файл отсутствует");
        }
        numberString=3429;//сделать подсчет строк и в идеале столбцов в файле,
        inputData = new String[numberString][numberColumn];
//        number2 = new String[numberString];
        k = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
//            number = line.split("\";\"");
            number = line.replace(',', '.');
            inputData[k] = number.split("\";\"");
//            number2[k] = Arrays.toString(number);
            k++;
        }
        scan.close();
//        for (int i = 0; i < inputData.length; i++) {
//            inputData[i] = number[i].split("\";\"");
//        }
    }

    public void printArr() {
        for (int i = 0; i < inputData.length; i++) {
            System.out.println(Arrays.toString(inputData[i]));
        }
    }
}
