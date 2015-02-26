/* File : WeightedUF.java 
 * Date : 27 Sept 2014
 * __________________________________________________________________________________________________________
 * 
 * This class implements the weighted Union find datastructure in which tree with smaller depth
 *  is made child of tree with greater depth in union method.
 *  
 *  An extra array is used to keep track of the size of tree.
 *  
 *  And an extra line of code for path compression and there is no reason not to use it.
 */

/**
 *  Initialization : O(n)
 *  Worst Case : n+m  lg* n  (weighted union find + path compression)
 */


class WeightedUF{
	public  WeightedUF(int n){
		id = new int[n];
		sz = new int[n];
		
		for(int i=0;i<n;i++){
			id[i] = i;
            sz[i] = 1;
		}
	}
	
	private int root(int n){
		while(id[n] != n){
			id[n] = id[id[n]]; //extra line of code for path compression
			n = id[n];
		}
		return n;
	}
	
	public boolean isConnected(int p, int q){
		return root(p) == root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		if(sz[i]<sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	private int[] id;
	private int[] sz;
}