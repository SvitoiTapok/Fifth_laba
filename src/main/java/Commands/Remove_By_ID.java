package Commands;

import MainClasses.ProductCollection;
/**
 * Класс команды, удаляющей из коллекции элемент по id
 */

public class Remove_By_ID implements Command{
    public final static Remove_By_ID REMOVE = new Remove_By_ID();
    private Remove_By_ID(){}
    /**
     * метод, удаляляющий элемент из коллекции по заданному id(если элемента нет, то команда не делает ничего
     * @param p передается id(он должен быть типа long). при передаче более чем одного параметра команда выведет предупреждение
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
        ProductCollection.PRODUCT_COLLECTION.removeProduct(id);
        System.out.println("объект с id=" + id + "(если такой был) удален");
    }
}
