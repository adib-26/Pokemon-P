package src.pokemaze;

import java.util.*;

public class PokemonMaze {
    private char[][] maze;
    private int[] start;
    private Stack<int[]> stack = new Stack<>();
    private Map<String, int[]> directions = new HashMap<>();

    public PokemonMaze(char[][] maze) {
        this.maze = maze;
        this.start = findStart();
        this.stack.push(this.start);
        this.directions.put("up", new int[]{-1, 0});
        this.directions.put("down", new int[]{1, 0});
        this.directions.put("left", new int[]{0, -1});
        this.directions.put("right", new int[]{0, 1});
    }

    private int[] findStart() {
        for (int i = 0; i < this.maze.length; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                if (this.maze[i][j] == 'P') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};  // Return invalid coordinates if start not found
    }

    public boolean move(String direction) {
        int[] d = this.directions.get(direction);
        int[] pos = this.stack.peek();
        int nx = pos[0] + d[0];
        int ny = pos[1] + d[1];
        while (this.maze[nx][ny] != '#' && this.maze[nx][ny] != 'G' && this.maze[nx][ny] != 'E') {
            this.stack.push(new int[]{nx, ny});
            this.maze[nx][ny] = '*';
            nx += d[0];
            ny += d[1];
        }
        if (this.maze[nx][ny] == 'G') {
            System.out.println("You've been caught by a Ghost!");
            return false;
        } else if (this.maze[nx][ny] == 'E') {
            System.out.println("Congratulations! You've escaped the maze.");
            return false;
        }
        return true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (char[] row : this.maze) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Enter direction (up, down, left, right): ");
            String direction = scanner.nextLine();
            if (!this.directions.containsKey(direction)) {
                System.out.println("Invalid direction. Try again.");
            } else {
                if (!this.move(direction)) {
                    break;
                }
            }
        }
        scanner.close();
    }

    public void startMaze() {
        char[][] maze = {
                "##########".toCharArray(),
                "#P...#...#".toCharArray(),
                "#....#...".toCharArray(),
                "#....#...#".toCharArray(),
                "#....G..G#".toCharArray(),
                "#........#".toCharArray(),
                "#G..##...#".toCharArray(),
                "#....#...#".toCharArray(),
                "#....#..E#".toCharArray(),
                "##########".toCharArray(),
        };

        PokemonMaze game = new PokemonMaze(maze);
        game.play();

    }
}
