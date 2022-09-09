package Test;
import java.util.*;
import java.util.Arrays;
public class tictactoee {
    static void go(int[][] arr,int n)
    {
    	arr[(n-1)/3][(n-1)%3]=0;
    }
    static void go2(int[][] arr,int n)
    {
    	if(arr[(n-1)/3][(n-1)%3]==9) arr[(n-1)/3][(n-1)%3]=1;
    	else 
    	{
    		Scanner sc2= new Scanner(System.in);
    		System.out.println("Already Occupied!! Enter another position:");
    		int p= sc2.nextInt();
    		go2(arr,p);
    	}
    }
    static int board(int[][] arr,int t)
    {
    	return arr[(t-1)/3][(t-1)%3];
    }
    static boolean posswin(int[][] arr,int m,boolean player)
    {
    	int flagz=0;
    	int temp=0;
    	if(arr[(m-1)/3][(m-1)%3]==9) flagz=1;
    	else { temp=arr[(m-1)/3][(m-1)%3]; }
    	if(player==false) {
    		go(arr,m); }
    	else arr[(m-1)/3][(m-1)%3]=1;
    	if((rowdown(arr)==true || coldown(arr)==true || diagdown(arr)==true) && flagz==1)
    	{
    		arr[(m-1)/3][(m-1)%3]=9;
    		return true;
    	}
    	else 
    		if(flagz==1) { arr[(m-1)/3][(m-1)%3]=9; }
    		else arr[(m-1)/3][(m-1)%3]=temp;
    		return false;
    }	
    static boolean posswin2(int[][] arr,int m,boolean player)
    {
    	int flagz=0;
    	int temp=0;
    	if(arr[(m-1)/3][(m-1)%3]==9) flagz=1;
    	else { temp=arr[(m-1)/3][(m-1)%3]; }
    	arr[(m-1)/3][(m-1)%3]=1;
    	//System.out.println(rowdown(arr)+" "+coldown(arr)+" "+diagdown(arr));
    	if((rowdown(arr)==true || coldown(arr)==true || diagdown(arr)==true) && flagz==1)
    	{
    		arr[(m-1)/3][(m-1)%3]=9;
    		return true;
    	}
    	else 
    		if(flagz==1) { arr[(m-1)/3][(m-1)%3]=9; }
    		else arr[(m-1)/3][(m-1)%3]=temp;
    		return false;
    }	
    static boolean rowdown(int[][] arr)
    {
    	int flag=0;
    	for(int i=0;i<3;i++)
    	{
    		if(arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i] && arr[0][i]!=9)
    		{
    			flag=1;
    			break;
    		}
    		else flag=0;
    	}
    	if(flag==0) return false;
    	else return true;
    }
    static boolean coldown(int[][] arr)
    {
    	int flag2=0;
    	for(int j=0;j<3;j++)
    	{
    		if(arr[j][0]!=9) {
    		if(arr[j][0]==arr[j][1] && arr[j][1]==arr[j][2] && arr[j][0]!=9)
    		{
    			flag2=1;
    			break;
    		}
    		else flag2=0;
    	}}
    	if(flag2==1) return true;
    	else return false;
    }
    static boolean diagdown(int[][] arr)
    {
    	if(arr[1][1]!=9) {
    	if(arr[1][1]==arr[0][0] && arr[1][1]==arr[2][2]) return true;
    	else if(arr[1][1]==arr[2][0] && arr[1][1]==arr[0][2]) return true;
    	else return false;}
    	else return false;
    }
    static void makemove(int[][] arr)
    {
        if(board(arr,7)==9) go(arr,7);
        else if(arr[0][1]==9) go(arr,2);
        else if(board(arr,4)==9) go(arr,4);
        else if(board(arr,8)==9) go(arr,8);
        else go(arr,6);
    }
    static void show(int[][] arr)
    {
    	for(int i=0;i<3;i++)
    	{
    		System.out.println("  "+arr[i][0]+"  "+arr[i][1]+"  "+arr[i][2]);
    	}
    }
    
    public static void main(String[] args)
    {
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
    	if(c.equals("n"))
    	{
    		show(arr);
    		System.out.println("Computer's turn!");
    		go(arr,5);
    		show(arr);
    		System.out.println("Its your turn! Make a move:(0-9)");
    		int k= sc.nextInt();
    		go2(arr,k);
    		show(arr);
    		System.out.println("Computer's turn!");
    		if(board(arr,1)==9) go(arr,1);
    		else go(arr,3);
    		show(arr);
    		System.out.println("Its your turn! Make a move:(0-9)");
    		int l= sc.nextInt();
    		go2(arr,l);
    		show(arr);
    		System.out.println("Computer's turn!");
    		if(posswin(arr,7,false)==true && board(arr,7)==9) 
    		{
    			go(arr,7);
    			System.out.println("Comp Wins!!");
    			winner=1;
    			show(arr);
    		}
    		else if(posswin(arr,9,false)==true && board(arr,9)==9)
    		{
    			go(arr,9);
    			System.out.println("Comp Wins!!");
    			winner=1;
    			show(arr);
    		}
    		else
    		{ 
    			if(posswin(arr,8,true)==true && board(arr,8)==9) go(arr,8);
    		    else { if(posswin(arr,7,true)==true && board(arr,7)==9) go(arr,7);
    		    else { if(posswin(arr,4,true)==true && board(arr,4)==9) go(arr,4);
    		    else { if(posswin(arr,6,true)==true && board(arr,6)==9) go(arr,6);
    		    else { if(posswin(arr,3,true)==true && board(arr,3)==9) go(arr,3);
    		    else { if(board(arr,3)==9) go(arr,3);
    		    else makemove(arr);}}}}}
    			show(arr);
    		}
    		if(winner!=1)
    		{
    			System.out.println("Its your turn! Make a move:(0-9)");
        		int z= sc.nextInt();
        		go2(arr,z);
        		show(arr);
        		System.out.println("Computer's turn!");
        		int flag4=0;
        		int winner2=0;
        		for(int h=1;h<=9;h++)
        		{
        			if(posswin(arr,h,false)==true && board(arr,h)==9)
        			{
        				go(arr,h);
        				flag4=1;
        				winner2=1;
        				show(arr);
        				break;
        			}
        		}
        		if(flag4==0 && winner2==0) {
        				for(int g=1;g<=9;g++)
        				{
        					if(posswin(arr,g,true)==true && board(arr,g)==9) 
        					{
        						go(arr,g);
        						flag4=1;
        						winner2=1;
        						show(arr);
        						break;
        					}
        				}
        				if(flag4==0 && winner2==0) makemove(arr); show(arr);
        			}
        		if(winner2==0) {
        		System.out.println("Its your turn! Make a move:(0-9)");
        		int y= sc.nextInt();
        		go2(arr,y);
        		show(arr);
        		System.out.println("Computer's turn!");
        		for(int e=0;e<3;e++)
        		{
        			for(int f=0;f<3;f++)
        			{
        				if(arr[e][f]==9)
        				{
        					if(posswin(arr,((e*3)+(f%3)+1),false)==true)
        					{
        						go(arr,((e*3)+(f%3)+1));
        						System.out.println("Comp Wins!!");
        						show(arr);
        					}
        					else
        					{
        						go(arr,((e*3)+(f%3)+1));
        						System.out.println("Match Drawn!! Well Played!!");
        						show(arr);
        					}
        				}
        			}
        		}}
        		else System.out.println("Comp Wins!! Well Played!!");
    		}
    		else System.out.println("Better Luck Next Time!");;
    	}
    	
    	else if(c.equals("y"))
    	{
    		int winner2=0;
    		show(arr);
    		System.out.println("Enter a number to start:(0-9):");
    		int k2= sc.nextInt();
    		go2(arr,k2);
    	    show(arr);
    	    System.out.println("Computer's turn!");
    	    if(board(arr,5)==9) go(arr,5);
    	    else go(arr,1);
    	    show(arr);
    	    System.out.println("Its your turn! Make a move:(0-9)");
    		int z= sc.nextInt();
    		go2(arr,z);
    		show(arr);
    		System.out.println("Computer's turn!");
    		
    		/*int flag3=0;
    		for(int q=1;q<=9;q++)
    		{
    			if(posswin(arr,q,true)==true && board(arr,q)==-1)
    			{
    				go(arr,q);
    				flag3=1;
    				show(arr);
    				break;
    			}
    		}*/
    		int flagu=0;
    		for(int u=1;u<=9;u++)
    		{
    			if(posswin2(arr,u,true)==true && board(arr,u)==9)
    			{
    				go(arr,u);
    				flagu=1;
    				//System.out.println(posswin2(arr,u,true)+" "+u);
    				break;
    			}
    		}
    		//if(flagu==1) go(arr,flagu);
    		/*if(posswin(arr,8,true)==true && board(arr,8)==9) go(arr,8);
    		else { if(posswin(arr,9,true)==true && board(arr,9)==9) go(arr,9);
		    else { if(posswin(arr,7,true)==true && board(arr,7)==9) go(arr,7);
		    else { if(posswin(arr,4,true)==true && board(arr,4)==9) go(arr,4);
		    else { if(posswin(arr,6,true)==true && board(arr,6)==9) go(arr,6);
		    else { if(posswin(arr,3,true)==true && board(arr,3)==9) go(arr,3);
		    else { if(posswin(arr,2,true)==true && board(arr,2)==9) go(arr,2); 
		    else { if(posswin(arr,1,true)==true && board(arr,1)==9) go(arr,1);*/
		    if(flagu==0) makemove(arr);//}//}}}}}}
			show(arr);
    		//if(flag3==0) { makemove(arr); show(arr); }		
    			
    		System.out.println("Its your turn! Make a move:(0-9)");
    		int r= sc.nextInt();
    		go2(arr,r);
    		show(arr);
    		System.out.println("Computer's turn!");
    		
    		for(int i=1;i<=9;i++)
    		{
    			if(posswin(arr,i,false)==true && board(arr,i)==9)
    			{
    				go(arr,i);
    				System.out.println("Comp Wins!!");
    				winner2=1;
        			show(arr);
        			break;
    			}	
    		}
    		if(winner2!=1) {
    			int flagw=0;
    			for(int w=1;w<9;w++)
    			{
    				if(posswin(arr,w,true)==true && board(arr,w)==9) {
    					go(arr,w);
    					flagw=1;
    					show(arr);
    					break;
    				}
    			}
    			if(flagw==0) {
    				makemove(arr);
    				show(arr);
    			}
    			System.out.println("Its your turn! Make a move:(0-9)");
        		int a= sc.nextInt();
        		go2(arr,a);
        		show(arr);
        		System.out.println("Computer's turn!");
        		
        		int winner5=0;
        		for(int d=1;d<9;d++)
        		{
        			if(posswin(arr,d,false)==true && board(arr,d)==9)
        			{
        				go(arr,d);
        				System.out.println("Comp Wins!");
        				show(arr);
        				winner5=1;
        				break;
        			}
        		}
        		if(winner5==0) {
        		int flagb=0;
        		for(int b=1;b<9;b++)
        		{
        			if(posswin(arr,b,true)==true && board(arr,b)==9)
        			{
        				go(arr,b);
        				flagb=1;
        				show(arr);
        				break;
        			}
        		}
        		if(flagb==0) { makemove(arr); show(arr); }
        		
        		for(int e=0;e<3;e++)
        		{
        			for(int f=0;f<3;f++)
        			{
        				if(arr[e][f]==9)
        				{
        						go2(arr,((e*3)+(f%3)+1));
        						System.out.println("Match Drawn!! Well Played!!");
        						show(arr);	
        				}
        			}
        		}
        		
    		}
        }			
    }
    	
    	else System.out.println("Please dont!!!");
    	
    }
}
