package important_codes;

public class take_or_leave {
	static int SackSize;
	static int[] values;
	static int[] sizes;

	public static int solve(int curr, int acc) {
		if (curr == values.length) {
			if (acc > SackSize)
				return Integer.MIN_VALUE;
			return 0;
		}
		int take = values[curr] + solve(curr + 1, acc + sizes[curr]);
		int leave = solve(curr + 1, acc);
		return Math.max(take, leave);
	}

}
