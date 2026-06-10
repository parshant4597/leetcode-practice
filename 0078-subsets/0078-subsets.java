 class Solution {
//binary subset
// 000	 []
// 001	 [nums[0]]
// 010	 [nums[1]]
// 011	 [nums[0], nums[1]] 
// best approach and best usecase of binary seen so far
    public List<List<Integer>> subsets(int[] nums) { 
        int n = nums.length; 
        List<List<Integer>> ans = new ArrayList<>();
        int count = (1 << n); 
        for (int val = 0; val < count; val++) { 
            List<Integer> subset = new ArrayList<>(); 
            for (int i = 0; i < n; i++) {
                if ((val & (1 << i)) != 0 ) {
                    subset.add(nums[i]);
                }
            } 
            ans.add(subset);
        }
        return ans;
    }
}
/**
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(nums, 0, res, subset);
        return res;        
    }

    private void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubset(nums, index + 1, res, subset);

        subset.remove(subset.size() - 1);
        createSubset(nums, index + 1, res, subset);
    }    
} */