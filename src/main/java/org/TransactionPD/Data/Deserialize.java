package org.TransactionPD.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Deserialize {


    public void deserialize() {
        Parameterr newParameter = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newParameter = (Parameterr) in.readObject();
            fileIn.close();

            System.out.println("Десериализация прошла успешно");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException r) {
            r.printStackTrace();
            System.out.println("Класс не найден");
            return;
        }


    }

}
