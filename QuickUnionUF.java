
/* File : QuickUnionUF.java 
 * Date : 27 Sept 2014
 * _________________________________________________________________________________________________
 * This classi implements QuickUnion unionfind data structure.
 * 
 * Initialization : O(n)
 * Find : O(n) { worst Case }
 * Union : O(n) {includes cost of finding roots }
 * _______________________________________________________________________________________________________
 */


public class QuickUnionUF{
	
	public QuickUnionUF(int n){
		id = new int[n];
		for(int i = 0;i<n;i++){
			id[i] = i;
		}
	}
	
	private int root(int p){
		while(id[p] != p){
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
	}
	
	public boolean isConnected(int p, int q){
		return root(p) == root(q);
	}
	
	private int[] id;
}