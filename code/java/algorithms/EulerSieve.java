package algorithms;

import java.util.ArrayList;
import java.util.List;

public class EulerSieve {

    public static List<Integer> findPrimes(int n) {
        // 存储找到的质数
        List<Integer> primes = new ArrayList<>();

        // 标记数组，默认都是false（未被标记为合数）
        boolean[] isComposite = new boolean[n + 1];

        // 0和1不是质数，先标记为合数
        isComposite[0] = isComposite[1] = true;

        // 从2开始遍历到n
        for (int i = 2; i <= n; i++) {
            // 如果i未被标记为合数，则i是质数
            if (!isComposite[i]) {
                primes.add(i);
            }

            // 用当前的i和已知质数筛选后续的合数
            for (int j = 0; j < primes.size() && i * primes.get(j) <= n; j++) {
                int prime = primes.get(j);
                // 标记合数
                isComposite[i * prime] = true;

                // 如果i能被当前质数整除，则终止循环
                // 这是欧拉筛法的关键：确保每个合数只被其最小质因子筛掉
                if (i % prime == 0) {
                    break;
                }
            }
        }

        return primes;
    }

    // 测试欧拉筛法
    public static void main(String[] args) {
        int n = 100;
        List<Integer> primes = findPrimes(n);

        System.out.println("1到" + n + "之间的质数有: ");
        System.out.println(primes);
        System.out.println("共" + primes.size() + "个质数");
    }
}