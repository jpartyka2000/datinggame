
package datingGame;

import java.util.*;

class datingDemo {


   public static void main(String[] args) {


      //grab value of n, specified by user, or set default value if not specified by user
      int n = 4;

      try {

         n = Integer.parseInt(args[0]);

      } catch (Exception e) {

         //set default value of 3
         n = 4;

      }//end catch


      //create new datingSim object with a max moves number of 5
      datingSim ds = new datingSim(n, 5);

      //create initial state node. It passes to the gameNode constructor the number of players participating
      gameNode initState = new gameNode(n);

      // System.out.println("Finished! A total of " + ds.totalNodes + " nodes were printed");

      ///do tree traversal algorithm, with all players playing optimally.
      //I can only look ahead 5 moves before hardware limitations assert their angst upon me, so
      //I will segment the outing into 4 parts of 5.

       //initiate the construction of the game tree
	   int[] rootVals = ds.maximizeValue(0, initState, 1);

	   //get the first player's name
	   String playerNm = ds.players[0].getPlayerName();

	   String outingLocation = Language.setOutingLocation(playerNm);

	   System.out.println("The friends decide to go out again. It will take place at: " + outingLocation);

       gameNode bottomNode = ds.traverseGameTree(initState, 1, 0, outingLocation);


      int numberOfOutings = 4;
      int outingNumber = 0;

      int outingTimer = 1;
      int nextPlayerToMove = 4 % n;



      while (outingNumber < numberOfOutings) {

		  //here we will choose a new outing based on Language class
		  //outingLocation = Language.setOutingLocation();

         int[] nextVals;

         while (outingTimer < 4) {

            // System.out.println("The next node in the game is: ");
            gameNode nxtNode = new gameNode(n);

            nextVals = ds.maximizeValue(nextPlayerToMove, nxtNode, 1);

            nxtNode = ds.traverseGameTree(nxtNode, 4, nextPlayerToMove, outingLocation);
            outingTimer++;

            nextPlayerToMove = (outingTimer * 4) % n;


        }//end while

        ds.printOODFreq();
        outingNumber++;

        outingTimer = 0;

        //now we must enact player and relationship changes here
        ds.enactPlayerChanges();
        ds.enactRelationshipChanges();

        nextPlayerToMove = 0;

        //System.exit(0);

        outingLocation = Language.setOutingLocation(playerNm);
        System.out.println();
        System.out.println("The friends decide to go out again. It will take place at: " + outingLocation);

      }//end while

      System.out.println("Game over man!");

   }//end main



}//class datingDemo