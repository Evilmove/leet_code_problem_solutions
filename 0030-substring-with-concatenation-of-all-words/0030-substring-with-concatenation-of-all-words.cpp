class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> ans;
        int m = words.size();  
        int n = s.size(); 
        int k = words[0].size();  
        int totalLen = m * k;  

        unordered_map<string, int> mp;
        for (auto it : words) mp[it]++;  
        for (int offset = 0; offset < k; offset++) {
            int left = offset, right = offset;  
            unordered_map<string, int> windowMap;  
            int count = 0;  

            while (right + k <= n) {
                
                string word = s.substr(right, k);
                right += k;  
                
                if (mp.find(word) != mp.end()) {
                    windowMap[word]++; 
                    count++;

                   
                    while (windowMap[word] > mp[word]) {
                        string leftWord = s.substr(left, k); 
                        windowMap[leftWord]--;  
                        left += k; 
                        count--;  
                    }

                    
                    if (count == m) {
                        ans.push_back(left);
                    }
                } else {
                    
                    windowMap.clear();
                    count = 0;
                    left = right;  
                }
            }
        }

        return ans;
    }
};