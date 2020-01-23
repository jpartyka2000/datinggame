package datingGame;

import java.util.*;

class PriorityQueue {


   private int count;
   private gameNode[] nodes;
   private int capac;

   public PriorityQueue(int capacity) {

      //initialize count
      count = 0;

	  //initialize state array. I choose 10 just to make sure that the PriorityQueue has enough capacity
	  nodes = new gameNode[capacity];

	  capac = capacity;

   }//constructor PriorityQueue


   public void insert(gameNode newnode) {

      nodes[count] = newnode;
      count++;


   }//method insert

   public int size() {

       return count;

   }//method size

   public int getCapacity() {

      return capac;

   }//method getCapacity

   public boolean isEmpty() {

      if (count > 0)
         return false;
      else
         return true;


   }//method isEmpty

   public gameNode remove(int playerID) {

      //this method will determine the gameNode of highest priority based on utility value

      int playerValue = 0;
      Random tieBreakGen = new Random();

      int maxValue = nodes[0].valueArray[playerID];
      int maxIndex = 0;
      gameNode maxNode = nodes[0];

      String comma = " ";

      if (count == 0) {

	     return null;

      } else {

        //  nodes[0].printState();

        //  System.out.println("Child state has utility value of: {" + "\n");

        //     for (int k = 0; k < nodes[0].valueArray.length; k++) {

        //        System.out.print(comma + nodes[0].valueArray[k]);
        //        comma = ",";

  		//    }//end for

 		    System.out.println();
            System.out.println();
            System.out.println();

         for (int i = 1; i < count; i++) {

		//	nodes[i].printState();

        //    System.out.println("Child state has utility value of: {" + "\n");
//
        //    for (int k = 0; k < nodes[i].valueArray.length; k++) {
//
        //       System.out.print(comma + nodes[i].valueArray[k]);
        //       comma = ",";

		//    }//end for


            //next, we need to take the valueArrays for each node, and extract the relevant integer value
            //according to the playerID param

            playerValue = nodes[i].valueArray[playerID];

            if (playerValue >= maxValue) {

               maxValue = playerValue;
               maxIndex = i;
               maxNode = nodes[i];

		    }//end if


	     }//end for

         //we know what the highest value is; now we just need to plug in the hole left vacant
         //by the now returned lowest value

         //System.out.println(nodes[maxIndex].getSourceMarker());
         //System.exit(0);
         nodes[maxIndex] = nodes[--count];

         return maxNode;



      }//end if



  }//method remove



}//class PriorityQueue