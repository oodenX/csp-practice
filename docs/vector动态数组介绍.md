在 C++ 中，`std::vector` 是一个动态数组容器，提供了许多方便的成员函数和操作方法。以下是一些常用的 `std::vector` 方法及其用途：

---

### **1. 基本操作**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `push_back(value)`       | 在末尾添加一个元素。                                                 |
| `pop_back()`             | 删除末尾的元素。                                                    |
| `size()`                 | 返回当前元素的数量。                                                |
| `empty()`                | 检查容器是否为空，返回 `true` 或 `false`。                          |
| `clear()`                | 清空容器中的所有元素。                                              |
| `resize(n, value)`       | 调整容器大小为 `n`，可以指定新元素的默认值（可选）。                 |
| `assign(n, value)`       | 用 `n` 个值 `value` 替换当前容器中的所有元素。                      |
| `insert(pos, value)`     | 在指定位置插入一个元素。                                             |
| `erase(pos)`             | 删除指定位置的元素。                                                |
| `erase(start, end)`      | 删除指定范围内的元素（左闭右开区间）。                              |

---

### **2. 访问元素**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `operator[]`             | 通过索引访问元素（不进行边界检查）。                                 |
| `at(index)`              | 通过索引访问元素（进行边界检查）。                                   |
| `front()`                | 返回第一个元素。                                                    |
| `back()`                 | 返回最后一个元素。                                                  |
| `data()`                 | 返回指向底层数组的指针。                                            |

---

### **3. 容量相关**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `capacity()`             | 返回当前分配的存储容量（不一定等于 `size()`）。                     |
| `reserve(n)`             | 预留至少 `n` 个元素的存储空间，避免频繁分配内存。                   |
| `shrink_to_fit()`        | 减少容量以适应当前大小，释放多余的内存。                            |

---

### **4. 排序与算法**

`std::vector` 可以与 `<algorithm>` 中的算法配合使用，例如：
- `sort(vec.begin(), vec.end())`：对向量进行升序排序。
- `reverse(vec.begin(), vec.end())`：反转向量中的元素。
- `find(vec.begin(), vec.end(), value)`：查找元素，返回迭代器。
- `unique(vec.begin(), vec.end())`：去除相邻重复元素（需要先排序）。

---

### **示例代码**

#### **1. 基本操作**
```cpp
#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> vec;

    // 添加元素
    vec.push_back(10);
    vec.push_back(20);
    vec.push_back(30);

    // 访问元素
    cout << "First element: " << vec.front() << endl;
    cout << "Last element: " << vec.back() << endl;

    // 删除元素
    vec.pop_back();
    cout << "After pop_back, size: " << vec.size() << endl;

    // 遍历元素
    for (int val : vec) {
        cout << val << " ";
    }
    cout << endl;

    return 0;
}
```

输出：
```
First element: 10
Last element: 30
After pop_back, size: 2
10 20
```

---

#### **2. 排序与算法**
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> vec = {5, 2, 8, 6, 3};

    // 排序
    sort(vec.begin(), vec.end());
    cout << "Sorted: ";
    for (int val : vec) {
        cout << val << " ";
    }
    cout << endl;

    // 反转
    reverse(vec.begin(), vec.end());
    cout << "Reversed: ";
    for (int val : vec) {
        cout << val << " ";
    }
    cout << endl;

    return 0;
}
```

输出：
```
Sorted: 2 3 5 6 8
Reversed: 8 6 5 3 2
```

---

#### **3. 动态调整大小**
```cpp
#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> vec(5, 1); // 初始化 5 个元素，每个值为 1

    // 调整大小
    vec.resize(8, 2); // 扩展到 8 个元素，新元素值为 2
    vec.resize(3);    // 缩小到 3 个元素

    for (int val : vec) {
        cout << val << " ";
    }
    cout << endl;

    return 0;
}
```

输出：
```
1 1 1
```

---

### **总结**
`std::vector` 是 C++ 中最常用的容器之一，提供了灵活的动态数组功能。常见用法包括：
1. 动态添加和删除元素（`push_back`、`pop_back`）。
2. 随机访问元素（`operator[]`、`at`）。
3. 与 STL 算法配合使用（`sort`、`reverse` 等）。
4. 动态调整大小（`resize`、`reserve`）。

根据需求选择合适的方法，可以大大提高代码的效率和可读性。