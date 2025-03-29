package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    static class Task implements Comparable<Task> {
        private int priority;

        public Task(int priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return -(this.priority - other.priority);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Arrays.fill(nums, Integer.MAX_VALUE);
        System.out.println(Arrays.toString(nums));
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(5));
        tasks.add(new Task(1));
        tasks.add(new Task(3));

        Collections.sort(tasks);

        for (Task task : tasks) {
            System.out.println(task.priority);
        }
    }
}