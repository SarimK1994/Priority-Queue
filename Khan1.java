public class PriorityQueue 
{
   private Comparable[] HeapArray;
   private int Last, Limit;

   public PriorityQueue(int Capacity)
   {
      HeapArray = new Comparable[Capacity+1];
      Last      = 0;
      Limit     = Capacity;
      return;
   }
   // end constructor

   public PriorityQueue()
   {
      HeapArray = new Comparable[101];
      Last      = 0;
      Limit     = 100;
      return;
   }
   // end constructor

   public void Insert(Comparable PQI)
   {
      if (Last == Limit)
      {
         System.out.println("Priority Queue Overflow!");
         System.exit(0);
      }
      // end if

      HeapArray[++Last] = PQI;
      this.UpHeap(Last);
      return;
   }
   // end public method Insert

   private void UpHeap(int k)
   {
      Comparable V;

      V = HeapArray[k];
   
      while (k > 1  &&  HeapArray[k/2].compareTo(V) < 0)
      {
         HeapArray[k] = HeapArray[k/2];
         k = k/2;
      }
      // end while

      HeapArray[k] = V;
      return;
   }
   // end private method UpHeap

   public Comparable Remove()
   {
      Comparable PQI ;

      if (Last == 0)
      {
         System.out.println("Priority Queue Underflow!");
         System.exit(0);
      }
      // end if

      PQI = HeapArray[1];
      HeapArray[1] = HeapArray[Last--];
      this.DownHeap(1);
      return PQI;
   }
   // end public method Remove

   private void DownHeap(int k)
   {
      Comparable V;
      int    j;

      V = HeapArray[k];
   
      while (k <= Last/2)
      {
         j = k+k;

         if (j < Last  &&  HeapArray[j].compareTo(HeapArray[j+1]) < 0)
            j++;
         // end if

         if (V.compareTo(HeapArray[j]) >= 0)
            break;
         // end if

         HeapArray[k] = HeapArray[j];
         k = j;
      }
      // end while

      HeapArray[k] = V;
      return;
   }
   // end private method DownHeap

   public boolean IsEmpty()
   {
      if (Last == 0)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsEmpty

   public boolean IsFull()
   {
      if (Last == Limit)
         return true;
      else
         return false;
      // end if
   }
   // end public method IsFull

   public int Length()
   {
      return Last;
   }
   // end public method Length
   
   public int PriorityCount (Comparable X)
   {
      int i;
      int count = 0; 
      
      if (this.IsEmpty())
      {
         return count; 
      }
     
      else
      { 
         for (i = 1; i<=Last; i++)
         {
            if (X.compareTo(HeapArray[i]) == 0)
            {
               count++; 
            }    
         }    
      }
      return count; 
   }
   //end public method PriorityCont
   
   public Comparable RemoveLowest ()
   {
      Comparable Temp1, Temp2, Temp3; 
      int i; 
      
      if (Last == 0)
      {
         System.out.println("PriorityQueue Underflow has occured."); 
         System.exit(0); 
      }
      
      for (i = 1; i<=Last; i++) 
      {
         if (HeapArray[Last].compareTo(HeapArray[i])>0)
         {
            Temp2 = HeapArray[Last]; 
            Temp1 = HeapArray[i]; 
            HeapArray[i] = Temp2; 
            HeapArray[Last] = Temp1; 
         }
      }
      
      Temp3 = HeapArray[Last--]; 
      return Temp3; 
   }
   //end public method RemoveLowest

   public void InsertAndDestroyAllSuperiors(Comparable X)
   {
      int i; 
      
      if (Last == Limit)
      {
         System.out.println("PriorityQueue Overflow has occured."); 
         System.exit(0); 
      }
      
      else 
      {
         HeapArray[++Last] = X; 
      }
      
      while (X.compareTo(HeapArray[1])<0)
      {
         for (i=1; i<Last; i++)
         {
            if (X.compareTo(HeapArray[i])<0)
            {
            this.Remove(); 
            }
         }
      } 
         
      this.UpHeap(Last);     
      return; 
   }
   
   //end public method InsertAndDestroyAllSuperiors
}
// end class PriorityQueue
