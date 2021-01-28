package day7;

import org.junit.Test;

import java.util.List;

public class BagRulesInputReaderTest {

    @Test
    public void checkIfInputReader(){
        String fileName = "day7/bagsRulesInput";
        BagRulesInputReader bagRulesInputReader = new BagRulesInputReader();
        List<String> allRules = bagRulesInputReader.readBagRulesInput(fileName);
        System.out.println(allRules.get(0));
        System.out.println(allRules.get(1));
    }

}