# 📝 Tree Boundary Traversal (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Tree

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Given a root of a Binary Tree, return its boundary traversal in the following order:

1. Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

2. Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

3. Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

**Note:**  The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

**Examples:**

```
Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

```

```
Input: root = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
```

**Constraints:** 
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105