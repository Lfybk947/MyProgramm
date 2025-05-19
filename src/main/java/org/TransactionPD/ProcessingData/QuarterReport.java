package org.TransactionPD.ProcessingData;

import org.TransactionPD.Data.CreateOutputFile;
import org.TransactionPD.Data.OutputData;
import org.TransactionPD.Interface.FormaInterface;

import java.util.List;

public class QuarterReport {
    static int exitQuarter;
    static int amountQuarter;
    private final Identification dataFile;
    private final int timeColumn;
    private final int categories;
    private final int description;
    private final int operation;
    private final List<String> qMODescr;
    private final List<String> qMOCate;
    private final List<String> qPOCate;
    private final List<String> qPODescr;

    private String[][] PODescrArrQuarter;
    private String[][] MODescrArrQuarter;
    private String[][] POCateArrQuarter;
    private String[][] MOCateArrQuarter;

    public QuarterReport(Identification dataFile, int timeColumn, int categories, int description, int operation,
                         List<String> qPODescr, List<String> qMODescr, List<String> qPOCate, List<String> qMOCate) {
        this.dataFile = dataFile;
        this.timeColumn = timeColumn;
        this.categories = categories;
        this.description = description;
        this.operation = operation;

        this.qPODescr = qPODescr;
        this.qMODescr = qMODescr;
        this.qPOCate = qPOCate;
        this.qMOCate = qMOCate;
    }
    public String[][] getPODescrArrQuarter() {
        return PODescrArrQuarter;
    }
    public String[][] getMODescrArrQuarter() {
        return MODescrArrQuarter;
    }
    public String[][] getPOCateArrQuarter() {
        return POCateArrQuarter;
    }
    public String[][] getMOCateArrQuarter() {
        return MOCateArrQuarter;
    }

    public void quarterReport() {
/*
        amountQuarter = 0;
        int i=0;
        while (true) {//кварталы
            exitQuarter=0;
            i++;
            TimeQuarter timeQuarter = new TimeQuarter(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountQuarter);
            timeQuarter.numberTimeQuarter();//начальная и конечная строка квартала

            RangeData rangeQuarter = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeQuarter.getPlusStartNumberQuarter(), timeQuarter.getPlusEndNumberQuarter(),timeQuarter.getMinusStartNumberQuarter(), timeQuarter.getMinusEndNumberQuarter(), description, categories, operation);
            rangeQuarter.dataCateDescr();//группирует траты за диапозон по описанию
            amountQuarter -= 1;//задается количество месяцев

            DeleteNull deleteNullQuarter = new DeleteNull(rangeQuarter.getPlusOutputDataDescription(), rangeQuarter.getMinusOutputDataDescription(), rangeQuarter.getPlusOutputDataCategories(), rangeQuarter.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
            deleteNullQuarter.deleteNull();//удаляет пустые строки

            if ((timeQuarter.getPlusStartNumberQuarter()==timeQuarter.getPlusEndNumberQuarter())&&(timeQuarter.getMinusStartNumberQuarter()==timeQuarter.getMinusEndNumberQuarter())) {
                exitQuarter = i;//для окончания записи в файл
            }

            OutputData outputDataQuarter = new OutputData(deleteNullQuarter.getPlusOutputDescr(), deleteNullQuarter.getMinusOutputDescr(), deleteNullQuarter.getPlusOutputCate(), deleteNullQuarter.getMinusOutputCate(), deleteNullQuarter.getPlusDescr(), deleteNullQuarter.getMinusDescr(), deleteNullQuarter.getPlusCate(), deleteNullQuarter.getMinusCate(), exitQuarter, CreateOutputFile.getWriterQuarter(), timeQuarter.getPlusQuarter(), timeQuarter.getPlusYears(), timeQuarter.getMinusQuarter(), timeQuarter.getMinusYears(), qPODescr, qMODescr, qPOCate, qMOCate);
            outputDataQuarter.outputData();//запись данных в файл

            if ((timeQuarter.getPlusStartNumberQuarter()==timeQuarter.getPlusEndNumberQuarter())&&(timeQuarter.getMinusStartNumberQuarter()==timeQuarter.getMinusEndNumberQuarter())) {
                break;//условие выхода(файл для анализа закончился)
            }

            /*проверка
                        time.printStringData();//печатает начальную и конечную строку
                        rangeQuarter.printOutputData();//печатает сгруппированный диапозон по описанию
                        deleteNullMonth.print();//печатает строки без нулей
            */
       /* }

        FormaInterface graphicInterfaceQuarter = new FormaInterface(qPODescr, qMODescr, qPOCate, qMOCate);
        graphicInterfaceQuarter.graphicInterface();//формирование файла для вывода в интерфейс

        PODescrArrQuarter = graphicInterfaceQuarter.getPODescrArr();
        MODescrArrQuarter = graphicInterfaceQuarter.getMODescrArr();
        POCateArrQuarter = graphicInterfaceQuarter.getPOCateArr();
        MOCateArrQuarter = graphicInterfaceQuarter.getMOCateArr();
*/
    }
}
