package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

/**
 * Класс команды, выводящий элементы коллекции в консоль
 * */

public class Show implements Command{
    public final static Show SHOW = new Show();

    private Show(){}
    /**
     * метод, Выводящий все элементы коллекции в консоль(вызывает to string у ProductCollection)
     */
    @Override
    public void execute(){
        if(ProductCollection.PRODUCT_COLLECTION.getProducts().isEmpty()){
            System.out.println("На данный момент в коллекции нет элементов");
            return;
        }
        for(Product product: ProductCollection.PRODUCT_COLLECTION.getProducts()){
            System.out.println(product);
        }
        System.out.println();
    }
}
