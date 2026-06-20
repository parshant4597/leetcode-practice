class Solution {
    public boolean canChange(String start, String target) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        // target l should be in more left 
        // target r shoudl be in more or equal l ; 
        for(int i = 0 ; i < start.length() ; i++){
            if(start.charAt(i) != '_') qu1.offer(i);
        }
        for(int i = 0 ; i < target.length() ; i++){
            if(target.charAt(i) != '_') qu2.offer(i);
        }
        while(!qu1.isEmpty() && !qu2.isEmpty()){
            int top1 = qu1.poll();// start
            int top2 = qu2.poll();// target
            char s = start.charAt(top1);
            char t = target.charAt(top2);
            if(s == 'R'){
                if(t == 'L')return false ; 
                if(top2 < top1 )return false ; 
            }else{
                if(t== 'R')return false ; 
                if(top2 > top1)return false;
            }
        }
        if(!qu1.isEmpty())return false ; 
        if(!qu2.isEmpty())return false ; 
        return true ; 
    }
}
// class Solution {
//     public boolean canChange(String start, String target) {
//         int lastl = -1 ; 
//         int firstr = -1;
//         int countl = 0 ; 
//         for(int i =0 ; i < start.length()  ; i++){
//             if(start.charAt(i) == 'R' ){
//                 if(firstr == -1){
//                      firstr = i ; 
//                 }
//             }else if(start.charAt(i) == 'L'){
//                 lastl = i ; 
//                 countl++;
//             }
//         }
//         int lastlt = -1;
//         int firstrt = -1;
//         int countlt = 0; 
//         for(int i =0 ; i < target.length()  ; i++){
//             if(target.charAt(i) == 'R' ){
//                 if(firstrt == -1){
//                      firstrt = i ; 
//                 }
//             }else if(target.charAt(i) == 'L'){
//                 lastlt = i ; 
//                 countlt++;
//             }
//         }
//         if(lastlt > lastl ){
//             return false ; 
//         }
//         if(firstrt < firstr){
//             return false ; 
//         }
//         while(lastl)
        
//         return true ; 
//     }
// }
/**
String r1 = "";
        String r2 = "";
        for(int i = 0 ; i < start.length() ; i++){
            char ch = start.charAt(i);
            if(ch == 'R'){
                r1 += ch;
            }else if(ch == 'L'){
                r1 += ch ; 
            }
        }
        for(int i = 0 ; i < target.length() ; i++){
            char ch = target.charAt(i);
            if(ch == 'R'){
                r2 += ch;
            }else if(ch == 'L'){
                r2 += ch ; 
            }
        } */