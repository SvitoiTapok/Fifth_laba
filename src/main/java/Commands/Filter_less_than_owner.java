package Commands;

import InnerClasses.Person;
import MainClasses.Product;
import MainClasses.ProductCollection;

import java.util.LinkedHashSet;

/**
 * Класс команды, выводящей все элементы коллекции, значение поля owner которых меньше заданного(сравнение производится сравнением имени владельца лексикографическим порядком)
 */

public class Filter_less_than_owner implements Command{
    public static final Filter_less_than_owner FILTER_LESS_THAN_OWNER = new Filter_less_than_owner();
    private Filter_less_than_owner(){};
    /**
     * метод, создающий объект Person и выводящий в консоль все элементы коллекции, значение поля owner которых меньше созданного
     */
    @Override
    public void execute() {
        Person owner = Person.createPerson();
        if(owner!=null) {
            LinkedHashSet<Product> products = ProductCollection.PRODUCT_COLLECTION.getProducts();
            System.out.println("Все продукты, имена владельцев которых меньше в лексикографическом порядке:");
            for (Product product : products) {
                if (product.getOwner().compareTo(owner) < 0)
                    System.out.println(product);

            }
            //System.out.println(products);
        }
    }
}
