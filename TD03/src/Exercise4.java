
public class Exercise4 {

	public static void main(String[] args) {
		int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		final int from = 0;
		final int to = 4;

		swap(intArray, 0, 9);
		swap(intArray, 1, 7);
		swap(intArray, 3, 4);
		System.out.println("Content of the array after swap operation: ");
		for (int element : intArray) {
			System.out.println(element);
		}

		int minimumValueIndex = indexOfMin(intArray);
		System.out
				.println("Minimum value is at index: " + minimumValueIndex + " and is " + intArray[minimumValueIndex]);

		int minimumValueIndexInRange = indexOfMin(intArray, from, to);
		System.out.println("Between index " + from + " and " + to + ", minimum value is at index: "
				+ minimumValueIndexInRange + " and is " + intArray[minimumValueIndexInRange]);
		
		sort(intArray);
		System.out.println("Content of the array after sort operation: ");
		for (int element : intArray) {
			System.out.println(element);
		}
	}

	static void swap(int[] array, int index1, int index2) {
		if (index1 != index2) {
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}

	static int indexOfMin(int[] array) {
		return indexOfMin(array, 0, array.length);
	}

	static int indexOfMin(int[] array, final int from, final int to) throws IllegalArgumentException {
		if (from < 0 || from > array.length - 1) {
			throw new IllegalArgumentException("Argument (from) must be in range of array size.");
		}
		if (to <= from || to > array.length) {
			throw new IllegalArgumentException("Argument (to) must be in range of array size.");
		}

		int minIndex = from;
		int maxIndex = to;
		for (int i = minIndex + 1; i < maxIndex; i++)
			if (array[i] < array[minIndex])
				minIndex = i;
		return minIndex;
	}
	
	static void sort(int[] array) {
		sort(array, 0, array.length);
	}
	
	static void sort(int[] array, final int from, final int to) {		
		int minIndex = indexOfMin(array, from, to);
		swap(array, from, minIndex);
		for(int i = from + 1; i < to; i++) {
			sort(array, from + 1, to);
		}
	}

}
