import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("Ввердите номер операции: \n" +
                    "1. Добавить \n" +
                    "2. Показать \n" +
                    "3. Удалить \n" +
                    "4. Найти \n" +
                    "Введите \" end \" для выхода из программы.");

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            try {
                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Неверный символ.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Что хотите купить?");
                    list.add(scanner.nextLine());
                    break;

                case 2:
                    showList(list);
                    break;

                case 3:
                    System.out.println("Какую покупку удалить из списка?");
                    String delete = scanner.nextLine();

                    try {
                        int productNum = Integer.parseInt(delete) - 1;
                        System.out.println("Покупка " + list.get(productNum) + " удалена из списка.");
                        list.remove(productNum);

                    } catch (NumberFormatException e) {
                        System.out.println("Покупка " + delete + " удалена из списка.");
                        list.remove(delete);
                    }
                    break;

                case 4:
                    System.out.println("Введите текст для поиска");
                    String search = scanner.nextLine();
                    String searchLower = search.toLowerCase();
                    String listLower;
                    boolean find = false;
                    System.out.println("По запросу + " + search + " найдено: ");
                    for (int i = 0; i < list.size(); i++) {
                        listLower = list.get(i).toLowerCase();
                        if (listLower.contains(searchLower)) {
                            find = true;
                            System.out.println((i + 1) + " " + list.get(i));
                        }

                        if (!find) {
                            System.out.println("Поиск не дал результата.");
                            break;
                        }
                    }
            }

        }


    }

    public static void showList(List list) {
        System.out.println("    Список покупок:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }


    }
}