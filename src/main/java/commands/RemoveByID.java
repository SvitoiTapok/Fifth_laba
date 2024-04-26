package commands;

import mainClasses.ProductCollection;

import java.util.Scanner;

/**
 * Класс команды, удаляющей из коллекции элемент по id
 */

public class RemoveByID implements Command{
    /**
     * метод, удаляляющий элемент из коллекции по заданному id(если элемента нет, то команда не делает ничего
     *
     * @param sc
     * @param productCollection
     * @param p                 передается id(он должен быть типа long). при передаче более чем одного параметра команда выведет предупреждение
     * @param isFileReading
     */
    @Override
    public void executeWithParameters(Scanner sc, ProductCollection productCollection, String[] p, boolean isFileReading) {
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
        productCollection.removeProduct(id);
        System.out.println("объект с id=" + id + "(если такой был) удален");
    }
}
