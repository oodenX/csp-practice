package api;

import java.util.PriorityQueue;

public class TestScores {
    static class Score implements Comparable<Score> {
        private int chinese;
        private int math;
        private int english;

        public Score(int ch, int m, int en) {
            this.chinese = ch;
            this.math = m;
            this.english = en;
        }

        @Override
        public int compareTo(Score other) {
            double average1 = (this.chinese + this.math + this.english) / 3.0;
            double average2 = (other.chinese + other.math + other.english) / 3.0;
            return Double.compare(average1, average2);
        }

        @Override
        public String toString() {
            return "Score{" +
                    "chinese=" + chinese +
                    ", math=" + math +
                    ", english=" + english +
                    '}';
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Score> pq = new PriorityQueue<>();
        pq.add(new Score(1, 2, 3));
        pq.add(new Score(2, 3, 4));
        pq.add(new Score(3, 4, 5));
        pq.add(new Score(4, 5, 6));
        pq.add(new Score(5, 6, 7));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().toString());
        }

    }

}
