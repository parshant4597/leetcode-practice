class Solution {
    public boolean backspaceCompare(String s, String t) {

        String ress = "";
        String rest = "";

        ArrayList<Integer> txtindx = new ArrayList<>();
        ArrayList<Integer> hashindx = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#')
                hashindx.add(i);
            else
                txtindx.add(i);
        }

        int left = txtindx.size() - 1;
        int right = hashindx.size() - 1;

        while(right >= 0 && left >= 0){
            while(left >= 0 && txtindx.get(left) > hashindx.get(right)){
                left--;
            }

            if(left >= 0){
                txtindx.set(left, Integer.MAX_VALUE);
                left--;
            }

            right--;
        }

        for(int i = 0; i < txtindx.size(); i++){
            if(txtindx.get(i) != Integer.MAX_VALUE){
                ress += s.charAt(txtindx.get(i));
            }
        }

        ArrayList<Integer> txtindxt = new ArrayList<>();
        ArrayList<Integer> hashindxt = new ArrayList<>();

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#')
                hashindxt.add(i);
            else
                txtindxt.add(i);
        }

        left = txtindxt.size() - 1;
        right = hashindxt.size() - 1;

        while(right >= 0 && left >= 0){
            while(left >= 0 && txtindxt.get(left) > hashindxt.get(right)){
                left--;
            }

            if(left >= 0){
                txtindxt.set(left, Integer.MAX_VALUE);
                left--;
            }

            right--;
        }

        for(int i = 0; i < txtindxt.size(); i++){
            if(txtindxt.get(i) != Integer.MAX_VALUE){
                rest += t.charAt(txtindxt.get(i));
            }
        }

        return ress.equals(rest);
    }
}