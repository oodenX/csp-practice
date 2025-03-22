`std::map` 和 `std::unordered_map` 都是 C++ 中的关联容器，用于存储键值对，但它们在实现、性能和使用场景上有显著区别。

---

### **主要区别**

| 特性                     | `std::map`                          | `std::unordered_map`               |
|--------------------------|--------------------------------------|-------------------------------------|
| **底层实现**             | 基于 **红黑树**（平衡二叉搜索树）。   | 基于 **哈希表**。                   |
| **键的顺序**             | 键按 **升序**（默认）或自定义顺序存储。| 键的存储顺序是 **无序的**。         |
| **查找/插入时间复杂度**  | **O(log n)**（树的高度）。            | **O(1)**（平均），**O(n)**（最坏）。|
| **内存使用**             | 较少的额外内存开销。                 | 需要额外的内存用于哈希表。          |
| **自定义排序**           | 支持通过比较函数自定义键的排序规则。   | 不支持排序，键是无序的。            |
| **适用场景**             | 需要有序数据或范围查询时使用。         | 需要快速查找、插入时使用。          |

---

### **详细对比**

#### 1. **底层实现**
- **`std::map`** 使用红黑树实现，键值对存储在树的节点中，按键的顺序排列。
- **`std::unordered_map`** 使用哈希表实现，键值对存储在哈希桶中，键的顺序是无序的。

#### 2. **键的顺序**
- **`std::map`** 会自动对键进行排序（默认升序）。如果需要自定义排序，可以通过比较函数实现。
- **`std::unordered_map`** 不保证键的顺序，键的排列完全取决于哈希函数。

#### 3. **查找和插入性能**
- **`std::map`** 的查找和插入操作的时间复杂度为 **O(log n)**，因为它需要在红黑树中查找或插入节点。
- **`std::unordered_map`** 的查找和插入操作的平均时间复杂度为 **O(1)**，但在哈希冲突严重时，最坏情况下可能退化为 **O(n)**。

#### 4. **内存使用**
- **`std::map`** 的内存开销较小，因为它只需要存储树的节点。
- **`std::unordered_map`** 需要额外的内存来维护哈希表和处理哈希冲突。

#### 5. **自定义排序**
- **`std::map`** 支持通过比较函数自定义键的排序规则。
- **`std::unordered_map`** 不支持排序，因为它的键是无序的。

---

### **使用场景**

#### 使用 `std::map` 的场景：
1. **需要有序数据**：例如按键的顺序遍历。
2. **范围查询**：例如查找键在某个范围内的所有元素。
3. **自定义排序**：需要按特定规则对键排序。

#### 使用 `std::unordered_map` 的场景：
1. **快速查找**：需要高效的键查找和插入操作。
2. **无序数据**：不关心键的顺序。
3. **内存不是主要限制**：可以接受额外的内存开销。

---

### **示例代码对比**

#### 使用 `std::map`：
```cpp
#include <iostream>
#include <map>
using namespace std;

int main() {
    map<int, string> myMap;

    myMap[3] = "three";
    myMap[1] = "one";
    myMap[2] = "two";

    // 按键的升序遍历
    for (const auto& pair : myMap) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```
输出：
```
1: one
2: two
3: three
```

#### 使用 `std::unordered_map`：
```cpp
#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    unordered_map<int, string> myUnorderedMap;

    myUnorderedMap[3] = "three";
    myUnorderedMap[1] = "one";
    myUnorderedMap[2] = "two";

    // 无序遍历
    for (const auto& pair : myUnorderedMap) {
        cout << pair.first << ": " << pair.second << endl;
    }

    return 0;
}
```
输出（顺序可能不同）：
```
3: three
1: one
2: two
```

---

### **总结**
- 如果需要 **有序数据** 或 **范围查询**，使用 `std::map`。
- 如果需要 **快速查找和插入**，使用 `std::unordered_map`。