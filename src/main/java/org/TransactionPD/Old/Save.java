package org.TransactionPD.Old;

//public class Save {
//    package org.TransactionPD;
//
//import org.TransactionPD.Data.CreateOutputFile;
//import org.TransactionPD.Data.InputData;
//import org.TransactionPD.Data.OutputData;
//import org.TransactionPD.Interface.CreateInterface;
//import org.TransactionPD.Interface.FormaInterface;
//import org.TransactionPD.ProcessingData.*;
//import java.io.IOException;
//import java.util.*;
//
//    public class MainTransactionPD {
//        static int categories;
//        static int description;
//        static int operation;
//        static int numberColumn;
//        static int timeColumn;
//        static int amountMonth;
//        static int amountQuarter;
//        static int amountYear;
//        static String fileNameMonth;
//        static String fileNameQuarter;
//        static String fileNameYear;
//        static int exitMonth;
//
//        static List<String> mPODescr = new ArrayList<>();
//        static List<String> mMODescr = new ArrayList<>();
//        static List<String> mPOCate = new ArrayList<>();
//        static List<String> mMOCate = new ArrayList<>();
//
//        static List<String> qPODescr = new ArrayList<>();
//        static List<String> qMODescr = new ArrayList<>();
//        static List<String> qPOCate = new ArrayList<>();
//        static List<String> qMOCate = new ArrayList<>();
//
//        static List<String> yPODescr = new ArrayList<>();
//        static List<String> yMODescr = new ArrayList<>();
//        static List<String> yPOCate = new ArrayList<>();
//        static List<String> yMOCate = new ArrayList<>();
//
//
//
//        public static void main(String[] args) throws IOException {
//
//            System.out.println("Hello, Transaction Program Data!");
//
//            numberColumn = 15;//общее количество столбцов
//            InputData inputDataFile = new InputData("operations.csv", numberColumn);//сюда будем передавать ссылку на файл
//            inputDataFile.inputDataFile();//импорт данных из файла и запись в массив inputData
//
//
//            categories = 9;//категории
//            description = 11;//описание
//            operation = 6;//операции
//            Identification dataFile = new Identification(inputDataFile.getInputData(),categories, description, operation, numberColumn);
//            dataFile.operationInputData();//разделение поступлений и трат
//            dataFile.sortFile();//Идентификация категорий и описания отдельно
//
//
//            fileNameMonth = "OutputMonth";
//            fileNameQuarter = "OutputQuarter";
//            fileNameYear = "OutputYear";
//            CreateOutputFile createFile = new CreateOutputFile(fileNameMonth, fileNameQuarter, fileNameYear);
//            createFile.createOutputData();//создание файлов
//
//        /* проверка
//        inputDataFile.printArr();
//        dataFile.dataPrint2();//печать массивов с категориями и описанием
//         */
//
//
//            timeColumn = 0;//столбец времени
//
//            //месячный отсчет
//            MonthReport monthReport = new MonthReport(dataFile, timeColumn, categories, description, operation, mPODescr, mMODescr, mPOCate, mMOCate);
//            monthReport.monthReport();
//
//
////        amountMonth = 0;
////        int i=0;
////        while (true) {//месяцы
////            exitMonth=0;
////            i++;
////            TimeMonth timeMonth = new TimeMonth(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountMonth);
////            timeMonth.numberTimeMonth();//начальная и конечная строка месяца
////
////            RangeData rangeMonth = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeMonth.getPlusStartNumberMonth(), timeMonth.getPlusEndNumberMonth(),timeMonth.getMinusStartNumberMonth(), timeMonth.getMinusEndNumberMonth(), description, categories, operation);
////            rangeMonth.dataCateDescr();//группирует траты за диапозон по описанию
////            amountMonth -= 1;//задается количество месяцев
////
////            DeleteNull deleteNullMonth = new DeleteNull(rangeMonth.getPlusOutputDataDescription(), rangeMonth.getMinusOutputDataDescription(), rangeMonth.getPlusOutputDataCategories(), rangeMonth.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
////            deleteNullMonth.deleteNull();//удаляет пустые строки
////
////            if ((timeMonth.getPlusStartNumberMonth()==timeMonth.getPlusEndNumberMonth())&&(timeMonth.getMinusStartNumberMonth()==timeMonth.getMinusEndNumberMonth())) {
////                exitMonth = i;//для окончания записи в файл
////            }
////
////            OutputData outputDataMonth = new OutputData(deleteNullMonth.getPlusOutputDescr(), deleteNullMonth.getMinusOutputDescr(), deleteNullMonth.getPlusOutputCate(), deleteNullMonth.getMinusOutputCate(), deleteNullMonth.getPlusDescr(), deleteNullMonth.getMinusDescr(), deleteNullMonth.getPlusCate(), deleteNullMonth.getMinusCate(), exitMonth, CreateOutputFile.getWriterMonth(), timeMonth.getPlusMonth(), timeMonth.getPlusYears(), timeMonth.getMinusMonth(), timeMonth.getMinusYears(), mPODescr, mMODescr, mPOCate, mMOCate);
////            outputDataMonth.outputData();//запись данных в файл
////
////            if ((timeMonth.getPlusStartNumberMonth()==timeMonth.getPlusEndNumberMonth())&&(timeMonth.getMinusStartNumberMonth()==timeMonth.getMinusEndNumberMonth())) {
////                break;//условие выхода(файл для анализа закончился)
////            }
////
////            /*проверки
////                        time.printStringData();//печатает начальную и конечную строку
////                        rangeMonth.printOutputData();//печатает сгруппированный диапозон по описанию
////                        deleteNullMonth.print();//печатает строки без нулей
////            */
////        }
////
////        FormaInterface graphicInterfaceMonth = new FormaInterface(mPODescr, mMODescr, mPOCate, mMOCate);
////        graphicInterfaceMonth.graphicInterface();//формирование файла для вывода в интерфейс
//
//
//
//
//
//
//
//            //квартальный отсчет
//            QuarterReport quarterReport = new QuarterReport(dataFile, timeColumn, categories, description, operation, qPODescr, qMODescr, qPOCate, qMOCate);
//            quarterReport.quarterReport();
//
//
//
////        amountQuarter = 0;
////        int i=0;
////        while (true) {//месяцы
////            exitMonth=0;
////            i++;
////            TimeQuarter timeQuarter = new TimeQuarter(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountQuarter);
////            timeQuarter.numberTimeQuarter();//начальная и конечная строка квартала
////
////            RangeData rangeQuarter = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeQuarter.getPlusStartNumberQuarter(), timeQuarter.getPlusEndNumberQuarter(),timeQuarter.getMinusStartNumberQuarter(), timeQuarter.getMinusEndNumberQuarter(), description, categories, operation);
////            rangeQuarter.dataCateDescr();//группирует траты за диапозон по описанию
////            amountQuarter -= 1;//задается количество месяцев
////
////            DeleteNull deleteNullQuarter = new DeleteNull(rangeQuarter.getPlusOutputDataDescription(), rangeQuarter.getMinusOutputDataDescription(), rangeQuarter.getPlusOutputDataCategories(), rangeQuarter.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
////            deleteNullQuarter.deleteNull();//удаляет пустые строки
////
////            if ((timeQuarter.getPlusStartNumberQuarter()==timeQuarter.getPlusEndNumberQuarter())&&(timeQuarter.getMinusStartNumberQuarter()==timeQuarter.getMinusEndNumberQuarter())) {
////                exitMonth = i;//для окончания записи в файл
////            }
////
////            OutputData outputDataQuarter = new OutputData(deleteNullQuarter.getPlusOutputDescr(), deleteNullQuarter.getMinusOutputDescr(), deleteNullQuarter.getPlusOutputCate(), deleteNullQuarter.getMinusOutputCate(), deleteNullQuarter.getPlusDescr(), deleteNullQuarter.getMinusDescr(), deleteNullQuarter.getPlusCate(), deleteNullQuarter.getMinusCate(), exitMonth, CreateOutputFile.getWriterQuarter(), timeQuarter.getPlusQuarter(), timeQuarter.getPlusYears(), timeQuarter.getMinusQuarter(), timeQuarter.getMinusYears(), qPODescr, qMODescr, qPOCate, qMOCate);
////            outputDataQuarter.outputData();//запись данных в файл
////
////            if ((timeQuarter.getPlusStartNumberQuarter()==timeQuarter.getPlusEndNumberQuarter())&&(timeQuarter.getMinusStartNumberQuarter()==timeQuarter.getMinusEndNumberQuarter())) {
////                break;//условие выхода(файл для анализа закончился)
////            }
////
////            /*проверка
////                        time.printStringData();//печатает начальную и конечную строку
////                        rangeQuarter.printOutputData();//печатает сгруппированный диапозон по описанию
////                        deleteNullMonth.print();//печатает строки без нулей
////            */
////        }
////
////        FormaInterface graphicInterfaceQuarter = new FormaInterface(qPODescr, qMODescr, qPOCate, qMOCate);
////        graphicInterfaceQuarter.graphicInterface();//формирование файла для вывода в интерфейс
//
//
//
//
//            //годовой отсчет
//            YearReport yearReport = new YearReport(dataFile, timeColumn, categories, description, operation, yPODescr, yMODescr, yPOCate, yMOCate);
//            yearReport.yearReport();
//
////        amountYear = 0;
////        int i=0;
////        while (true) {//месяцы
////            exitMonth=0;
////            i++;
////            TimeYear timeYear = new TimeYear(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountYear);
////            timeYear.numberTimeYear();//начальная и конечная строка года
////
////            RangeData rangeYear = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeYear.getPlusStartNumberYear(), timeYear.getPlusEndNumberYear(),timeYear.getMinusStartNumberYear(), timeYear.getMinusEndNumberYear(), description, categories, operation);
////            rangeYear.dataCateDescr();//группирует траты за диапозон по описанию
////            amountYear -= 1;//задается количество месяцев
////
////            DeleteNull deleteNullYear = new DeleteNull(rangeYear.getPlusOutputDataDescription(), rangeYear.getMinusOutputDataDescription(), rangeYear.getPlusOutputDataCategories(), rangeYear.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
////            deleteNullYear.deleteNull();//удаляет пустые строки
////
////            if ((timeYear.getPlusStartNumberYear()==timeYear.getPlusEndNumberYear())&&(timeYear.getMinusStartNumberYear()==timeYear.getMinusEndNumberYear())) {
////                exitMonth = i;//для окончания записи в файл
////            }
////
////            OutputData outputDataYear = new OutputData(deleteNullYear.getPlusOutputDescr(), deleteNullYear.getMinusOutputDescr(), deleteNullYear.getPlusOutputCate(), deleteNullYear.getMinusOutputCate(), deleteNullYear.getPlusDescr(), deleteNullYear.getMinusDescr(), deleteNullYear.getPlusCate(), deleteNullYear.getMinusCate(), exitMonth, CreateOutputFile.getWriterYear(), timeYear.getPlusMonth(), timeYear.getPlusYears(),timeYear.getMinusMonth(), timeYear.getMinusYears(), yPODescr, yMODescr, yPOCate, yMOCate);
////            outputDataYear.outputData();//запись данных в файл
////
////            if ((timeYear.getPlusStartNumberYear()==timeYear.getPlusEndNumberYear())&&(timeYear.getMinusStartNumberYear()==timeYear.getMinusEndNumberYear())) {
////                break;//условие выхода(файл для анализа закончился)
////            }
////
////            /*проверка
////                        time.printStringData();//печатает начальную и конечную строку
////                        rangeYear.printOutputData();//печатает сгруппированный диапозон по описанию
////                        deleteNullMonth.print();//печатает строки без нулей
////            */
////        }
////
////        FormaInterface graphicInterfaceYears = new FormaInterface(yPODescr, yMODescr, yPOCate, yMOCate);
////        graphicInterfaceYears.graphicInterface();//формирование файла для вывода в интерфейс
//
//
//
//
////        CreateInterface createInterface = new CreateInterface(graphicInterfaceMonth.getPODescrArr(), graphicInterfaceMonth.getMODescrArr(), graphicInterfaceMonth.getPOCateArr(), graphicInterfaceMonth.getMOCateArr(), graphicInterfaceQuarter.getPODescrArr(), graphicInterfaceQuarter.getMODescrArr(), graphicInterfaceQuarter.getPOCateArr(), graphicInterfaceQuarter.getMOCateArr(), graphicInterfaceYears.getPODescrArr(), graphicInterfaceYears.getMODescrArr(), graphicInterfaceYears.getPOCateArr(), graphicInterfaceYears.getMOCateArr());
////        //создание графического интерфейса
//
//            CreateInterface createInterface = new CreateInterface(monthReport.getPODescrArrMonth(), monthReport.getMODescrArrMonth(), monthReport.getPOCateArrMonth(), monthReport.getMOCateArrMonth(), quarterReport.getPODescrArrQuarter(), quarterReport.getMODescrArrQuarter(), quarterReport.getPOCateArrQuarter(), quarterReport.getMOCateArrQuarter(), yearReport.getPODescrArrYear(), yearReport.getMODescrArrYear(), yearReport.getPOCateArrYear(), yearReport.getMOCateArrYear());
//            //создание графического интерфейса
//
//
//
//
//
//        }
//}
