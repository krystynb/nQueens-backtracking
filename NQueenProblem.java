// this class solves the N Queens problem in a NxN chessboard
// author: Krystyn Bondad

import java.util.*;
public class NQueenProblem {
    
    private int nQ;
    private String[][] board;
    private int qCount;

    public NQueenProblem(int n) {
        nQ = n;
        board = new String[nQ][nQ];
        qCount = 0;
    }


    public boolean checkSolution()
    {   
        //initialize x,y coordinates where there are already queens
        HashSet<Integer> iVals = new HashSet<Integer>();
        HashSet<Integer> jVals = new HashSet<Integer>();

        //begin
        for (int i = 0; i < nQ; i++){
            for (int j = 0; j < nQ; j++){ 

                //set first Q and specify xy coordinates in appropriate HashSets, increment qCount 
                board[i][j] = "Q";
                qCount++;
                iVals.add(i);
                jVals.add(j);

                //test the board for solutions with the first Q location set
                if (testboard(i, j, iVals, jVals))
                    return true;
                
                //if no solutions, reset the board and the HashSets, decrement qCount
                board[i][j] = null;
                iVals.remove(i);
                jVals.remove(j);
                qCount--;
            }
        }
        return false;
    }

    //recursive method testboard, tests the board for any solutions after the first Q location is set
    public boolean testboard(int i, int j, HashSet<Integer> iVals, HashSet<Integer> jVals){

        //return true if all the Queens have already been placed 
        if (qCount == nQ)
            return true; 
        
        //check all valid locations on the board for conflicts
        for (int a = 0; a < nQ ; a++){
            if (!iVals.contains(a)){   //the row cannot already have a queen on it anywhere
                for (int b = 0; b < nQ; b++){  
                    if (!jVals.contains(b)){   //col cannot have a queen placed on it anywhere
                        
                        //if the diagonals of the location do not cause conflicts, place queen 
                        if (checkDiagonal (a,b))
                        {
                            board[a][b] = "Q";
                            qCount++;
                            iVals.add(a);
                            jVals.add(b);
                            
                            //recursive call, check the board starting at the most recently placed Queen
                            if (testboard(a, b, iVals, jVals)) 
                                return true;
                                
                            board[a][b]  = null;
                            qCount--; 
                            iVals.remove(a);
                            jVals.remove(b);
                        }
                    }
                }
            }
        }         

        return false;
    }

    //checks the diagonals of the proposed location to make sure there are no conflicts
    public boolean checkDiagonal(int a, int b){
        for (int i = 1; i < nQ; i++){

            //if we are off the board in all directions, break
            if (!(a + i < nQ || b + i < nQ || a - i >= 0 || b - i >= 0))
                break;
            
            //check the top right direction
            if(a + i < nQ  && b + i < nQ )
            {
                if (board[a+i][b+i] == "Q")
                    return false;
            }

            //top left direction
            if(a - i >= 0 && b - i >= 0)
            {
                if (board[a-i][b-i] == "Q")
                    return false;
            }

            //bottom left direction
            if(a + i < nQ && b - i >= 0)
            {
                if (board[a+i][b-i] == "Q")
                    return false;
            }

            //top right direction
            if(a - i >= 0 && b + i < nQ)
            {
                if (board[a-i][b+i] == "Q")
                    return false;
            }
        }
        return true;
    }
        
    //prints output after checking for a solution
    public void solveNQ(){
        if (checkSolution())
            System.out.println(this.toString());

        else 
            System.out.println("Solution does not exist");
            
    }
        
    //toString method to make life easier
    public String toString(){
        String stringbuilder= "";
        for (int i = 0; i < nQ; i++){
            for (int j = 0; j < nQ; j++)
            {
                if (board[i][j] == "Q")
                    stringbuilder += "Q ";
                else
                    stringbuilder += ". ";
                
            }
            stringbuilder += "\n";
        }
        return stringbuilder;
    }


    public int getnQ() {
        return nQ;
    }


    public void setnQ(int nQ) {
        this.nQ = nQ;
    }


    public String[][] getBoard() {
        return board;
    }


    public void setBoard(String[][] board) {
        this.board = board;
    }


    public int getqCount() {
        return qCount;
    }


    public void setqCount(int qCount) {
        this.qCount = qCount;
    }
}


