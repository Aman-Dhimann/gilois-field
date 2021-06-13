package crypto;

import java.util.Scanner;

public class giloi {
	public static void giloiMultiply(int size , String p1,String  p2,String mod) {
		int flag=0;
		String output1="0";
		String[] shiftleft=new String[size];
		String[] exor=new String[size];
		for (int i=0;i<size;i++) {
			/*if (p1.charAt(i)!=1 && p1.charAt(i)!=0 || p2.charAt(i)!=1 && p2.charAt(i)!=0 || mod.charAt(i)!=1 && mod.charAt(i)!=0) {
				System.out.println("enter the elements again");
				System.exit(0);}*/
		
				if (p1.charAt(i)=='1') {
					flag++;
			}
			
		}
		String []output=new String[flag];
		String []discard=new String[size-flag];
		int[] count =new int[size];
		int[] count1 =new int[size];
		for (int i=0;i<size;i++) {
			if (p1.charAt(i)=='0') {
				count[i]=0;
				
			}
			else {
				count[i]=1;
			}
		}for (int i=0;i<count.length;i++) {
				count1[count1.length-1-i]=count[i];
			}
		System.out.println("polynomial 1");
		for (int i=0;i<size;i++) {
			
			System.out.print(count1[i]+ " ");
		}
		System.out.println();
		
		
		exor[0]=p2;
		shiftleft[0]="00000000";
		for (int i=1;i<size;i++) {
			shiftleft[i]=leftrotate(exor[i-1],size);
			if (exor[i-1].charAt(0)=='1') {
				exor[i]=xoring(shiftleft[i],mod,size);
			
			}else {
				exor[i]=shiftleft[i];
			}
			
			
			
		}System.out.println("Powers "+ "shiftleft "+"         exoring");
		for (int i=0;i<size;i++) {
			System.out.println("x"+i+ "xorP2 "+ shiftleft[i]+ "          "+ exor[i]);
		}int j=0,k=0;
		for (int i=0;i<size;i++) {
			if (count1[i]==1) {
				output[j]=exor[i];
				j++;
				
			}else {
				discard[k]=exor[i];
				k++;
			}
				
		
		}System.out.println("result is:");
		for (int i=0;i<flag;i++) {
			System.out.println(output[i]+" xor");
		}if (output.length==1) {
			System.out.println("p1 x p2 ="+output[0]);
		}else {
		for (int i=0;i<flag-1;i++) {
			 output1=xoring(output[i],output[i+1],size);
			output[i+1]=output1;
		}
		System.out.println("p1 x p2 ="+output1);
	}}
	static String  xoring(String a, String b, int n){ 
	    String ans = ""; 
	          
	     
	        for (int i = 0; i < n; i++) 
	        { 
	         
	            if (a.charAt(i) == b.charAt(i)) 
	                ans += "0"; 
	            else
	                ans += "1"; 
	        } 
	        return ans; 
	    } 


static String leftrotate(String str, int d)
{
        String ans =   str.substring(1, d);
        String o="0";
        String answer=ans.concat(o);
        return answer;
}
public static void main(String []args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter 1st polynomial");
	String p1=sc.next();
	System.out.println("enter 2nd polynomial");
	String p2=sc.next();
	System.out.println("enter mod");
	String mod1=sc.next();
	String mod=mod1.substring(1);
	System.out.println("modulus for calculation :"+mod);
	System.out.println("enter the degree of the ploynomial");
	int si=sc.nextInt();
    giloiMultiply(si,p1,p2,mod);
	
	
	
}
}
