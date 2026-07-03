class Solution {
    public boolean check(int mid, int[] nums, int k) {
    if (mid == 0) return false;
    
    int count = 0;
    for (int num : nums) { 
        count += (num -1) /mid  ;
        
        if (count > k) return false;
    }
    return true;
}
    public int minimumSize(int[] nums, int k) {
        int left = 0 ;
        int right  = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            right = Math.max(right , nums[i]);
        }
        int indx = -1  ; 
        while(left <= right){
            int mid = (right - left)/2 + left ; 
            if(check(mid , nums , k)){
                indx = mid ; 
                right = mid - 1;  
            }else{
                left = mid + 1; 
            }
        }
        return indx ; 
        
    }
}
/**Perfect. Here's the Binary Search Cheat Sheet that you can revise in 2–3 minutes before interviews.

Step 1: What are you searching for?
A. Exact Element

Examples

Binary Search (LC 704)
Search in Rotated Array
Guess Number

Question:

"Does this value exist?"

Use

while(low <= high)

Reason:

When

low == high

there is still one unchecked element.

B. Boundary / Answer

Examples

Lower Bound
Upper Bound
Koko Eating Bananas
Ship Packages
Minimum Speed

Question:

"Find the first/last valid answer."

Use

while(low < high)

Reason:

When

low == high

both pointers already point to the answer.

Step 2: Can mid still be the answer?

This is the Golden Rule.

Ask yourself:

Can mid still be the answer?

❌ NO

Throw it away.

Move Right

low = mid + 1;

Move Left

high = mid - 1;
✅ YES

Keep it.

Searching for the first valid answer

high = mid;

Searching for the last valid answer

low = mid;

⚠️ Use

mid = low + (high - low + 1)/2;

to avoid an infinite loop.

Step 3: What do I return?
Exact Search
if(nums[mid] == target)
    return mid;

return -1;
First Valid Answer
return low;
Last Valid Answer
return low;

or

return high;

because

low == high

after the loop.

Three Binary Search Templates
1. Exact Search
while(low <= high){

    int mid = low + (high-low)/2;

    if(nums[mid] == target)
        return mid;

    else if(nums[mid] < target)
        low = mid + 1;

    else
        high = mid - 1;
}

return -1;
2. First Valid Answer (Lower Bound)
while(low < high){

    int mid = low + (high-low)/2;

    if(valid(mid))
        high = mid;
    else
        low = mid + 1;
}

return low;
3. Last Valid Answer (Upper Bound)
while(low < high){

    int mid = low + (high-low+1)/2;

    if(valid(mid))
        low = mid;
    else
        high = mid - 1;
}

return low;
Decision Tree
Binary Search
      │
      ▼
Am I searching for an exact value?
      │
 ┌────┴────┐
 │         │
YES        NO
 │         │
while      while
<=         <
 │         │
 │         ▼
 │     Is mid still
 │     a possible answer?
 │         │
 │    ┌────┴────┐
 │    │         │
 │   YES        NO
 │    │         │
 │ high=mid   low=mid+1
 │ low=mid    high=mid-1
 │
 ▼
return mid
One-Line Memory Rules
Rule 1

Exact Element

while(low <= high)

because one unchecked element may remain.

Rule 2

Boundary Search

while(low < high)

because when only one candidate remains, it is the answer.

Rule 3

If mid cannot be the answer

Discard it
low = mid + 1

or

high = mid - 1
Rule 4

If mid can still be the answer

Keep it
high = mid

or

low = mid
Rule 5

Return

Problem	Return
Exact Search	mid
First Valid	low
Last Valid	low or high
The 3 Questions to Ask Before Writing Any Binary Search
What am I searching for?
Exact value → while (low <= high)
Boundary/answer → while (low < high)
Can mid still be the answer?
No → discard it (mid ± 1)
Yes → keep it (high = mid or low = mid)
What should I return?
Exact value → mid
First valid → low
Last valid → low (or high)
⭐ The only thing you really need to remember

Every binary search problem can be solved by answering these two questions:

Am I looking for an exact value or a boundary?
Can mid still be the answer? */