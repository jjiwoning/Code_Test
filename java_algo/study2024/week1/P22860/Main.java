package study2024.week1.P22860;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static Map<String, Folder> map;

	private static Map<String, Integer> fileMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new HashMap<>();

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			int type = Integer.parseInt(st.nextToken());

			Folder parent = map.getOrDefault(name1, new Folder(name1));
			map.put(name1, parent);

			if (type == 0) {
				// file
				parent.files.add(name2);
			}

			if (type == 1) {
				// folder
				Folder child = map.getOrDefault(name2, new Folder(name2));
				map.put(name2, child);
				parent.folders.put(name2, child);
			}
		}

		int queryCount = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < queryCount; i++) {
			fileMap = new HashMap<>();
			String query = br.readLine();

			String[] result = query.split("/");

			dfs(result[result.length - 1]);

			int count = 0;
			for (Integer value : fileMap.values()) {
				count += value;
			}

			answer.append(fileMap.size()).append(" ").append(count).append("\n");
		}

		System.out.println(answer);
	}

	private static void dfs(String now) {
		Folder nowFolder = map.get(now);

		for (String file : nowFolder.files) {
			fileMap.put(file, fileMap.getOrDefault(file, 0) + 1);
		}

		if (nowFolder.folders.size() == 0) {
			return;
		}

		for (String folder : nowFolder.folders.keySet()) {
			dfs(folder);
		}
	}
}

class Folder {

	String name;

	Map<String, Folder> folders;

	Set<String> files;

	public Folder(String name) {
		this.name = name;
		this.folders = new HashMap<>();
		this.files = new HashSet<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Folder folder = (Folder)o;
		return Objects.equals(name, folder.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
