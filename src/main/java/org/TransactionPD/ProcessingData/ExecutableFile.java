package org.TransactionPD.ProcessingData;

import org.TransactionPD.Data.*;
import java.util.ArrayList;
import java.util.List;


public class ExecutableFile {
    private final int categories;
    private final int description;
    private final int operation;
    private final int numberColumn;
    private final int timeColumn;
    private final String fileNameMonth;
    private final String fileNameQuarter;
    private final String fileNameYear;

    List<String> mPODescr = new ArrayList<>();
    List<String> mMODescr = new ArrayList<>();
    List<String> mPOCate = new ArrayList<>();
    List<String> mMOCate = new ArrayList<>();

    List<String> qPODescr = new ArrayList<>();
    List<String> qMODescr = new ArrayList<>();
    List<String> qPOCate = new ArrayList<>();
    List<String> qMOCate = new ArrayList<>();

    List<String> yPODescr = new ArrayList<>();
    List<String> yMODescr = new ArrayList<>();
    List<String> yPOCate = new ArrayList<>();
    List<String> yMOCate = new ArrayList<>();

    private Parameterr parameterr;

    public ExecutableFile(int numberColumn, int categories, int description, int operation, int timeColumn
            , String fileNameMonth, String fileNameQuarter, String fileNameYear) {
        this.numberColumn = numberColumn;
        this.categories = categories;
        this.description = description;
        this.operation = operation;
        this.timeColumn = timeColumn;
        this.fileNameMonth = fileNameMonth;
        this.fileNameQuarter = fileNameQuarter;
        this.fileNameYear = fileNameYear;

    }
    public Parameterr getParameterr() {return parameterr;}

    public void executable() {

        InputData inputDataFile = new InputData("operations.csv", numberColumn);
        //сюда будем передавать ссылку на файл
        inputDataFile.inputDataFile();
        //импорт данных из файла и запись в массив inputData

        Identification dataFile = new Identification(inputDataFile.getInputData(),categories, description, operation, numberColumn);
        dataFile.operationInputData();
        //разделение поступлений и трат
        dataFile.sortFile();
        //Идентификация категорий и описания отдельно

        CreateOutputFile createFile = new CreateOutputFile(fileNameMonth, fileNameQuarter, fileNameYear);
        createFile.createOutputData();
        //создание файлов

        /* проверка
        inputDataFile.printArr();
        dataFile.dataPrint2();//печать массивов с категориями и описанием
         */

        /// Основной код программы
        RunnableReportMonth runnableReportMonth = new RunnableReportMonth(categories, description
                , operation, timeColumn, mPODescr, mMODescr, mPOCate, mMOCate, dataFile);
        Thread runnableReportMonthThread = new Thread(runnableReportMonth);
        runnableReportMonthThread.start();
        //месячный отсчет
        RunnableReportQuarter runnableReportQuarter = new RunnableReportQuarter(categories, description
                , operation, timeColumn, qPODescr, qMODescr, qPOCate, qMOCate, dataFile);
        Thread runnableReportQuarterThread = new Thread(runnableReportQuarter);
        runnableReportQuarterThread.start();
        //квартальный отсчет
        RunnableReportYear runnableReportYear = new RunnableReportYear(categories, description
                , operation, timeColumn, yPODescr, yMODescr, yPOCate, yMOCate, dataFile);
        Thread runnableReportYearThread = new Thread(runnableReportYear);
        runnableReportYearThread.start();
        //годовой отсчет
        ///

        try {
            runnableReportMonthThread.join();
            runnableReportQuarterThread.join();
            runnableReportYearThread.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка потоков");
        }


        parameterr = new Parameterr(RunnableReportMonth.getMPODA(), RunnableReportMonth.getMMODA(), RunnableReportMonth.getMPOCA(),
                RunnableReportMonth.getMMOCA()
                , RunnableReportQuarter.getQPODA(), RunnableReportQuarter.getQMODA(), RunnableReportQuarter.getQPOCA(),
                RunnableReportQuarter.getQMOCA()
                , RunnableReportYear.getYPODA(), RunnableReportYear.getYMODA(), RunnableReportYear.getYPOCA()
                , RunnableReportYear.getYMOCA());
        //сериализуемый класс

        Serializable serializable = new Serializable(parameterr);
        serializable.mainSerializable();
        //сериализация класса Parameterr
        //сериализация выводных таблиц

        Deserialize des = new Deserialize();
        des.deserialize();
        //десериализация

    }

}


/// ///
class RunnableReportMonth implements Runnable {
    private final int categories;
    private final int description;
    private final int operation;
    private final int timeColumn;
    private final List<String> mPODescr;
    private final List<String> mMODescr;
    private final List<String> mPOCate;
    private final List<String> mMOCate;
    private final Identification dataFile;

    private volatile static String[][] mPODA;
    private volatile static String[][] mMODA;
    private volatile static String[][] mPOCA;
    private volatile static String[][] mMOCA;


