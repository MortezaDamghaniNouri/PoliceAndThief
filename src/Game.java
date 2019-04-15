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
        Police myPolices=new Police(numberOfPolices);









    }








}








