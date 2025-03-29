#include <iostream>
#include <vector>
using namespace std;

class SegmentTree {
private:
    vector<int> tree; // 线段树数组
    vector<int> arr;  // 原数组
    int n;

    // 构建线段树
    void build(int node, int start, int end) {
        if (start == end) {
            // 叶子节点
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            // 递归构建左右子树
            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);

            // 当前节点的值为左右子节点的和
            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    // 区间查询
    int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            // 查询区间与当前节点区间无交集
            return 0;
        }
        if (l <= start && end <= r) {
            // 查询区间完全包含当前节点区间
            return tree[node];
        }

        // 查询区间与当前节点区间部分重合
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftSum = query(leftChild, start, mid, l, r);
        int rightSum = query(rightChild, mid + 1, end, l, r);

        return leftSum + rightSum;
    }

    // 单点更新
    void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            // 更新叶子节点
            arr[idx] = value;
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            if (idx <= mid) {
                // 更新左子树
                update(leftChild, start, mid, idx, value);
            } else {
                // 更新右子树
                update(rightChild, mid + 1, end, idx, value);
            }

            // 更新当前节点的值
            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

public:
    SegmentTree(const vector<int>& input) {
        arr = input;
        n = arr.size();
        tree.resize(4 * n); // 分配足够的空间
        build(0, 0, n - 1); // 构建线段树
    }

    int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }
};

int main() {
    vector<int> arr = {1, 3, 5, 7, 9, 11};
    SegmentTree segTree(arr);

    // 区间查询
    cout << "Sum of range [1, 3]: " << segTree.query(1, 3) << endl; // 输出: 15

    // 单点更新
    segTree.update(1, 10);
    cout << "After update, sum of range [1, 3]: " << segTree.query(1, 3) << endl; // 输出: 22

    return 0;
}