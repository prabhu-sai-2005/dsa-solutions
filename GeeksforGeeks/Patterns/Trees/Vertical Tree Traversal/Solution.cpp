class Solution {
  public:
    vector<vector<int>> verticalOrder(Node *root) {
        vector<vector<int>> ans;

        if (root == nullptr)
            return ans;

        // horizontal distance -> nodes
        map<int, vector<int>> mp;

        // node, horizontal distance
        queue<pair<Node*, int>> q;
        q.push({root, 0});

        while (!q.empty()) {
            auto [curr, hd] = q.front();
            q.pop();

            mp[hd].push_back(curr->data);

            if (curr->left)
                q.push({curr->left, hd - 1});

            if (curr->right)
                q.push({curr->right, hd + 1});
        }

        // map is automatically sorted by horizontal distance
        for (auto it : mp) {
            ans.push_back(it.second);
        }

        return ans;
    }
};