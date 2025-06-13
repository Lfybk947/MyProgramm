package org.TransactionPD;

import org.TransactionPD.Interface.CreateInterface;


public class FirstThread implements Runnable {
    CreateInterface createInterface;
    public FirstThread() {}

    @Override
    public void run() {
        createInterface = new CreateInterface();
        createInterface.createTables();
        ///Создание графического интерфейса
    }
}
