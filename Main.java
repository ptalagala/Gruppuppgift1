import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Player player1;
        Player player2;

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter player 1 name:");
            player1 = new Player(scanner.nextLine());

            System.out.println("Enter player 2 name:");
            player2 = new Player(scanner.nextLine());

            int noOfTurns = 0;
            String answer = "";
            int rolledDice1P1 = 0;
            int rolledDice2P1 = 0;

            int rolledDice1P2 = 0;
            int rolledDice2P2 = 0;
            int totalRolledP1 = 0;
            int totalRolledP2 = 0;

            while (!answer.equalsIgnoreCase("no")) {
                noOfTurns++;

                System.out.println("Round " + noOfTurns);
                System.out.println(player1.getName() + " - Press Enter to roll the dice.");
                answer = scanner.nextLine();

                if (answer.isBlank()) {
                    rolledDice1P1 = dice1.roll();
                    rolledDice2P1 = dice2.roll();
                    System.out.println(player1.getName() + " rolled Dice 1: " + rolledDice1P1);
                    System.out.println(player1.getName() + " rolled Dice 2: " + rolledDice2P1);
                    totalRolledP1 = rolledDice1P1 + rolledDice2P1;
                    System.out.println("Total rolled by " + player1.getName() + ": " + totalRolledP1);

                } else {
                    throw new IllegalArgumentException("Invalid choice. Press enter to roll the dice");
                }

                System.out.println(player2.getName() + " - Press Enter to roll the dice.");
                answer = scanner.nextLine();

                if (answer.isBlank()) {
                    rolledDice1P2 = dice1.roll();
                    rolledDice2P2 = dice2.roll();

                    System.out.println(player2.getName() + " rolled Dice 1: " + rolledDice1P2);
                    System.out.println(player2.getName() + " rolled Dice 2: " + rolledDice2P2);
                    totalRolledP2 = rolledDice1P2 + rolledDice2P2;
                    System.out.println("Total rolled by " + player2.getName() + ": " + totalRolledP2);

                } else {
                    throw new IllegalArgumentException("Invalid choice");
                }

                if (totalRolledP1 > totalRolledP2) {
                    player1.setScore();
                    System.out.println(player1.getName() + " got 1 point");
                } else {
                    player2.setScore();
                    System.out.println(player2.getName() + " got 1 point");
                }

                System.out.println("");
                System.out.println("###### Toal Points ######");
                System.out.println(player1.getName() + ": " + player1.getScore());
                System.out.println(player2.getName() + ": " + player2.getScore());
                System.out.println("################");

                System.out.println("Do you want to continue? (Enter for Yes / No to exit)");
                answer = scanner.nextLine();
            }

            if (player1.getScore() > player2.getScore()) {
                System.out.println("Congratulations! " + player1.getName() + " won the game with " + player1.getScore()
                        + " points !!");
                Scoreboard.saveToFile(player1.getName(), player1.getScore());
            } else {
                System.out.println("Congratulations! " + player2.getName() + " won the game with " + player2.getScore()
                        + " points !!");
                Scoreboard.saveToFile(player2.getName(), player2.getScore());

            }
        }

    }

}
