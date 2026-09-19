import java.util.Scanner;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0) {
                result.append(" | ");
            }

            if (average >= threshold) {
                result.append("Match ").append(i).append(": Power Surge");
            } else {
                result.append("Match ").append(i).append(": Normal");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int matches = scanner.nextInt();

        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {
            System.out.print("Enter number of overs for match " + i + ": ");
            int overs = scanner.nextInt();

            runsPerOver[i] = new int[overs];

            System.out.println("Enter runs:");
            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        System.out.println(classifyMatches(runsPerOver, threshold));

        scanner.close();
    }
}