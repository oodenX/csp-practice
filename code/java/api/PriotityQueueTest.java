package api;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriotityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<String>((s1, s2) -> s1.length() - s2.length());
        pq.add("1");
        pq.add("123456");
        pq.add("123");
        pq.add("123456789");
        pq.add("1234567890");
        // 必须要这么才行
        PriorityQueue<String> pqCopy = new PriorityQueue<>(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
