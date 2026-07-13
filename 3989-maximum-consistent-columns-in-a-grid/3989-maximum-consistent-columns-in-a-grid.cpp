class Solution {
public:
/*
so do a dp wherin dp[j] denotes the max possible columns if the last col is j

*/
vector<vector<int>>dp1;
vector<int>dp2;
bool valid(vector<vector<int>>& arr,int limit,  int a, int b){
    int rows=arr.size();
    bool ans=true;
    if(dp1[a][b]!=-1)return dp1[a][b];
    for(int i=0;i<rows;i++){
        if(abs(arr[i][b]-arr[i][a])>limit){
            ans=false;
            break;
        }
    }

    return dp1[a][b]=ans;
    
}
    
    int maxConsistentColumns(vector<vector<int>>& arr, int limit) {
        int rows=arr.size();
        int cols=arr[0].size();
        dp1.resize(cols,vector<int>(cols,-1));   
        dp2.resize(cols,1);
        
        
        for(int i=0;i<cols;i++){
            int prevmax=0;
            for(int j=cols-1;j>=0;j--){
                if(valid(arr,limit,j,i)){
                    prevmax=max(prevmax,dp2[j]);
                }
            }
            dp2[i]+=prevmax;
        }
        int ans=0;
        for(int i=0;i<cols;i++)ans=max(ans,dp2[i]);
        return ans-1;
    }
};













