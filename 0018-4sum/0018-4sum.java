class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
             if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                 if (j > i + 1  && nums[j] == nums[j- 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                int sum = nums[i] + nums[j];
                while (left < right) {
                    if (sum + nums[left] + nums[right] < target) {
                        left++;
                    } else if (sum + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        ansList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                }
            }
        }
        return ansList;
    }
}