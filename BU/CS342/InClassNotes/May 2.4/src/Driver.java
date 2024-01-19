
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		
		EList graph = new EList(6);
		
		graph.addEdge(0, 5, 9);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 5, 6);
		graph.addEdge(1, 3, 15);
		graph.addEdge(1, 2, 8);
		graph.addEdge(2, 3, 1);
		graph.addEdge(4, 2, 7);
		graph.addEdge(4, 3, 3);
		graph.addEdge(5, 4, 3);
		
		System.out.println(graph);
		
		for (int loop = 0; loop < graph.size(); loop++) {
			int []distance = graph.shortestPath(loop);
			System.out.print("V" + loop + "= ");
			for (int i = 0; i < distance.length; i++) {
				if (distance[i] == Integer.MAX_VALUE) {
					System.out.print(" " + '\u221e' + " ");	
				} else {
					System.out.printf("%2d ", distance[i]);
				}
			}
			System.out.println();
		}
	}

}
