package org.TransactionPD;

import org.TransactionPD.Data.StartedNumbers;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.Interface.CreateTable;
import org.TransactionPD.ProcessingData.*;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class MainTransactionPD {


    public static void main(String[] args) {
        System.out.println("Hello, Transaction Program Data!");
//        final Lock firstLock = new ReentrantLock();
//        final Object firstLock = new Object();
        Process firstLock = new Process() {
            @Override
            public OutputStream getOutputStream() {
                return null;
            }

            @Override
            public InputStream getInputStream() {
                return null;
            }

            @Override
            public InputStream getErrorStream() {
                return null;
            }

            @Override
            public int waitFor() throws InterruptedException {
                return 0;
            }

            @Override
            public int exitValue() {
                return 0;
            }

            @Override
            public void destroy() {

            }
        };
        final FirstThread firstThread = new FirstThread(firstLock);
        final SecondThread secondThread = new SecondThread(firstLock, firstThread.getSelectedFile(), firstThread.getTabbedPane());
        final Thread firstThreads = new Thread(firstThread);
        final Thread secondThreads = new Thread(secondThread);

        firstThreads.start();
        secondThreads.start();


    }

}

class FirstThread implements Runnable {
    private final Process firstLock;
    private JTabbedPane tabbedPane;
    private File selectedFile;

    public FirstThread(Process firstLock) {
        this.firstLock = firstLock;
    }
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
    public File getSelectedFile() {
        return selectedFile;
    }

    @Override
    public void run() {
        synchronized (firstLock) {
//            firstLock.lock();
            CreateInterface createInterface = new CreateInterface(firstLock);
            createInterface.createTables();
            tabbedPane = createInterface.getTabbedPane();
            selectedFile = createInterface.getSelectedFile();
            ///Создание графического интерфейса
//            firstLock.unlock();

        }
    }
}
class SecondThread implements Runnable {
    private final Process firstLock;
    private final File selectedFile;
    private final JTabbedPane tabbedPane;

    public SecondThread(Process firstLock, File selectedFile, JTabbedPane tabbedPane) {
        this.firstLock = firstLock;
        this.selectedFile = selectedFile;
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void run() {
        synchronized (firstLock) {
            try {
                firstLock.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
//            firstLock.lock();
            StartedNumbers startedNumbers = new StartedNumbers(15, 9
                    , 11, 6, 0, "OutputMonth", "OutputQuarter", "OutputYear", selectedFile);

            ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(), startedNumbers.getCategories()
                    , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                    , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear(), startedNumbers.getSelectedFile());
            executableProgramm.executable();
            CreateTable createTable = new CreateTable(executableProgramm.getParameterr(), tabbedPane);
            firstLock.notify();
//            firstLock.unlock();
        }
    }
}