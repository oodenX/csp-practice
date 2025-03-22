在 C++ 中，`std::map` 是一个关联容器，用于存储键值对（key-value pairs），并根据键自动排序。以下是 `std::map` 的常见用法：

---

### 1. **基本操作**
```cpp
#include <iostream>
#include <map>
using namespace std;

int main() {
    map<string, int> myMap;

    // 插入元素
    myMap["apple"] = 3;
    myMap["banana"] = 5;
    myMap["cherry"] = 2;

    // 访问元素
    cout << "apple: " << myMap["apple"] << endl;

    // 查找元素
    if (myMap.find("banana") != myMap.end()) {
        cout << "banana is in the map." << endl;
    }

    // 删除元素
    myMap.erase("cherry");

    // 遍历 map
    for (const auto& pair : myMap) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```

---

### 2. **常用方法**
| 方法                        | 描述                                                                 |
|-----------------------------|----------------------------------------------------------------------|
| `insert(pair<key, value>)`  | 插入键值对。如果键已存在，则不会插入。                                |
| `erase(key)`                | 删除指定键的元素。                                                   |
| `find(key)`                 | 返回指向键的迭代器。如果键不存在，则返回 `end()`。                   |
| `count(key)`                | 返回键的出现次数（对于 `map`，结果为 0 或 1）。                      |
| `size()`                    | 返回 `map` 中的元素数量。                                           |
| `clear()`                   | 清空 `map`。                                                        |
| `empty()`                   | 检查 `map` 是否为空。                                               |

---

### 3. **自动排序**
`std::map` 会根据键自动排序（默认升序）。如果需要自定义排序，可以使用比较函数：
```cpp
#include <iostream>
#include <map>
using namespace std;

// 自定义比较函数（降序）
struct Descending {
    bool operator()(const int& a, const int& b) const {
        return a > b;
    }
};

int main() {
    map<int, string, Descending> myMap;

    myMap[3] = "three";
    myMap[1] = "one";
    myMap[2] = "two";

    for (const auto& pair : myMap) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```

---

### 4. **使用 `map` 计数**
`std::map` 常用于统计字符或单词的频率：
```cpp
#include <iostream>
#include <map>
#include <string>
using namespace std;

int main() {
    string str = "hello world";
    map<char, int> freq;

    for (char c : str) {
        if (c != ' ') {
            freq[c]++;
        }
    }

    for (const auto& pair : freq) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```

输出：
```
d: 1
e: 1
h: 1
l: 3
o: 2
r: 1
w: 1
```

---

### 5. **多重映射（`std::multimap`）**
如果需要存储相同键的多个值，可以使用 `std::multimap`：
```cpp
#include <iostream>
#include <map>
using namespace std;

int main() {
    multimap<string, int> myMultiMap;

    myMultiMap.insert({"apple", 3});
    myMultiMap.insert({"apple", 5});
    myMultiMap.insert({"banana", 2});

    for (const auto& pair : myMultiMap) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```

输出：
```
apple: 3
apple: 5
banana: 2
```

---

### 总结
`std::map` 是一个功能强大的容器，适用于需要快速查找、插入和排序的场景。常见用法包括：
- 存储键值对。
- 自动排序。
- 统计频率。
- 自定义排序规则。

如果键不需要排序，可以使用 `std::unordered_map`，它的查找和插入操作的平均时间复杂度为 **O(1)**。