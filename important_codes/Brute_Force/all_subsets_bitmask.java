package important_codes.Brute_Force;

import java.util.*;

public class all_subsets_bitmask {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int mask = 0;
		while (mask < (1 << arr.length)) {
			LinkedList<Integer> res = new LinkedList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				if ((mask & (1 << i)) != 0) {
					res.add(arr[i]);
				}
			}
			System.out.println(res);
			mask++;
		}
	}
}
