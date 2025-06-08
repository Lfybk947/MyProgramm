package org.TransactionPD.Interface;

import org.TransactionPD.Data.Parameterr;
import org.TransactionPD.Data.StartedNumbers;
import org.TransactionPD.ProcessingData.ExecutableFile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Lock;

public class CreateInterface extends JFrame {
    File selectedFile;
//    private final Parameterr parameterr;
    static int i;
    Process firstLock;
    JTabbedPane tabbedPane;

    public CreateInterface(Process firstLock) {
        super("Transaction Program Data");//название программы
        this.setBounds(100, 100, 100, 200);//размер поля
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие поля
        try {
            this.setIconImage(ImageIO.read(new File("icon.png")));//иконка
        } catch (IOException e) {
            System.out.println("Отсутствует файл иконки приложения");
        }
        this.firstLock = firstLock;
//        this.parameterr = parameterr;
    }
    public File getSelectedFile() {
        return selectedFile;
    }
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }



    public void createTables() {

        Font font = new Font("Verdana", Font.PLAIN, 12);
        JTabbedPane tabbedPann = new JTabbedPane();
        JPanel month = new JPanel();
        month.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        month.add(buttons, BorderLayout.WEST);
        JButton add = new JButton("Select file");
        add.setFont(font);


        add.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();//window with choice
            fileChooser.setDialogTitle("Select file");
            int result = fileChooser.showOpenDialog(month);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();//give selected File
                JOptionPane.showMessageDialog(month, "Selected file: " + selectedFile.getAbsolutePath()
                        , " Result", JOptionPane.INFORMATION_MESSAGE);

                firstLock.notify();

            } else if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(month, "Operation cancelled", "Result", JOptionPane.WARNING_MESSAGE);
            }
            ///
        /*
        StartedNumbers startedNumbers = new StartedNumbers(15,9
                ,11,6,0,"OutputMonth", "OutputQuarter", "OutputYear", selectedFile);

        ExecutableFile executableProgramm = new ExecutableFile(startedNumbers.getNumberColumn(),startedNumbers.getCategories()
                , startedNumbers.getDescription(), startedNumbers.getOperation(), startedNumbers.getTimeColumn(), startedNumbers.getFileNameMonth()
                , startedNumbers.getFileNameQuarter(), startedNumbers.getFileNameYear(), startedNumbers.getSelectedFile());
        executableProgramm.executable();
        parameterr = executableProgramm.getParameterr();

         */
        ///

//            firstLock.unlock();



            tabbedPane = new JTabbedPane();
            tabbedPann.addTab("File"+ i++, tabbedPane);
            tabbedPann.setFont(font);

/*
            JTabbedPane tabbedPane1 = new JTabbedPane();//1-месяцы
            JTabbedPane tabbedPane2 = new JTabbedPane();//2-кварталы
            JTabbedPane tabbedPane3 = new JTabbedPane();//3-годы

            JComponent table11 = new JTable(parameterr.getmPODescrArr(), columnNames);//1-месяцы
            JComponent table12 = new JTable(parameterr.getmPOCateArr(), columnNames);
            JComponent table13 = new JTable(parameterr.getmMODescrArr(), columnNames);
            JComponent table14 = new JTable(parameterr.getmMOCateArr(), columnNames);
            JComponent table21 = new JTable(parameterr.getqPODescrArr(), columnNames);//2-кварталы
            JComponent table22 = new JTable(parameterr.getqPOCateArr(), columnNames);
            JComponent table23 = new JTable(parameterr.getqMODescrArr(), columnNames);
            JComponent table24 = new JTable(parameterr.getqMOCateArr(), columnNames);
            JComponent table31 = new JTable(parameterr.getyPODescrArr(), columnNames);//3-годы
            JComponent table32 = new JTable(parameterr.getyPOCateArr(), columnNames);
            JComponent table33 = new JTable(parameterr.getyMODescrArr(), columnNames);
            JComponent table34 = new JTable(parameterr.getyMOCateArr(), columnNames);

            JScrollPane scrolPane11 = new JScrollPane((table11));
            JScrollPane scrolPane12 = new JScrollPane((table12));
            JScrollPane scrolPane13 = new JScrollPane((table13));
            JScrollPane scrolPane14 = new JScrollPane((table14));
            JScrollPane scrolPane21 = new JScrollPane((table21));
            JScrollPane scrolPane22 = new JScrollPane((table22));
            JScrollPane scrolPane23 = new JScrollPane((table23));
            JScrollPane scrolPane24 = new JScrollPane((table24));
            JScrollPane scrolPane31 = new JScrollPane((table31));
            JScrollPane scrolPane32 = new JScrollPane((table32));
            JScrollPane scrolPane33 = new JScrollPane((table33));
            JScrollPane scrolPane34 = new JScrollPane((table34));

            tabbedPane1.addTab("Пополнения по описанию", scrolPane11);
            tabbedPane1.addTab("Пополнения по категориям", scrolPane12);
            tabbedPane1.addTab("Траты по описанию", scrolPane13);
            tabbedPane1.addTab("Траты по категориям", scrolPane14);

            tabbedPane2.addTab("Пополнения по описанию", scrolPane21);
            tabbedPane2.addTab("Пополнения по категориям", scrolPane22);
            tabbedPane2.addTab("Траты по описанию", scrolPane23);
            tabbedPane2.addTab("Траты по категориям", scrolPane24);

            tabbedPane3.addTab("Пополнения по описанию", scrolPane31);
            tabbedPane3.addTab("Пополнения по категориям", scrolPane32);
            tabbedPane3.addTab("Траты по описанию", scrolPane33);
            tabbedPane3.addTab("Траты по категориям", scrolPane34);

            tabbedPane.addTab("Годовой Отсчет", tabbedPane3);
            tabbedPane.addTab("Квартальный Отсчет", tabbedPane2);
            tabbedPane.addTab("Месячный Отсчет", tabbedPane1);
*/
        });



        buttons.add(add);
        month.add(tabbedPann, BorderLayout.CENTER);


        getContentPane().add(month);
        setPreferredSize(new Dimension(1000, 2000));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }


}
