package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс, команды добавляющий новый элемент в коллекцию
 */
public class Add implements Command {
    /**
     * метод, создающий объект с помощью метода класса Product и записывающий его в коллекцию
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        Product product = Product.createProduct(sc, productCollection, isFileReading);
        if (product != null) {
            productCollection.addProduct(product);
        }
    }
}
