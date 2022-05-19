package important_codes;

import java.util.*;

public class all_subsets_recursive {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		generate(0, arr, new LinkedList<Integer>());
	}

	public static void generate(int curr, int[] arr, LinkedList<Integer> acc) {
		if (curr == arr.length) {
			System.out.println(acc);
			return;
		}
		LinkedList<Integer> tmp = (LinkedList<Integer>) acc.clone();
		tmp.add(arr[curr]);
		generate(curr + 1, arr, tmp);
		generate(curr + 1, arr, acc);
	}
}
