/**
 * sample
 */

public class Main 
{
     static void merge ( int arr[] , int l, int mid, int r)
     {
          int n1= mid-l+1;   // [l, mid] mid-l+1
          int n2= r- mid;    // [mid+1, r]  r- ( mid+1)+1

          int L[]= new int[n1];

          int R[]= new int[n2];

          for( int i=0;i<n1;i++)
          {
               L[i] = arr[l+i];  //arr[l] , arr[l+1], arr[l+2]
          }
          for ( int i=0;i<n2 ;i++)
          {
                R[i]= arr[mid+1+i]; // arr[mid+1], arr[mid+2], arr[mid+3]
          }

          int i=0, j=0;

          int k=l;

          while( i< n1 && j< n2)
          {
               if( L[i]<= R[j])
               {
                    arr[k]= L[i];
                    k++;
                    i++;
               }
               else
               {
                    arr[k]= R[j];
                    j++;
                    k++;
               }
          }

          while( i< n1)
          {
                arr[k]= L[i];
                i++;
                k++;
          }

          while( j<n2)
          {
               arr[k]= R[j];
               j++;
               k++;
          }


     }
    static void sort( int arr[], int l, int r)
    {
        if( l<r )
        {
             int mid= (l+r)/2;

             sort(arr, l, mid);

             sort(arr, mid+1, r);

             merge( arr, l, mid,r);
        }
    }
    public static void main(String[] args) 
    {
           int arr[]= {9,6,3,4,2,8,7,1};
           int n= arr.length;
           sort( arr,0, n-1 );

           for( int i=0;i<n;i++)
           {
                System.out.print(arr[i]+" ");
           }


    }
}
=== Code Output ===
1 2 3 4 6 7 8 9 
=== Code Execution Successful ===
