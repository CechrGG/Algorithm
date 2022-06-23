package acmr.algorithm.medium.matrix;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author guohz
 * @version 5.0.0
 * 2022/6/23
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 *
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *  
 *
 * 提示：
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 * 通过次数291,751提交次数459,361
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSudoku36 {

    public static boolean isValidSudoku(char[][] board) {
        if(board.length != 9) {
            return false;
        }
        Set<Character> nums = new HashSet<Character>() {
            {
                add('1');
                add('2');
                add('3');
                add('4');
                add('5');
                add('6');
                add('7');
                add('8');
                add('9');
            }
        };

        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> matrixMap = new HashMap<>();
        for(int row = 0; row < board.length; row++) {
            if(board[row].length != 9) {
                return false;
            }
            if(row % 3 == 0) {
                matrixMap.put(0, new HashSet<>());
                matrixMap.put(1, new HashSet<>());
                matrixMap.put(2, new HashSet<>());
            }
            Set<Character> rowSet = new HashSet<>();
            for(int col = 0; col < board[row].length; col++) {
                char value = board[row][col];
                if(value == '.'){
                    continue;
                }
                if(!nums.contains(value)) {
                    System.out.println("非1-9");
                    return false;
                }
                if(rowSet.contains(value)) {
                    System.out.println("row repeat");
                    return false;
                }
                rowSet.add(value);
                if(!colMap.containsKey(col)) {
                    colMap.put(col, new HashSet<>());
                }
                if(colMap.get(col).contains(value)) {
                    System.out.println("col repeat");
                    return false;
                } else {
                    colMap.get(col).add(value);
                }
                //三行处理
                int matrixIndex = col / 3;
                if(matrixMap.get(matrixIndex).contains(value)) {
                    System.out.println("3*3 repeat");
                    return false;
                } else {
                    matrixMap.get(matrixIndex).add(value);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        if(board.length != 9) {
            return false;
        }
        Set<Character> nums = new HashSet<Character>() {
            {
                add('1');
                add('2');
                add('3');
                add('4');
                add('5');
                add('6');
                add('7');
                add('8');
                add('9');
            }
        };

        int[][] rowNums = new int[9][9];
        int[][] colNums = new int[9][9];
        int[][][] matrix = new int[3][3][9];
        for(int row = 0; row < board.length; row++) {
            if(board[row].length != 9) {
                return false;
            }

            for(int col = 0; col < board[row].length; col++) {
                char value = board[row][col];
                if(value == '.'){
                    continue;
                }
                if(!nums.contains(value)) {
                    System.out.println("非1-9");
                    return false;
                }
                int index = value - '0' - 1;
                rowNums[row][index]++;
                if(rowNums[row][index] > 1) {
                    return false;
                }
                colNums[index][col]++;
                if(colNums[index][col] > 1) {
                    return false;
                }
                matrix[row/3][col/3][index]++;
                if(matrix[row/3][col/3][index] > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku2(board));
    }
}
