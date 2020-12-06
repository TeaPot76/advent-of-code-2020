package day1;

import java.util.List;

public class ExpenseReport {

    public Integer resultDay1(List<Integer> integers) {
        for (Integer integer : integers) {
            for (Integer integer1 : integers) {
                if (integer + integer1 == 2020) {
                    return integer * integer1;
                }
            }
        }

        return 0;
    }
    public Integer result2Day1(List<Integer> integers) {
        for (Integer integer : integers) {
            for (Integer integer1 : integers) {
                for (Integer integer2 : integers) {
                    if (integer + integer1 + integer2 == 2020) {
                        return integer * integer1 * integer2;
                    }
                }
            }
        }


        return 0;
    }

}
