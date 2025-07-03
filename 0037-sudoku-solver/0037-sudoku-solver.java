class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        // Initialize trackers
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val != '.') {
                    int idx = val - '1';
                    int boxNo = (r / 3) * 3 + (c / 3);
                    row[r][idx] = col[c][idx] = box[boxNo][idx] = true;
                }
            }
        }

        backtrack(board, row, col, box, 0, 0);
    }

    private boolean backtrack(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int r, int c) {
        if (r == 9) return true;

        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c + 1) % 9;

        if (board[r][c] != '.') {
            return backtrack(board, row, col, box, nextR, nextC);
        }

        int boxNo = (r / 3) * 3 + (c / 3);

        for (char ch = '1'; ch <= '9'; ch++) {
            int idx = ch - '1';
            if (!row[r][idx] && !col[c][idx] && !box[boxNo][idx]) {
                board[r][c] = ch;
                row[r][idx] = col[c][idx] = box[boxNo][idx] = true;

                if (backtrack(board, row, col, box, nextR, nextC)) return true;

                board[r][c] = '.';
                row[r][idx] = col[c][idx] = box[boxNo][idx] = false;
            }
        }

        return false;
    }
}