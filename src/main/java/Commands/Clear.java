package Commands;

import MainClasses.ProductCollection;
/**
 * Класс, команды очищающей коллекцию
 */

public class Clear implements Command{
    public final static Clear CLEAR = new Clear();



    private Clear(){};
    /**
     * метод, очищающий коллекцию
     */
    @Override
    public void execute() {
        ProductCollection.PRODUCT_COLLECTION.clearCollection();
        System.out.println("Коллекция очищена");
    }
}
