
public class AMatrix extends MetaGraph {
	
	boolean [][]graph;
	String []labels;
	
	public AMatrix(int vertices) {
		graph = new boolean[vertices][vertices];
		labels = new String[vertices];
		for (int i = 0; i < vertices; i++) {
			labels[i] = "V"+i;
		}
	}
	
	public void addEdge(int source, int target) {
		
		// prototypical error checking
		if ((source > size()) || (target > size())) {
			return;
		}
		
		if ((source < 0) || (target < 0 )) {
			return;
		}
		graph[source][target] = true;
	}
	
	public boolean isEdge(int source, int target) {
		return graph[source][target];
	}

	public void removeEdge(int source, int target) {
		graph[source][target] = false;
	}
	
	public void setLabel(int source, String label) {
		labels[source] = label;
	}
	
	public String getLabel(int source) {
		return labels[source];
	}
	
	public int size() {
		return labels.length;
	}
	
	public int[] neighbors(int vertex) {
		
		// Count the neighbors
		int count = 0;
		for (int i = 0; i < labels.length; i++) {
			if (isEdge(vertex, i)) {  // if (graph[vertex][i] == true ) {
				count++;
			}
		}
		
		// Allocate an array to hold the neighbors
		int []result = new int[count];
		
		// Insert the neighbors into the new array
		count = 0;
		for (int i = 0; i < labels.length; i++) {
			if (isEdge(vertex, i)) {  // if (graph[vertex][i] == true ) {
				result[count++] = i;
			}
		}
		
		return result;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int vCount = 0; vCount < labels.length; vCount++) {
			rtn += labels[vCount] + " = <";
			for (int eCount = 0; eCount < labels.length; eCount++) {
				if (graph[vCount][eCount] == true) {
					rtn += eCount + " ";
				}
			}
			rtn += ">\n";
		}
		
		return rtn;
	}
}
