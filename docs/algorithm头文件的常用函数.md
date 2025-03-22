C++ 的 `<algorithm>` 头文件提供了许多常用的算法函数，用于操作容器（如 `vector`、`array` 等）或普通数组。这些函数可以极大地简化代码，提高开发效率。以下是一些常用的函数及其用途：

---

### **1. 排序相关**

#### **`sort`**
- 用于对范围内的元素进行升序排序（默认）。
- 可以通过自定义比较函数实现降序或其他排序规则。

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> vec = {5, 2, 8, 6, 3};

    // 升序排序
    sort(vec.begin(), vec.end());
    for (int val : vec) cout << val << " "; // 输出: 2 3 5 6 8
    cout << endl;

    // 降序排序
    sort(vec.begin(), vec.end(), greater<int>());
    for (int val : vec) cout << val << " "; // 输出: 8 6 5 3 2
    cout << endl;

    return 0;
}
```

---

#### **`stable_sort`**
- 与 `sort` 类似，但保持相等元素的相对顺序。

---

#### **`partial_sort`**
- 对部分元素排序，仅保证前 `k` 个元素有序。

```cpp
partial_sort(vec.begin(), vec.begin() + k, vec.end());
```

---

### **2. 查找相关**

#### **`find`**
- 用于查找范围内的第一个等于指定值的元素，返回迭代器。

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> vec = {5, 2, 8, 6, 3};

    auto it = find(vec.begin(), vec.end(), 8);
    if (it != vec.end()) {
        cout << "Found: " << *it << endl; // 输出: Found: 8
    } else {
        cout << "Not found" << endl;
    }

    return 0;
}
```

---

#### **`binary_search`**
- 用于检查范围内是否存在某个值（前提是范围已排序）。

```cpp
sort(vec.begin(), vec.end());
if (binary_search(vec.begin(), vec.end(), 6)) {
    cout << "6 is in the vector" << endl;
}
```

---

#### **`lower_bound` / `upper_bound`**
- **`lower_bound`**：返回第一个大于等于指定值的迭代器。
- **`upper_bound`**：返回第一个大于指定值的迭代器。

```cpp
auto lb = lower_bound(vec.begin(), vec.end(), 6);
auto ub = upper_bound(vec.begin(), vec.end(), 6);
```

---

### **3. 修改容器**

#### **`reverse`**
- 反转范围内的元素。

```cpp
reverse(vec.begin(), vec.end());
```

---

#### **`rotate`**
- 将范围内的元素旋转，使某个元素成为新的起点。

```cpp
rotate(vec.begin(), vec.begin() + 2, vec.end());
```

---

#### **`unique`**
- 移除相邻重复元素（需要先排序），返回新范围的结束迭代器。

```cpp
vec.erase(unique(vec.begin(), vec.end()), vec.end());
```

---

### **4. 数学相关**

#### **`accumulate`**
- 计算范围内元素的累加和（需要包含 `<numeric>` 头文件）。

```cpp
#include <numeric>
int sum = accumulate(vec.begin(), vec.end(), 0);
```

---

#### **`max_element` / `min_element`**
- 返回范围内的最大值或最小值的迭代器。

```cpp
auto maxIt = max_element(vec.begin(), vec.end());
auto minIt = min_element(vec.begin(), vec.end());
```

---

#### **`iota`**
- 用于生成连续递增的值。

```cpp
#include <numeric>
vector<int> vec(5);
iota(vec.begin(), vec.end(), 1); // vec = {1, 2, 3, 4, 5}
```

---

### **5. 集合操作**

#### **`set_union`**
- 计算两个有序范围的并集。

#### **`set_intersection`**
- 计算两个有序范围的交集。

#### **`set_difference`**
- 计算两个有序范围的差集。

```cpp
vector<int> result;
set_union(vec1.begin(), vec1.end(), vec2.begin(), vec2.end(), back_inserter(result));
```

---

### **6. 其他常用函数**

#### **`fill`**
- 用指定值填充范围。

```cpp
fill(vec.begin(), vec.end(), 0);
```

---

#### **`replace`**
- 将范围内的某个值替换为另一个值。

```cpp
replace(vec.begin(), vec.end(), oldValue, newValue);
```

---

#### **`shuffle`**
- 随机打乱范围内的元素（需要 `<random>` 头文件）。

```cpp
#include <random>
shuffle(vec.begin(), vec.end(), default_random_engine());
```

---

### **总结**
C++ 的 `<algorithm>` 提供了丰富的函数，常见的功能包括：
1. **排序**：`sort`、`stable_sort`、`partial_sort`。
2. **查找**：`find`、`binary_search`、`lower_bound`。
3. **修改**：`reverse`、`rotate`、`unique`。
4. **数学**：`accumulate`、`max_element`、`min_element`。
5. **集合操作**：`set_union`、`set_intersection`。

这些函数可以与 STL 容器（如 `vector`、`list` 等）配合使用，大大提高代码的简洁性和效率。