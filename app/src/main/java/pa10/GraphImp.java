package pa10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GraphImp implements Graph {
	
	ArrayList<ArrayList<Integer>> adjlist; //unweighted graph
	int size;
	int[] inGoing;
	
	public GraphImp(int n) {
		adjlist = new ArrayList<>();
		for (int i=0; i<n; i++)
			adjlist.add(new ArrayList<Integer>());
		size = n;
		inGoing = new int[n];
	}
	
	@Override
	public void addEdge(int v, int w) {
		inGoing[w]++;
		adjlist.get(v).add(w);
		
	}

	@Override
	public String topologicalSort() {
		ArrayList<String> result = new ArrayList<>();
		boolean[] visited = new boolean[size];
		for (int i=0; i<size; i++)
			if (!visited[i])
				dfs(i, visited, result);
		Collections.reverse(result);
		return String.join(" ", result);
	}

	private void dfs(int i, boolean[] visited, ArrayList<String> result) {
		visited[i] = true;
		for (int neib: adjlist.get(i))
			if (!visited[neib])
				dfs(neib, visited, result);
		result.add(Integer.toString(i));
		
	}

	@Override
	public String kahn() {
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		int[] copy = Arrays.copyOf(inGoing, size);
		ArrayList<String> result = new ArrayList<>();
		for (int i=0; i<size; i++)
			if (copy[i] == 0)
				zeros.add(i);
		while (zeros.size() != 0) {
			int curr = zeros.removeLast();
			result.add(Integer.toString(curr));
			for (int neib: adjlist.get(curr)) 
				if (copy[neib] == 1)
					zeros.add(neib);
				else
					 copy[neib]--;
		}
		return String.join(" ", result);
	}

}
