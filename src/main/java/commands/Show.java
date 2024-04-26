package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс команды, выводящий элементы коллекции в консоль
 * */

public class Show implements Command{
    /**
     * метод, Выводящий все элементы коллекции в консоль(вызывает to string у ProductCollection)
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading){
        if(productCollection.getProducts().isEmpty()){
            System.out.println("На данный момент в коллекции нет элементов");
            return;
        }
        for(Product product: productCollection.getProducts()){
            System.out.println(product);
        }
        System.out.println();
    }
}
