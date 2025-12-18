import java.util.List;

public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A, B, C, A.size());
    }

    public void dfs(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            // 当只有一个盘子，直接将其从初始柱子转移到目标柱子
            C.add(A.remove(A.size() - 1));
            return;
        }

        // 要想将所有盘子从初始柱子转移到目标柱子，得先把最后一个盘子上面的所有盘子先转移到中间柱子上面
        dfs(A, C, B, n - 1);
        // 然后把最后一个盘子从初始柱子转移到目标柱子
        C.add(A.remove(A.size() - 1));
        // 接着将剩余的盘子从中间柱子转移到目标柱子
        dfs(B, A, C, n - 1);
    }
}
