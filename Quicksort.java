import java.util.*;
import java.io.*;

public class Quicksort
{	
	// Wrapper function for Quicksort.
	public static void sort(int [] array)
	{
		sorting(array, 0, array.length - 1);
	}

	public static void sorting(int [] array, int low, int hi)
	{
		if (low < hi)
		{
			int pIndex = partician(array, low, hi);
			sorting(array, low, pIndex - 1);
			sorting(array, pIndex + 1, hi);
		}
	}

	public static int partician(int [] array, int low, int hi)
	{
		int pivot = array[hi];

		int pIndex = low;

		for (int j = low; j < hi; j++)
		{
			if (array[j] <= pivot)
			{	
				swap(array, pIndex, j);
				pIndex++;
			}
		}

		swap(array, pIndex, hi);

		return pIndex;
	}

	public static void swap(int [] array, int i, int j)
	{
		int temp = array[i];

		array[i] = array[j];

		array[j] = temp;
	}

	public static void printArray(int [] array, int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.print("[" + array[i] + "]");
			System.out.print((i == n - 1) ? "\n" : " ");
		}
	}

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("unsorted1.txt"));

		// Getting the number of elements in the array from text file.
		int n = in.nextInt();

		int [] array = new int[n];

		for (int i = 0; i < n; i++)
		{
			array[i] = in.nextInt();
		}

		System.out.println("Unsorted Array: ");

		printArray(array, n);

		sort(array);

		System.out.println("After Quicksort: ");

		printArray(array, n);
	}
}