/* File : QuickFindUF
 * Date : 27 Sept 2014
 * ___________________________________________________________________________________________________________
 * This class implements the QuickFind union find datastructure.
 * Find time : O(1)
 * Union time : O(n)
 * Initialize : O(n)
 * ___________________________________________________________________________________________________________
 *
 */

class QuickFindUF{
	
	public QuickFindUF(int n){
		id = new int[n];
		for(int i =0;i<n;i++){
			id[i] = i;
		}
	}
	
	public boolean isConnected(int p, int q){
		return id[p] == id[q];
	}
	
	public void Union(int p, int q){
		for(int i=0; i<id.length; i++){
			if(id[i] == id[p]) id[i] = id[q];
		}
	}
	
	private int[] id;
}