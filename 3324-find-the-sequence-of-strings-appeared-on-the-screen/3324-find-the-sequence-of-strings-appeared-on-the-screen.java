// class Solution {
//     public List<String> stringSequence(String target) {
//         List<String> ans = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 0 ; i < target.length() ; i++){
//             char ch = target.charAt(i);
//             char ch2 = 'a';
//             ans.add(sb.toString()+ch2);
//             while(ch2 != ch){
//                 ch2 += 1;
//                 ans.add(sb.toString() + ch2);
            
//             sb.append(ch);
//         }
//         return ans ; 

//     }
// }
class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i); 
            for (char ch2 = 'a'; ch2 <= ch; ch2++) {
                sb.append(ch2);
                ans.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);  
            } 
            sb.append(ch);
        }
        return ans;
    }
}