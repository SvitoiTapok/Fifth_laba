package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс, команды добавляющий новый элемент в коллекцию, если его значение меньше минимального в коллекции
 */
public class AddIfMin implements Command {
    /**
     * метод, создающий объект с помощью метода класса Product и записывающий его в коллекцию, если он меньше минимального элемента коллекции
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        Product product = Product.createProduct(sc, productCollection, isFileReading);
        if(product!=null && productCollection.getMinProduct().compareTo(product)>0){
            productCollection.addProduct(product);
        }else{
            if(product!=null)
                System.out.println("Продукт не был добавлен так как он не является минимальным(сортировка идет в алфавитном порядке имени продукта)");
        }
    }
}
