
import java.util.Random;
public class HelpBot {
    public static Random random = new Random();
    static boolean checkWinner;


    public static void playingBot() {
        System.out.println("Ход бота");
        if (GameMain.manyPencil != 5 && ((GameMain.manyPencil - 5) % 4 != 0 || GameMain.manyPencil < 5)) {
            if (GameMain.manyPencil == 4 || GameMain.manyPencil % 4 == 0 && GameMain.manyPencil >= 4) {
                GameMain.manyPencil -= 3;
                System.out.println("Бот взял 3 карандаша.");
            } else if (GameMain.manyPencil != 3 && ((GameMain.manyPencil - 3) % 4 != 0 || GameMain.manyPencil < 3)) {
                if (GameMain.manyPencil != 2 && ((GameMain.manyPencil - 2) % 4 != 0 || GameMain.manyPencil < 2)) {
                    if (GameMain.manyPencil == 1) {
                        --GameMain.manyPencil;
                        System.out.println("Бот взял 1 карандаш.");
                    }
                } else {
                    --GameMain.manyPencil;
                    System.out.println("Бот взял 1 карандаш.");
                }
            } else {
                GameMain.manyPencil -= 2;
                System.out.println("Бот взял 2 карандаша.");
            }
        } else {
            int chooseRandom = random.nextInt(1, 3);
            GameMain.manyPencil -= chooseRandom;
            System.out.println("Бот взял " + chooseRandom  +" карандаша.");
        }

        if (GameMain.manyPencil >= 0) {
            if (GameMain.manyPencil > 0) {
                GameMain.printPencils(GameMain.manyPencil);
                System.out.println();
            }

            if (GameMain.manyPencil == 0) {
                System.out.println("Победитель:" + GameMain.name1);
            }
        }
    }


    public static void helpsBot() {
        if (GameMain.manyPencil != 5 && ((GameMain.manyPencil - 5) % 4 != 0 || GameMain.manyPencil < 5)) {
            if (GameMain.manyPencil == 4 || GameMain.manyPencil % 4 == 0 && GameMain.manyPencil >= 4) {
                System.out.println("Помощь бота: возьмите 3 карандаша.");
            } else if (GameMain.manyPencil != 3 && ((GameMain.manyPencil - 3) % 4 != 0 || GameMain.manyPencil < 3)) {
                if (GameMain.manyPencil != 2 && ((GameMain.manyPencil - 2) % 4 != 0 || GameMain.manyPencil < 2)) {
                    if (GameMain.manyPencil == 1) {
                        System.out.println("Вероятно вы проиграете, остался последний канандаш.");
                    }
                } else {
                    System.out.println("Помощь бота: возьмите 1 карандаш.");
                }
            } else {
                System.out.println("Помощь бота: возьмите 2 карандаша.");
            }
        } else {
            System.out.println("Помощь бота: к сожалению вы в проигрышной позиции,возьмите 1,2 или 3 карандаша.");
        }

    }
}
