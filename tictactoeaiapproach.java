package Test;
import java.util.*;
public class tictactoeaiapproach {
    static int board(int[][] arr,int t) {
    	return arr[(t-1)/3][(t-1)%3];
    }
    static void go(int[][] arr,int n) {
    	arr[(n-1)/3][(n-1)%3]=0;
    }
    static void go2(int[][] arr,int n)
    {
    	//if(board(arr,n)==9) 
    	arr[(n-1)/3][(n-1)%3]=1;
    	/*else 
    	{
    		Scanner sc2= new Scanner(System.in);
    		System.out.println("Already Occupied!! Enter another position:");
    		int p= sc2.nextInt();
    		go2(arr,p);
    	}*/
    }
    static void add(int[][] arr,int n,int value) {
    	arr[(n-1)/3][(n-1)%3]+=value;
    }
    static void show(int[][] arr) {
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<arr.length;j++) {
    			System.out.print(" "+arr[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    static int[][] heur(int[][] arr) {
        int[][] heuristic= new int[3][3];
        for(int x=0;x<3;x++)
    	{
    		for(int y=0;y<3;y++)
    		{
    			heuristic[x][y]=0;
    		}
    	}
    	for(int i=1;i<10;i++) {
        	if(board(arr,i)==9) {
        	  go(arr,i);
        	  if(coldown(arr,i)) add(heuristic,i,100);
        	  if(rowdown(arr,i)) add(heuristic,i,100);
        	  if(diagdown(arr,i)) add(heuristic,i,100);
        	  if(coldown(arr,i)==false && coldown1(arr,i)==true) add(heuristic,i,10);
        	  if(rowdown(arr,i)==false && rowdown1(arr,i)==true) add(heuristic,i,10);
        	  if(diagdown(arr,i)==false && diagdown1(arr,i)==true) add(heuristic,i,10);
        	  go2(arr,i);
        	  if(coldown(arr,i)) add(heuristic,i,-100);
        	  if(rowdown(arr,i)) add(heuristic,i,-100);
        	  if(diagdown(arr,i)) add(heuristic,i,-100);
        	  if(coldown(arr,i)==false && coldown1(arr,i)==true) add(heuristic,i,-10);
        	  if(rowdown(arr,i)==false && rowdown1(arr,i)==true) add(heuristic,i,-10);
        	  if(diagdown(arr,i)==false && diagdown1(arr,i)==true) add(heuristic,i,-10);
        	  arr[(i-1)/3][(i-1)%3]=9;
        	}
        }
    	return heuristic;
    }
    static int bestmove(int[][] arr) {
    	int  max=Integer.MIN_VALUE;
    	int min=Integer.MAX_VALUE;
    	int maxpos=0;
    	int minpos=0;
    	for(int i=1;i<=9;i++) {
    		if(board(arr,i)>max) {
    			max= board(arr,i);
    			maxpos=i;
    		}
    		if(board(arr,i)<min) {
    			min= board(arr,i);
    			minpos=i;
    		}
    	}
    	if(max>=70) return maxpos;
    	else if(min<=-70) return minpos;
    	else if(max>=10) return maxpos;
    	else if(min<=0) return minpos;
    	else return maxpos;
    }
       static boolean coldown(int[][] arr,int n) {
    	int row= (n-1)/3;
    	int col= (n-1)%3;
    	if(arr[0][col]==arr[1][col] && arr[1][col]==arr[2][col] && arr[0][col]!=9) return true;
    	return false;
    }
   static boolean rowdown(int[][] arr,int n) {
	   int row= (n-1)/3;
	   if(arr[row][0]==arr[row][1] && arr[row][1]==arr[row][2] && arr[row][0]!=9) return true;
	   return false;
  }
   static boolean diagdown(int[][] arr,int n) {
	   int row= (n-1)/3;
       int col= (n-1)%3;
       if(n==2 || n==4 || n==6 ||n==8) return false;
       else if(board(arr,5)==board(arr,1) && board(arr,5)==board(arr,9)) return true;
       else if(board(arr,5)==board(arr,3) && board(arr,5)==board(arr,7)) return true;
       return false;
   }
   static boolean rowdown1(int[][] arr,int n) {
	   int row= (n-1)/3;
	   if(arr[row][0]==arr[row][1] && arr[row][1]!=arr[row][2] && arr[row][2]==9) return true;
	   else if(arr[row][0]!=arr[row][1] && arr[row][1]==arr[row][2] && arr[row][0]==9) return true;
	   return false;
   }
   static boolean coldown1(int[][] arr,int n) {
	   int col= (n-1)%3;
	   if(arr[0][col]==arr[1][col] && arr[1][col]!=arr[2][col] && arr[2][col]==9) return true;
	   else if(arr[0][col]!=arr[1][col] && arr[1][col]==arr[2][col] && arr[0][col]==9) return true;
	   return false;
   }
   static boolean diagdown1(int[][] arr,int n) {
	   if(n==2 || n==4 || n==6 ||n==8) return false;
       else if(board(arr,5)==board(arr,1) && board(arr,5)!=board(arr,9) && board(arr,9)==9) return true;
       else if(board(arr,5)==board(arr,3) && board(arr,5)!=board(arr,7) && board(arr,7)==9) return true;
       else if(board(arr,5)!=board(arr,1) && board(arr,5)==board(arr,9) && board(arr,1)==9) return true;
       else if(board(arr,5)!=board(arr,3) && board(arr,5)==board(arr,7) && board(arr,3)==9) return true;
       return false;
   }
   static void playerturn(int[][] arr) {
	   Scanner sc2= new Scanner(System.in); 
	   System.out.println("Its your turn! Make a move:(0-9)");
		int k= sc2.nextInt();
		go2(arr,k); 
		show(arr);
   }
   static void checkwin(int[][] arr)
   {
	int winner=0;
   	for(int i=1;i<=9;i++) {
	   if(rowdown(arr,i) || coldown(arr,i) || diagdown(arr,i))
   	{
   		winner=1;
   	}
   }
   	if(winner==1) {
   		System.out.println("Comp  Wins!!");
   		show(arr);
   		System.exit(0);
   	}
   	else show(arr);
   }
   public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
   	int[][] arr= new int[3][3];
   	for(int x=0;x<3;x++)
   	{
   		for(int y=0;y<3;y++)
   		{
   			arr[x][y]=9;
   		}
   	}
   	System.out.println("Welcome to the Game!!");
   	System.out.println("Blank spaces are represented by 9!!");
   	System.out.println("You play with 1!! Comp plays with 0!!");
   	System.out.println("Would you like to start?(y/n)");
   	String c= sc.next();
   	int winner=0;
   	if(c.equals("n")) {
   		show(arr);
		System.out.println("Computer's Turn!");
		go(arr,5);
		show(arr);
		playerturn(arr);
		System.out.println("Computer's Turn!");
		if(board(arr,1)==9) go(arr,1);
		else go(arr,3);
   		show(arr);
   		playerturn(arr);
   		System.out.println("Computer's Turn!");
   		go(arr,bestmove(heur(arr)));
   		checkwin(arr);
   		playerturn(arr);
   		System.out.println("Computer's Turn!");
   		go(arr,bestmove(heur(arr)));
   		checkwin(arr);
   		playerturn(arr);
   		for(int k1=1;k1<=9;k1++) {
   			if(board(arr,k1)==9) {
   				go(arr,k1);
   				checkwin(arr);
   			}
   		}
   		System.out.println("Match Drawn!! Well Played!!");
   	}
   	
   	else if(c.equals("y")) {
   		playerturn(arr);
   		System.out.println("Computers Turn!");
   		if(board(arr,5)==9) { go(arr,5); }
   		else { go(arr,1); }
   		show(arr);
   		playerturn(arr);
   		int[][] ans=heur(arr);
   		/*for(int i=0;i<3;i++) {
   			for(int j=0;j<3;j++) {
   				System.out.print(ans[i][j]+" ");
   			}
   			System.out.println();
   		}*/
   		System.out.println("Computer's Turn!!");
   		go(arr,bestmove(heur(arr)));
   		show(arr);
   		playerturn(arr);
   		System.out.println("Computer's Turn!!");
   		go(arr,bestmove(heur(arr)));
   		checkwin(arr);
   		playerturn(arr);
   		System.out.println("Computer's Turn!!");
   		go(arr,bestmove(heur(arr)));
   		checkwin(arr);
   		for(int k1=1;k1<=9;k1++) {
   			if(board(arr,k1)==9) {
   				go2(arr,k1);
   				break;
   			}
   		}
   		System.out.println("Match Drawn!! Well Played!!");
   		show(arr);
   	}
   }
}
