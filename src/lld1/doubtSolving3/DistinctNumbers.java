package lld1.doubtSolving3;

import java.util.List;
import java.util.stream.Collectors;

/*
Implement the getDistinctNumbers method inside the DistinctNumbers class
You need to use Java Streams and Lambdas for doing the operation.
Return the answer in the same order as they appear in the input.
Hint: use distinct()
 */
public class DistinctNumbers {
    public List<Integer> getDistinctNumbers(List<Integer> numbers){
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());

    }
}
