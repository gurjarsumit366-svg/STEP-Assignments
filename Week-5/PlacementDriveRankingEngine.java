import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    public String getName() {
        return name;
    }

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Borderline CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    public static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {

            boolean eligible;

            if (isEligible(candidate.cgpa)) {
                eligible = true;
            } else {
                eligible = isEligible(
                    candidate.cgpa,
                    candidate.codingScore
                );
            }

            if (eligible) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        // Ranking is handled completely by compareTo()
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].getName())
                  .append(" (")
                  .append(finalList[i].getCompositeScore())
                  .append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}