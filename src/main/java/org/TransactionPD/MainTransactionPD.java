package org.TransactionPD;

import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.ProcessingData.*;

public class MainTransactionPD {


    public static void main(String[] args) {
        System.out.println("Hello, Transaction Program Data!");


        ExecutableFile executableProgramm = new ExecutableFile();
        executableProgramm.executable();

        CreateInterface createInterface = new CreateInterface(executableProgramm.getParameterr());
        ///Создание графического интерфейса





    }





}