/**
 * SevenSearch -- solution to exercise 4 of exam 2ip90 of 20 January 2015
 * 
 * @author Kees Huizing
 */

class SevenSearch {
    
     boolean has7( int[] a)  {
         return has7( a, 0, a.length );
     }
    
     boolean has7( int[] a, int lo, int hi ) {
         if ( hi - lo < 1 ) { 
             return false;
         } else if ( hi - lo == 1 ) {
             return a[lo] == 7; 
         } else {
             int m = (hi + lo)/2;
             if ( 7 < a[m] ) {
                 return has7( a, lo, m );
             } else if ( a[m] < 7 ) {
                 return has7( a, m, hi );
             } else { // a[m] == 7
                 return true;
             }
         }
     }
     
     void test() {
         int[] a = { 1, 2, 4, 7, 8, 8, 9 };
         int[] b = new int[100];
         int n = -50;
         for (int i=0; i<b.length; i++) {
             b[i] = n;
             n += 4;
         }
         
         int[] c = { 7, 1, 2, 3, 4 }; // c is NOT SORTED
         
         System.out.println( has7(a, 0, 7) ); // should print true
         System.out.println( has7(a, 0, 3) ); // should print true
         System.out.println( has7(a, 4, 5) ); // should print true
         
         System.out.println( has7(a) );  // should print true
         
         System.out.println( has7(b) ); // should print false, since b contains only even numbers
     
         /*
          * The following is not a real test, it is meant to show the limitations of has7
          * It will print false, although c contains a 7
          * The reason that this is possible is that c is not sorted. 
          * has7 does NOT work for unsorted arrays
          */
         System.out.println( has7(c) ); 
     }
                  
     public static void main( String[] a ) {
         ( new SevenSearch() ).test();
     }
}
                 
             
         
                 
            
