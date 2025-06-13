package org.TransactionPD;



public class MainTransactionPD {

    public static void main(String[] args) {
        System.out.println("Hello, Transaction Program Data!");

        SecondThread secondThread = new SecondThread();
        Thread secondThreads = new Thread(secondThread);

        FirstThread firstThread = new FirstThread();
        Thread firstThreads = new Thread(firstThread);
        firstThreads.start();
        secondThreads.start();


    }

}

