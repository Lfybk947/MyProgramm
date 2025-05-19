package org.TransactionPD.ProcessingData;

import org.TransactionPD.Data.CreateOutputFile;
import org.TransactionPD.Data.OutputData;
import org.TransactionPD.Interface.FormaInterface;

import java.util.List;

public class YearReport {
    static int exitYear;
    static int amountYear;
    private final Identification dataFile;
    private final int timeColumn;
    private final int categories;
    private final int description;
    private final int operation;
    private final List<String> yMODescr;
    private final List<String> yMOCate;
    private final List<String> yPOCate;
    private final List<String> yPODescr;

    private String[][] PODescrArrYear;
    private String[][] MODescrArrYear;
    private String[][] POCateArrYear;
    private String[][] MOCateArrYear;

    public YearReport(Identification dataFile, int timeColumn, int categories, int description, int operation,
                      List<String> yPODescr, List<String> yMODescr, List<String> yPOCate, List<String> yMOCate) {
        this.dataFile = dataFile;
        this.timeColumn = timeColumn;
        this.categories = categories;
        this.description = description;
        this.operation = operation;

        this.yPODescr = yPODescr;
        this.yMODescr = yMODescr;
        this.yPOCate = yPOCate;
        this.yMOCate = yMOCate;
    }
    public String[][] getPODescrArrYear() {
        return PODescrArrYear;
    }
    public String[][] getMODescrArrYear() {
        return MODescrArrYear;
    }
    public String[][] getPOCateArrYear() {
        return POCateArrYear;
    }
    public String[][] getMOCateArrYear() {
        return MOCateArrYear;
    }

    public void yearReport() {
/*
        amountYear = 0;
        int i=0;
        while (true) {//месяцы
            exitYear=0;
            i++;
            TimeYear timeYear = new TimeYear(dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeColumn, amountYear);
            timeYear.numberTimeYear();//начальная и конечная строка года

            RangeData rangeYear = new RangeData(dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories(), dataFile.getPlusInputData(), dataFile.getMinusInputData(), timeYear.getPlusStartNumberYear(), timeYear.getPlusEndNumberYear(),timeYear.getMinusStartNumberYear(), timeYear.getMinusEndNumberYear(), description, categories, operation);
            rangeYear.dataCateDescr();//группирует траты за диапозон по описанию
            amountYear -= 1;//задается количество месяцев

            DeleteNull deleteNullYear = new DeleteNull(rangeYear.getPlusOutputDataDescription(), rangeYear.getMinusOutputDataDescription(), rangeYear.getPlusOutputDataCategories(), rangeYear.getMinusOutputDataCategories(), dataFile.getPlusDataFileCateDescr(), dataFile.getMinusDataFileCateDescr(), dataFile.getPlusDataFileCategories(), dataFile.getMinusDataFileCategories());
            deleteNullYear.deleteNull();//удаляет пустые строки

            if ((timeYear.getPlusStartNumberYear()==timeYear.getPlusEndNumberYear())&&(timeYear.getMinusStartNumberYear()==timeYear.getMinusEndNumberYear())) {
                exitYear = i;//для окончания записи в файл
            }

            OutputData outputDataYear = new OutputData(deleteNullYear.getPlusOutputDescr(), deleteNullYear.getMinusOutputDescr(), deleteNullYear.getPlusOutputCate(), deleteNullYear.getMinusOutputCate(), deleteNullYear.getPlusDescr(), deleteNullYear.getMinusDescr(), deleteNullYear.getPlusCate(), deleteNullYear.getMinusCate(), exitYear, CreateOutputFile.getWriterYear(), timeYear.getPlusMonth(), timeYear.getPlusYears(),timeYear.getMinusMonth(), timeYear.getMinusYears(), yPODescr, yMODescr, yPOCate, yMOCate);
            outputDataYear.outputData();//запись данных в файл

            if ((timeYear.getPlusStartNumberYear()==timeYear.getPlusEndNumberYear())&&(timeYear.getMinusStartNumberYear()==timeYear.getMinusEndNumberYear())) {
                break;//условие выхода(файл для анализа закончился)
            }

            /*проверка
                        time.printStringData();//печатает начальную и конечную строку
                        rangeYear.printOutputData();//печатает сгруппированный диапозон по описанию
                        deleteNullMonth.print();//печатает строки без нулей
            */
        /*}

        FormaInterface graphicInterfaceYear = new FormaInterface(yPODescr, yMODescr, yPOCate, yMOCate);
        graphicInterfaceYear.graphicInterface();//формирование файла для вывода в интерфейс

        PODescrArrYear = graphicInterfaceYear.getPODescrArr();
        MODescrArrYear = graphicInterfaceYear.getMODescrArr();
        POCateArrYear = graphicInterfaceYear.getPOCateArr();
        MOCateArrYear = graphicInterfaceYear.getMOCateArr();
*/
    }

}
