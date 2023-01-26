package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

	static int p, w;
	static int c, v;
	static int[] groups;
	static List<Road>[] roads;
	static List<Road> road;

	static class Road implements Comparable<Road> {
		int start;
		int end;
		int score;

		public Road(int start, int end, int score) {
			this.start = start;
			this.end = end;
			this.score = score;
		}

		@Override
		public int compareTo(Road o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.score, this.score);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new java.io.FileInputStream("./src/algo/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// p - 지점, w 길
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		groups = new int[p];
		roads = new ArrayList[p];
		road = new ArrayList<>();
		for (int i = 0; i < p; i++) {
			groups[i] = i;
			roads[i] = new ArrayList<>();
		}

		// c(국왕) - v(큐브)
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			road.add(new Road(start, end, score));
		}
		Collections.sort(road);

		for (Road now : road) {
			//System.out.println(now.start + " " + now.end + " " + now.score);
			union(now.start, now.end);
			if (find(c) == find(v)) {
				System.out.println(now.score);
				break;
			}
		}

	}

	private static void union(int start, int end) {
		int sG = find(start);
		int eG = find(end);
		if (sG != eG) {
			if (sG < eG)
				groups[eG] = sG;
			else
				groups[sG] = eG;
		}

	}

	private static int find(int idx) {
		if (idx == groups[idx])
			return idx;
		return groups[idx] = find(groups[idx]);
	}

}
