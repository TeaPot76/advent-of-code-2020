package day5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoardingPassesTest {

    @Test
    public void checkSeat(){
        List<String> example = new ArrayList<>();
        String pass1 = "BFFFBBFRRR";
        String pass2 = "FFFBBBFRRR";
        String pass3 = "BBFFBBFRLL";
        example.add(pass1);
        example.add(pass2);
        example.add(pass3);
//
//        BFFFBBFRRR: row 70, column 7, seat ID 567.
//        FFFBBBFRRR: row 14, column 7, seat ID 119.
//        BBFFBBFRLL: row 102, column 4, seat ID 820.

        BoardingPasses boardingPasses = new BoardingPasses();

        Integer result1 = 567;
        Integer result2 = 119;
        Integer result3 = 820;

        assertEquals(result1, boardingPasses.findSeat(pass1));
        boardingPasses = new BoardingPasses();
        assertEquals(result2, boardingPasses.findSeat(pass2));
        boardingPasses = new BoardingPasses();
        assertEquals(result3, boardingPasses.findSeat(pass3));

    }

    @Test
    public void checkIfFindsTheHighestSeatId(){
        List<String> example = new ArrayList<>();
        String pass1 = "BFFFBBFRRR";
        String pass2 = "FFFBBBFRRR";
        String pass3 = "BBFFBBFRLL";
        example.add(pass1);
        example.add(pass2);
        example.add(pass3);
        System.out.println(example);
        BoardingPasses boardingPasses = new BoardingPasses();
        Integer result = 820;
        assertEquals(result, boardingPasses.checkEachBoardingPassForHighestSeatId(example));
        boardingPasses = new BoardingPasses();
        BoardingPassReader boardingPassReader = new BoardingPassReader();
        String fileName = "day5/boardingPasses";
        List<String> allPasses = boardingPassReader.readBoardingPassesFromFile(fileName);
        System.out.println(boardingPasses.checkEachBoardingPassForHighestSeatId(allPasses));
        boardingPasses = new BoardingPasses();
        System.out.println(boardingPasses.findMySeat(allPasses));
    }

}