package com.buneev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = scanner.nextInt();
        logger.log("Создаём и наполняем список");
        List<Integer> source = generateList(listSize, maxValue);
        printList("Вот случайный список:", source);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int threshold = scanner.nextInt();
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(source);
        logger.log("Вывщдим результат на экран");
        printList("Отфильтрованный список", result);
        logger.log("Завершаем программу");
    }

    public static List<Integer> generateList(int listSize, int maxValue) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxValue + 1));
        }
        return list;
    }

    public static void printList(String caption, List<Integer> list) {
        System.out.print(caption);
        for (int value : list) {
            System.out.print(" " + value);
        }
        System.out.println();
    }
}
