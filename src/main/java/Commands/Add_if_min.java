package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

/**
 * Класс, команды добавляющий новый элемент в коллекцию, если его значение меньше минимального в коллекции
 */
public class Add_if_min implements Command {
    public static final Add_if_min ADD_IF_MIN = new Add_if_min();
    /**
     * приватный конструктор для единственности команды
     */
    private Add_if_min(){};
    /**
     * метод, создающий объект с помощью метода класса Product и записывающий его в коллекцию, если он меньше минимального элемента коллекции
     */
    @Override
    public void execute() {
        Product product = Product.createProduct(null);
        if(product!=null && ProductCollection.PRODUCT_COLLECTION.getMinProduct().compareTo(product)>0){
            //System.out.println(ProductCollection.PRODUCT_COLLECTION.getMinProduct());
            //System.out.println(product + " " + ProductCollection.PRODUCT_COLLECTION.getMinProduct().compareTo(product));
            ProductCollection.PRODUCT_COLLECTION.addProduct(product);
        }else{
            if(product!=null)
                System.out.println("Продукт не был добавлен так как он не является минимальным(сортировка идет в алфавитном порядке имени продукта)");
        }
    }
}
