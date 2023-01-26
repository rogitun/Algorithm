package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] groups;
	static long result;
	static int current = 1;
	static long[] scores;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int score;

		public Edge(int start, int end, int score) {
			this.start = start;
			this.end = end;
			this.score = score;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(score, o.score);
		}
	}

	public static void main(String args[]) throws IOException {
		System.setIn(new java.io.FileInputStream("./src/algo/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // vet
		int m = Integer.parseInt(st.nextToken()); // edges

		result = 0;
		groups = new int[n + 1];
		scores = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			groups[i] = i;
		}

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Edge edge = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			edges.add(edge);
		}
		Collections.sort(edges);

		for (Edge e : edges) {
			union(e.start, e.end, e.score);

			if (current >= n) {
				System.out.println(result);
				break;
			}
		}
	}

	private static void union(int start, int end, int score) {
		int sG = find(start);
		int eG = find(end);
		if (sG != eG) {
			if (sG < eG) {
				groups[eG] = sG;
				result += score;
			} else {
				groups[sG] = eG;
				result += score;
			}
			current++;
		}
	}

	private static int find(int idx) {
		if (idx == groups[idx])
			return idx;
		return groups[idx] = find(groups[idx]);
	}
}
