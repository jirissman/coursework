package Graphs;


public class EList2 extends MetaGraph {

	private Vertex2 vertices;
//	private Vertex []vertices;
	private int vertexCount = 0;
	
	public EList2(int count) {
		//vertices
		for (int i = count-1; i >= 0; i--) {
			Vertex2 n = new Vertex2();
			n.setLabel("V" + i);
			n.setNext(vertices);
			n.setVertex(i);
			vertices = n;
			vertexCount++;
		}
	}

	private Vertex2 getVertex(int source) {
		Vertex2 v = vertices;
		while(v != null) {
			if (v.getVertex() == source) {
				return v;
			}
			v = v.getNext();
		}
		
		return null;
	}
	
	public boolean addVertex() {
		Vertex2 n = new Vertex2();
		n.setLabel("V" + vertexCount);
		n.setNext(vertices);
		n.setVertex(vertexCount);
		vertices = n;
		vertexCount++;
		return true;
	}
	
	public void addEdge(int source, int target) {

		// If the edge already exists just return
		if (isEdge(source, target)) {
			return;
		}
		
		Edge e = new Edge();
		e.setVertex(target);
		e.setNext(getVertex(source).getList());
		
		getVertex(source).setList(e);
	}

	public boolean isEdge(int source, int target) {
		boolean edgeExists = false;
		Edge e = getVertex(source).getList();
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
			Edge cur = getVertex(source).getList();
			while (cur != null) {
				if (cur.getVertex() == target) {
					// This is it...
					if (prev == null) {
						// First or only in list
						getVertex(source).setList(cur.getNext());
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
		getVertex(source).setLabel(label);
	}


	public String getLabel(int source) {
		return getVertex(source).getLabel();
	}

	public int size() {
		return vertexCount;
	}

	public int[] neighbors(int vertex) {
		int count = 0;
		Edge e = getVertex(vertex).getList();
		while (e != null) {
			count++;
			e = e.getNext();
		}
		
		int []result = new int[count];
		
		count = 0;
		e = getVertex(vertex).getList();
		while (e != null) {
			result[count++] = e.getVertex();
			e = e.getNext();
		}
		return result;
	}
	
	public String toString() {
		String rtn = "";
		for (int i = 0; i < vertexCount; i++) {
			rtn += getVertex(i).getLabel() + " = <";
			Edge e = getVertex(i).getList();
			while(e != null) {
				rtn += e.getVertex() + " ";
				e = e.getNext();
			}
			rtn += ">\n";
		}
		return rtn;
	}
	
	
}
