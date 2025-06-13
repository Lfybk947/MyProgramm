package org.TransactionPD.Interface;

import org.TransactionPD.Interfaces.PersonListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CreateInterface extends JFrame {
    private JTabbedPane tabbedPann;
    private JButton add;
    private JPanel month;

    private static final ArrayList<PersonListener> personListeners = new ArrayList<>();



    public CreateInterface() {
        super("Transaction Program Data");//название программы
        this.setBounds(100, 100, 100, 200);//размер поля
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие поля
        try {
            this.setIconImage(ImageIO.read(new File("icon.png")));//иконка
        } catch (IOException e) {
            System.out.println("Отсутствует файл иконки приложения");
        }
    }

    public void createTables() {
        Font font = new Font("Verdana", Font.PLAIN, 12);
        tabbedPann = new JTabbedPane();
        month = new JPanel();
        month.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        month.add(buttons, BorderLayout.WEST);
        add = new JButton("Select file");
        add.setFont(font);
        tabbedPann.setFont(font);

        add.addActionListener(e -> notifyPersonListener(add, month, tabbedPann));


        buttons.add(add);
        month.add(tabbedPann, BorderLayout.CENTER);

        getContentPane().add(month);
        setPreferredSize(new Dimension(1000, 2000));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void addPersonListener(PersonListener listener) {
        personListeners.add(listener);
    }

    private void notifyPersonListener(JButton add, JPanel month, JTabbedPane tabbedPann) {
        for (PersonListener listener:personListeners) {
            listener.personCreated(add, month, tabbedPann);
        }
    }

}
