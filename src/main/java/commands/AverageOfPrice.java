package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс, команды возвращающей среднее значение цены у всех элементов коллекции
 */

public class AverageOfPrice implements Command{
    /**
     * метод, выводящий в консоль среднее значение цены у всех элементов коллекции
     */

    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        if(productCollection.getLen()==0)
            System.out.println("В коллекции нет ни одного продукта, пожалуйста, добавьте их");
        else {
            System.out.print("Cреднее значение цены по всем продуктам: ");
            System.out.println(Math.round(productCollection.getProducts().stream()
                    .map(Product::getPrice).reduce(Float::sum).get() /
                    productCollection.getLen() * 100000) / 100000);
        }
    }
}
