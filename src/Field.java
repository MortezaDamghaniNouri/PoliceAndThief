public class Field
{
    private int row,column;
    public Field(int m,int n)
    {
        row=m;
        column=n;

    }
    public int getRow()
    {
        return row;
    }
    public int getColumn()
    {
        return column;
    }
    public int[][] fieldMaker(Thief t,Police polices[],int n)
    {
        int gameTable[][]=new int[row][column];
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<column;++j)
            {
                gameTable[i][j]=0;

            }

        }
        gameTable[t.getRow()][t.getColumn()]=1;
        for(int i=0;i<n;++i)
        {
            if(gameTable[polices[i].getRow()][polices[i].getColumn()]==1)
            {
                gameTable[polices[i].getRow()][polices[i].getColumn()]=12;
            }
            else
            {
                gameTable[polices[i].getRow()][polices[i].getColumn()]=2;
            }


        }
        return gameTable;

    }
    public int gameConditionChecker(int gameTable[][])
    {



    }
    public void fieldPrinter(int gameTable[][])
    {
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<column;++j)
            {
                if(gameTable[i][j]==12)
                {
                    System.out.print("| P&T |");
                }
                if(gameTable[i][j]==0)
                {
                    System.out.print("|     |");
                }
                if(gameTable[i][j]==1)
                {
                    System.out.print("|  T  |");
                }
                if(gameTable[i][j]==2)
                {
                    System.out.print("|  P  |");
                }

            }
            System.out.println();

        }

    }









}












