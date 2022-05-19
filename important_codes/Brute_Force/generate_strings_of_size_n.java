package important_codes;

public class generate_strings_of_size_n {
	public static void generate(int n) {
		generate_helper(n,"");
	}

	public static void generate_helper(int n, String acc) {
		if (n == 0)
			System.out.println(acc);
		else {
			for (char i = 'a'; i <= 'z'; i++) {
				generate_helper(n - 1, acc + i);
			}
		}
	}
}
