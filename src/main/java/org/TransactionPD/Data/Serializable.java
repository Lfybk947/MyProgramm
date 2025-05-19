package org.TransactionPD.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializable {//сериализация класса Parameterr
    Parameterr parameterr;

    public Serializable(Parameterr parameterr) {
        this.parameterr = parameterr;

    }
    public void mainSerializable() {
        serializableMitod(parameterr);
    }



    public void serializableMitod(Parameterr parameterr) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(parameterr);



            out.close();
            fileOut.close();
            System.out.println("Сериализация данных сохранена в employee.ser");



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
