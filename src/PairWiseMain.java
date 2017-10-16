/**
 * @author Urvashi
 *
 */
import java.util.*;

import java.math.*;
import java.awt.Color;
import java.lang.*;
public class PairWiseMain {
	public char[][] SubscriptS;
	public char[][] SubscriptIns;
	public char[][] SubscriptDel;
	
	public String X,Y;
	 double[][] S ;
	 double[][] Ins;
	 double[][] Del;
	Scanner scan= new Scanner(System.in);
	public  double ext=1;
	public  double op=6;
	public void GetInput(){
		System.out.println("Enter the first string X exclusively ACGT");
		 X= scan.next();
		 int x=X.length();
		System.out.println("Enter the second string exclusively ACGT ");
		 Y=scan.next();
		 int y= Y.length();
		 InitializeTable(x,y);
	}
	public void InitializeTable(int x, int y){
		  S = new double[x+1][y+1];
		  Ins= new double[x+1][y+1];
		  Del= new double[x+1][y+1];
		  SubscriptS= new char[x+1][y+1];
		  SubscriptIns= new char[x+1][y+1];
		 SubscriptDel= new char[x+1][y+1];
		  S[0][0]=0;
		  SubscriptS[0][0]='S';
		 //Del[1][0]=-op;
		// SubscriptDel[1][0]='S';
		// Ins[0][1]=-op;
		// SubscriptIns[0][1]='S';
		  for(int i=0;i<x+1;i++){
			  Ins[i][0]=Double.NEGATIVE_INFINITY;
			  SubscriptIns[i][0]='I';
			  
		  }
		  for(int i=0;i<y+1;i++){
			  Del[0][i]=Double.NEGATIVE_INFINITY;
			  SubscriptDel[0][i]='D';
			 
		  }
		  for(int i=1;i<x+1;i++){
			  S[i][0]=Double.NEGATIVE_INFINITY;
			  SubscriptS[i][0]='S';
			  Del[i][0]=DelTable(i,0,S,Del);
			  
		  }
		  for(int i=1;i<y+1;i++){
			  S[0][i]=Double.NEGATIVE_INFINITY;
			  SubscriptS[0][i]='S';
			  Ins[0][i]=InsTable(0,i,S,Ins);
			 
			  
		  }
		  
		  
		  
		  for(int i=1;i<x+1;i++){
				for(int j=1;j<y+1;j++){
					
						S[i][j]=Stable(i,j,S,Ins,Del,X,Y);
						Ins[i][j]=InsTable(i,j,S,Ins);
						Del[i][j]= DelTable(i,j,S,Del);
					
					
			
				}
				
			}
		  
	}
	public void PrintTable(){
		System.out.println();
		System.out.print("***S Table***");
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(S[i][j]+"   ");
			}
			
		}
		System.out.println("\n");
		System.out.print("*Subscript table for S*");
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(SubscriptS[i][j]+"   ");
			}
			
		}
		System.out.println("\n");
		System.out.print("***Insert Table***");
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(Ins[i][j]+"   ");
			}
			
		}
		System.out.println("\n");
		System.out.print("*Subscript Table for I*");
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(SubscriptIns[i][j]+"   ");
			}
			
		}
		System.out.println("\n");
		System.out.print("***Deletion Table***");
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(Del[i][j]+"   ");
			}
			
		}
		
		
		System.out.println("\n");
		System.out.print("*Subscript Table for D*");
		
		for(int i=0;i<X.length()+1;i++){
			System.out.println();
			for(int j=0;j<Y.length()+1;j++){
				System.out.print(SubscriptDel[i][j]+"   ");
			}
			
		}
		TraceAlignment(X.length(),Y.length(),SubscriptS);
		System.out.println();
		for(int i=S1.length()-1;i>=0;i--){
			System.out.print(S1.charAt(i)+ " ");
		}
		System.out.println();
		for(int i=S2.length()-1;i>=0;i--){
			System.out.print(S2.charAt(i)+ " ");
		}
	}
	public String S1="" ,S2="";
	public int p,q;
	public void TraceAlignment(int i,int j,char[][] temp){
		
		
		
			if(i==0 && j==0){
				S1=S1+' ';	
				S2=S2+' ';
			}
			
		else{
		if(temp==SubscriptS){
			 p=i-1;
			 q=j-1;
			   S1=S1+X.charAt(i-1);
				S2=S2+Y.charAt(j-1);
			 
		}
		else if(temp==SubscriptIns){
			p=i; 
			q=j-1; 
			S1=S1+'_';
			S2=S2+Y.charAt(j-1);
		}
		else if(temp==SubscriptDel){
			p=i-1;
			q=j;
			S1=S1+X.charAt(i-1);
			S2=S2+'_';
		}
		if(temp[i][j]=='S'){
			TraceAlignment(p,q,SubscriptS);
		}
		else if(temp[i][j]=='I'){
			
			TraceAlignment(p,q,SubscriptIns);
						
		}
		else if(temp[i][j]=='D'){
			
			TraceAlignment(p,q,SubscriptDel);
			
				}
		} 
			
		}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairWiseMain p= new PairWiseMain();
		p.GetInput();
		p.PrintTable();
		
	
	}
	
	public  double Stable(int i, int j, double[][] S,double[][] Ins, double[][] Del,String X, String Y){
		double v,score;
		
		if(X.charAt(i-1)==Y.charAt(j-1))
			 score=5;
		else
			 score=-2;
		v=Math.max(S[i-1][j-1]+score,(Math.max(Ins[i-1][j-1]+score,Del[i-1][j-1]+score )) );
		if((S[i-1][j-1]+score>Ins[i-1][j-1]+score) &&(S[i-1][j-1]+score>Del[i-1][j-1]+score)) 
			SubscriptS[i][j]='S';
			
			else if(Del[i-1][j-1]+score>S[i-1][j-1]+score && (Del[i-1][j-1]+score>Ins[i-1][j-1]+score ))
				SubscriptS[i][j]='D';
		
		else SubscriptS[i][j]='I';
		return v;
		
	}
	public double InsTable(int i, int j, double[][] S,double[][] Ins){
		double v;
		v=Math.max(S[i][j-1]-op,Ins[i][j-1]-ext);
		if(S[i][j-1]-op>Ins[i][j-1]-ext){
			SubscriptIns[i][j]='S';
		}
		else SubscriptIns[i][j]='I';
		return v;
		
	}
	public double DelTable(int i, int j, double[][] S, double[][] Del){
		double v;
		v=Math.max(S[i-1][j]-op,Del[i-1][j]-ext);
		if(S[i-1][j]-op>Del[i-1][j]-ext){
			SubscriptDel[i][j]='S';
		}
		else SubscriptDel[i][j]='D';
		return v;
		
	}
	public double Neg(){
		double v=Double.NEGATIVE_INFINITY;
		return v;
	}

}
