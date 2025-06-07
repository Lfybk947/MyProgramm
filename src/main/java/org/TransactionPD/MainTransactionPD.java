package org.TransactionPD;

import org.TransactionPD.Data.StartedNumbers;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.ProcessingData.*;

public class MainTransactionPD {


    public static void main(String[] args) {
        System.out.println("Hello, Transaction Program Data!");
/*
        StartedNumbers startedNumbers = new StartedNumbers(15,9
                ,11,6,0,"OutputMonth", "OutputQuarter", "OutputYear");

        ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(),startedNumbers.getCategories()
                , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear());
        executableProgramm.executable();
*/
//        CreateInterface createInterface = new CreateInterface(executableProgramm.getParameterr());
        CreateInterface createInterface = new CreateInterface();
        createInterface.createTables();
        ///Создание графического интерфейса





    }





}