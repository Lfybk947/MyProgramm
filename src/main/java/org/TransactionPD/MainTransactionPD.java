package org.TransactionPD;

import org.TransactionPD.Data.StartedNumbers;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.Interface.CreateTable;
import org.TransactionPD.Interfaces.PersonListener;
import org.TransactionPD.ProcessingData.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, Transaction Program Data!");
        final Lock firstLock = new ReentrantLock();

        FirstThread firstThread = new FirstThread(firstLock);
        SecondThread secondThread = new SecondThread(firstLock, firstThread.getCreateInterface());
        Thread firstThreads = new Thread(firstThread);
        Thread secondThreads = new Thread(secondThread);

        firstThreads.start();
//        secondThreads.start();


    }

}

class FirstThread implements Runnable {
    private File selectedFile;
    private static int i = 1;

    private final Lock firstLock;

    CreateInterface createInterface;

    public FirstThread(Lock firstLock) {
        this.firstLock = firstLock;
    }
    public CreateInterface getCreateInterface() {
        return createInterface;
    }


    @Override
    public void run() {
        createInterface = new CreateInterface(firstLock);
        createInterface.createTables();
        ///Создание графического интерфейса
        System.out.println("1");
        createInterface.addPersonListener(new PersonListener() {
            @Override
            public void personCreated(JButton add, JPanel month, JTabbedPane tabbedPann) {
                JFileChooser fileChooser = new JFileChooser();//window with choice
                fileChooser.setDialogTitle("Select file");
                int result = fileChooser.showOpenDialog(month);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();//give selected File
                    JOptionPane.showMessageDialog(month, "Selected file: " + selectedFile.getAbsolutePath()
                            , " Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(month, "Operation cancelled", "Result", JOptionPane.WARNING_MESSAGE);
                }
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPann.addTab("File number " + i++, tabbedPane);

                StartedNumbers startedNumbers = new StartedNumbers(15, 9
                        , 11, 6, 0, "OutputMonth", "OutputQuarter", "OutputYear", selectedFile);

                ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(), startedNumbers.getCategories()
                        , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                        , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear(), startedNumbers.getSelectedFile());
                executableProgramm.executable();
                CreateTable createTable = new CreateTable(executableProgramm.getParameterr(), tabbedPane);
            }
        });


    }
}

class SecondThread implements Runnable {
    private File selectedFile;

    private final Lock firstLock;
    private final CreateInterface createInterface;

    private static int i;

//    private final

    public SecondThread(Lock firstLock, CreateInterface createInterface) {
        this.firstLock = firstLock;
        this.createInterface = createInterface;
    }

    @Override
    public void run() {
        createInterface.addPersonListener(new PersonListener() {
            @Override
            public void personCreated(JButton add, JPanel month, JTabbedPane tabbedPann) {
                add.addActionListener(e -> {
                    JFileChooser fileChooser = new JFileChooser();//window with choice
                    fileChooser.setDialogTitle("Select file");
                    int result = fileChooser.showOpenDialog(month);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();//give selected File
                        JOptionPane.showMessageDialog(month, "Selected file: " + selectedFile.getAbsolutePath()
                                , " Result", JOptionPane.INFORMATION_MESSAGE);
                    } else if (result == JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(month, "Operation cancelled", "Result", JOptionPane.WARNING_MESSAGE);
                    }
                    JTabbedPane tabbedPane = new JTabbedPane();
                    tabbedPann.addTab("File"+ i++, tabbedPane);


                    StartedNumbers startedNumbers = new StartedNumbers(15, 9
                            , 11, 6, 0, "OutputMonth", "OutputQuarter", "OutputYear", selectedFile);

                    ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(), startedNumbers.getCategories()
                            , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                            , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear(), startedNumbers.getSelectedFile());
                    executableProgramm.executable();
                    CreateTable createTable = new CreateTable(executableProgramm.getParameterr(), tabbedPane);
                });
            }
        });
    }
}