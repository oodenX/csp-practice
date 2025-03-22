是的，`std::pair` 和 `std::tuple` 的功能可以通过 **结构体** 来实现。它们的主要作用是将多个值组合在一起，而结构体也可以达到类似的效果。以下是对比和实现方式的说明：

---

### **1. 使用 `std::pair`**
`std::pair` 是一个模板类，用于存储两个值，类型可以不同。它的成员变量是 `first` 和 `second`。

#### 示例：
```cpp
#include <iostream>
#include <utility> // 包含 std::pair
using namespace std;

int main() {
    pair<int, string> p = {1, "apple"};

    cout << "First: " << p.first << ", Second: " << p.second << endl;

    return 0;
}
```

输出：
```
First: 1, Second: apple
```

#### 使用结构体替代：
```cpp
#include <iostream>
using namespace std;

// 定义结构体
struct Item {
    int id;
    string name;
};

int main() {
    Item item = {1, "apple"};

    cout << "ID: " << item.id << ", Name: " << item.name << endl;

    return 0;
}
```

输出：
```
ID: 1, Name: apple
```

---

### **2. 使用 `std::tuple`**
`std::tuple` 是一个模板类，可以存储多个值（不限数量），类型可以不同。它的成员变量通过 `std::get<index>()` 访问。

#### 示例：
```cpp
#include <iostream>
#include <tuple> // 包含 std::tuple
using namespace std;

int main() {
    tuple<int, string, double> t = {1, "apple", 3.14};

    cout << "First: " << get<0>(t) << ", Second: " << get<1>(t) << ", Third: " << get<2>(t) << endl;

    return 0;
}
```

输出：
```
First: 1, Second: apple, Third: 3.14
```

#### 使用结构体替代：
```cpp
#include <iostream>
using namespace std;

// 定义结构体
struct Item {
    int id;
    string name;
    double price;
};

int main() {
    Item item = {1, "apple", 3.14};

    cout << "ID: " << item.id << ", Name: " << item.name << ", Price: " << item.price << endl;

    return 0;
}
```

输出：
```
ID: 1, Name: apple, Price: 3.14
```

---

### **3. 对比：`pair` / `tuple` 与结构体**

| 特性                     | `std::pair` / `std::tuple`                | 结构体                              |
|--------------------------|-------------------------------------------|-------------------------------------|
| **灵活性**               | 可以动态定义类型和数量（`tuple` 支持多个）。| 需要手动定义字段和类型。            |
| **可读性**               | 字段名固定为 `first` / `second` 或通过索引访问，语义不明确。 | 字段名可以自定义，语义清晰。        |
| **性能**                 | 标准库实现，性能优化较好。                 | 性能类似，取决于具体实现。           |
| **适用场景**             | 临时组合少量值，快速实现。                 | 更适合复杂数据结构或需要语义化字段。 |

---

### **4. 什么时候用结构体替代？**
- **使用 `std::pair` 或 `std::tuple` 的场景**：
  - 数据结构简单，字段数量少（如 2-3 个）。
  - 不需要字段的语义化名称。
  - 临时使用，代码简洁优先。

- **使用结构体的场景**：
  - 数据结构复杂，字段数量多。
  - 需要字段的语义化名称，增强代码可读性。
  - 数据结构需要在多个地方复用。

---

### **5. 示例：复杂数据结构**
假设我们需要存储一个商品的详细信息，包括 ID、名称、价格和库存数量。

#### 使用 `std::tuple`：
```cpp
#include <iostream>
#include <tuple>
using namespace std;

int main() {
    tuple<int, string, double, int> product = {1, "apple", 3.14, 100};

    cout << "ID: " << get<0>(product) << ", Name: " << get<1>(product)
         << ", Price: " << get<2>(product) << ", Stock: " << get<3>(product) << endl;

    return 0;
}
```

#### 使用结构体：
```cpp
#include <iostream>
using namespace std;

// 定义结构体
struct Product {
    int id;
    string name;
    double price;
    int stock;
};

int main() {
    Product product = {1, "apple", 3.14, 100};

    cout << "ID: " << product.id << ", Name: " << product.name
         << ", Price: " << product.price << ", Stock: " << product.stock << endl;

    return 0;
}
```

**对比**：
- 使用 `std::tuple` 时，字段访问需要通过索引，语义不明确。
- 使用结构体时，字段名清晰，代码更具可读性。

---

### **总结**
- **`std::pair` 和 `std::tuple`** 是快速组合少量值的工具，适合临时使用。
- **结构体** 更适合复杂数据结构，尤其是需要语义化字段名称时。
- 根据场景选择合适的工具，代码可读性和简洁性是关键考虑因素。