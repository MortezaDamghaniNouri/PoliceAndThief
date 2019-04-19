import java.util.Random;

public class Thief {
    Random rand = new Random();
    private int moves;
    private int row, column;
    private int totalRow, totalColumn;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Thief(int r, int c, int m, int n) {
        row = r;
        column = c;
        totalRow = m;
        totalColumn = n;
        moves = 0;
    }

    public void addMove() {
        ++moves;
    }

    public int getMoves() {
        return moves;
    }

    public void makeDecision() {

        int result = 0;
        if (row == 0 && column == 0) {
            result = 1;
            int random = rand.nextInt(3);
            random += 1;
            if (random == 1) {
                column += 1;
            }
            if (random == 2) {
                row += 1;
                column += 1;
            }
            if (random == 3) {
                row += 1;
            }
            addMove();
        }

        if (column == 0 && row != 0 && row != totalRow - 1) {
            result = 1;
            int random = rand.nextInt(5);
            random += 1;
            if (random == 1) {
                row -= 1;
            }
            if (random == 2) {
                row -= 1;
                column += 1;
            }
            if (random == 3) {
                column += 1;
            }
            if (random == 4) {
                row += 1;
                column += 1;
            }
            if (random == 5) {
                row += 1;
            }
            addMove();
        }
        if (column == 0 && row == totalRow - 1) {
            result = 1;
            int random = rand.nextInt(3);
            random += 1;
            if (random == 1) {
                row -= 1;
            }
            if (random == 2) {
                row -= 1;
                column += 1;
            }
            if (random == 3) {
                column += 1;
            }
            addMove();
        }
        if (row == 0 && column != 0 && column != totalColumn - 1) {
            result = 1;
            int random = rand.nextInt(5);
            random += 1;
            if (random == 1) {
                column += 1;
            }
            if (random == 2) {
                row += 1;
                column += 1;
            }
            if (random == 3) {
                row += 1;
            }
            if (random == 4) {
                row += 1;
                column -= 1;
            }
            if (random == 5) {
                column -= 1;
            }
            addMove();


        }
        if (row == 0 && column == totalColumn - 1) {
            result = 1;
            int random = rand.nextInt(3);
            random += 1;
            if (random == 1) {
                row += 1;
            }
            if (random == 2) {
                row += 1;
                column -= 1;
            }
            if (random == 3) {
                column -= 1;
            }
            addMove();
        }
        if (column == totalColumn - 1 && row != 0 && row != totalRow - 1) {
            result = 1;
            int random = rand.nextInt(5);
            random += 1;
            if (random == 1) {
                row += 1;
            }
            if (random == 2) {
                row += 1;
                column -= 1;
            }
            if (random == 3) {
                column -= 1;
            }
            if (random == 4) {
                row -= 1;
                column -= 1;
            }
            if (random == 5) {
                row -= 1;
            }
            addMove();
        }
        if (row == totalRow - 1 && column == totalColumn - 1) {
            result = 1;
            int random = rand.nextInt(3);
            random += 1;
            if (random == 1) {
                column -= 1;
            }
            if (random == 2) {
                row -= 1;
                column -= 1;
            }
            if (random == 3) {
                row -= 1;
            }
            addMove();
        }
        if (row == totalRow - 1 && column != 0 && column != totalColumn - 1) {
            result = 1;
            int random = rand.nextInt(5);
            random += 1;
            if (random == 1) {
                column += 1;
            }
            if (random == 2) {
                column -= 1;
            }
            if (random == 3) {
                row -= 1;
                column -= 1;
            }
            if (random == 4) {
                row -= 1;
            }
            if (random == 5) {
                row -= 1;
                column += 1;
            }
            addMove();
        }
        if (result == 0) {
            int random = rand.nextInt(8);
            random += 1;
            if (random == 1) {
                column += 1;
            }
            if (random == 2) {
                row += 1;
                column += 1;
            }
            if (random == 3) {
                row += 1;
            }
            if (random == 4) {
                row += 1;
                column -= 1;
            }
            if (random == 5) {
                column -= 1;
            }
            if (random == 6) {
                row -= 1;
                column -= 1;
            }
            if (random == 7) {
                row -= 1;
            }
            if (random == 8) {
                row -= 1;
                column += 1;
            }
            addMove();
        }

    }


}
