package important_codes.Brute_Force;

public class take_or_leave {
	static int SackSize;
	static int[] values;
	static int[] sizes;

	public static int solve(int curr, int acc) {
		if (curr == values.length) {
			return 0;
		}
		int take = 0;
		if (acc + sizes[curr] <= SackSize)
			take = values[curr] + solve(curr + 1, acc + sizes[curr]);
		int leave = solve(curr + 1, acc);
		return Math.max(take, leave);
	}

}
