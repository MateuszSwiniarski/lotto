package pl.rodzyn.lotto.model;

import lombok.Data;

import java.util.Set;

@Data
public class Lotto {
    private Set<Integer> listOfGeneratedRandomNumber;
    private Set<Integer> listOfNumberProvidedByUser;
}
