import java.util.Scanner;

class QueensDriver
{
   // Driver program to test above function
    public static void main(String args[])
    {
        Scanner myInput = new Scanner(System.in);
        System.out.print("How many queens? ");
        
        int numQueens = myInput.nextInt();
        myInput.close();
        System.out.println("\nSolution");
        NQueenProblem Queen = new NQueenProblem(numQueens);
        Queen.solveNQ();
    }
}
