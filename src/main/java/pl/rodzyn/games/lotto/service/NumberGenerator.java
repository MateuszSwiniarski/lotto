package pl.rodzyn.games.lotto.service;

import pl.rodzyn.games.lotto.config.Config;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    Set<Integer> generateRandomNumbers() {
        Set<Integer> listOfGeneratedRandomNumber = new HashSet<>();
        SecureRandom random = new SecureRandom();
        while (listOfGeneratedRandomNumber.size() < Config.NUMBERS_TO_HIT){
            int generatedNumber = random.nextInt(Config.MAX_RANGE)+Config.MIN_RANGE;
            listOfGeneratedRandomNumber.add(generatedNumber);
        }
        return listOfGeneratedRandomNumber;
    }
}
