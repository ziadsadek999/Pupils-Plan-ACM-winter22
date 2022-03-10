package important_codes;
public class mergeSort {
	public static void sort(int[] arr) {
		sortHelper(arr, 0, arr.length - 1);
	}

	public static void sortHelper(int[] arr, int l, int r) {
		if (l != r) {
			int mid = (l + r) / 2;
			sortHelper(arr, l, mid);
			sortHelper(arr, mid + 1, r);
			merge(arr, l, mid, mid + 1, r);
		}
	}

	public static void merge(int[] arr, int l1, int r1, int l2, int r2) {
		int[] tmp = new int[r2 - l1 + 1];
		int i = l1;
		int j = l2;
		int curr = 0;
		while (i <= r1 && j <= r2) {
			if (arr[i] <= arr[j]) {
				tmp[curr++] = arr[i++];
			} else {
				tmp[curr++] = arr[j++];
			}
		}
		while (i <= r1) {
			tmp[curr++] = arr[i++];
		}
		while (j <= r2) {
			tmp[curr++] = arr[j++];
		}
		curr = 0;
		for (int k = l1; k <= r2; k++) {
			arr[k] = tmp[curr++];
		}
	}
}
