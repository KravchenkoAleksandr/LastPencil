public class GamePlay {


    public static void playersOneAndTwoPlayWithoutHelpBot(int numName) {
        switch (numName) {
            case 1:
                System.out.println(GameMain.name1 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName1();
                }

                return;
            case 2:
                System.out.println(GameMain.name2 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName2();
                }
        }

    }

    public static void playersOneAndTwoPlayWithHelpBot(int numName) {
        switch (numName) {
            case 1:
                System.out.println(GameMain.name1 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName1TheyWithHelpBot();
                }

                return;
            case 2:
                System.out.println(GameMain.name2 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName2TheyWithHelpBot();
                }
        }

    }

    public static void playersOnePlayWithHelpBot(int numName) {
        switch (numName) {
            case 1:
                System.out.println(GameMain.name1 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName1WithHelpBot();
                }

                return;
            case 2:
                System.out.println(GameMain.name2 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName2Name1WithHelpBot();
                }
        }

    }

    public static void playersTwoPlayWithHelpBot(int numName) {
        switch (numName) {
            case 1:
                System.out.println(GameMain.name1 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName1Name2WithHelpBot();
                }

                return;
            case 2:
                System.out.println(GameMain.name2 + " начинает игру!");

                while (GameMain.manyPencil > 0) {
                    GameMain.firstGoesName2WithHelpBot();
                }
        }

    }

    public static void playersOnePlayWithBot() {
        System.out.println(GameMain.name1 + " начинает игру!");

        while (GameMain.manyPencil > 0) {
            GameMain.playName1VsBot();
        }

    }

    public static void playersOneWithHelpPlayWithBot() {
        System.out.println(GameMain.name1 + " начинает игру!");

        while (GameMain.manyPencil > 0) {
            GameMain.playName1WithHelpBotVsBot();
        }

    }
}

