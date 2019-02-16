import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianzhe on 10/14/18.
 */
public class SnakeGame {

    Queue<Integer> snake;
    boolean[][] board;
    int[][] food;
    int foodIndex;
    int height, width;
    int row, col;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.board = new boolean[width][height];
        this.food = food;
        this.foodIndex = 0;
        this.snake = new LinkedList<>();
        this.snake.offer(0);
        this.board[0][0] = true;

        this.width = width;
        this.height = height;

        this.row = 0;
        this.col = 0;
        this.score = 0;
    }

    public int move(String direction) {
        if (score == -1) return score;
        if (direction.equals("U")) row--;
        else if (direction.equals("L")) col--;
        else if (direction.equals("R")) col++;
        else if (direction.equals("D")) row++;
        if (row < 0 || row >= height || col < 0 || col >= width) {
            score = -1;
            return score;
        }
        if (foodIndex == food.length || !(row == food[foodIndex][0] &&
        col == food[foodIndex][1]) ) {
            int idx = snake.poll();
            board[idx / width][idx % width] = false;

        } else {
            score++;
            foodIndex++;
        }
        if (board[row][col]) {
            score = -1;
            return score;
        } else {
            snake.offer(row * width + col);
            board[row][col] = true;
        }
        return score;
    }
}
