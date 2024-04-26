package commands;

import innerClasses.Person;
import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды, выводящей все элементы коллекции, значение поля owner которых меньше заданного(сравнение производится сравнением имени владельца лексикографическим порядком)
 */

public class FilterLessThanOwner implements Command{
    /**
     * метод, создающий объект Person и выводящий в консоль все элементы коллекции, значение поля owner которых меньше созданного
     */
    @Override
    public void execute(Scanner sc, ProductCollection productCollection, boolean isFileReading) {
        Person owner = Person.createPerson(sc, isFileReading);
        if(owner!=null) {
            LinkedHashSet<Product> products = productCollection.getProducts();
            System.out.println("Все продукты, имена владельцев которых меньше в лексикографическом порядке:");
            for (Product product : products) {
                if (product.getOwner().compareTo(owner) < 0)
                    System.out.println(product);

            }
            //System.out.println(products);
        }
    }

}
