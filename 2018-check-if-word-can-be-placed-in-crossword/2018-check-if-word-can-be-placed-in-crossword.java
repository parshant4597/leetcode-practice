class Solution {
    public boolean left(int x, int y, int indx, String word, char[][] board) {
        if (indx == word.length()) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return true;
            }
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (indx < word.length()) {
            if (board[x][y] == '#') {
                return false;
            }
            if (board[x][y] != word.charAt(indx) && board[x][y] != ' ') {
                return false;
            }
        }
        if (indx >= word.length()) {
            if (board[x][y] != '#') {
                return false;
            } else {
                return true;
            }
        }
        return left(x + 1, y, indx + 1, word, board);
    }

    public boolean right(int x, int y, int indx, String word, char[][] board) {
        if (indx == word.length()) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return true;
            }
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (indx < word.length()) {
            if (board[x][y] == '#') {
                return false;
            }
            if (board[x][y] != word.charAt(indx) && board[x][y] != ' ') {
                return false;
            }
        }
        if (indx >= word.length()) {
            if (board[x][y] != '#') {
                return false;
            } else {
                return true;
            }
        }
        return right(x - 1, y, indx + 1, word, board);
    }

    public boolean up(int x, int y, int indx, String word, char[][] board) {
        if (indx == word.length()) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return true;
            }
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (indx < word.length()) {
            if (board[x][y] == '#') {
                return false;
            }
            if (board[x][y] != word.charAt(indx) && board[x][y] != ' ') {
                return false;
            }
        }
        if (indx >= word.length()) {
            if (board[x][y] != '#') {
                return false;
            } else {
                return true;
            }
        }
        return up(x, y + 1, indx + 1, word, board);
    }

    public boolean down(int x, int y, int indx, String word, char[][] board) {
        if (indx == word.length()) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return true;
            }
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (indx < word.length()) {
            if (board[x][y] == '#') {
                return false;
            }
            if (board[x][y] != word.charAt(indx) && board[x][y] != ' ') {
                return false;
            }
        }
        if (indx >= word.length()) {
            if (board[x][y] != '#') {
                return false;
            } else {
                return true;
            }
        }
        return down(x, y - 1, indx + 1, word, board);
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                char w = word.charAt(0);
                if (ch == w || ch == ' ') {
                    // left() moves DOWN (x+1)
                    if ((i - 1 < 0 || board[i - 1][j] == '#') &&
                            left(i, j, 0, word, board)) {
                        return true;
                    }

                    // right() moves UP (x-1)
                    if ((i + 1 >= board.length || board[i + 1][j] == '#') &&
                            right(i, j, 0, word, board)) {
                        return true;
                    }

                    // up() moves RIGHT (y+1)
                    if ((j - 1 < 0 || board[i][j - 1] == '#') &&
                            up(i, j, 0, word, board)) {
                        return true;
                    }

                    // down() moves LEFT (y-1)
                    if ((j + 1 >= board[0].length || board[i][j + 1] == '#') &&
                            down(i, j, 0, word, board)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }
}