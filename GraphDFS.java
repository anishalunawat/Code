import java.util.*;


class Graph {
	public int V;
	public LinkedList<Integer> adj[];
	
	Graph(int v) {
		V=v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
	}
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

}

class GraphDFS {
	public static Graph source;


	public static void dfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v);
		
		Iterator<Integer> iterrator = source.adj[v].listIterator();
		
		while(iterrator.hasNext()){
			int u = iterrator.next();
			if(!visited[u])
				dfsUtil(u, visited);
		}
		
	}
	
	private static void DFS(int v){
		boolean visited[] = new boolean[source.V];
		for(int i=0; i<v; i++) {
			if(visited[i]!=true)
				dfsUtil(i, visited);
		}
	}
	
	public static void main(String args[]) {
		source = new Graph(4);
		source.addEdge(0, 1); 
        source.addEdge(0, 2); 
        source.addEdge(1, 2); 
        source.addEdge(2, 0); 
        source.addEdge(2, 3); 
        source.addEdge(3, 3); 
		DFS(2);
	
	}

}