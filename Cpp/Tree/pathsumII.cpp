/**
 * Definition for a binary tree node.
 * 
 */
#include <vector>   
using namespace std; 

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> results;

    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> path;
        pathSumDfs(root, sum, path);
        return results;
    }

    void pathSumDfs(TreeNode *currentNode, int currentSum, vector<int> &currentVals) {
        if (!currentNode) return;

        currentVals.push_back(currentNode->val);
        if (!currentNode->left && !currentNode->right && currentNode->val == currentSum) {
            results.push_back(currentVals);
        } else {
            pathSumDfs(currentNode->left, currentSum - currentNode->val, currentVals);
            pathSumDfs(currentNode->right, currentSum - currentNode->val, currentVals);
        }

        currentVals.pop_back();
    }
};