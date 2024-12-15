import java.util.*;

class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) ->
            Double.compare(b[0], a[0])
        );

        for (int[] singleClass : classes) {
            int passes = singleClass[0];
            int totalStudents = singleClass[1];
            double gain = calculateGain(passes, totalStudents);
            maxHeap.offer(new double[] { gain, passes, totalStudents });
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(
                new double[] {
                    calculateGain(passes + 1, totalStudents + 1),
                    passes + 1,
                    totalStudents + 1,
                }
            );
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }

    private double calculateGain(int passes, int totalStudents) {
        return (
            (double) (passes + 1) / (totalStudents + 1) -
            (double) passes / totalStudents
        );
    }
}

public class Main {
    public static void main(String[] args) {
        // Example input: Classes with [passes, total students] and extra students
        int[][] classes = {
            {1, 2},
            {3, 5},
            {2, 2}
        };
        int extraStudents = 2;

        Solution solution = new Solution();

        double result = solution.maxAverageRatio(classes, extraStudents);
        System.out.println("Maximum average pass ratio: " + result);
    }
}





=== Code Output ===
Maximum average pass ratio: 0.7833333333333333

=== Code Execution Successful ===
