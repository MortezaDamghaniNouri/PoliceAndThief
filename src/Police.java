import java.util.Random;
public class Police
{
    private int id;
    private int row;
    private int column;
    private int totalRow;
    private int totalColumn;
    public Police(int i,int r,int c,int m,int n)
    {
        id=i;
        row=r;
        column=c;
        totalRow=m;
        totalColumn=n;
    }
    public int getId()
    {
        return id;
    }

    public int getRow()
    {
        return row;
    }
    public void setRow(int r)
    {
        row=r;
    }
    public int getColumn()
    {
        return column;
    }
    public void setColumn(int c)
    {
        column=c;
    }
    public int getTotalRow()
    {
        return totalRow;
    }
    public int getTotalColumn()
    {
        return totalColumn;
    }













}