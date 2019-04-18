import java.util.Scanner;
import java.util.Random;
public class Game
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        int m,n,numberOfPolices;
        System.out.println("Enter m(row):");
        m=input.nextInt();
        System.out.println("Enter n(column):");
        n=input.nextInt();
        Field myField=new Field(m,n);
        System.out.println("Enter the number of polices.");
        numberOfPolices=input.nextInt();
        Random rand1=new Random();
        Random rand2=new Random();
        Random rand3=new Random();
        Random rand4=new Random(rand1.nextInt(100*m)*rand2.nextInt(100*n)*rand3.nextInt(100*numberOfPolices));
        Police myPolices[]=new Police[numberOfPolices];
        for(int i=0;i<numberOfPolices;++i)
        {
            int row=rand4.nextInt(m);
            int column=rand4.nextInt(n);
            Police police=new Police(i,row,column,m,n);
            myPolices[i]=police;
        }
        Thief myTheif=new Thief(rand4.nextInt(m),rand4.nextInt(n),m,n);
        int time=0;
        myField.fix();

        //myField.pause();
        //myField.pause();
        //myField.clean();

        for(int i=1;i<=10;++i)
        {
            int gameTable[][]=new int[m][n];
            gameTable=myField.fieldMaker(myTheif,myPolices,numberOfPolices);
            myField.fieldPrinter(gameTable);
            myTheif.makeDecision();
           // myField.fieldPrinter(myField.fieldMaker(myTheif,myPolices,numberOfPolices));











        }







    }








}