
public class EList {

	
	private Vertex []vertices;
	
	public EList(int count) {
		vertices = new Vertex[count];
		for (int i = 0; i < count; i++) {
			vertices[i] = new Vertex();
			vertices[i].setLabel("V" + i);
		}
	}

	
	public void addEdge(int source, int target, int cost) {
		// TODO Auto-generated method stub

		if (isEdge(source, target)) {
			return;
		}
		
		Edge e = new Edge();
		e.setVertex(target);
		e.setCost(cost);
		e.setNext(vertices[source].getList());
		
		vertices[source].setList(e);
	}

	public boolean isEdge(int source, int target) {
		boolean edgeExists = false;
		Edge e = vertices[source].getList();
		while(e != null) {
			if (e.getVertex() == target) {
				edgeExists = true;
				break;
			}
			e = e.getNext();
		}
		return edgeExists;
	}

	public int getCost(int source, int target) {
		Edge e = vertices[source].getList();
		while(e != null) {
			if (e.getVertex() == target) {
				return e.getCost();
			}
			e = e.getNext();
		}
		return Integer.MAX_VALUE;
	}

	public void removeEdge(int source, int target) {
		if (isEdge(source, target)) {
			Edge prev = null;
			Edge cur = vertices[source].getList();
			while (cur != null) {
				if (cur.getVertex() == target) {
					// This is it...
					if (prev == null) {
						// First or only in list
						vertices[source].setList(cur.getNext());
						return;
					} else {
						prev.setNext(cur.getNext());
					}
				}
				prev = cur;
				cur = cur.getNext();
			}
		}
	}

	public void setLabel(int source, String label) {
		vertices[source].setLabel(label);
	}

	public String getLabel(int source) {
		return vertices[source].getLabel();
	}

	public int size() {
		return vertices.length;
	}

	public int[] neighbors(int vertex) {
		int count = 0;
		Edge e = vertices[vertex].getList();
		while (e != null) {
			count++;
			e = e.getNext();
		}
		
		int []result = new int[count];
		
		count = 0;
		e = vertices[vertex].getList();
		while (e != null) {
			result[count++] = e.getVertex();
			e = e.getNext();
		}
		return result;
	}
	
	public String toString() {
		String rtn = "";
		for (int i = 0; i < vertices.length; i++) {
			rtn += vertices[i].getLabel() + " = <";
			Edge e = vertices[i].getList();
			while(e != null) {
				rtn += e.getVertex() + "(" + e.getCost() + ") ";
				e = e.getNext();
			}
			rtn += ">\n";
		}
		return rtn;
	}
	
//	private boolean []visited;
//	public void depthFirstSearch(int vertex) {
//		visited = new boolean[this.size()];
//		intdfs(vertex);
//	}
//	
//	private void intdfs(int vertex) {
//		if (visited[vertex]) {
//			return;
//		}
//		
//		visited[vertex] = true;
//		System.out.println(this.getLabel(vertex));
//		int []n = this.neighbors(vertex);
//		
//		for (int i = 0; i < n.length; i++) {
//			intdfs(n[i]);
//		}
//	}
//	
//	public void breadthFirstSearch(int vertex) {
//		ArrayQueue q = new ArrayQueue();
//		visited = new boolean[this.size()];
//		
//		// start by putting first vertex on q
//		visited[vertex] = true;
//		System.out.println(this.getLabel(vertex));
//		q.add(vertex);
//		
//		while (!q.isEmpty()) {
//			int vert = q.remove();
//			int []n = this.neighbors(vert);
//			for (int i = 0; i < n.length; i++) {
//				if (!visited[n[i]]) {
//					visited[n[i]] = true;
//					System.out.println(this.getLabel(n[i]));
//					q.add(n[i]);
//				}
//			}
//			
//		}
//		
//		
//	}
	
	public int[] shortestPath(int start) {
		
		int []distance = new int[this.vertices.length];
		boolean []unvisited = new boolean[this.vertices.length];
		
		// Initialize everybody to be unvisited, and of infinite cost
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
			unvisited[i] = true;
		}
		
		// Set the start/current vertex to cost 0
		int current = start;
		distance[start] = 0;
		
		// Loop until all processable vertices are processed
		boolean done = false;
		while(!done) {
			// Set tentative distances
			int neighbors[] = this.neighbors(current);
			
			// See if a better cost exists, and the vertex is unvisited.
			// if there is a better cost, use it.
			for (int i = 0; i < neighbors.length; i++) {
				if (unvisited[neighbors[i]] == true) {
					int newValue = distance[current] + this.getCost(current, neighbors[i]);
					if (newValue < distance[neighbors[i]]) {
						distance[neighbors[i]] = newValue;
					}
				}
			}
			
			
			// The current node is visited, remove from unvisited set
			// This means we have processed the current node to the fullest possible extent
			unvisited[current] = false;
			
			// select a new current
			// This will be the smallest unvisited vertex
			int curSmall = Integer.MAX_VALUE;
			
			for (int i = 0; i < distance.length; i++) {
				if (unvisited[i]) {
					if (distance[i] < curSmall) {
						curSmall = distance[i];
						current = i;
					}
				}
			}
			
			// See if we should stop
			// We will only stop if there are no more unvisited nodes that contain infinity as a cost
			done = true;
			for (int i = 0; i < distance.length; i++) {
				if (unvisited[i] && (distance[i] != Integer.MAX_VALUE)) {
					// Keep going
					done = false;
				}
			}
		}
		
		return distance;
	}
}
