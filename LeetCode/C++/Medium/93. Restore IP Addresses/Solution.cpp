class Solution
{
public:
    bool is_valid(string ts)
    {
        if (ts[0] == '0' && ts.size() > 1)
            return false;

        if (ts.size() > 3)
            return false;

        if (stoi(ts) > 255)
            return false;

        return true;
    }
    void func(int idx, int dots_used, string &temp, vector<string> &fans, string &s, int n)
    {

        if (dots_used >= 4)
        {
            if (idx >= n)
            {
                string temp2 = temp;
                temp2.pop_back(); // remove last '.'
                fans.push_back(temp2);
            }
            return;
        }

        for (int i = idx; i < n; i++)
        {
            if (i > idx && s[idx] == '0')
                break;

            if (is_valid(s.substr(idx, (i - idx + 1))))
            {
                string part = s.substr(idx, i - idx + 1);

                temp.append(part);
                temp += '.';
                func(i + 1, dots_used + 1, temp, fans, s, n);
                temp.pop_back();
                temp.erase(temp.size() - part.size());
            }
        }
    }
    vector<string> restoreIpAddresses(string s)
    {
        int n = s.size();
        string temp;
        vector<string> fans;

        func(0, 0, temp, fans, s, n);
        return fans;
    }
};