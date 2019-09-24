package zhaofanqi.exercise.recursion;

public class MiGong {
    public static void main(String[] args) {
        //假设地图为 8行7列
        int a = 8;
        int b = 7;
        int[][] map = wall(a, b);
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("迷宫路线图");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

    }


    private static int[][] wall(int a, int b) {
        int[][] map = new int[a][b];
        //生成横向围墙
        for (int i = 0; i < b; i++) {
            map[0][i] = 1;
            map[a - 1][i] = 1;
        }
        //生成纵向围墙
        for (int i = 0; i < a; i++) {
            map[i][0] = 1;
            map[i][b - 1] = 1;
        }
        return map;

    }

    /**
     * 说明：
     * map 表示地图
     * i,j表示从地图开始的位置
     * 如果小球能到 map[6][5] 的位置，则说明通路找到
     * 约定：当map[i][j] 为
     * 0 表示该店没有走过，
     * 1 则表示为墙，
     * 2则表示可以走通，
     * 3则表示该店已经走过，但是走不通
     * 确定一个路线策略： 下->右->上->左 ，如果该点走不通再回调
     *
     * @param map 表示地图
     * @param i   ,j 表示从地图开始的位置
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//这条路没走过
                map[i][j] = 2;//假设这条路可以走通
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    System.out.println(" 此路不同");
                    map[i][j] = 3;
                    return false;// return false 则造成了回溯
                }
            }else {
                System.out.println(" 此路不同 2");
                return false;
            }
        }
    }
}
