package Graphs;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		EList graph = new EList(9);
		
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		//graph.addEdge(2, 1);
		graph.addEdge(2, 5);
		graph.addEdge(3, 0);
		graph.addEdge(3, 2);
		graph.addEdge(4, 8);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 5);
		graph.addEdge(7, 6);
		graph.addEdge(8, 4);
		graph.addEdge(8, 6);
//		graph.setLabel(6, "New V6");
		System.out.println(graph);
		System.out.print("Neighbors of 5: ");
		for (int a:graph.neighbors(5)) {
			System.out.print(a + " ");
		}
		System.out.println();
//		graph.removeEdge(7, 5);
//		System.out.println(graph);
		System.out.println("Depth First");
		graph.depthFirstSearch(5);
		System.out.println("\nBreadth First");
		graph.breadthFirstSearch(5);
	}

	public void doIt2() {
		EList2 graph = new EList2(8);
		
		graph.addVertex();
		
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		//graph.addEdge(2, 1);
		graph.addEdge(2, 5);
		graph.addEdge(3, 0);
		graph.addEdge(3, 2);
		graph.addEdge(4, 8);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 5);
		graph.addEdge(7, 6);
		graph.addEdge(8, 4);
		graph.addEdge(8, 6);
		System.out.println(graph);
		System.out.print("Neighbors of 5: ");
		for (int a:graph.neighbors(5)) {
			System.out.print(a + " ");
		}
		System.out.println();
//		graph.removeEdge(7, 5);
//		System.out.println(graph);
//		System.out.println("Depth First");
//		graph.depthFirstSearch(5);
		System.out.println("\nBreadth First");
		graph.breadthFirstSearch(5);
	}

}
