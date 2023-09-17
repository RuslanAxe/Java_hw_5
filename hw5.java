// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
// их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

/**
 * hw5
 */
import java.util.*;

public class hw5 {
    
    public static Map<String, Set<String>> tel = new HashMap<>();
//  public static Set<String> numberSet = new HashSet<>();

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду: ");
            String input = scanner.nextLine();

            String[] split = input.split(" ");
            String command = split[0];

            switch (command) {
                case "ADD" -> addContact(split);
                case "GET" -> getNumbers(split);
                case "REMOVE" -> removeContact(split);
                case "LIST" -> listContacts();
                case "EXIT" -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Неверная команда.");
            }
        }
    }
    //ADD
    public static void addContact(String[] command){
        if (command.length < 3) {
            System.out.println("Неверный формат команды ADD.");
            return;
        }

        String lastName = command[1];
        String phoneNumber = command[2];

        Set<String> numberSet = tel.getOrDefault(lastName, new HashSet<>());
        numberSet.add(phoneNumber);
        tel.put(lastName, numberSet);
        System.out.println(tel);
    }  
    //GET
    public static void getNumber(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды GET.");
            return;
        }
        String lastName = command[1];
        Set<String> numberSet = tel.get(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \" "+ lastName + "\"");
        } 
        else {
            System.out.println(numberSet);
        }
    }
    //REMOVE
    public static void removeContact(String[] command) {
        if (command.length < 2) {
            System.out.println("Неверный формат команды REMOVE.");
            return;
        }
        String lastName = command[1];
        Set<String> numberSet = tel.remove(lastName);

        if (numberSet == null) {
            System.out.println("Не найдена запись с фамилией \"" + lastName + "\"");
        }
        else {
            System.out.println("Записи с фамилией \"" + lastName + "\" удалены.");
        }
    }
    //LIST
    public static void listContacts() {
        for (Map.Entry<String, Set<String>> entry : tel.entrySet()) {
            String lastName = entry.getKey();
            Set<String> numberSet = entry.getValue();
            System.out.println(lastName + " = " + numberSet);
        }
    }
}