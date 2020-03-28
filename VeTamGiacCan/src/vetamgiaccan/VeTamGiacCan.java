/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetamgiaccan;

/**
 *
 * @author AnhTu
 */
public class VeTamGiacCan {
    
    static void inTG(int n) {
        int i=0,k=0,j,m=0; //i laf chir soos hangf cuar tam giac, j laf chir soos cootj
	for(i=1; i<=n; i++) {
		for(j=1; j<=n+i-1; j++)  {
			if(j<(n-i+1)) System.out.print("   ");
			else if(j<=n) for(k=1; k<=i; k++) System.out.print(" "+k+" ");
			else if(j<=n+i-1) for(m=i-1; m>0; m--)  System.out.println(" "+m+" ");
		}
		          System.out.println("\n");
	}
    }
    public static void main(String[] args) {
        int p = 5;
        inTG(p);
    }
    
}
