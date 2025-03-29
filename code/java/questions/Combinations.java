package questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 主函数
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine(), 10); // 总人数
        int m = Integer.parseInt(reader.readLine(), 10); // 选出的人数

        // 生成从 1 到 n 的数列
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // 存储结果
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // 调用递归函数
        generateCombinations(arr, m, 0, current, result);

        // 打印结果
        System.out.println("All combinations:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    // 递归生成组合
    private static void generateCombinations(int[] arr, int m, int start, List<Integer> current,
            List<List<Integer>> result) {
        // 如果当前组合的大小等于 m，加入结果集
        if (current.size() == m) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 遍历数组，从 start 开始
        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]); // 选择当前元素
            generateCombinations(arr, m, i + 1, current, result); // 递归选择下一个元素
            current.remove(current.size() - 1); // 回溯，移除最后一个元素
        }
    }
}