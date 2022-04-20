import java.io.*;
import java.util.*;

class Node {
		public int val;
		public List<Node> neighbour;
		
		Node(int val) {
			this.val=val;
			neighbour=new ArrayList<Node>();
		}
	}
	
class Graph {
	public Node createGraph() {
		Node node1 = new Node(1);
		Node node2= new Node(2);
		Node node3= new Node(3);
		Node node4= new Node(4);
		node1.neighbour.add(node2);
		node1.neighbour.add(node4);
		node2.neighbour.add(node1);
		node2.neighbour.add(node3);
		node3.neighbour.add(node2);
		node3.neighbour.add(node4);
		node4.neighbour.add(node1);
		node4.neighbour.add(node3);
		return node1;
	}
	
	public void bfs(Node source) {
		if(source == null)
			return;
		Queue<Node> stack = new LinkedList<Node>();
		stack.add(source);
		Map<Node, Boolean> visited = new HashMap<Node, Boolean>();
		visited.put(source, true);
		while(!stack.isEmpty()) {
			Node currentNode= stack.remove();
			System.out.println(currentNode.val + " " + currentNode);
			if(!currentNode.neighbour.isEmpty()) {
				for(Node entry: currentNode.neighbour) {
					if(visited.get(entry) == null) {
						stack.add(entry);
						visited.put(entry, true);
					}
				}
			}
		}
	
	}
	
		public Node cloneGraph(Node source){
			if(source == null)
				return source;
			Queue<Node> stack = new LinkedList<Node>();
			stack.add(source);
			Map<Node, Node> visited = new HashMap<Node, Node>();
			visited.put(source, new Node(source.val));
			while(!stack.isEmpty()) {
				Node currentNode= stack.remove();
				Node cloneNode = visited.get(currentNode);
				if(!currentNode.neighbors.isEmpty()) {
					for(Node entry: currentNode.neighbors) {
						if(visited.get(entry) == null) {
							stack.add(entry);
							Node neighbor = new Node(entry.val);
							cloneNode.neighbors.add(neighbor);
							visited.put(entry, neighbor);
						} else {
							cloneNode.neighbors.add(visited.get(entry));
						}
					}
				}
			}
			return visited.get(source);
		}
	}

}


class CloneNode {
	
	public static void main(String args[]) {
		Graph graph = new Graph();
		Node source = graph.createGraph();
		graph.bfs(source);
		graph.cloneGraph(source);
		graph.bfs(source);
	
	}
	
	
	
}