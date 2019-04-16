import java.util.Random;
public class Theif
{
    private int seed;
    Random rand=new Random(seed);
   private int row,column;

   public int getRow()
   {
       return row;
   }
   public int getColumn()
   {
       return column;
   }
   public Theif(int r,int c)
   {
       row=r;
       column=c;
       seed=r*c;
   }
   public void makeDecision()
   {


       if(row==0&&column==0)
       {
           int random=rand.nextInt(3);
           random+=1;

       }

       if(row==0&&column==0)
       {
           int random=rand.nextInt(3);
           random+=1;


       }
       if(row==0&&column==0)
       {
           int random=rand.nextInt(3);
           random+=1;


       }
       if(row==0&&column==0)
       {
           int random=rand.nextInt(3);
           random+=1;


       }






   }








}
