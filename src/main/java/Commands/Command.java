package Commands;

/**
 * Интерфейс всех для команд
 */

public interface Command {
    /**
    * метод, вызываемый у команд без передаваемых параметров(или параметров, передаваемых не в одной строке с командой)
    */
    default public void execute(){
        System.out.println("у этой команды нет реализации выполнения без параметров");
    }
    /**
     * метод, вызываемый у команд с передаваемыми параметрами
     * */
    default public void executeWithParameters(String[] p){
        System.out.println("у этой команды нет реализации выполнения c параметрами");
    }

}
