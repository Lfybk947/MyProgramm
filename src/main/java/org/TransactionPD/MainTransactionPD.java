package org.TransactionPD;

import org.TransactionPD.Data.*;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.Interface.FormaInterface;
import org.TransactionPD.ProcessingData.*;
import java.io.IOException;
import java.util.*;

public class MainTransactionPD {


    public static void main(String[] args) {

        System.out.println("Hello, Transaction Program Data!");


        ExecutableFile executableProgramm = new ExecutableFile();
        executableProgramm.executable();

        CreateInterface createInterface = new CreateInterface(executableProgramm.getParameterr());

//        CreateInterface createInterface = new CreateInterface(monthReport.getPODescrArr(), monthReport.getMODescrArr(), monthReport.getPOCateArr(),
//                monthReport.getMOCateArr(), quarterReport.getPODescrArr(), quarterReport.getMODescrArr(), quarterReport.getPOCateArr(),
//                quarterReport.getMOCateArr(), yearReport.getPODescrArr(), yearReport.getMODescrArr(), yearReport.getPOCateArr(), yearReport.getMOCateArr());
        //создание графического интерфейса





    }





}