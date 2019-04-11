package alg.uwec.edu;

import java.util.Scanner;

public class perm_Sub {
	
	private static void subset (int i) {
		
		int[] a = new int[i+1];
		
		System.out.print("\n");
		backtrack(a, 0, i, false);
		System.out.print("\n\n");
		
	}
	
	private static void perm (int i) {
		
		int[] a = new int[i+1];
		
		System.out.print("\n");
		backtrack(a, 0, i, true);
		System.out.print("\n\n");
		
	}
	
	private static void backtrack(int a[], int k, int in, boolean permutation) {
		
		int[] c = new int[in+1];
		int ncandidates = 0;
		
		if(is_a_solution(a, k, in)) {
			
			if(permutation) {
				perm_process_solution(a, k, in);
			} else {
				sub_process_solution(a, k);
			}
			
		} else {
			
			k++;
			
			if(permutation) {
				ncandidates = perm_construct_candidates(a, k, in, c, ncandidates);
			} else {
				ncandidates = sub_construct_candidates(a, k, in, c, ncandidates);
			}
			
			
			for(int d=0; d<ncandidates; d++) {
				a[k] = c[d];
				backtrack(a, k, in, permutation);
			}
		}
	}
	
	private static int perm_construct_candidates(int a[], int k, int n, int c[], int ncandidates) {
		
		boolean[] in_perm = new boolean[n+1];
		
		for(int i=1; i<n; i++) {
			in_perm[i] = false;
		}
		
		for(int d=0; d<k; d++) {
			in_perm[a[d]] = true;
		}
		
		ncandidates = 0;
		for(int e=1; e<=n; e++) {
			if(in_perm[e] == false) {
				c[ncandidates] = e;
				ncandidates = ncandidates +1;
			}
		}
		
		return ncandidates;
		
	}
	
	private static int sub_construct_candidates(int a[], int k, int n, int c[], int ncandidates) {
		
		c[0] = 1;
		c[1] = 0;
		ncandidates = 2;
		
		return ncandidates;
		
	}
	
	private static void perm_process_solution(int a[], int k, int in) {
		
		System.out.print("(");
		
		for(int i=1; i<=k; i++) {
			
			if(i % in == 0) {
				System.out.print(a[i] + ")");
			} else {
				System.out.print(a[i] + ",");
			}
			
		}
		
	}
	
	private static void sub_process_solution(int a[], int k) {
		
		System.out.print("(");
		
		for(int i=1; i<=k; i++) {
			
			if(a[i] == 1) {
				System.out.print(i);
			} else {
				System.out.print("-");
			}
			
			if(i != k) {
				System.out.print(",");
			}
			
		}
		
		System.out.print(")");
		
	}
	
	private static boolean is_a_solution(int a[], int k, int n) {
		return(k==n);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice;
		
		while(true) {
			
			System.out.println("Choose one of the following options:");
			System.out.println("1- Subset");
			System.out.println("2- Permutation");
			System.out.println("3- Exit");
			
			choice = scan.nextInt();
			
			if(choice == 1) {
				
				System.out.println("\nChoose a number larger than 1:");
				choice = scan.nextInt();
				
				if(choice > 1) {
					subset(choice);
				} else {
					System.out.println("Oops...Try Again.\n");
				}
				
			} else if(choice == 2) {
				
				System.out.println("\nChoose a number larger than 1:");
				choice = scan.nextInt();
				
				if(choice > 1) {
					perm(choice);
				} else {
					System.out.println("Oops...Try Again.\n");
				}
				
			} else if(choice == 3) {
				
				System.exit(0);
				
			}
		
		}

	}

}
