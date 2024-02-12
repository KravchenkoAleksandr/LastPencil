
import java.util.Random;
import java.util.Scanner;

public class GameMain {
    public static Scanner scanner;
    static Random random;
    static int manyPencil;
    static String name1;
    static String name2;
    static int numName;
    static String name;

    public static void main(String[] args) {
        int command;
        do {
            System.out.println("\nВыберете режим игры");
            System.out.println("1.Играть с компьютером.");
            System.out.println("2.Два игрока.");
            System.out.println("3.Выход.");
            command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.println("Введите имя игрока");
                    name1 = scanner.nextLine();
                    System.out.println("Вы ходите играть с подсказками?");
                    System.out.println("Введите \"Да\" - с подсказками.");
                    System.out.println("Введите \"Нет\" - без подсказок.");
                    String choose = scanner.nextLine();
                    if (choose.equalsIgnoreCase("Да")) {
                        System.out.println("Вы хотите сами ввести количество карандашей?\nНажмите" +
                                " \"Да\"-если хотите ввести сами" +
                                "\n\"Нет\"-количество карандашей будет рандомное.");
                        switch (scanner.nextLine()) {
                            case "Да":
                                manyPencil = inputManyPencil();
                                printPencils(manyPencil);
                                GamePlay.playersOneWithHelpPlayWithBot();
                                break;
                            case "Нет":
                                manyPencil = random.nextInt(1, 100);
                                printPencils(manyPencil);
                                GamePlay.playersOneWithHelpPlayWithBot();
                        }
                    } else if (choose.equalsIgnoreCase("Нет")) {
                        System.out.println("Вы хотите сами ввести количество карандашей?\nНажмите" +
                                " \"Да\"-если хотите ввести сами\n" +
                                "\"Нет\"-количество карандашей будет рандомное.");
                        switch (scanner.nextLine()) {
                            case "Да":
                                manyPencil = inputManyPencil();
                                printPencils(manyPencil);
                                GamePlay.playersOnePlayWithBot();
                                break;
                            case "Нет":
                                manyPencil = random.nextInt(1, 100);
                                printPencils(manyPencil);
                                GamePlay.playersOnePlayWithBot();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите имя первого игрока");
                    name1 = scanner.nextLine();
                    System.out.println(name1 + " Вы хотите играть с подсказками?\n\"Да\" - с подсказками\n\"Нет\" - без подсказок.");
                    String chooseName1 = scanner.nextLine();
                    System.out.println("Введите имя второго игрока");
                    name2 = scanner.nextLine();
                    System.out.println(name1 + " Вы хотите играть с подсказками?\n\"Да\" - с подсказками\n\"Нет\" - без подсказок.");
                    String chooseName2 = scanner.nextLine();

                    manyPencil = inputManyPencil();
                    name = inputNameWhoFirstStart(name1, name2);
                    printPencils(manyPencil);
                    numName = numberName(name, name1, name2);

                    if (chooseName1.equalsIgnoreCase("Да") && chooseName2.equalsIgnoreCase("Да"))
                        GamePlay.playersOneAndTwoPlayWithHelpBot(numName);

                    if (chooseName1.equalsIgnoreCase("Да") && chooseName2.equalsIgnoreCase("Нет"))
                        GamePlay.playersOnePlayWithHelpBot(numName);

                    if (chooseName1.equalsIgnoreCase("Нет") && chooseName2.equalsIgnoreCase("Да"))
                        GamePlay.playersTwoPlayWithHelpBot(numName);

                    if (chooseName1.equalsIgnoreCase("Нет") && chooseName2.equalsIgnoreCase("Нет"))
                        GamePlay.playersOneAndTwoPlayWithoutHelpBot(numName);

                case 3:
                    break;
                default:
                    System.out.println("Вы ввели не существующую команду!");
            }
        } while (command != 3);

    }

    public static int inputManyPencil() {
        System.out.println("Сколько карандашей вы хотите использовать:");

        while (true) {
            while (scanner.hasNextInt()) {
                manyPencil = scanner.nextInt();
                if (manyPencil < 0) {
                    System.out.println("Количество карандашей должно быть числом");
                } else if (manyPencil == 0) {
                    System.out.println("Количество карандашей должно быть положительным");
                }

                if (manyPencil != 0 && manyPencil >= 0) {
                    scanner.nextLine();
                    return manyPencil;
                }
            }

            System.out.println("Количество карандашей должно быть числом");
            scanner.next();
        }
    }

    public static String inputNameWhoFirstStart(String name1, String name2) {
        System.out.println("Кто начнет игру первым: " + name1 + " или " + name2);

        String inputName;
        do {
            inputName = scanner.nextLine();
            if (!inputName.equals(name1) && !inputName.equals(name2)) {
                System.out.println("Выберете между игроками: " + name1 + " и " + name2);
            }
        } while (!inputName.equals(name1) && !inputName.equals(name2));

        return inputName;
    }

    public static int numberName(String name, String name1, String name2) {
        if (name.equals(name1)) {
            return 1;
        } else {
            return name.equals(name2) ? 2 : 0;
        }
    }

    public static void printPencils(int manyPencil) {
        for (int i = 0; i < manyPencil; ++i) {
            System.out.print("| ");
        }

        System.out.println(manyPencil);
    }

    public static void turnName1() {
        System.out.println(name1 + " ходит! Возьмите 1,2 или 3 карандаша.");

        while (true) {
            while (scanner.hasNextInt()) {
                int many = scanner.nextInt();
                if (many > 3) {
                    System.out.println("Можно взять 1, 2 или 3 карандаша!");
                }

                if (many <= 0) {
                    System.out.println("Число должно быть положительным!");
                }

                if (many > manyPencil) {
                    System.out.println(String.format("Вы взяли больше карандашей,чем осталось! Возьмите не больше %d штук", manyPencil));
                }

                if (many <= 3 && many <= manyPencil && many > 0) {
                    int summ = manyPencil - many;
                    if (summ >= 0) {
                        printPencils(summ);
                        System.out.println();
                    }

                    manyPencil -= many;
                    if (manyPencil == 0 && !HelpBot.checkWinner) {
                        System.out.println(String.format("Победитель: %s", name2));
                    }
                    if (manyPencil == 0 && HelpBot.checkWinner) {
                        System.out.println(name1 + " Вы проиграли\nПобедил бот!");
                    }
                    return;
                }
            }

            System.out.println("Количество карандашей должно быть числом");
            scanner.next();
        }
    }

    public static void turnName2() {
        System.out.println(name2 + " ходит! Возьмите 1,2 или 3 карандаша.");

        while (true) {
            while (scanner.hasNextInt()) {
                int many = scanner.nextInt();
                if (many > 3) {
                    System.out.println("Можно взять 1,2 или 3 карандаша!");
                }

                if (many <= 0) {
                    System.out.println("Число должно быть положительным!");
                }

                if (many > manyPencil) {
                    System.out.println(String.format("Вы взяли больше карандашей,чем осталось! Возьмите не больше %d штук", manyPencil));
                }

                if (many <= 3 && many <= manyPencil && many > 0) {
                    int summ = manyPencil - many;
                    if (summ >= 0) {
                        printPencils(summ);
                        System.out.println();
                    }

                    manyPencil -= many;
                    if (manyPencil == 0) {
                        System.out.println(String.format("Победитель: %s", name1));
                    }

                    return;
                }
            }

            System.out.println("Количество карандашей должно быть числом");
            scanner.next();
        }
    }

    public static void firstGoesName1() {
        if (manyPencil > 0) {
            turnName1();
        }

        if (manyPencil > 0) {
            turnName2();
        }

    }

    public static void firstGoesName2() {
        if (manyPencil > 0) {
            turnName2();
        }

        if (manyPencil > 0) {
            turnName1();
        }

    }

    public static void firstGoesName1TheyWithHelpBot() {
        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName1();
        }

        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName2();
        }

    }

    public static void firstGoesName2TheyWithHelpBot() {
        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName2();
        }

        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName1();
        }

    }

    public static void firstGoesName1WithHelpBot() {
        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName1();
        }

        if (manyPencil > 0) {
            turnName2();
        }

    }

    public static void firstGoesName1Name2WithHelpBot() {
        if (manyPencil > 0) {
            turnName1();
        }

        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName2();
        }

    }

    public static void firstGoesName2WithHelpBot() {
        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName2();
        }

        if (manyPencil > 0) {
            turnName1();
        }

    }

    public static void firstGoesName2Name1WithHelpBot() {
        if (manyPencil > 0) {
            turnName2();
        }

        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName1();
        }

    }

    public static void playName1VsBot() {
        HelpBot.checkWinner = true;
        if (manyPencil > 0) {
            turnName1();
        }

        if (manyPencil > 0) {
            HelpBot.playingBot();
            if (manyPencil == 0) {
                System.out.println("Победил бот");
            }
        }

    }

    public static void playName1WithHelpBotVsBot() {
        HelpBot.checkWinner = true;
        if (manyPencil > 0) {
            HelpBot.helpsBot();
            turnName1();
        }

        if (manyPencil > 0) {
            HelpBot.playingBot();
        }

    }

    static {
        scanner = new Scanner(System.in);
        random = new Random();
        manyPencil = 0;
    }
}
