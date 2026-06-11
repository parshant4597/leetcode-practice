 
class Solution {
    public boolean solve(int x, int y, int indx, String word, char[][] board, boolean[][] vis) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || vis[x][y]) {
            return false;
        }
        char ch = word.charAt(indx);
        char bch = board[x][y];
        if (indx < word.length() - 1) {
            if (ch != bch) {
                return false;
            }
        }
        if (indx == word.length() - 1) {
            if (ch == bch) {
                return true;
            } else
                return false;
        }

        vis[x][y] = true;

        boolean ans = solve(x + 1, y, indx + 1, word, board, vis) ||
                solve(x - 1, y, indx + 1, word, board, vis) ||
                solve(x, y + 1, indx + 1, word, board, vis) ||
                solve(x, y - 1, indx + 1, word, board, vis);

        vis[x][y] = false;

        return ans;
    }

    public boolean exist(char[][] board, String word) {
      
        boolean[] ans = new boolean[1];
         
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (solve(i, j, 0, word , board, new boolean[board.length][board[0].length])) {
                            ans[0] = true;
                            break;
                        }
                    }
                }
                if (ans[0]) {
                    break;
                }
            }
      
        if(ans[0]){
            return true ; 
        }
        return false;
    }
}