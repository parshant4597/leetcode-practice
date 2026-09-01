// class Solution {
//     class Pair {
//         int x;
//         int y;
//         int moves;
//         int e;
//         int count;
//         HashMap<Integer, Integer> map;

//         public Pair(int x, int y, int moves, int e, int count,
//                 HashMap<Integer, Integer> map) {
//             this.x = x;
//             this.y = y;
//             this.moves = moves;
//             this.e = e;
//             this.count = count;
//             this.map = (map != null) ? new HashMap<>(map) : new HashMap<>();
//         }
//     }

//     public boolean isvalid(int x, int y, String[] arr) {
//         int n = arr.length;
//         int m = arr[0].length();

//         if (x < 0 || x >= n)
//             return false;
//         if (y < 0 || y >= m)
//             return false;

//         return true;
//     }

//     public int bfs(int x, int y, String[] arr, int energy, int count) {
//         Queue<Pair> qu = new LinkedList<>();

//         int ans = (int) 1e9;

//         qu.add(new Pair(x, y, 0, energy, count, new HashMap<>()));

//         while (!qu.isEmpty()) {
//             Pair top = qu.poll();

//             int currx = top.x;
//             int curry = top.y;
//             int currmoves = top.moves;
//             int currcount = top.count;
//             int curre = top.e;
//             HashMap<Integer, Integer> map = top.map;

//             if (curre == 0)
//                 continue;

//             if (currcount == 0) {
//                 ans = Math.min(currmoves, ans);
//             }

//             int[] dx = { 0, 0, 1, -1 };
//             int[] dy = { 1, -1, 0, 0 };

//             for (int i = 0; i < 4; i++) {
//                 int nextx = currx + dx[i];
//                 int nexty = curry + dy[i];

//                 if (!isvalid(nextx, nexty, arr)) {
//                     continue;
//                 }

//                 // if (arr[nextx].charAt(nexty) == '.') {
//                     qu.add(new Pair(
//                             nextx,
//                             nexty,
//                             currmoves + 1,
//                             curre - 1,
//                             currcount,
//                             map));
//                     continue;
//                 }

//                 if (arr[nextx].charAt(nexty) == 'X') {
//                     continue;
//                 }

//                 if (arr[nextx].charAt(nexty) == 'R') {
//                     qu.add(new Pair(
//                             nextx,
//                             nexty,
//                             currmoves + 1,
//                             energy,
//                             currcount,
//                             map));
//                     continue;
//                 }

//                 if (arr[nextx].charAt(nexty) == 'L') {
//                     int key = nextx + 10 * nexty;

//                     if (map.containsKey(key)) {
//                         qu.add(new Pair(
//                                 nextx,
//                                 nexty,
//                                 currmoves + 1,
//                                 curre - 1,
//                                 currcount,
//                                 map));
//                     } else {
//                         map.put(key, 1);

//                         qu.add(new Pair(
//                                 nextx,
//                                 nexty,
//                                 currmoves + 1,
//                                 curre - 1,
//                                 currcount - 1,
//                                 map));
//                     }
//                 }
//             }
//         }

//         return ans;
//     }

//     public int minMoves(String[] arr, int energy) {
//         int sx = -1;
//         int sy = -1;
//         int count = 0;

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[0].length(); j++) {

//                 if (arr[i].charAt(j) == 'S') {
//                     sx = i;
//                     sy = j;
//                 }

//                 if (arr[i].charAt(j) == 'L') {
//                     count++;
//                 }
//             }
//         }

//         int ans = bfs(sx, sy, arr, energy, count);

//         return ans == (int) 1e9 ? -1 : ans;
//     }
// }/
class Solution {

    class Pair {
        int x;
        int y;
        int moves;
        int e;
        int mask;

        public Pair(int x, int y, int moves, int e, int mask) {
            this.x = x;
            this.y = y;
            this.moves = moves;
            this.e = e;
            this.mask = mask;
        }
    }

    public boolean isvalid(int x, int y, String[] arr) {
        int n = arr.length;
        int m = arr[0].length();

        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;

        return true;
    }

    public int bfs(int x, int y, String[] arr, int energy,
                   int[][] lid, int count) {

        Queue<Pair> qu = new ArrayDeque<>();

        int fullMask = (1 << count) - 1;

        /*
         * best[x][y][mask] = maximum energy with which
         * we have reached this state.
         */
        int[][][] best = new int[arr.length][arr[0].length()][1 << count];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                Arrays.fill(best[i][j], -1);
            }
        }

        qu.add(new Pair(x, y, 0, energy, 0));
        best[x][y][0] = energy;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!qu.isEmpty()) {

            Pair top = qu.poll();

            int currx = top.x;
            int curry = top.y;
            int currmoves = top.moves;
            int curre = top.e;
            int mask = top.mask;

            // All L collected
            if (mask == fullMask) {
                return currmoves;
            }

            if (curre == 0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {

                int nextx = currx + dx[i];
                int nexty = curry + dy[i];

                if (!isvalid(nextx, nexty, arr)) {
                    continue;
                }

                char cell = arr[nextx].charAt(nexty);

                if (cell == 'X') {
                    continue;
                }

                // Every movement costs 1 energy
                int nextE = curre - 1;

                // Recharge
                if (cell == 'R') {
                    nextE = energy;
                }

                int nextMask = mask;

                // L
                if (cell == 'L') {
                    int id = lid[nextx][nexty];

                    if (id != -1) {
                        nextMask = mask | (1 << id);
                    }
                }

                /*
                 * If we have already reached the same
                 * (x, y, mask) with >= energy, this state
                 * can never be better.
                 */
                if (best[nextx][nexty][nextMask] >= nextE) {
                    continue;
                }

                best[nextx][nexty][nextMask] = nextE;

                qu.add(new Pair(
                    nextx,
                    nexty,
                    currmoves + 1,
                    nextE,
                    nextMask
                ));
            }
        }

        return -1;
    }

    public int minMoves(String[] arr, int energy) {

        int sx = -1;
        int sy = -1;
        int count = 0;

        int n = arr.length;
        int m = arr[0].length();

        /*
         * lid[i][j] tells which bit belongs
         * to this L cell.
         */
        int[][] lid = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(lid[i], -1);

            for (int j = 0; j < m; j++) {

                char c = arr[i].charAt(j);

                if (c == 'S') {
                    sx = i;
                    sy = j;
                }

                if (c == 'L') {
                    lid[i][j] = count;
                    count++;
                }
            }
        }

        return bfs(sx, sy, arr, energy, lid, count);
    }
}