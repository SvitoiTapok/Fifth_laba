package commands;

import mainClasses.Product;
import mainClasses.ProductCollection;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Класс команды, выводящей все элементы коллекции, значение поля name которых начинается с заданной строки
 */

public class FilterStartsWithName implements Command{
    /**
     * метод, вывоящий в консоль все элементы коллекции, значение поля name которых начинается с заданной строки
     *
     * @param sc
     * @param productCollection
     * @param p                 строка, с которой должно начинаться имя продукта(len(p)=1 иначе в консоль будет выведена ошибка)
     * @param isFileReading
     */
    @Override
    public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        String StrBegin = p[0];
        Set<Product> products = productCollection.getProducts().stream().filter(x -> x.getName().startsWith(StrBegin)).collect(Collectors.toSet());
        for(Product product: products){
            System.out.println(product);
        }
    }
}
