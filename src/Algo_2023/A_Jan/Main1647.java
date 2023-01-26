package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1647 {

	static int n;
	static int m;

	static class Edge implements Comparable<Edge> {
		int start, end, score;

		public Edge(int start, int edge, int score) {
			this.start = start;
			this.end = edge;
			this.score = score;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(score, o.score);
		}
	}

	static int[] groups;
	static int biggest = 0;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("./src/algo/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		groups = new int[n + 1];
		for(int i=1;i<=n;i++) {
			groups[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			pq.offer(edge);
		}

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			union(now.start, now.end,now.score);
		}
		System.out.println(result - biggest);
		

	}

	private static void union(int start, int end,int score) {
		int sG = find(start);
		int eG = find(end);
		if (sG != eG) {
			if(sG < eG) groups[eG] = sG;
			else groups[sG] = eG;
			result += score;
			biggest = Math.max(biggest, score);
		}
	}

	private static int find(int idx) {
		if (idx == groups[idx])
			return idx;
		return groups[idx] = find(groups[idx]);
	}

}
