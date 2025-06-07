package org.TransactionPD.Data;

import java.io.File;

public class StartedNumbers {
    private int numberColumn;// = 15;
    //общее количество столбцов
    private int categories; //= 9;
    //категории
    private int description; //= 11;
    //описание
    private int operation; //= 6;
    //операции
    private int timeColumn; //= 0;
    //столбец времени
    private String fileNameMonth; //= "OutputMonth";
    private String fileNameQuarter; //= "OutputQuarter";
    private String fileNameYear; //= "OutputYear";
    private final File selectedFile;


    public StartedNumbers(int numberColumn, int categories, int description, int operation, int timeColumn
            , String fileNameMonth, String fileNameQuarter, String fileNameYear, File selectedFile) {
        this.numberColumn = numberColumn;
        this.categories = categories;
        this.description = description;
        this.operation = operation;
        this.timeColumn = timeColumn;
        this.fileNameMonth = fileNameMonth;
        this.fileNameQuarter = fileNameQuarter;
        this.fileNameYear = fileNameYear;
        this.selectedFile = selectedFile;
    }

    public int getNumberColumn() {return numberColumn;}
    public int getCategories() {return categories;}
    public int getDescription() {return description;}
    public int getOperation() {return operation;}
    public int getTimeColumn() {return timeColumn;}
    public String getFileNameMonth() {return fileNameMonth;}
    public String getFileNameQuarter() {return fileNameQuarter;}
    public String getFileNameYear() {return fileNameYear;}
    public File getSelectedFile() {return selectedFile;}


    public void setNumberColumn(int numberColumn) {this.numberColumn = numberColumn;}
    public void setCategories(int categories) {this.categories = categories;}
    public void setDescription(int description) {this.description = description;}
    public void setOperation(int operation) {this.operation = operation;}
    public void setTimeColumn(int timeColumn) {this.timeColumn = timeColumn;}
    public void setFileNameMonth(String fileNameMonth) {this.fileNameMonth = fileNameMonth;}
    public void setFileNameQuarter(String fileNameQuarter) {this.fileNameQuarter = fileNameQuarter;}
    public void setFileNameYear(String fileNameYear) {this.fileNameYear = fileNameYear;}






}
