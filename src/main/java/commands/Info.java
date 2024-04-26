package commands;

import innerClasses.Month;
import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс команды, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
 */

public class Info implements Command{
    /**
     * метод, выводящей в консоль краткую информацию о коллекции(дата создания, количество и тип элементов)
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
        String[] data = productCollection.getDate().toString().split(" ");

        System.out.println("Коллекция состоит из элементов типа Product, она была создана " +
                data[2] + " " + Month.getMounthTranslation(data[1]) + " " + data[5] + " года в " + data[3] +
                ". На данный момент она содержит " + productCollection.getLen() + " различных элементов");
    }
}
