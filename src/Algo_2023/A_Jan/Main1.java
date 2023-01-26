package Algo_2023.A_Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] group;
	static int[] money;
	static Group[] set;

	static class Group implements Comparable<Group> {
		int idx;
		int number;
		int money;

		public Group(int idx, int number, int money) {
			this.idx = idx;
			this.number = number;
			this.money = money;
		}

		@Override
		public int compareTo(Group o) {
			// TODO Auto-generated method stub
			int compare = Integer.compare(o.number, this.number);
			if (compare == 0) {
				return Integer.compare(this.money, o.money);
			}
			return compare;
		}

	}

	public static void main(String[] args) throws IOException {
		System.setIn(new java.io.FileInputStream("./src/algo/sample.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		money = new int[n + 1];
		group = new int[n + 1];
		set = new Group[n + 1];
		set[0] = new Group(0, 0, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			group[i] = i;
			set[i] = new Group(i, 1, money[i]);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			union(left, right);
		}

		int result = 0;
		int friends = 0;
		Arrays.sort(set);
//		Arrays.stream(set).forEach(e -> {
//			System.out.println(e.idx + " " + e.number + " " + e.money);
//		});
		for (int i = 0; i < n; i++) {
			Group now = set[i];
			friends += now.number;
			result += now.money;
			if (result >= k || friends >= n) {
				break;
			}
		}

		if (friends != n || result > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(result);
		}

	}

	private static void union(int left, int right) {
		int leftGroup = find(left);
		int rightGroup = find(right);

		if (leftGroup != rightGroup) {
			if (money[leftGroup] < money[rightGroup]) {
				group[rightGroup] = leftGroup;
				set[leftGroup].number += set[rightGroup].number;
				set[rightGroup].number = 0;

			} else {
				group[leftGroup] = rightGroup;
				set[rightGroup].number += set[leftGroup].number;
				set[leftGroup].number = 0;

			}
		}
	}

	private static int find(int idx) {
		if (idx == group[idx])
			return idx;
		return group[idx] = find(group[idx]);
	}
}
