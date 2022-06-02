import java.util.*;

class GraphSCC{
	public int V;
	public LinkedList<Integer> adj[];
	
	GraphSCC(int v){
		this.V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void fillOrder(int i, boolean visited[], Stack<Integer> stack) {
		visited[i] = true;
		Iterator<Integer> iterator = adj[i].listIterator();
		while(iterator.hasNext()) {
			int node = iterator.next();
			if(!visited[node]) {
				fillOrder(node, visited, stack);
				stack.push(node);
			}
		}
	}
	
	public void dfsUtil(int v, boolean visited[], GraphSCC g) {
		System.out.print(v);
		visited[v] = true;
		Iterator<Integer> iterator = g.adj[v].listIterator();
		while(iterator.hasNext()) {
			int node = iterator.next();
			if(!visited[node]) {
				dfsUtil(node, visited, g);
			}
		}
	}
	
	public GraphSCC getTranspose() {
		GraphSCC g = new GraphSCC(V);
		for(int i=0 ;i<V ;i++){
			Iterator<Integer> iterator = adj[i].listIterator();
			while(iterator.hasNext()) {
				g.adj[iterator.next()].add(i);
			}
		}
		return g;
	}
	
	public void printSCC() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] =  new boolean[V];
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				fillOrder(i,visited, stack);
				stack.push(i);
			}
		}
		
		GraphSCC g = getTranspose();
		
		for(int i=0;i<V;i++)
			visited[i] = false;
		
		while(!stack.isEmpty()) {
			int i = stack.pop();
			if(!visited[i]) {
				dfsUtil(i, visited, g);
				System.out.println();
			}
		}
		
	}
	
	
	public static void main(String args[]) {
		GraphSCC g = new GraphSCC(5); 
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 
		g.printSCC();
	
	}


}