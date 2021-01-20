package day7;

import org.junit.Test;

import static org.junit.Assert.*;

public class BagRulesInputReaderTest {

    @Test
    public void checkIfInputReader(){
        String fileName = "day7/bagsRulesInput";
        BagRulesInputReader bagRulesInputReader = new BagRulesInputReader();
        System.out.println(bagRulesInputReader.readBagRulesInput(fileName));
    }

}