在 C++ 中，`std::string` 是一个功能强大的字符串类，提供了许多方便的成员函数和操作方法。以下是一些常用的功能和方法：

---

### **1. 基本操作**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `size()` 或 `length()`   | 返回字符串的长度。                                                   |
| `empty()`                | 检查字符串是否为空，返回 `true` 或 `false`。                        |
| `clear()`                | 清空字符串内容。                                                    |
| `push_back(char)`        | 在字符串末尾添加一个字符。                                           |
| `pop_back()`             | 删除字符串末尾的一个字符。                                           |
| `append(str)`            | 在字符串末尾追加另一个字符串。                                       |
| `insert(pos, str)`       | 在指定位置插入字符串。                                               |
| `erase(pos, len)`        | 删除从指定位置开始的 `len` 个字符。                                  |
| `replace(pos, len, str)` | 替换从指定位置开始的 `len` 个字符为另一个字符串。                    |

---

### **2. 访问字符**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `operator[]`             | 通过索引访问字符（不进行边界检查）。                                 |
| `at(index)`              | 通过索引访问字符（进行边界检查）。                                   |
| `front()`                | 返回字符串的第一个字符。                                             |
| `back()`                 | 返回字符串的最后一个字符。                                           |

---

### **3. 查找与子串操作**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `find(str)`              | 查找子串 `str` 的第一个位置，找不到返回 `std::string::npos`。        |
| `rfind(str)`             | 从右向左查找子串 `str` 的第一个位置。                                |
| `substr(pos, len)`       | 返回从指定位置开始的子串，长度为 `len`。                             |
| `compare(str)`           | 比较两个字符串，返回负值、0 或正值（分别表示小于、等于、大于）。      |

---

### **4. 转换与修改**

| 方法                     | 描述                                                                 |
|--------------------------|----------------------------------------------------------------------|
| `c_str()`                | 返回一个指向 C 风格字符串的指针（`const char*`）。                   |
| `data()`                 | 返回底层字符数组的指针（与 `c_str()` 类似）。                        |
| `to_string(value)`       | 将数值类型转换为字符串（`std::to_string` 是全局函数）。              |

---

### **5. 遍历字符串**

可以使用范围 `for` 循环或索引遍历字符串：
```cpp
#include <iostream>
#include <string>
using namespace std;

int main() {
    string str = "hello";

    // 使用范围 for 遍历
    for (char c : str) {
        cout << c << " ";
    }
    cout << endl;

    // 使用索引遍历
    for (size_t i = 0; i < str.size(); ++i) {
        cout << str[i] << " ";
    }
    cout << endl;

    return 0;
}
```

输出：
```
h e l l o
h e l l o
```

---

### **6. 示例代码**

#### **1. 基本操作**
```cpp
#include <iostream>
#include <string>
using namespace std;

int main() {
    string str = "hello";

    // 添加字符和字符串
    str.push_back('!');
    str.append(" world");

    // 删除字符
    str.pop_back();

    // 插入和替换
    str.insert(5, ",");
    str.replace(6, 5, "C++");

    cout << str << endl; // 输出: hello,C++ world

    return 0;
}
```

---

#### **2. 查找与子串**
```cpp
#include <iostream>
#include <string>
using namespace std;

int main() {
    string str = "hello world";

    // 查找子串
    size_t pos = str.find("world");
    if (pos != string::npos) {
        cout << "'world' found at position: " << pos << endl;
    }

    // 提取子串
    string sub = str.substr(6, 5);
    cout << "Substring: " << sub << endl;

    return 0;
}
```

输出：
```
'world' found at position: 6
Substring: world
```

---

#### **3. 转换与拼接**
```cpp
#include <iostream>
#include <string>
using namespace std;

int main() {
    int num = 42;
    double pi = 3.14159;

    // 数值转字符串
    string strNum = to_string(num);
    string strPi = to_string(pi);

    // 拼接字符串
    string result = "Number: " + strNum + ", Pi: " + strPi;
    cout << result << endl;

    return 0;
}
```

输出：
```
Number: 42, Pi: 3.141590
```

---

### **7. 常见用法总结**

#### **统计字符频率**
```cpp
#include <iostream>
#include <string>
#include <map>
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

### **总结**
`std::string` 是一个功能强大的字符串类，常用功能包括：
1. **基本操作**：添加、删除、修改字符串。
2. **查找与子串**：查找子串、提取子串。
3. **转换与拼接**：数值与字符串的相互转换。
4. **遍历与统计**：遍历字符串、统计字符频率。

这些功能可以满足大多数字符串处理需求，结合 STL 算法可以进一步提高效率。