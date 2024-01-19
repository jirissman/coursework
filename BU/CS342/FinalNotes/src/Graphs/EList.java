package Graphs;


public class EList extends MetaGraph {

	
	private Vertex []vertices;
	
	public EList(int count) {
		vertices = new Vertex[count];
		for (int i = 0; i < count; i++) {
			vertices[i] = new Vertex();
			vertices[i].setLabel("V" + i);
		}
	}

	
	public void addEdge(int source, int target) {

		// If the edge already exists just return
		if (isEdge(source, target)) {
			return;
		}
		
		Edge e = new Edge();
		e.setVertex(target);
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
				rtn += e.getVertex() + " ";
				e = e.getNext();
			}
			rtn += ">\n";
		}
		return rtn;
	}
	
	
}
