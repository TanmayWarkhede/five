import java.util.Scanner;

public class TraineeFitness {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] oxygenLevels = new int[3][3];
            boolean isValid = true;

            // Input oxygen levels for 3 trainees over 3 rounds
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int input = sc.nextInt();
                    // Check if input is within the valid range
                    if (input < 1 || input > 100) {
                        isValid = false;
                    }
                    oxygenLevels[i][j] = input;
                }
            }

            // If any oxygen level was invalid, print "INVALID INPUT" and exit
            if (!isValid) {
                System.out.println("INVALID INPUT");
                return;
            }

            // Calculate the average oxygen level for each trainee
            double[] avgOxygen = new double[3];
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += oxygenLevels[i][j];
                }
                avgOxygen[i] = Math.round(sum / 3.0);  // Calculate the rounded average
            }

            // Find the maximum average oxygen level
            double maxAvg = 0;
            for (double avg : avgOxygen) {
                if (avg > maxAvg) {
                    maxAvg = avg;
                }
            }

            // If all trainees are unfit, print the appropriate message
            if (maxAvg < 70) {
                System.out.println("All trainees are unfit");
            } else {
                // Print the trainee(s) with the highest average oxygen level
                for (int i = 0; i < 3; i++) {
                    if (avgOxygen[i] == maxAvg) {
                        System.out.println("Trainee Number : " + (i + 1));
                    }
                }
            }

            sc.close();
        }
    }
}
