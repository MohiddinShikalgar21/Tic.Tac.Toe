package Test;
import java.util.*;

public class tictactoenonai {
    static void go(int[][] arr,int n)
    	{
    		arr[(n-1)/3][(n-1)%3]=0;
    	}
    static void go2(int[][] arr,int n)
        {
        	arr[(n-1)/3][(n-1)%3]=1;
        }
    static int board(int[][] arr,int t)
    {
    	return arr[(t-1)/3][(t-1)%3];
    }
    static int random(int[][] arr,int m)
    {
    	
    	int max=m;
    	int min=1;
    	int random= (int) (Math.random()*(max-min+1)+min);
    	if(board(arr,random)==9) return random;
    	else return random(arr,m);
    	
    }
    static void show(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			System.out.print(" "+arr[i][j]+"  ");
    		}
    		System.out.println();
    	}
    }
    static boolean rowdown(int[][] arr)
    {
    	int flag=0;
    	for(int i=0;i<3;i++)
    	{
    		if(arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2] && arr[i][0]!=9)
    		{
    			flag=1;
    		}
    	}
    	if(flag==0) return false;
    	else return true;
    }
    static boolean coldown(int[][] arr)
    {
    	int flag=0;
    	for(int i=0;i<3;i++)
    	{
    		if(arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i] && arr[i][0]!=9)
    		{
    			flag=1;
    		}
    	}
    	if(flag==0) return false;
    	else return true;
    }
    static boolean diagdown(int[][] arr)
    {
    	int flag=0;
    	if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0]!=9) flag=1;
    	else if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[1][1]!=9) flag=1;
    	if(flag==0) return false;
    	else return true;
    }
    static boolean posswin(int[][] arr)
    {
    	if(rowdown(arr) || coldown(arr) || diagdown(arr))
    	{
    		return true;
    	}
    	else return false;
    }
    public static void main(String[] args)
    {
    	Scanner sc= new Scanner(System.in);
    	int[][] arr= new int[3][3];
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			arr[i][j]=9;
    		}
    	}
    	System.out.println("Welcome to the Game!!");
    	System.out.println("Blank spaces are represented by 9!!");
    	System.out.println("You play with 1!! Comp plays with 0!!");
    	System.out.println("Would You Like To Start!?!(y/n)");
    	String s= sc.next();
    	if(s.equals("y") || s.equals("Y"))
    	{
    		System.out.println("Enter a position between 1 to 9:");
    		int n= sc.nextInt();
        	go2(arr,n);
        	show(arr);
        	System.out.println("Computer's Turn!!");
        	go(arr,random(arr,9));
        	show(arr);
        	System.out.println("Your Turn!! Enter Your Move:");
        	int n2= sc.nextInt();
        	go2(arr,n2);
        	show(arr);
        	System.out.println("Computer's Turn!!");
        	go(arr,random(arr,9));
        	show(arr);
        	System.out.println("Your Turn!! Enter Your Move:");
        	int n3= sc.nextInt();
        	go2(arr,n3);
        	if(posswin(arr)==true)
        	{
        		System.out.println("You Win!!");
        		show(arr);
        	}
        	else{
        		show(arr);
            	System.out.println("Computer's Turn!!");
        		go(arr,random(arr,9));
        		if(posswin(arr)==true)
            	{
            		System.out.println("Comp Wins!!");
            		show(arr);
            	}
        		else {
        			show(arr);
        			System.out.println("Your Turn!! Enter Your Move:");
                	int n4= sc.nextInt();
                	go2(arr,n4);
                	if(posswin(arr)==true)
                	{
                		System.out.println("You Win!!");
                		show(arr);
                	}
                	else {
                		show(arr);
                    	System.out.println("Computer's Turn!!");
                		go(arr,random(arr,9));
                		if(posswin(arr)==true)
                    	{
                    		System.out.println("Comp Wins!!");
                    		show(arr);
                    	}
                		else {
                			show(arr);
                			for(int i=1;i<=9;i++)
                			{
                				if(board(arr,i)==9) {
                					go2(arr,i);
                					if(posswin(arr)==true)
                                	{
                                		System.out.println("You Win!!");
                                		show(arr);
                                	}
                					else {
                						System.out.println("Match Drawn!!");
                						show(arr);
                					}
                					break;
                				}
                			}
                		}
                	}
        		}
        	}
        	
    	}
    	else if(s.equals("n") || s.equals("N"))
    	{
    		System.out.println("Computer's Turn:");
    		go(arr,random(arr,9));
    		show(arr);
    		System.out.println("Your Turn!! Enter a position(1-9)!!");
    		int n= sc.nextInt();
    		go2(arr,n);
    		show(arr);
    		System.out.println("Computer's Turn:");
    		go(arr,random(arr,9));
    		show(arr);
    		System.out.println("Your Turn!! Make your move:");
    		int n2= sc.nextInt();
    		go2(arr,n2);
    		show(arr);
    		System.out.println("Computer's Turn:");
    		go(arr,random(arr,9));
    		if(posswin(arr)==true) {
    			System.out.println("Comp Wins!!");
    			show(arr);
    		}
    		else {
    			show(arr);
    			System.out.println("Your Turn!! Make your move:");
        		int n3= sc.nextInt();
        		go2(arr,n3);
        		if(posswin(arr)==true) {
        			System.out.println("You Win!!");
        			show(arr);
        		}
        		else {
        		    show(arr);
        		    System.out.println("Computer's Turn!!");
        		    go(arr,random(arr,9));
        		    if(posswin(arr)==true) {
        		    	show(arr);
        		    	System.out.println("Comp Wins!!");
        		    }
        		    else {
        		    	show(arr);
        		    	System.out.println("Your Turn!! Make your move:");
        	    		int n4= sc.nextInt();
        	    		go2(arr,n4);
        	    		if(posswin(arr)==true) {
        	    			show(arr);
        	    			System.out.println("You Win!!");
        	    		}
        	    		else {
        	    			show(arr);
        	    			for(int i=1;i<=9;i++)
        	    			{
        	    				if(board(arr,i)==9) {
        	    					go(arr,i);
        	    					if(posswin(arr)==true) {
        	    						System.out.println("Comp Wins!!");
        	    						show(arr);
        	    					}
        	    					else {
        	    						System.out.println("Match Drawn!!");
        	    						show(arr);
        	    					}
        	    				}
        	    			}
        	    		}
        		    }
        		}
    		}
    	}
    	else System.out.println("Please Don't!!!");
    }
}
