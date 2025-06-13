package org.TransactionPD.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputData {
    private String[][] inputData;
    private final File linkFile;
    private Scanner scan;
    private final int numberColumn;
    String number;

    public String[][] getInputData() {return inputData;}

    public InputData(File linkFile, int numberColumn) {
        this.linkFile = linkFile;
        this.numberColumn = numberColumn;
    }
    public void inputDataFile() {
        try {
            scan = new Scanner(linkFile);//сделать возможность использования вайла с расширением Excel
        } catch (FileNotFoundException e) {
            System.out.println("Файл отсутствует");
        }
        int numberString = 3429;//сделать подсчет строк и в идеале столбцов в файле,
        inputData = new String[numberString][numberColumn];
        int k = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            number = line.replace(',', '.');
            inputData[k] = number.split("\";\"");
            k++;
        }
        scan.close();
    }
}
