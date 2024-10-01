//import java.util.*;
/*
 * IT-2660 - Lab 1
 * Student Name: Brendan Pruden
 */

 public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world!");

    Lab1 lab = new Lab1();
    System.out.println(lab.increment(1));

    int[] array = {5, 9, 3, 12, 7, 3, 11, 5};

    // Output the array in order using a while loop
    int i = 0;
    while (i < array.length) {
      System.out.print(array[i] + " ");
      i++;
    }
    System.out.println();

    // Output the array in reverse using a for loop
    for (int j = array.length - 1; j >= 0; j--) {
      System.out.print(array[j] + " ");
    }
    System.out.println();

    // Output the first and last values of the array
    System.out.println("First value: " + array[0]);
    System.out.println("Last value: " + array[array.length - 1]);

    // Call the methods created in Lab1
    System.out.println("Max of 5 and 9: " + lab.max(5, 9));
    System.out.println("Min of 5 and 9: " + lab.min(5, 9));
    System.out.println("Sum of array: " + lab.sum(array));
    System.out.println("Average of array: " + lab.average(array));
    System.out.println("Max of array: " + lab.max(array));
    System.out.println("Min of array: " + lab.min(array));
  }
}

class Lab1 {
  public int increment(int num) {
    return ++num;
  }

  public int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }

  public int min(int a, int b) {
    if (a < b) {
      return a;
    } else {
      return b;
    }
  }

  public int sum(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }

  public double average(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return (double) sum / nums.length;
  }

  public int max(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    return max;
  }

  public int min(int[] nums) {
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < min) {
        min = nums[i];
      }
    }
    return min;
  }
}
