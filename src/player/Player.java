package player;

import Element.Point;
import control.Array2D;
import gui_game.GamePanle;
import java.util.Scanner;

public class Player {

    GamePanle gp;
    Scanner sc;

    public Player(GamePanle gp) {

        this.gp = gp;
        sc = new Scanner(System.in);

    }

    public void next() {
        if (gp.array2DControl.fullArray != gp.gameSize * gp.gameSize) {
            System.out.print("Row: ");
            int row = sc.nextInt() - 1;
            System.out.print("Col: ");
            int col = sc.nextInt() - 1;

            if (gp.array2DControl.checkEdit(new Point(row, col))) {
                System.out.print("Num: ");
                int num = sc.nextInt();
                if (checkNum(row, col, num)) {
                    if (gp.array2D[row][col] == 0) {
                        gp.array2D[row][col] = num;
                        gp.array2DControl.amountNumber[num - 1]++;
                        gp.array2DControl.fullArray++;
                    } else {
                        int num2 = gp.array2D[row][col];
                        gp.array2DControl.amountNumber[num2 - 1]--;
                        gp.array2DControl.amountNumber[num - 1]++;
                        gp.array2D[row][col] = num;
                    }
                } else {
                    System.err.println("ERROR: " + num + " is exists!!!!");
                }
            }
        }
    }

    public boolean checkNum(int row, int col, int num) {

        for (int i = 0; i < gp.gameSize; i++) {
            if (gp.array2D[i][col] == num) {
                return false;
            }
        }

        for (int i = 0; i < gp.gameSize; i++) {
            if (gp.array2D[row][i] == num) {
                return false;
            }
        }

        return true;
    }
}
