package com.suri.java.vinit;


import java.io.*;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 15/07/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class SingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1==singleton2);

        /**
         * checking serialization property
         */

        Singleton singletonSer = Singleton.getInstance();

        /**
         * serialized
         */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("vinit.ser"));

        objectOutputStream.writeObject(singletonSer);
        objectOutputStream.close();

        /**
         * deserialize
         */

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("vinit.ser"));

        Singleton singletonDeser = (Singleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(singletonSer==singletonDeser);
        System.out.println("hash code of singletonSer "+singletonSer);
        System.out.println("hashcode of singletonDeser "+singletonDeser);


    }
}

/**
 * Singleton
 */
class Singleton implements Serializable {

    private static Singleton singleton;

    /**
     * private constructor
     */
    private Singleton(){

    }

    /**
     * @return
     */
    public static Singleton getInstance() {


        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }

            }

        }
        return singleton;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * @return
     */
    protected Object readResolve()
    {
        return singleton;
    }
}