package day5;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardingPasses {


    int maxNumberRow = 127;
    int minNumberRow = 0;
    int seatNumber = 0;
    int newRowMaxNumber = 0;
    int minColumnNumber = 0;
    int maxColumnNumber = 7;


    public void checkSize(int size, char letter){
        if (size >2){
            updateRange(letter);
        }
    }

    public void updateRange(char letter) {
        if (letter == 'F'){
            maxNumberRow = maxNumberRow -(maxNumberRow -minNumberRow +1)/2;
        } else if (letter == 'B'){
            minNumberRow = minNumberRow + (maxNumberRow - minNumberRow +1)/2;
        }
    }

    public void updateColumn(char letter){
        if(letter == 'L' ){
            maxColumnNumber = maxColumnNumber - (maxColumnNumber - minColumnNumber + 1)/2;
        } else if(letter == 'R'){
            minColumnNumber = minColumnNumber + (maxColumnNumber - minColumnNumber + 1)/2;
        }
    }


    public Integer findSeat(String boardingPass) {

//        FBFBBFFRLR
//        Start by considering the whole range, rows 0 through 127.
//        F means to take the lower half, keeping rows 0 through 63.
//        B means to take the upper half, keeping rows 32 through 63.
//        F means to take the lower half, keeping rows 32 through 47.
//        B means to take the upper half, keeping rows 40 through 47.
//        B keeps rows 44 through 47.
//        F keeps rows 44 through 45.
//        The final F keeps the lower of the two, row 44.

//        For example, consider just the last 3 characters of FBFBBFFRLR:
//
//        Start by considering the whole range, columns 0 through 7.
//        R means to take the upper half, keeping columns 4 through 7.
//        L means to take the lower half, keeping columns 4 through 5.
//        The final R keeps the upper of the two, column 5.
//        So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.
//
//        Every seat also has a unique seat ID: multiply the row by 8,
//        then add the column. In this example, the seat has ID 44 * 8 + 5 = 357.
        for (char letter : boardingPass.toCharArray()) {
            if(letter == 'F' || letter == 'B') {
                updateRange(letter);
             }
            if (letter == 'L' || letter == 'R') {
            updateColumn(letter);
            }

            seatNumber = maxNumberRow * 8 + maxColumnNumber;
        }
        return seatNumber;
    }

    public Integer checkEachBoardingPassForHighestSeatId(List<String> boardingPasses){
        List<Integer> seats = new ArrayList<>();
        for (String boardingPass : boardingPasses){
            Integer seat = findSeat(boardingPass);

            if(seat >= 0){
                seats.add(seat);
            }
             this.maxNumberRow = 127;
             this.minNumberRow = 0;
             this.newRowMaxNumber = 0;
             this.minColumnNumber = 0;
             this.maxColumnNumber = 7;
             this.seatNumber = 0;


        }

        System.out.println(seats);

        return Collections.max(seats);
    }

    public Integer findMySeat(List<String> passes){
        List<Integer> allSeats = new ArrayList<>();
        for(String seatNumber : passes){
            Integer foundSeat = findSeat(seatNumber);
            allSeats.add(foundSeat);
            this.maxNumberRow = 127;
            this.minNumberRow = 0;
            this.newRowMaxNumber = 0;
            this.minColumnNumber = 0;
            this.maxColumnNumber = 7;
            this.seatNumber = 0;
        }
        Collections.sort(allSeats);
        System.out.println(allSeats);
        List<Integer> helperList = new ArrayList<>();
        for (int i =70; i <=826; i++){
            helperList.add(i);

        }
        System.out.println(helperList);
        helperList.removeAll(allSeats);
        allSeats.removeAll(helperList);

        System.out.println(allSeats);
        System.out.println(helperList);
        return helperList.get(0);

    }

}