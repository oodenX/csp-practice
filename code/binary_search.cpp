#include <iostream>
#include <vector>

using namespace std;

// 二分查找函数
int binarySearch(const vector<int>& arr, int target) {
    int left = 0, right = arr.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // 防止溢出

        if (arr[mid] == target) {
            return mid; // 找到目标值，返回索引
        } else if (arr[mid] < target) {
            left = mid + 1; // 在右半部分查找
        } else {
            right = mid - 1; // 在左半部分查找
        }
    }

    return -1; // 未找到目标值
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);
    // 示例有序数组
    vector<int> arr = {1, 3, 5, 7, 9, 11, 13, 15};

    int target = 7;
    int result = binarySearch(arr, target);

    if (result != -1) {
        cout << "Target " << target << " found at index " << result << endl;
    } else {
        cout << "Target " << target << " not found in the array." << endl;
    }

    return 0;
}