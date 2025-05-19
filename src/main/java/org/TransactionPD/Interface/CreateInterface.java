package org.TransactionPD.Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CreateInterface extends JFrame {

    private final String[][] mPODescrArr;
    private final String[][] mMODescrArr;
    private final String[][] mPOCateArr;
    private final String[][] mMOCateArr;

    private final String[][] qPODescrArr;
    private final String[][] qMODescrArr;
    private final String[][] qPOCateArr;
    private final String[][] qMOCateArr;

    private final String[][] yPODescrArr;
    private final String[][] yMODescrArr;
    private final String[][] yPOCateArr;
    private final String[][] yMOCateArr;


    public CreateInterface(String[][] mPODescrArr, String[][] mMODescrArr, String[][] mPOCateArr, String[][] mMOCateArr,
                           String[][] qPODescrArr, String[][] qMODescrArr, String[][] qPOCateArr, String[][] qMOCateArr,
                           String[][] yPODescrArr, String[][] yMODescrArr, String[][] yPOCateArr, String[][] yMOCateArr) {

        super("Transaction Program Data");//название программы
        this.setBounds(100, 100, 100, 200);//размер поля
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие поля
        try {
            this.setIconImage(ImageIO.read(new File("icon.png")));//иконка
        } catch (IOException e) {
            System.out.println("Отсутствует файл иконки приложения");
        }

        this.mPODescrArr = mPODescrArr;
        this.mMODescrArr = mMODescrArr;
        this.mPOCateArr = mPOCateArr;
        this.mMOCateArr = mMOCateArr;

        this.qPODescrArr = qPODescrArr;
        this.qMODescrArr = qMODescrArr;
        this.qPOCateArr = qPOCateArr;
        this.qMOCateArr = qMOCateArr;

        this.yPODescrArr = yPODescrArr;
        this.yMODescrArr = yMODescrArr;
        this.yPOCateArr = yPOCateArr;
        this.yMOCateArr = yMOCateArr;

        Font font = new Font("Verdana", Font.PLAIN, 12);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel month = new JPanel();
        month.setLayout(new BorderLayout());

        String[] columnNames = {"Time Data", "Categories", "Description", "Operation"};

        JComponent table11 = new JTable(mPODescrArr, columnNames);//1-месяцы
        JComponent table12 = new JTable(mPOCateArr, columnNames);
        JComponent table13 = new JTable(mMODescrArr, columnNames);
        JComponent table14 = new JTable(mMOCateArr, columnNames);
        JComponent table21 = new JTable(qPODescrArr, columnNames);//2-кварталы
        JComponent table22 = new JTable(qPOCateArr, columnNames);
        JComponent table23 = new JTable(qMODescrArr, columnNames);
        JComponent table24 = new JTable(qMOCateArr, columnNames);
        JComponent table31 = new JTable(yPODescrArr, columnNames);//3-годы
        JComponent table32 = new JTable(yPOCateArr, columnNames);
        JComponent table33 = new JTable(yMODescrArr, columnNames);
        JComponent table34 = new JTable(yMOCateArr, columnNames);

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

//        JCheckBox Button1 = new JCheckBox("");
//        Button1.setMnemonic(KeyEvent.VK_C);
//        Button1.setSelected(false);
//        table11.add(Button1);

//        JButton addFile = new JButton("Добавить файл");
//        addFile.setFont(font);
//        addFile.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });


        JTabbedPane tabbedPane1 = new JTabbedPane();//1-месяцы

        JTabbedPane tabbedPane2 = new JTabbedPane();//2-кварталы

        JTabbedPane tabbedPane3 = new JTabbedPane();//3-годы


        tabbedPane.addTab("Месячный Отсчет", tabbedPane1);
        tabbedPane.addTab("Квартальный Отсчет", tabbedPane2);
        tabbedPane.addTab("Годовой Отсчет", tabbedPane3);

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








        month.add(tabbedPane, BorderLayout.CENTER);

        getContentPane().add(month);

        setPreferredSize(new Dimension(1000, 2000));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
