package org.TransactionPD.ProcessingData;

import org.TransactionPD.Data.CreateOutputFile;
import org.TransactionPD.Data.OutputData;
import org.TransactionPD.Interface.FormaInterface;
import org.TransactionPD.Interfaces.TimeInterfaces;

import java.util.List;


public class RunnableReport {
    private final Identification dataFile;
    private final int timeColumn;
    private final int categories;
    private final int description;
    private final int operation;
    private final List<String> mMODescr;
    private final List<String> mMOCate;
    private final List<String> mPOCate;
    private final List<String> mPODescr;

    private String[][] PODescrArr;
    private String[][] MODescrArr;
    private String[][] POCateArr;
    private String[][] MOCateArr;

    private final int identificationTime;

    public RunnableReport(Identification dataFile, int timeColumn, int categories, int description, int operation,
                       List<String> mPODescr, List<String> mMODescr, List<String> mPOCate, List<String> mMOCate, int identificationTime) {
        this.dataFile = dataFile;
        this.timeColumn = timeColumn;
        this.categories = categories;
        this.description = description;
        this.operation = operation;

        this.mPODescr = mPODescr;
        this.mMODescr = mMODescr;
        this.mPOCate = mPOCate;
        this.mMOCate = mMOCate;

        this.identificationTime = identificationTime;
    }
    public String[][] getPODescrArr() {return PODescrArr;}
    public String[][] getMODescrArr() {return MODescrArr;}
    public String[][] getPOCateArr() {return POCateArr;}
    public String[][] getMOCateArr() {return MOCateArr;}


    public void report() {
        ReportStringS monthReport = ReportStringS.monthReport(identificationTime, dataFile, timeColumn, categories, description,
                operation, mPODescr, mMODescr, mPOCate, mMOCate);
        PODescrArr = monthReport.PODescrArr;
        MODescrArr = monthReport.MODescrArr;
        POCateArr = monthReport.POCateArr;
        MOCateArr = monthReport.MOCateArr;
    }

    public static class ReportStringS {
        String[][] PODescrArr;
        String[][] MODescrArr;
        String[][] POCateArr;
        String[][] MOCateArr;

        public ReportStringS(String[][] PODescrArr, String[][] MODescrArr, String[][] POCateArr, String[][] MOCateArr) {
            this.PODescrArr = PODescrArr;
            this.MODescrArr = MODescrArr;
            this.POCateArr = POCateArr;
            this.MOCateArr = MOCateArr;
        }

        public static ReportStringS monthReport(int identificationTime, Identification dataFile, int timeColumn, int categories,
                                                int description, int operation, List<String> mPODescr, List<String> mMODescr,
                                                List<String> mPOCate, List<String> mMOCate) {
            int amountMonth = 0;
            int i = 0;
            while (true) {//месяцы
                int exitMonth = 0;
                i++;
                TimeInterfaces time;
                if (identificationTime==1) {
                    time = new TimeMonth(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountMonth);
                } else if (identificationTime==2) {
                    time = new TimeQuarter(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountMonth);
                } else {
                    time = new TimeYear(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountMonth);
                }
                time.timeInterfaces(amountMonth);



                RangeData rangeMonth = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(),
                        dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(),
                        dataFile.getMinusInputData(), time.getPlusStartNumber(), time.getPlusEndNumber(), time.getMinusStartNumber(),
                        time.getMinusEndNumber(), description, categories, operation);
                rangeMonth.dataCateDescr();//группирует траты за диапозон по описанию
                amountMonth -= 1;//задается количество месяцев

                DeleteNull deleteNullMonth = new DeleteNull(rangeMonth.getPlusOutputDataDescription(), rangeMonth.getMinusOutputDataDescription(),
                        rangeMonth.getPlusOutputDataCategories(), rangeMonth.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(),
                        dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
                deleteNullMonth.deleteNull();//удаляет пустые строки

                if ((time.getPlusStartNumber() == time.getPlusEndNumber()) && (time.getMinusStartNumber() == time.getMinusEndNumber())) {
                    exitMonth = i;//для окончания записи в файл
                }

                OutputData outputDataMonth = new OutputData(deleteNullMonth.getPlusOutputDescr(), deleteNullMonth.getMinusOutputDescr(),
                        deleteNullMonth.getPlusOutputCate(), deleteNullMonth.getMinusOutputCate(), deleteNullMonth.getPlusDescr(),
                        deleteNullMonth.getMinusDescr(), deleteNullMonth.getPlusCate(), deleteNullMonth.getMinusCate(), exitMonth,
                        CreateOutputFile.getWriterMonth(), CreateOutputFile.getWriterQuarter(), CreateOutputFile.getWriterYear(), time.getPlusMonth(), time.getPlusYears(), time.getMinusMonth(),
                        time.getMinusYears(), mPODescr, mMODescr, mPOCate, mMOCate, identificationTime);

                outputDataMonth.outputData();//запись данных в файл

                if ((time.getPlusStartNumber() == time.getPlusEndNumber()) && (time.getMinusStartNumber() == time.getMinusEndNumber())) {
                    break;//условие выхода(файл для анализа закончился)
                }

                /*проверки
                            time.printStringData();//печатает начальную и конечную строку
                            rangeMonth.printOutputData();//печатает сгруппированный диапозон по описанию
                            deleteNullMonth.print();//печатает строки без нулей
                */
            }

            FormaInterface graphicInterfaceMonth = new FormaInterface(mPODescr, mMODescr, mPOCate, mMOCate);
            graphicInterfaceMonth.graphicInterface();//формирование файла для вывода в интерфейс


            return new ReportStringS(graphicInterfaceMonth.getPODescrArr(), graphicInterfaceMonth.getMODescrArr(),
                    graphicInterfaceMonth.getPOCateArr(), graphicInterfaceMonth.getMOCateArr());
        }
    }

}
