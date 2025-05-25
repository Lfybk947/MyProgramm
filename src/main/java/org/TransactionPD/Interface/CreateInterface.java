package org.TransactionPD.Interface;

import org.TransactionPD.Data.Parameterr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CreateInterface extends JFrame {

//    private final Parameterr parameterr;

    public CreateInterface(Parameterr parameterr) {
        super("Transaction Program Data");//название программы
        this.setBounds(100, 100, 100, 200);//размер поля
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие поля
        try {
            this.setIconImage(ImageIO.read(new File("icon.png")));//иконка
        } catch (IOException e) {
            System.out.println("Отсутствует файл иконки приложения");
        }
//        this.parameterr = parameterr;

        Font font = new Font("Verdana", Font.PLAIN, 12);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);

        JPanel month = new JPanel();
        month.setLayout(new BorderLayout());

        String[] columnNames = {"Time Data", "Categories", "Description", "Operation"};

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

/*
*
        JCheckBox Button1 = new JCheckBox("");
        Button1.setMnemonic(KeyEvent.VK_C);
        Button1.setSelected(false);
        table11.add(Button1);

        JButton addFile = new JButton("Добавить файл");
        addFile.setFont(font);
        addFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
*/

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
