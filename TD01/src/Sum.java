import java.util.Arrays;

public class Sum {

	static int[] stringArrayToIntArray(String[] arr) {
		return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
	}

	static int sumElementsOfIntArray(int[] values) {
		int sum = 0;

		for (int value : values) {
			sum += value;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] values = stringArrayToIntArray(args);
		int sum = sumElementsOfIntArray(values);

		System.out.println(Arrays.toString(values));
		System.out.printf("Sum = %d\n", sum);
	}

}
