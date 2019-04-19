import java.util.Random;

public class Police {
    private int id;
    private int row;
    private int column;
    private int totalRow;
    private int totalColumn;
    private int thiefRow;
    private int thiefColumn;
    private int moves;

    public Police(int i, int r, int c, int m, int n) {
        id = i;
        row = r;
        column = c;
        totalRow = m;
        totalColumn = n;
        thiefRow = 100000;
        thiefColumn = 100000;
        moves = 0;
    }

    public void addMove() {
        ++moves;
    }

    public int getMoves() {
        return moves;
    }

    public void randomSiteGenerator() {
        Random rand = new Random();
        setRow(rand.nextInt(totalRow));
        setColumn(rand.nextInt(totalColumn));
    }

    public int getThiefRow() {
        return thiefRow;
    }

    public int getThiefColumn() {
        return thiefColumn;
    }

    public void setThiefRow(int r) {
        thiefRow = r;
    }

    public void setTotalColumn(int c) {
        thiefColumn = c;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int c) {
        column = c;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public int getTotalColumn() {
        return totalColumn;
    }

    public void iSawThief(int r, int c, Police p[], int n) {
        for (int i = 0; i < n; ++i) {
            p[i].setThiefRow(r);
            p[i].setTotalColumn(c);
        }


    }


    public void makeDecision(Police p) {
        if (p.getThiefRow() == 100000 && p.getThiefColumn() == 100000) {
            p.randomSiteGenerator();
            addMove();
        } else {
            int thiefRow = p.getThiefRow();
            int thiefColumn = p.getThiefColumn();
            int result = 0;
            if (thiefRow == p.getRow()) {
                result = 1;
                if (thiefColumn > p.getColumn()) {
                    p.setColumn(p.getColumn() + 1);
                    addMove();
                } else {
                    p.setColumn(p.getColumn() - 1);
                    addMove();
                }

            }
            if (thiefColumn == p.getColumn()) {
                result = 1;
                if (thiefRow > p.getRow()) {
                    p.setRow(p.getRow() + 1);
                    addMove();
                } else {
                    p.setRow(p.getRow() - 1);
                    addMove();
                }

            }
            if (result == 0) {
                if (thiefRow < p.getRow() && thiefColumn > p.getColumn()) {
                    p.setRow(p.getRow() - 1);
                    p.setColumn(p.getColumn() + 1);
                    addMove();
                }
                if (thiefRow < p.getRow() && thiefColumn < p.getColumn()) {
                    p.setRow(p.getRow() - 1);
                    p.setColumn(p.getColumn() - 1);
                    addMove();
                }
                if (thiefRow > p.getRow() && thiefColumn > p.getColumn()) {
                    p.setRow(p.getRow() + 1);
                    p.setColumn(p.getColumn() + 1);
                    addMove();
                }
                if (thiefRow > p.getRow() && thiefColumn < p.getColumn()) {
                    p.setRow(p.getRow() + 1);
                    p.setColumn(p.getColumn() - 1);
                    addMove();
                }

            }


        }

    }

    public void haveYouSeen(Police p[], int[][] gameTable, int n) {
        Police police;
        int thiefRow;
        int thiefColumn;
        for (int i = 0; i < n; ++i) {
            int result = 0;
            police = p[i];
            int row = police.getRow();
            int column = police.getColumn();
            if (row == 0 && column == 0) {
                result = 1;
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == 0 && column == police.getTotalColumn() - 1) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == police.getTotalRow() - 1 && column == police.getTotalColumn() - 1) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == police.getTotalRow() - 1 && column == 0) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == 0 && column == 1) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }


            }
            if (row == 0 && column == police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }


            }
            if (row == police.getTotalRow() - 1 && column == police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }


            }
            if (row == police.getTotalRow() - 1 && column == 1) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }


            }
            if (row == 0 && column > 1 && column < police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (column == 0 && row > 1 && row < police.getTotalRow() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == police.getTotalRow() - 1 && column > 1 && column < police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (column == police.getTotalColumn() - 1 && row > 1 && row < police.getTotalRow() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == 1 && column == 1) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == 1 && column == police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == police.getTotalRow() - 2 && column == 1) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (row == police.getTotalRow() - 2 && column == police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }

            }
            if (column == 1 && row > 1 && row < police.getTotalRow() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
            }
            if (row == 1 && column > 1 && column < police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
            }
            if (column == police.getTotalColumn() - 2 && row > 1 && row < police.getTotalRow() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
            }
            if (row == police.getTotalRow() - 2 && column > 1 && column < police.getTotalColumn() - 2) {
                result = 1;
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;

                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
            }
            if (result == 0) {
                if (gameTable[row][column + 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column + 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 1] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row][column - 2] == 1) {
                    thiefRow = row;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column - 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column - 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column - 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 1][column + 1] == 1) {
                    thiefRow = row - 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row - 2][column + 2] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column - 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column - 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column - 1] == 1) {
                    thiefRow = row - 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 1][column + 1] == 1) {
                    thiefRow = row + 1;
                    thiefColumn = column + 1;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }
                if (gameTable[row + 2][column + 2] == 1) {
                    thiefRow = row + 2;
                    thiefColumn = column + 2;
                    police.iSawThief(thiefRow, thiefColumn, p, n);
                    break;
                }


            }


        }

    }


}