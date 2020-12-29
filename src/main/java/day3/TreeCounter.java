package day3;

import java.util.ArrayList;
import java.util.List;

public class TreeCounter {
    private int xCurrentPosition = 0;
    private int yCurrentPosition = 0;

    public TreeCounter(int xCurrentPosition, int yCurrentPosition) {
        this.xCurrentPosition = xCurrentPosition;
        this.yCurrentPosition = yCurrentPosition;
    }

    public void moveTobogan(int xDistance, int yDistance, int maxWidth){
        xCurrentPosition = (xCurrentPosition + xDistance) % maxWidth;
        yCurrentPosition = yCurrentPosition + yDistance;

    }

    public int getxCurrentPosition() {
        return xCurrentPosition;
    }

    public int getyCurrentPosition() {
        return yCurrentPosition;
    }

//    public Integer numberOfTrees(List<String> input, int xdistance, int ydistance ) {
//        int counter = 0;
//            for (int i = 0; i<input.size()-1; i++) {
//                moveTobogan(xdistance, ydistance, input.get(0).length());
//                System.out.println(input.get(i));
//                if(input.get(yCurrentPosition).charAt(xCurrentPosition) == '#'){
//                    counter++;
//                }
//            }
//        return counter;
//    }

    public Integer numberOfTreesNew(List<String> input, int xdistance, int ydistance ) {
        int counter = 0;
        if(input.get(yCurrentPosition).charAt(xCurrentPosition) == '#') {
            counter++;
        }
        while(yCurrentPosition < input.size()-1) {
            moveTobogan(xdistance, ydistance, input.get(0).length());
            if(input.get(yCurrentPosition).charAt(xCurrentPosition) == '#'){
                counter++;
            }
        }
        return counter ;
    }


}
