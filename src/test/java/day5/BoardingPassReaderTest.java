package day5;

import org.junit.Test;

public class BoardingPassReaderTest {

    @Test
    public void checkIfReaderWorks(){
        BoardingPassReader boardingPassReader = new BoardingPassReader();
        String filename = "day5/boardingPasses";
        System.out.println(boardingPassReader.readBoardingPassesFromFile(filename));

    }
}