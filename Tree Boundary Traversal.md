## 01. Tree Boundary Traversal

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1)

### Problem Description

**Task:** Given a root of a Binary Tree, return its boundary traversal in the following order:
Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.
Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.
Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

> **Note:** The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

#### Examples

##### Example 1

- **Input:**
```text
root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
```
- **Output:**
```text
[1, 2, 4, 8, 9, 6, 7, 3]
```

##### Example 2

- **Input:**
```text
root = [1, N, 2, N, 3, N, 4, N, N]
```
- **Output:**
```text
[1, 4, 3, 2]
```
- **Explanation:** Left boundary: [1] (as there is no left subtree) Leaf nodes: [4] Right boundary: [3, 2] (in reverse order) Final traversal: [1, 4, 3, 2]

#### Constraints

- **1.** `1 ≤ number of nodes ≤ 10⁵¹ ≤ node- > data ≤ 10⁵`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(h)

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2026-09-26 18:11:23
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:

    bool isLeaf(Node* node) {
        return node && node->left == nullptr && node->right == nullptr;
    }

    void addLeftBoundary(Node* root, vector<int>& ans) {
        Node* curr = root->left;

        while (curr) {
            if (!isLeaf(curr))
                ans.push_back(curr->data);

            if (curr->left)
                curr = curr->left;
            else
                curr = curr->right;
        }
    }

    void addLeaves(Node* root, vector<int>& ans) {
        if (root == nullptr)
            return;

        if (isLeaf(root)) {
            ans.push_back(root->data);
            return;
        }

        addLeaves(root->left, ans);
        addLeaves(root->right, ans);
    }

    void addRightBoundary(Node* root, vector<int>& ans) {
        Node* curr = root->right;
        vector<int> temp;

        while (curr) {
            if (!isLeaf(curr))
                temp.push_back(curr->data);

            if (curr->right)
                curr = curr->right;
            else
                curr = curr->left;
        }

        reverse(temp.begin(), temp.end());

        for (int x : temp)
            ans.push_back(x);
    }

    vector<int> boundaryTraversal(Node *root) {
        vector<int> ans;

        if (root == nullptr)
            return ans;

        // Root
        if (!isLeaf(root))
            ans.push_back(root->data);

        // Left boundary
        addLeftBoundary(root, ans);

        // All leaf nodes
        addLeaves(root, ans);

        // Right boundary in reverse
        addRightBoundary(root, ans);

        return ans;
    }
};
```

*Generated on: 9/26/2026, 6:12:54 PM*