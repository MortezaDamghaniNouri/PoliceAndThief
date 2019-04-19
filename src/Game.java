/**
 * PROGRAMMER : MORTEZA DAMGHANI NOURI.
 * EDUCATIONAL NUMBER :9625801.
 * EMAIL:mortezadamghani77@gmail.com
 */

import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m, n, numberOfPolices;
        System.out.println("Enter m(row):");
        m = input.nextInt();
        System.out.println("Enter n(column):");
        n = input.nextInt();
        Field myField = new Field(m, n);
        System.out.println("Enter the number of polices.");
        numberOfPolices = input.nextInt();
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();
        Random rand4 = new Random(rand1.nextInt(100 * m) * rand2.nextInt(100 * n) * rand3.nextInt(100 * numberOfPolices));
        Police myPolices[] = new Police[numberOfPolices];
        for (int i = 0; i < numberOfPolices; ++i) {
            int row = rand4.nextInt(m);
            int column = rand4.nextInt(n);
            Police police = new Police(i, row, column, m, n);
            myPolices[i] = police;
        }
        Thief myTheif = new Thief(rand4.nextInt(m), rand4.nextInt(n), m, n);
        int time = 0;
        myField.fix();
        int gameTable[][];
        gameTable = myField.fieldMaker(myTheif, myPolices, numberOfPolices);
        myField.fieldPrinter(gameTable);
        for (int y = 0; y < 1000000000; ++y) {
            for (int x = 0; x < 5; ++x) {
                myField.pause();
            }
        }
        myField.clean();
        for (; myField.gameConditionChecker(gameTable, m, n); ) {
            gameTable = myField.fieldMaker(myTheif, myPolices, numberOfPolices);
            Police.haveYouSeen(myPolices, gameTable, numberOfPolices);
            myTheif.makeDecision();
            gameTable = myField.fieldMaker(myTheif, myPolices, numberOfPolices);
            if (!myField.gameConditionChecker(gameTable, m, n)) {
                myField.fieldPrinter(gameTable);
                for (int y = 0; y < 1000000000; ++y) {
                    for (int x = 0; x < 6; ++x) {
                        myField.pause();
                    }
                }
                myField.clean();
                break;
            }
            for (int k = 0; k < numberOfPolices; ++k) {
                myPolices[k].makeDecision(myPolices[k]);
            }
            gameTable = myField.fieldMaker(myTheif, myPolices, numberOfPolices);
            if (!myField.gameConditionChecker(gameTable, m, n)) {
                myField.fieldPrinter(gameTable);
                for (int y = 0; y < 1000000000; ++y) {
                    for (int x = 0; x < 5; ++x) {
                        myField.pause();
                    }
                }
                myField.clean();
                break;
            }
            myField.fieldPrinter(gameTable);
            for (int y = 0; y < 1000000000; ++y) {
                for (int x = 0; x < 5; ++x) {
                    myField.pause();
                }
            }
            myField.clean();


        }
        System.out.println("GAME FINISHED.");
        System.out.println("Thief`s moves:" + myTheif.getMoves());
        int totalPolicesMoves = 0;
        for (int i = 0; i < numberOfPolices; ++i) {
            totalPolicesMoves += myPolices[i].getMoves();

        }
        System.out.println("Total polices moves:" + totalPolicesMoves);


    }


}