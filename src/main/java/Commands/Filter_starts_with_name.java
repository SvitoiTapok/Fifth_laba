package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

import java.util.Set;
import java.util.stream.Collectors;
/**
 * Класс команды, выводящей все элементы коллекции, значение поля name которых начинается с заданной строки
 */

public class Filter_starts_with_name implements Command{
    public static final Filter_starts_with_name FILTER_STARTS_WITH_NAME = new Filter_starts_with_name();
    private Filter_starts_with_name(){};
    /**
     * метод, вывоящий в консоль все элементы коллекции, значение поля name которых начинается с заданной строки
     * @param p строка, с которой должно начинаться имя продукта(len(p)=1 иначе в консоль будет выведена ошибка)
     */
    @Override
    public void executeWithParameters(String[] p) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        String StrBegin = p[0];
        Set<Product> products = ProductCollection.PRODUCT_COLLECTION.getProducts().stream().filter(x -> x.getName().startsWith(StrBegin)).collect(Collectors.toSet());
        for(Product product: products){
            System.out.println(product);
        }
    }
}
