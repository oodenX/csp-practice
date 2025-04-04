package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line.length() > 10) return;
        System.out.println(line.length());
        int[] nums = Arrays.
                stream(line.split(" ")).
                mapToInt(Integer::parseInt).
                toArray();
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
