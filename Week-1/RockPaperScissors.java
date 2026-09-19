
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static final int TOTAL_ROUNDS = 5;
    static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock")
                && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper")
                && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors")
                && computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove(Random random) {
        int index = random.nextInt(MOVES.length);
        return MOVES[index];
    }

    public static String getPlayerMove(Scanner scanner) {

        while (true) {

            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            String playerMove = scanner.nextLine().trim();

            if (playerMove.equalsIgnoreCase("Rock")
                    || playerMove.equalsIgnoreCase("Paper")
                    || playerMove.equalsIgnoreCase("Scissors")) {

                return playerMove;
            }

            System.out.println(
                    "Invalid input! Please enter Rock, Paper, or Scissors."
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("==============================");
        System.out.println("     ROCK PAPER SCISSORS");
        System.out.println("==============================");

        for (int round = 0; round < TOTAL_ROUNDS; round++) {

            System.out.println("\nRound " + (round + 1));

            String playerMove = getPlayerMove(scanner);
            String computerMove = getComputerMove(random);

            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);
        }

        double winPercentage =
                ((double) wins / TOTAL_ROUNDS) * 100;

        System.out.println("\n==============================================");
        System.out.println("                 FINAL SUMMARY");
        System.out.println("==============================================");

        System.out.printf(
                "%-8s %-15s %-18s %-18s%n",
                "Round",
                "Player Move",
                "Computer Move",
                "Result"
        );

        System.out.println("--------------------------------------------------------------");

        for (int round = 0; round < TOTAL_ROUNDS; round++) {

            System.out.printf(
                    "%-8d %-15s %-18s %-18s%n",
                    round + 1,
                    playerMoves[round],
                    computerMoves[round],
                    results[round]
            );
        }

        System.out.println("--------------------------------------------------------------");

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}