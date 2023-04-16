package pl.rodzyn.games.lotto.input;

import pl.rodzyn.games.lotto.config.Config;
import pl.rodzyn.games.lotto.service.MessagePrinter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputNumber {

    MessagePrinter printer = new MessagePrinter();

    public Set<Integer> loadNumberFromUSer(Scanner scanner) {
        Set<Integer> listOfNumberProvidedByUser = loadUserNumber(scanner);
        scanner.close();
        return listOfNumberProvidedByUser;
    }

    private Set<Integer> loadUserNumber(Scanner scanner) {
        Set<Integer> generatedSet = new HashSet<>();
        printer.printText("Please provide 6 number from range 1 to 100");
        while (generatedSet.size() < Config.NUMBERS_TO_HIT) {
            printer.printText("Please give number: " + (generatedSet.size() + 1));
            try {
                while (!scanner.hasNext()) {
                    if (!scanner.hasNextInt()) {
                        return Collections.emptySet();
                    }
                }
                int readNumber = scanner.nextInt();
                if (isInRange(readNumber)) {
                    generatedSet.add(readNumber);
                }else {
                    printer.printText(readNumber + " is incorrect number, please enter number from 1 to 100");
                }
            } catch (Exception e) {
                printer.printText("It is not a number");
                scanner.nextLine();
            }
        }
        return generatedSet;
    }

    private boolean isInRange(int number){
        return number >= Config.MIN_RANGE && number <= Config.MAX_RANGE;
    }
}
