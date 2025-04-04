import java.util.*;

public class B {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            List<Integer> nums = new ArrayList<>();
            nums.add(Integer.parseInt(s.substring(0, 1)));
            nums.add(Integer.parseInt(s.substring(2, 3)));
            nums.add(Integer.parseInt(s.substring(4, 5)));
            nums.add(Integer.parseInt(s.substring(6, 7)));
            List<Character> ops = new ArrayList<>();
            ops.add(s.charAt(1));
            ops.add(s.charAt(3));
            ops.add(s.charAt(5));

            for (int j = 0; j < ops.size(); j++) {
                if (ops.get(j) == 'x') {
                    int num = nums.get(j) * nums.get(j + 1);
                    nums.set(j, num);
                    nums.remove(j + 1);
                    ops.remove(j);
                    j--;
                }
            }

            for (int j = 0; j < ops.size(); j++) {
                if (ops.get(j) == '/') {
                    int num = nums.get(j) / nums.get(j + 1);
                    nums.set(j, num);
                    nums.remove(j + 1);
                    ops.remove(j);
                    j--;
                }
            }
            while (!ops.isEmpty()) {
                if (ops.get(0) == '+') {
                    int num = nums.get(0) + nums.get(1);
                    nums.set(0, num);
                    nums.remove(1);
                    ops.remove(0);
                }
                else if (ops.get(0) == '-') {
                    int num = nums.get(0) - nums.get(1);
                    nums.set(0, num);
                    nums.remove(1);
                    ops.remove(0);
                }
            }
            if (nums.get(0) == 24) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}
