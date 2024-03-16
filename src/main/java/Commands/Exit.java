package Commands;

/**
 * Класс команды, заканчивающий выполнение программы
 */

public class Exit implements Command{
    public static final Exit EXIT = new Exit();

    private Exit(){}
    /**
     * метод, заканчивающий выполнение программы
     */
    @Override
    public void execute() {
        System.out.println("Программа была завершена");
        System.exit(0);
    }
}
