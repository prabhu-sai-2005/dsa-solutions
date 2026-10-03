/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    string serialize(TreeNode* root) {
        string ans;
        if (root == nullptr) {
            return ans;
        }

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            if (node) {
                ans.append(to_string(node->val) + ',');
            } else {
                ans.append("#,");
            }

            if (node) {
                q.push(node->left);
                q.push(node->right);
            }
        }

        return ans;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if (data.size() == 0) {
            return nullptr;
        }

        stringstream ss(data);
        string temp;
        getline(ss, temp, ',');

        TreeNode* root = new TreeNode(stoi(temp));

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();

            getline(ss, temp, ',');
            if (temp == "#") {
                node->left = nullptr;
            } else {
                TreeNode* newnode1 = new TreeNode(stoi(temp));
                node->left = newnode1;
                q.push(newnode1);
            }

            getline(ss, temp, ',');
            if (temp == "#") {
                node->right = nullptr;
            } else {
                TreeNode* newnode2 = new TreeNode(stoi(temp));
                node->right = newnode2;
                q.push(newnode2);
            }
        }

        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));