    public RunnableReportMonth(int categories, int description, int operation, int timeColumn
            ,  List<String> mPODescr, List<String> mMODescr, List<String> mPOCate, List<String> mMOCate, Identification dataFile) {
        this.categories = categories;
        this.description = description;
        this.operation = operation;
        this.timeColumn = timeColumn;
        this.mPODescr = mPODescr;
        this.mMODescr = mMODescr;
        this.mPOCate = mPOCate;
        this.mMOCate = mMOCate;
        this.dataFile = dataFile;
    }

    public static String[][] getMPODA() {return mPODA;}
    public static String[][] getMMODA() {return mMODA;}
    public static String[][] getMPOCA() {return mPOCA;}
    public static String[][] getMMOCA() {return mMOCA;}

    @Override
    public void run() {
        synchronized (RunnableReportMonth.class) {//это не работает
            int identificationTime = 1;
            RunnableReport monthReport = new RunnableReport(dataFile, timeColumn, categories, description, operation
                    , mPODescr, mMODescr, mPOCate, mMOCate, identificationTime);
            monthReport.report();
            mPODA = monthReport.getPODescrArr();
            mMODA = monthReport.getMODescrArr();
            mPOCA = monthReport.getPOCateArr();
            mMOCA = monthReport.getMOCateArr();
            //месячный отсчет
        }
    }
}
class RunnableReportQuarter implements Runnable {
    private final int categories;
    private final int description;
    private final int operation;
    private final int timeColumn;
    private final List<String> qPODescr;
    private final List<String> qMODescr;
    private final List<String> qPOCate;
    private final List<String> qMOCate;
    private final Identification dataFile;
    private static String[][] qPODA;
    private static String[][] qMODA;
    private static String[][] qPOCA;
    private static String[][] qMOCA;

    public RunnableReportQuarter(int categories, int description, int operation, int timeColumn
            ,  List<String> qPODescr, List<String> qMODescr, List<String> qPOCate, List<String> qMOCate, Identification dataFile) {
        this.categories = categories;
        this.description = description;
        this.operation = operation;
        this.timeColumn = timeColumn;
        this.qPODescr = qPODescr;
        this.qMODescr = qMODescr;
        this.qPOCate = qPOCate;
        this.qMOCate = qMOCate;
        this.dataFile = dataFile;
    }
    public static String[][] getQPODA() {return qPODA;}
    public static String[][] getQMODA() {return qMODA;}
    public static String[][] getQPOCA() {return qPOCA;}
    public static String[][] getQMOCA() {return qMOCA;}

    @Override
    public void run() {
        synchronized (RunnableReportQuarter.class) {
            int identificationTime = 2;
            RunnableReport quarterReport = new RunnableReport(dataFile, timeColumn, categories, description, operation
                    , qPODescr, qMODescr, qPOCate, qMOCate, identificationTime);
            quarterReport.report();
            qPODA = quarterReport.getPODescrArr();
            qMODA = quarterReport.getMODescrArr();
            qPOCA = quarterReport.getPOCateArr();
            qMOCA = quarterReport.getMOCateArr();
            //квартальный отсчет
        }
    }
}
class RunnableReportYear implements Runnable {
    private final int categories;
    private final int description;
    private final int operation;
    private final int timeColumn;
    private final List<String> yPODescr;
    private final List<String> yMODescr;
    private final List<String> yPOCate;
    private final List<String> yMOCate;
    private final Identification dataFile;
    private static String[][] yPODA;
    private static String[][] yMODA;
    private static String[][] yPOCA;
    private static String[][] yMOCA;

    public RunnableReportYear(int categories, int description, int operation, int timeColumn
            ,  List<String> yPODescr, List<String> yMODescr, List<String> yPOCate, List<String> yMOCate, Identification dataFile) {
        this.categories = categories;
        this.description = description;
        this.operation = operation;
        this.timeColumn = timeColumn;
        this.yPODescr = yPODescr;
        this.yMODescr = yMODescr;
        this.yPOCate = yPOCate;
        this.yMOCate = yMOCate;
        this.dataFile = dataFile;
    }
    public static String[][] getYPODA() {return yPODA;}
    public static String[][] getYMODA() {return yMODA;}
    public static String[][] getYPOCA() {return yPOCA;}
    public static String[][] getYMOCA() {return yMOCA;}

    @Override
    public void run() {
        synchronized (RunnableReportYear.class) {
            int identificationTime = 3;
            RunnableReport yearReport = new RunnableReport(dataFile, timeColumn, categories, description
                    , operation, yPODescr, yMODescr, yPOCate, yMOCate, identificationTime);
            yearReport.report();
            yPODA = yearReport.getPODescrArr();
            yMODA = yearReport.getMODescrArr();
            yPOCA = yearReport.getPOCateArr();
            yMOCA = yearReport.getMOCateArr();
            //годовой отсчет
        }
    }
}

