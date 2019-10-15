import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        //Field field = new Field(10,10);
        Field field = new Field(10,10,new int[][] {
                {0,0,1,0,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        });
        while (!field.isGameEnd()) {
            field.nextDay();
            System.out.print(field);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===============================");
        }
        System.out.println("Game End!");
    }
}
