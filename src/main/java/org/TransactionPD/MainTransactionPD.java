package org.TransactionPD;

import org.TransactionPD.Data.*;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.Interface.FormaInterface;
import org.TransactionPD.ProcessingData.*;
import java.io.IOException;
import java.util.*;

public class MainTransactionPD {
    static int categories;
    static int description;
    static int operation;
    static int numberColumn;
    static int timeColumn;
    static String fileNameMonth;
    static String fileNameQuarter;
    static String fileNameYear;


    static List<String> mPODescr = new ArrayList<>();
    static List<String> mMODescr = new ArrayList<>();
    static List<String> mPOCate = new ArrayList<>();
    static List<String> mMOCate = new ArrayList<>();

    static List<String> qPODescr = new ArrayList<>();
    static List<String> qMODescr = new ArrayList<>();
    static List<String> qPOCate = new ArrayList<>();
    static List<String> qMOCate = new ArrayList<>();

    static List<String> yPODescr = new ArrayList<>();
    static List<String> yMODescr = new ArrayList<>();
    static List<String> yPOCate = new ArrayList<>();
    static List<String> yMOCate = new ArrayList<>();



    public static void main(String[] args) {

        System.out.println("Hello, Transaction Program Data!");

        numberColumn = 15;
        //общее количество столбцов
        InputData inputDataFile = new InputData("operations.csv", numberColumn);
        //сюда будем передавать ссылку на файл
        inputDataFile.inputDataFile();
        //импорт данных из файла и запись в массив inputData


        categories = 9;
        //категории
        description = 11;
        //описание
        operation = 6;
        //операции
        Identification dataFile = new Identification(inputDataFile.getInputData(),categories, description, operation, numberColumn);
        dataFile.operationInputData();
        //разделение поступлений и трат
        dataFile.sortFile();
        //Идентификация категорий и описания отдельно


        fileNameMonth = "OutputMonth";
        fileNameQuarter = "OutputQuarter";
        fileNameYear = "OutputYear";
        CreateOutputFile createFile = new CreateOutputFile(fileNameMonth, fileNameQuarter, fileNameYear);
        try {
            createFile.createOutputData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //создание файлов


        /* проверка
        inputDataFile.printArr();
        dataFile.dataPrint2();//печать массивов с категориями и описанием
         */

        timeColumn = 0;
        //столбец времени

        /// Основной код программы
        int identificationTime = 1;
        MonthReport monthReport = new MonthReport(dataFile, timeColumn, categories, description, operation, mPODescr, mMODescr, mPOCate, mMOCate, identificationTime);
        monthReport.report();
        //месячный отсчет
        identificationTime = 2;
        MonthReport quarterReport = new MonthReport(dataFile, timeColumn, categories, description, operation, qPODescr, qMODescr, qPOCate, qMOCate, identificationTime);
        quarterReport.report();
        //квартальный отсчет
        identificationTime = 3;
        MonthReport yearReport = new MonthReport(dataFile, timeColumn, categories, description, operation, yPODescr, yMODescr, yPOCate, yMOCate, identificationTime);
        yearReport.report();
        //годовой отсчет
        ///


        Parameterr parameterr = new Parameterr(monthReport.getPODescrArr(), monthReport.getMODescrArr(), monthReport.getPOCateArr(),
                monthReport.getMOCateArr(), quarterReport.getPODescrArr(), quarterReport.getMODescrArr(), quarterReport.getPOCateArr(),
                quarterReport.getMOCateArr(), yearReport.getPODescrArr(), yearReport.getMODescrArr(), yearReport.getPOCateArr(), yearReport.getMOCateArr());
        //сериализуемый класс

        Serializable serializable = new Serializable(parameterr);
        serializable.mainSerializable();
        //сериализация класса Parameterr
        //сериализация выводных таблиц

        Deserialize des = new Deserialize();
        des.deserialize();
        //десериализация


        CreateInterface createInterface = new CreateInterface(monthReport.getPODescrArr(), monthReport.getMODescrArr(), monthReport.getPOCateArr(),
                monthReport.getMOCateArr(), quarterReport.getPODescrArr(), quarterReport.getMODescrArr(), quarterReport.getPOCateArr(),
                quarterReport.getMOCateArr(), yearReport.getPODescrArr(), yearReport.getMODescrArr(), yearReport.getPOCateArr(), yearReport.getMOCateArr());
        //создание графического интерфейса





    }





}