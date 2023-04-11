package pl.rodzyn.lotto;

import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

@Data
public class NumberGenerator {
    MessagePrinter writer = new MessagePrinter();

    public Set<Integer> provideNumberByUser(int numberOfNumberToHit) {
        Set<Integer> listOfNumberProvidedByUser = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        int readNumber;
        getWriter().printText("Please provide 6 number from range 1 to 100");
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
                    getWriter().printText(" is incorrect number, please enter number from 1 to 100");
                }
            } catch (NumberFormatException | IOException e) {
                getWriter().printText("It is not a number");
            }
        }
        return listOfNumberProvidedByUser;
    }

    public Set<Integer> generateRandomNumbers(int numberToHit) {
        Set<Integer> listOfGeneratedRandomNumber = new HashSet<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < numberToHit; i++) {
            int generatedNumber = random.nextInt(100)+1;
            if(listOfGeneratedRandomNumber.contains(generatedNumber)){
                i--;
            }
            listOfGeneratedRandomNumber.add(generatedNumber);
        }
        return listOfGeneratedRandomNumber;
    }
}
