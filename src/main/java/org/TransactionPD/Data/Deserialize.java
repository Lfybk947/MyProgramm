package org.TransactionPD.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserialize {

    public void deserialize() {
//        Parameterr newParameter = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.readObject();
            fileIn.close();

            System.out.println("Десериализация прошла успешно");
        } catch (ClassNotFoundException r) {
            System.out.println("Класс не найден");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
