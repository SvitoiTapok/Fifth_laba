package Commands;

import MainClasses.Product;
import MainClasses.ProductCollection;

/**
 * Класс команды, обновляющий элемент по заданному id
 */

public class Update implements Command{
    public static final Update UPDATE = new Update();
    private Update(){};
    /**
     * метод, создающий элемент с заданным id, обновляющий его если он существует и добавляющий, если такого id не было
     * @param p id обновляемого элемента(передается одно значение - long id, на все остальное будет выведена ошибка)
     */

    @Override
    public void executeWithParameters(String[] p) {
        if(p.length>1){
            System.out.println("эта функция принимает только один аргумент");
            return;
        }
        try{
            if(Long.parseLong(p[0]) <= 0)
                throw new Exception();
        }catch (Exception e){
            System.out.println("пожалуйста, введите валентный id элемента(он должен быть натуральным числом)");
            return;
        }
        long id = Long.parseLong(p[0]);
        Product updatedProduct = Product.createProduct(id);
        ProductCollection.PRODUCT_COLLECTION.addProduct(updatedProduct);

        //два варианта: id уже существует и id не существует

    }
}
