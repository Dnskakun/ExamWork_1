package AnimalNursery;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final AnimalsDB animalsDB;
    private final Scanner scanner;

    public Menu(AnimalsDB animalsDB) {
        this.animalsDB = animalsDB;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Реестр питомника:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Увидеть список команд, которые выполняет животное");
                System.out.println("3. Обучить животное новым командам");
                System.out.println("4. Посмотреть список всех животных питомника");
                System.out.println("0. Выйти из реестра");
                System.out.println("Выбирете номер пункта:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewAnimal();
                        break;
                    case 2:
                        showAnimalCommands();
                        break;
                    case 3:
                        teachNewCommads();
                        break;
                    case 4:
                        animalsDB.showAllAnimals();
                        break;
                    case 0:
                        System.out.println("Реестр закрыт!");
                        return;
                    default:
                        System.out.println("Введен не корректный номер пункта. Введите повторно.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный формат ввода. Введите повторно.");
                scanner.nextLine();
            }
        }
    }

    private void addNewAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите даты рождения животного (формат гггг-мм-дд):");
        String birthday = scanner.nextLine();
        System.out.println("Введите команды, которые умеет выполнять животное:");
        String commands = scanner.nextLine();
               
        System.out.println("Выбирите вид (род) животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел");
        int animalGenue = scanner.nextInt();
        scanner.nextLine();

        Animals animal;
        try (Counter count = new Counter()) {
            switch (animalGenue) {
                case 1:
                    animal = new Dog(name, birthday, commands);
                    break;
                case 2:
                    animal = new Cat(name, birthday, commands);
                    break;
                case 3:
                    animal = new Hamster(name, birthday, commands);
                    break;
                case 4:
                    animal = new Horse(name, birthday, commands);
                    break;
                case 5:
                    animal = new Camel(name, birthday, commands);
                    break;
                case 6:
                    animal = new Donkey(name, birthday, commands);
                    break;
                default:
                    System.out.println("Неверно выбран вид (род) животного.");
                    return;
            }

            animalsDB.addNewAnimal(animal);
            count.add();
        }
        System.out.println("Животное добавлено в реестр!");
    }

    private void showAnimalCommands() {
        System.out.println("Введите имя интересующего животного:");
        String name = scanner.nextLine();
        
        animalsDB.showAnimalCommands(name);
    }

    private void teachNewCommads() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите новые команды для данного животного через запятую:");
        String commands = scanner.nextLine();

        animalsDB.teachNewCommads(name, commands);
        System.out.println("Команды успешно добавлены!");
    }

}
