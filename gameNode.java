package datingGame;


class gameNode {


   //this class defines a node in the game tree of cognac. It consists of the following fields
   //this indicates the node type: There are 4 players, so the node type values are in the set: {1,2,3,4}
   //byte nodeType;

   byte[][] gameState;

   //in this game, which has 4 players, an array is needed to represent the values for each player at this node.
   int[] valueArray;

   //this allows us to associate a gameNode object with the chosen game branch. IOW, it allows us to know
   //which player(s) the current player decided to talk to during a given interaction

   String sourceMarker;


   //an array of refrences to other game node objects. This will help us traverse our game tree once
   //it has been generated

   gameNode[] links;

   public gameNode(int nop) {

     // nodeType = type;

      //initialize valueArray such that all values are at a minimum, which I designate to be -99. This is done because
      //each player seeks to maximize their own utility value as they strive towards the object of their desire.

      valueArray = new int[nop];

      for (int i = 0; i < nop; i++)
         valueArray[i] = -99;


      //initialize each gamestate to default empty value
      gameState = new byte[nop][nop];

      //init sourceMarker
      sourceMarker = null;


   }//constructor gameNode



   public int getNodeValue(int playerID) {

      return valueArray[playerID];

   }//method getNodeValue


    public byte[][] getGameState() {

         return gameState;

      }//method getGameState


      public void setGameState (byte[][] state) {

         gameState = state;

      }//method setGameState

      public void setSourceMarker (String idStr) {

         sourceMarker = idStr;

      }//method setSourceMarker

      public String getSourceMarker () {

	     return sourceMarker;

	  }//method getSourceMarker



     //method to print out a gameState
	  public void printState () {

            int k = 0;

	        //System.out.println("Current state being printed is: \n");

	        for (int i = 0; i < gameState.length; i++)  {

	  	     for (int j = 0; j < gameState[i].length; j++)  {

	               //each value in the gamestate is a byte value
	               //indicating the social benefit of talking to that person
	               //each j value here is the ID of the target, the i value
	               //is the ID of the current player

	               System.out.print("P" + i + "T" + j + ": " + gameState[i][j] + " ");

	               //print separator chars
	              // if (j < (gameState[i].length - 1))
	               //   System.out.print("|");

	               // playerMark = ' ';

	  	     }//end for

	          System.out.println();

	  		  	     k = 0;

	  	     System.out.println();

	       }//end for

	       System.out.println();
	       System.out.println();


	     }//method printState



}//class gameNode