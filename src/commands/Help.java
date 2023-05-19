package commands;

import managers.CollectionManager;
import managers.ConsoleManager;

public class Help extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public Help(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("help", "h");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String args) {
        consoleManager.print("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "remove_all_by_difficulty difficulty : удалить из коллекции все элементы, значение поля difficulty которого эквивалентно заданному\n" +
                "remove_any_by_minimal_point minimalPoint : удалить из коллекции один элемент, значение поля minimalPoint которого эквивалентно заданному\n" +
                "filter_by_difficulty difficulty : вывести элементы, значение поля difficulty которых равно заданному\n");
        return true;
    }
}
