import java.util.Random;
public class Thief
{
    private int seed;
    Random rand=new Random(seed);
   private int row,column;
   private int totalRow,totalColumn;
   public int getRow()
   {
       return row;
   }
   public int getColumn()
   {
       return column;
   }
   public Thief(int r,int c,int m,int n)
   {
       row=r;
       column=c;
       seed=r*c;
       totalRow=m;
       totalColumn=n;
   }
   public void makeDecision()
   {

       int result=0;
       if(row==0&&column==0)
       {
           result=1;
           int random=rand.nextInt(3);
           random+=1;
           if(random==1)
           {
               column+=1;
           }
           if(random==2)
           {
               row+=1;
               column+=1;
           }
           if(random==3)
           {
               row+=1;
           }
       }

       if(column==0&&row!=0&&row!=totalRow-1)
       {
           result=1;
           int random=rand.nextInt(5);
           random+=1;
           if(random==1)
           {
              row-=1;
           }
           if(random==2)
           {
               row-=1;
               column+=1;
           }
           if(random==3)
           {
               column+=1;
           }
           if(random==4)
           {
               row+=1;
               column+=1;
           }
           if(random==5)
           {
               row+=1;
           }

       }
       if(column==0&&row==totalRow-1)
       {
           result=1;
           int random=rand.nextInt(3);
           random+=1;
           if(random==1)
           {
               row-=1;
           }
           if(random==2)
           {
               row-=1;
               column+=1;
           }
           if(random==3)
           {
               column+=1;
           }

       }
       if(row==0&&column!=0&&column!=totalColumn-1)
       {
           result=1;
           int random=rand.nextInt(5);
           random+=1;
           if(random==1)
           {
               column+=1;
           }
           if(random==2)
           {
               row+=1;
               column+=1;
           }
           if(random==3)
           {
               row+=1;
           }
           if(random==4)
           {
               row+=1;
               column-=1;
           }
           if(random==5)
           {
               column-=1;
           }



       }
       if(row==0&&column==totalColumn-1)
       {
           result=1;
           int random=rand.nextInt(3);
           random+=1;
           if(random==1)
           {
               row+=1;
           }
           if(random==2)
           {
               row+=1;
               column-=1;
           }
           if(random==3)
           {
               column-=1;
           }

       }
       if(column==totalColumn-1&&row!=0&&row!=totalRow-1)
       {
           result=1;
           int random=rand.nextInt(5);
           random+=1;
           if(random==1)
           {
               row+=1;
           }
           if(random==2)
           {
               row+=1;
               column-=1;
           }
           if(random==3)
           {
               column-=1;
           }
           if(random==4)
           {
               row-=1;
               column-=1;
           }
           if(random==5)
           {
               row-=1;
           }

       }
       if(row==totalRow-1&&column==totalColumn-1)
       {
           result=1;
           int random=rand.nextInt(3);
           random+=1;
           if(random==1)
           {
               column-=1;
           }
           if(random==2)
           {
               row-=1;
               column-=1;
           }
           if(random==3)
           {
               row-=1;
           }

       }
       if(row==totalRow-1&&column!=0&&column!=totalColumn-1)
       {
           result=1;
           int random=rand.nextInt(5);
           random+=1;
           if(random==1)
           {
               column+=1;
           }
           if(random==2)
           {
               column-=1;
           }
           if(random==3)
           {
               row-=1;
               column-=1;
           }
           if(random==4)
           {
               row-=1;
           }
           if(random==5)
           {
               row-=1;
               column+=1;
           }

       }
       if(result==0)
       {
           int random=rand.nextInt(8);
           random+=1;
           if(random==1)
           {
               column+=1;
           }
           if(random==2)
           {
               row+=1;
               column+=1;
           }
           if(random==3)
           {
               row+=1;
           }
           if(random==4)
           {
               row+=1;
               column-=1;
           }
           if(random==5)
           {
               column -= 1;
           }
           if(random==6)
           {
               row-=1;
               column -= 1;
           }
           if(random==7)
           {
               row -= 1;
           }
           if(random==8)
           {
               row-=1;
               column += 1;
           }

       }










   }








}
