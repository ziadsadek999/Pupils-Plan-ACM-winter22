package important_codes;
public class Binary_Search {

	public static int searchLastOcc(int[] arr, int target) {
		// returns the index of the last occurrence of the target
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return h;
	}

	public static int searchFirstOcc(int[] arr, int target) {
		// returns the index of the first occurrence of the target
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] < target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return l;
	}

	public static int searchSmallestHigher(int[] arr, int target) {
		// returns the smallest number that is larger than the target
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] <= target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return arr[l];
	}

	public static int searchLargestLower(int[] arr, int target) {
		// returns the smallest number that is larger than the target
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] < target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return arr[h];
	}
}
