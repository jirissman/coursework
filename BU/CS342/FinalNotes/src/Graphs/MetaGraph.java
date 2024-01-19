package Graphs;


public abstract class MetaGraph {
	private boolean []visited;
	public abstract int[] neighbors(int vertex);
	public abstract void setLabel(int source, String label);
	public abstract String getLabel(int source);
	public abstract int size();
	public abstract void addEdge(int source, int target);

	public abstract boolean isEdge(int source, int target);

	public abstract void removeEdge(int source, int target);
	
	public void depthFirstSearch(int vertex) {
		visited = new boolean[this.size()];
		intdfs(vertex);

		System.out.println("from Vertex " + vertex + " we can get to..");
		
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == true) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
}
	
	private void intdfs(int vertex) {
		// BASE CASE
		if (visited[vertex]) {
			return;
		}
		
		visited[vertex] = true;
		//System.out.println(this.getLabel(vertex));
		int []n = this.neighbors(vertex);
		
		for (int i = 0; i < n.length; i++) {
			intdfs(n[i]);
		}
	}
	
	public void breadthFirstSearch(int vertex) {
		ArrayQueue q = new ArrayQueue();
		visited = new boolean[this.size()];
		
		// start by putting first vertex on q
		visited[vertex] = true;
		System.out.println(this.getLabel(vertex));
		q.add(vertex);
		
		while (!q.isEmpty()) {
			int vert = q.remove();
			int []n = this.neighbors(vert);
			
			System.out.print("Neighbors of " + vert + " = ");
			for (int v:neighbors(vert)) {
				System.out.print(v + " ");
			}
			System.out.println();
			
			for (int i = 0; i < n.length; i++) {
				if (!visited[n[i]]) {
					visited[n[i]] = true;
					System.out.println(this.getLabel(n[i]));
					q.add(n[i]);
					System.out.println("Q = " + q);
				}
			}
			
			
		}
		System.out.println("from Vertex " + vertex + " we can get to..");
		
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == true) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		
		
	}

}
