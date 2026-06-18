class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int c = 0;
        while (right < s.length() && left < s.length()) {
            if (c == 0) {// reverse 
                int count = k;
                while (count-- > 0 && right < s.length()) {
                    right++;
                }

                int end = Math.min(s.length(), right );
                sb.append(new StringBuilder().append(s, left, end).reverse());
                c  = 1 ; 
            } else {// add simply ; 
                int count = k;
                while (count-- > 0 && right < s.length()) {
                    sb.append(s.charAt(right));
                    right++;
                }
                c = 0 ; 
            }
            left = right ;
        }
        return sb.toString();
    }
}