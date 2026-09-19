
import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyLeagueAutoDraftRankingEngine(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    boolean isPlayerDraftable() {
        return isDraftable(matchesPlayed) || isDraftable(matchesPlayed, injured);
    }

    @Override
    public int compareTo(FantasyLeagueAutoDraftRankingEngine other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(FantasyLeagueAutoDraftRankingEngine[] players) {
        int count = 0;

        for (FantasyLeagueAutoDraftRankingEngine player : players) {
            if (player.isPlayerDraftable()) {
                count++;
            }
        }

        FantasyLeagueAutoDraftRankingEngine[] draftable =
                new FantasyLeagueAutoDraftRankingEngine[count];

        int index = 0;

        for (FantasyLeagueAutoDraftRankingEngine player : players) {
            if (player.isPlayerDraftable()) {
                draftable[index++] = player;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FantasyLeagueAutoDraftRankingEngine[] players = {
            new FantasyLeagueAutoDraftRankingEngine("Virat", 15, 48.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Rahul", 7, 55.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Sameer", 3, 60.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}javac Week-5\Player.java