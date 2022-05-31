package br.ufrpe.ip2.va3.questao3.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataBaseCommunication {
    public static Object read(String filePath) {
        Object instanciaLocal = null;
        File in = new File(filePath);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(in);
            objectInputStream = new ObjectInputStream(fileInputStream);
            instanciaLocal = objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("There is no file with name " + filePath);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return instanciaLocal;
    }

    public static void write(Object obj, String filePath) throws Exception {
        if (obj == null) {
            return;
        }
        File outputFile = new File(filePath);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        fileOutputStream = new FileOutputStream(outputFile);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(obj);
        if (objectOutputStream != null) {
            objectOutputStream.close();
        }
    }
}
