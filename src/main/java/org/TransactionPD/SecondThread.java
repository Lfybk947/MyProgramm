package org.TransactionPD;

import org.TransactionPD.Data.StartedNumbers;
import org.TransactionPD.Interface.CreateInterface;
import org.TransactionPD.Interface.CreateTable;
import org.TransactionPD.ProcessingData.ExecutableFile;

import javax.swing.*;
import java.io.File;


public class SecondThread implements Runnable {
    private File selectedFile;
    private static int i;

    public SecondThread() {}

    @Override
    public void run() {
        CreateInterface.addPersonListener((add, month, tabbedPann) -> {
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
            tabbedPann.addTab("File" + i++, tabbedPane);

            StartedNumbers startedNumbers = new StartedNumbers(15, 9
                    , 11, 6, 0, "OutputMonth", "OutputQuarter", "OutputYear", selectedFile);

            ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(), startedNumbers.getCategories()
                    , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                    , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear(), startedNumbers.getSelectedFile());
            executableProgramm.executable();
            new CreateTable(executableProgramm.getParameterr(), tabbedPane);
        });
    }
}
