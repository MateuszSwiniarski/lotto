package pl.rodzyn.lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Lotto implements Game {
    public static Set<Integer> listOfGeneratedRandomNumber = new HashSet<>();
    public static Set<Integer> listOfNumberProvidedByUser = new HashSet<>();
    private final static int NUMBERS_TO_HIT = 6;
    private MessagePrinter writer = new MessagePrinter();


    public void start() {
        listOfGeneratedRandomNumber = generateRandomNumber(NUMBERS_TO_HIT);
        listOfNumberProvidedByUser = provideNumberByUser(NUMBERS_TO_HIT);

        checkHowManyNumberHit();
        listOfNumberProvidedByUser.retainAll(listOfGeneratedRandomNumber);
    }

    private void checkHowManyNumberHit() {
        writer.formatString("Drawn numbers: ");
        printNumberFromList(listOfGeneratedRandomNumber);

        writer.formatString("Entered numbers by User: ");
        printNumberFromList(listOfNumberProvidedByUser);

        int size = checkHitNumber();
        writer.printMessage(size);

    }

    private void printNumberFromList(Set<Integer> list){
        for (Integer integer : listOfGeneratedRandomNumber) {
            writer.formatInteger(integer);
        }
        System.out.println();
    }

    private int checkHitNumber() {
        listOfNumberProvidedByUser.retainAll(listOfGeneratedRandomNumber);
        return listOfNumberProvidedByUser.size();
    }

    private Set<Integer> provideNumberByUser(int numberOfNumberToHit) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        int readNumber;
        writer.printText("Please provide 6 number from range 1 to 100");
        while (counter != numberOfNumberToHit){
            try {
                readNumber = Integer.parseInt(reader.readLine());
                if(readNumber >0 && readNumber < 101) {
                    if(!listOfNumberProvidedByUser.contains(readNumber)) {
                        listOfNumberProvidedByUser.add(readNumber);
                        counter++;
                    }
                }else {
                    System.out.print(readNumber);
                    writer.printText(" is incorrect number, please enter number from 1 to 100");
                }
            } catch (NumberFormatException | IOException e) {
                writer.printText("It is not a number");
            }
        }
        return listOfNumberProvidedByUser;
    }

    private Set<Integer> generateRandomNumber(int numberOfNumberToHit) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < NUMBERS_TO_HIT; i++) {
            int generatedNumber = random.nextInt(100)+1;
            if(listOfGeneratedRandomNumber.contains(generatedNumber)){
                i--;
            }
            listOfGeneratedRandomNumber.add(generatedNumber);
        }
        return listOfGeneratedRandomNumber;
    }
}
