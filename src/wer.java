import java.io.*;
import java.util.*;
import java.lang.*;


public class wer 

{
//static int wc=0;
	static long err_count=0;
	static long total_words=0;
	static double wer_final=0;
	public static void main(String args[]) throws Exception 
	{
	FileReader ref_file = new FileReader(args[0]); 
	FileReader test_file = new FileReader(args[1]); 
	BufferedReader br = new BufferedReader(ref_file);
	BufferedReader br2= new BufferedReader(test_file);
	String s,t;
	int i=0; int count=0;
	String ref[] = new String[200];
	String test[]= new String[200];
	t=br2.readLine();
	
	while((s=br.readLine())!= null&&t!=null) 
	{	
		/* Token Parsing */
		StringTokenizer st = new StringTokenizer(s," ");
		StringTokenizer st2 = new StringTokenizer(t," ");
		while (st.hasMoreTokens()&&st2.hasMoreTokens())
		{
			if(count<50) // placing a count of no of words processed each time
				{
				ref[i] = st.nextToken();
				test[i]= st2.nextToken();	
				// Do stuff !!
				for(int c=0;c<50;c++) // initialize the arrays acc to chars
				{
					int a,b;
					int r1=ref[i].length();
					int t1=test[i].length();
					char[] reference= new char[20];
					char[] testword= new char[20];
					int[][] mat=new int[r1][t1];
					for(a=0;a<ref[i].length();a++)  //copy the string in char array
						{
						reference[a]=ref[i].charAt(a);
						}
					for(a=0;a<t1;a++)  //copy the string in char array
					{
					testword[a]=test[i].charAt(a);
					total_words++;
					}
					for(int a1=0;a1<r1;a1++)
					{
						mat[a1][0]=a1;
					}
					for(int a2=0;a2<t1;a2++)
					{
						mat[0][a2]=a2;
					}
					
					// Calculating matrix
					for(int l1=1;l1<r1;l1++)
					{
						for(int l2=1;l2<t1;l2++)
						{
							if(l1==l2)
							{
								if(reference[l1]==testword[l2])
									mat[l1][l2]=0;
							}
							else
							{
								if(l1==1 || l2==1)
									{mat[l1][l2]=Math.min((mat[l1-1][l2]+1),(mat[l1][l2-1]+1));}
								if(l1>1 && l2>1)
									mat[l1][l2]=Math.min((mat[l1-1][l2]+1), Math.min((mat[l1][l2-1]+1), (mat[l1-1][l2-1]+1)));
								
							}
						}
					}
					err_count+=mat[r1-1][t1-1];
					System.out.println(mat[r1-1][t1-1]+"    "+"errors:"+err_count+"     Out Of "+total_words+"  characters");
					
					// printing the matrix for @fun !!
					//System.out.println(mat[r1-1][t1-1]);
					//System.out.print("    "+ (double)());
					/*for(int f22=0;f22<r1;f22++)
						{for(int f23=0;f23<t1;f23++)
							{System.out.print(mat[f22][f23]+"   ");} System.out.println();} */
				}
				i++;
				count++;
				}
			else count=i=0;
		}
		
		//System.out.println("Working WHILE loop"+wc);wc++;	
     }
	//System.out.println("Working till here");
	
	}
}