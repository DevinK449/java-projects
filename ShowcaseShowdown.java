//Devin King
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class ShowcaseShowdown {
    static final int MAX_PRIZES = 100;
    static final int SHOWCASE_SIZE = 5;
    static String[] prizeNames = new String[MAX_PRIZES];
    static double[] prizePrices = new double[MAX_PRIZES];
    static int prizeCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Load prize data from file
        loadPrizesFromFile("prizes.txt");
        

        System.out.println("Welcome to the showcase show down!");

        boolean keepPlaying = true;

        while (keepPlaying) {
            // Pick 5 unique prizes
            int[] selectedIndexes = getUniqueRandomIndexes(SHOWCASE_SIZE, prizeCount);
            String[] selectedNames = new String[SHOWCASE_SIZE];
            double[] selectedPrices = new double[SHOWCASE_SIZE];
            double total = 0;

            System.out.println("Your prizes are:");
            for (int i = 0; i < SHOWCASE_SIZE; i++) {
                selectedNames[i] = prizeNames[selectedIndexes[i]];
                selectedPrices[i] = prizePrices[selectedIndexes[i]];
                System.out.println(selectedNames[i]);
                total += selectedPrices[i];
            }

            // Prompt for user guess
            System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
            System.out.print("Enter your guess\n");
            double guess = input.nextDouble();

            System.out.println("The actual cost was " + total);

            // Determine win or loss
            if (guess > total) {
                System.out.println("Your guess was over. You lose");
            } else if (guess >= total - 1300) {
                System.out.println("You win!!!");
            } else {
                System.out.println("Your guess was close, but not close enough. You lose.");
            }

            // Ask to quit
            System.out.println("Would you like to quit? Enter \"yes\" to quit");
            input.nextLine();
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                keepPlaying = false;
                System.out.println("Goodbye!");
            }
        }

        input.close();
    }

    // Loads prizes from a file into arrays
    public static void loadPrizesFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (!line.contains("\t")) {
                    continue; // skip messed up lines
                }

                String[] parts = line.split("\t");
                if (parts.length != 2) {
                    continue;
                }

                String name = parts[0].trim();
                try {
                    double price = Double.parseDouble(parts[1].trim());
                    if (prizeCount < MAX_PRIZES) {
                        prizeNames[prizeCount] = name;
                        prizePrices[prizeCount] = price;
                        prizeCount++;
                    }
                } catch (NumberFormatException e) {
                    // skip messed up price
                }
            }
            fileScanner.close();
        } catch (Exception e) {
           
        }
    }

    // Selects unique random prizes
    public static int[] getUniqueRandomIndexes(int howMany, int max) {
        Random rand = new Random();
        int[] result = new int[howMany];
        boolean[] used = new boolean[max];
        int count = 0;

        while (count < howMany) {
            int index = rand.nextInt(max);
            if (!used[index]) {
                used[index] = true;
                result[count] = index;
                count++;
            }
        }

        return result;
    }
}
