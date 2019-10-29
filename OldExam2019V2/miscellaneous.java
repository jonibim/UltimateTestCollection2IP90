// Question 1 -- Miscellaneous

/* 1.1
 * There are three local variables:
 * 1. double slithy
 * 2. int gyre
 * 3. double jubjubbird
 *
 * 1.2
 * There are only two instances of class Gnomes created
 * Gnome g and Gnome h
 * The Gnome array gnomes is being filled with the same
 * instance class Gnome g so no new new class is created
 *
 * 1.3
 * The method checks if there is any Zero in the array,
 * if it find a zero somewhere in the array, by searching
 * with the for loop every elements, it switched the flag
 * (the boolean result) from false to true, and than returns
 * that value. If it doesn't find any zero it returns the
 * default value assigned to the flag which is false;
 *
 * 1.4
 * We should add the base case first which says that
 * if the numbers.length == 0 it should return true
 * (as requested in the exercise)
 * We should get rid off the boolean variable and change the condition
 * inside the loop to check if the number in the index i of the array
 * is not equal to zero, it should return false.
 * Outside the loop, in the end of the method we should write
 * return true, which tells us that the loop didnt not find any number
 * other than zero so it should return true.
 *
 *       class Demonstration1Dot4 {
 *           boolean m(int[] numbers) {
 *               if (numbers.length==0){
 *                   return true;
 *               }
 *               for (int i = 0; i < numbers.length; i++) {
 *                   if (numbers[i] != 0) {
 *                       return false;
 *                   }
 *               }
 *               return true;
 *           }
 *       }
 *
 */
