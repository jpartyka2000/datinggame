package datingGame;

import java.util.*;


class datingSim {


   //the array of player objects that represent the group of friends
   Player[] players;

   //the number of players participating in this game
   int numberOfPlayers;

   //the maximum number of allowable moves per outing
   int maxMoves;

   //the number of nodes in the game tree
   int totalNodes = 0;

   //the number of times the OOD was chosen
   int OODChoice = 0;

   //the number of all selections in the game
   int totalChoice = 0;



   public datingSim(int numOfPlayas, int maxMvs) {

      numberOfPlayers = numOfPlayas;

      maxMoves = maxMvs;

      Random genderGen = new Random();

      //initialize array player objects here
      players = new Player[numberOfPlayers];

      //initialize each individual player object here. We need to ensure that there is at least 1 male and 1 female

      for (int i = 0; i < 2; i++) {

         players[i] = new Player(i, numOfPlayas, i);

      }//end for

      //if there are more players, just assign the genders randomly
      for (int j = 2; j < players.length; j++) {

        players[j] = new Player(j, numOfPlayas, genderGen.nextInt(2));

      }//end for

      //now I need to establish whether there are any relationships between players or not. In the beginning of the game
      //, relationships, if any, will be determined randomly. This will create maximize tactical gameplay and
      //change

      Random relGen = new Random();
      Random playerGen = new Random();
      int relNum = 0;
      int playerNum = 0;

      for (int d = 0; d < players.length; d++) {

	     //the probability of a relationship occurring here is 50/50

	     relNum = relGen.nextInt(players.length);
	     playerNum = playerGen.nextInt(players.length);

         //if the random num generator has decided in favor of a relationship, and both current player and randomly selected
         //player are single, and the current player is NOT the same as the randomly selected player, and both have different genders,
         //then

	     if (relNum != 1 && players[d].getDatingPartner() == null && players[playerNum].getDatingPartner() == null && playerNum != d && players[d].getGender() != players[playerNum].getGender()) {

            players[d].setDatingPartner(players[playerNum].getPlayerName());
            players[d].datingPartnerID = players[playerNum].playerID;
            players[playerNum].setDatingPartner(players[d].getPlayerName());
            players[playerNum].datingPartnerID = players[d].playerID;

	     }//end if


	  }//end for

      //This is part of the process of establishing social bonds between the players. In turn, doing this depends upon
      //how similar their personality traits are, both the outing traits and the attraction qualities. Social bond
      //strength is a major factor (but not the only factor) in determining the OOD for a given player is.
      //also, because the social bond strength is based on similarities, it is mutual. However,
      //there are other factors such as one's job, one's relationship status and one's overall social charm
      //that also determine mutual attraction, and these fall outside of an individual measurement of social bond strength

      //use player trait similarities (or lack thereof) to determine social bond strength
      //the social bond strength will be mutual for simplicity

      for (int outer = 0; outer < players.length; outer++) {

	     for (int inner = 0; inner < players.length; inner++) {

            //if the 2 players are not the same playe, and the bond has not been set up yet...

            if (outer != inner && players[outer].socialBonds[inner] == 0)
               players[outer].setSocialBond(players[inner]);

	     }//end for

      }//end for

      //now I need to calculate the social charm for each player

       for (int p = 0; p < players.length; p++) {

	      calculateSocialCharm(p);

       }//end for


      //finally, I must determine the object of desire for each player, based on their social bond strength values,
      //with the other players, and based on job status, social charm, relationship status, and
      //and the special quirks of each personality trait.

      calculateOOD();

       for (int p = 0; p < players.length; p++) {

	     players[p].printPlayer();

       }//end for

    }//constructor datingSim


     public void calculateSocialCharm(int pID) {

	     //calculating the social charm value is simply a matter of taking the average
	     //of all social bond strength values

	     int charmTotal = 0;

	     for (int j = 0; j < players.length; j++) {

	        if (j != pID)
	           charmTotal += players[pID].socialBonds[j];

	     }//end for

	     int socialCharm = (int)(charmTotal / (players.length - 1));

         //set final social charm value for this player
         players[pID].setSocialCharm(socialCharm);


	  }//method calculateSocialCharm



    //this method causes random changes in players
    //between outings. The changes can affect any trait or attraction quality
    //it can also affect job status and relationship status

   public void enactPlayerChanges() {


      System.out.println("**********************************");
	  System.out.println("So what individual changes among our group of friends have occurred since the last outing???");
	  System.out.println("**********************************");
      System.out.println();

      for (int i = 0; i < players.length; i++) {

         Random changeGen = new Random();
         Random effectGen = new Random();
         Random moreGen = new Random();
         Random traitGen = new Random();
         Random amountGen = new Random();

         String traitStr = " ";

         int randNum = 0;

          //first off, will this player even change any traits? Theres a 50/50 chance
       /*  while (changeGen.nextInt(2) == 1) {

            //select the traits that have changed within this player
            //there is a 30% chance for every new trait added

            while(moreGen.nextInt(100) < 30) {

               randNum = traitGen.nextInt(6);

                  if (traitStr.indexOf(new Integer(randNum).toString()) == -1) {

                     //depending upon value of randNum, a trait will be changed for this player
                     //the change could be positive or negative, it is 50/50

                     int traitChng = amountGen.nextInt(15) + 1;

                     if (effectGen.nextInt() == 1) {

                        //this is a positive effect. Select a random positive development message
                        //from the Language class

                        System.out.println(Language.getPositiveTraitMsg(randNum, traitChng, players[i].getPlayerName()));

                        //and now change this trait in the player by value determined by amountGen
                        players[i].outingTraits[randNum] += traitChng;

				     } else {

                        //this is a negative effect. Select a random negative development message
                        //from the Language class

                        System.out.println(Language.getNegativeTraitMsg(randNum, traitChng, players[i].getPlayerName()));

                        //and now change this trait in the player by value determined by amountGen
                        players[i].outingTraits[randNum] -= traitChng;

				     }//end if

                     //add to traitStr
                     traitStr += new Integer(randNum).toString();


	              } //end if

		    }//end while


	     }//end while*/

	     traitStr = " ";


         //how about attraction qualities?
         while (changeGen.nextInt(2) == 1) {

            //select the attraction qualities that have changed within this player
            //there is a 30% chance for every new quality added

            while(moreGen.nextInt(100) < 30) {

               randNum = traitGen.nextInt(3);

                  if (traitStr.indexOf(new Integer(randNum).toString()) == -1) {

                     //depending upon value of randNum, a trait will be changed for this player
                     //the change could be positive or negative, it is 50/50

                     int attChng = amountGen.nextInt(20) + 1;

                     if (effectGen.nextInt(2) == 1) {

                        //this is a positive effect. Select a random positive development message
                        //from the Language class

                        System.out.println("For " + players[i].getPlayerName() + ": " + Language.getPositiveAttMsg(randNum, attChng, players[i].getGender(), players[i].getPlayerName()));
                        System.out.println();

                        //and now change this trait in the player by value determined by amountGen
                        players[i].attractionValues[randNum] += attChng;

				     } else {

                        //this is a negative effect. Select a random negative development message
                        //from the Language class

                        System.out.println("For " + players[i].getPlayerName() + ": " + Language.getNegativeAttMsg(randNum, attChng, players[i].getGender(), players[i].getPlayerName()));
                        System.out.println();

                        //and now change this trait in the player by value determined by amountGen
                        players[i].attractionValues[randNum] -= attChng;

				     }//end if

                     //add to traitStr
                     traitStr += new Integer(randNum).toString();


	              } //end if

		    }//end while


	    }//end while


         traitStr = " ";

         //what about job status?
         //there is a 20% chance of a job change; the change is either gettig fired and subsequently
         //landing a lower tier job, or a getting a higher tier job
         //first off, can job change occur?

         if (changeGen.nextInt(5) == 1) {

            Job playerJob = players[i].getJob();
            int jt = playerJob.getTier();

            //job will change, will it be for the better or for the worse? It is 50/50
            if (changeGen.nextInt(2) == 1) {

               //change job tier and job
			   players[i].getJob().setNewJob(jt + 1);

		       //positive change in job. If the change can't go to any higher tier, then merely change the job
		       //Only a tier change actually changes anything

			   System.out.println("For " + players[i].getPlayerName() + ": " + Language.getPositiveJobChange(playerJob, players[i].getPlayerName()));

	        } else {

			  //negative change in job. If the change can't go to any lower tier, then merely change the job
			  //Only a tier change actually changes anything

			  System.out.println("For " + players[i].getPlayerName() + ": " + Language.getNegativeJobChange(playerJob, players[i].getPlayerName()));

			  //change job tier and job
			  players[i].getJob().setNewJob(jt - 1);

			  System.out.println(players[i].getPlayerName() + " was forced to get a job as a " + players[i].getJob().getJobName());
              System.out.println();

		    }//end if


	     }//end if


      }//end for


      System.out.println();

   }//method enactPlayerChanges


   public void enactRelationshipChanges() {

//finally, print the latest status for each player here
	        for (int pl = 0; pl < players.length; pl++) {

	           players[pl].printPlayer();


      }//end for

      //first, I must calculate social bond changes based on the changes in personality that have occurred.

      for (int outer = 0; outer < players.length; outer++) {

	  	     for (int inner = 0; inner < players.length; inner++) {

	              //if the 2 players are not the same player, and the bond has not been set up yet...

	              if (outer != inner)
	                 players[outer].setSocialBond(players[inner]);

	  	     }//end for

	  }//end for


	  //now I need to recalculate the social charm for each player

	  for (int p = 0; p < players.length; p++) {

	     calculateSocialCharm(p);

      }//end for

      //given the changes in the players, I need to recalculate the OOD values between all the players
      //if the OOD value between a player and the dating partner do not match, then the current relationship
      //will end and the new one will be formed. If the OOD value
      //for more than 1 person exceeds that of the current partner, then the person with the higher OOD value wins.
      //so I need to save the old OODs before the new ones are calculated.


      //recalculate OOD values
      calculateOOD();


      //now for each player, get new OOD value and compare against old one. If there is a change that is greater than the OOD
      //value that he has for the dating partner that exceeds 5 points, then the relationship is over.
      //we need to keep track of the index for which there is a max OOD value. That new person, if of the opposite gender,
      //will be the new boyfriend/girlfriend - this happens later

      System.out.println("**********************************");
      System.out.println("So have any relationships changed among our group of friends in between outings????");
      System.out.println("**********************************");
      System.out.println();


      for (int n = 0; n < players.length; n++) {

         int dateID = players[n].datingPartnerID;

	     if (players[n].getOOD() != players[n].datingPartnerID && players[n].datingPartnerID != -1)  {

	        //this signals a breakup. Wipe out dating partner name and ID
	        players[n].setDatingPartner(null);

	        //we also need to do this for the other as well, whether he/she wants to or not
	        players[dateID].setDatingPartner(null);

           //nullify dating partner IDs
           players[dateID].datingPartnerID = -1;
           players[n].datingPartnerID = -1;

           //add a little message
           System.out.println(players[n].getPlayerName() + " breaks up with " + players[dateID].getPlayerName() + "!");
           System.out.println();

	     } else {

	        int OOD_val = players[n].getOOD();

	        System.out.println(players[n].getPlayerName() + " is attracted to " + players[OOD_val].getPlayerName());
	        System.out.println();

	     }//end if

      }//end for


      //here is where I establish new relationships, if any. A relationship will only occur if
      //2 players are OODs of each other, and if the random number generator condition is met -- 66% chance
      //of being met, but only after symmetric OODs are discovered between 2 players

      int thisPlayerOOD = 0;
      int otherPlayerOOD = 0;
      Random relationGen = new Random();

        for (int n = 0; n < players.length; n++) {

             thisPlayerOOD = players[n].getOOD();
             otherPlayerOOD = players[thisPlayerOOD].getOOD();

	  	     if (n == otherPlayerOOD && (players[n].getGender() != players[thisPlayerOOD].getGender()) && players[n].datingPartnerID == -1 && players[thisPlayerOOD].datingPartnerID == -1)  {

                System.out.println(players[n].getPlayerName() + " and " + players[thisPlayerOOD].getPlayerName() + " seem right for each other. Will they initiate a relationship?");
                System.out.println();

                //use random number generator to determine whether these two will start a relationship
                if (relationGen.nextInt(3) != 0) {

                   //they have decided to start dating
                   System.out.println("Yes! " + players[n].getPlayerName() + " and " + players[thisPlayerOOD].getPlayerName() + " are now officially a couple!");

                   //set the dating names and IDs for each
                   players[n].datingPartnerID = thisPlayerOOD;
                   players[thisPlayerOOD].datingPartnerID = n;

                   players[n].setDatingPartner(players[thisPlayerOOD].getPlayerName());
                   players[thisPlayerOOD].setDatingPartner(players[n].getPlayerName());


			    } else {

                  //they have decided to not do anything just yet
                   System.out.println("No.....Hmm.... " + players[n].getPlayerName() + " and " + players[thisPlayerOOD].getPlayerName() + " appear reluctant to become a couple for some reason.\n");

			    }//end if


	  	     }//end if

      }//end for



   }//method enactRelationshipChanges




   public void calculateOOD() {

      //calcuting the OOD for a given player depends upon the following factors
	  //(1: social bond strength (2: job status of other players (3:
	  //relationship status, which is a detriment in all cases except those where a romantic
	  //dominated personality is involved (4: social charm (5: Other personality quirks

	  int OODValue = 0;
	  int maxValue = 0;
	  int maxIndex = 0;
	  int relationshipDeterrent = 1;
	  int relCount = 0;
	  int selfishPenalty = 0;
	  int loyaltyBonus = 0;


	  for (int out = 0; out < players.length; out++) {

	    for (int p = 0; p < players.length; p++) {

	        if (out != p && (players[out].getGender() != players[p].getGender())) {

				//if current player is in a relationship, then increse rel count
				if (players[out].getDatingPartner() != null)
				   relCount++;

				//if target player is in a relationship, then increase rel count again
				if (players[p].getDatingPartner() != null && p != players[out].datingPartnerID)
				   relCount++;


               //if the player is a romantic, then a potential in a relationship
               //will actually be more desireable. For all others, less desireable

               if (players[out].getDominantTrait() == 3) {

                  relationshipDeterrent = -1;

		       }//end if

		       //if the target player is selfish (with a threshold of 90, then this will reduce his/her desireability
		       //for all other players

               if (players[p].outingTraits[4] > 90) {

                  selfishPenalty += 10;

		       }//end if


               if (players[p].getDominantTrait() == 4) {

                  selfishPenalty += 10;

		       }//end if

		       if (players[out].outingTraits[5] > 90 && p == players[out].datingPartnerID) {

			      loyaltyBonus += 10;

			   }//end if


		       if (players[out].getDominantTrait() == 5 && p == players[out].datingPartnerID) {

			      loyaltyBonus += 10;

		       }//end if


	           OODValue = players[out].socialBonds[p] -
	              (Math.abs(players[out].getJob().getTier() - players[p].getJob().getTier()) * 10) -
                  (relationshipDeterrent * relCount * 10) + players[p].getSocialCharm() - selfishPenalty + loyaltyBonus;


               System.out.println(players[out].getPlayerName() + " OOD value for " + players[p].getPlayerName() + " is: " + OODValue);

	           if (OODValue > maxValue) {

	              maxValue = OODValue;
	              maxIndex = p;

		       }//end if


	     	 }//end if

	     	 selfishPenalty = 0;

	    }//end for

	    //based on calculations of OOD, set OOD_ID for this player and the specific value calculated
	    players[out].setOOD(maxIndex);
	    players[out].setOODValue(maxValue);

	    //reset vars
	    relCount = 0;
	    relationshipDeterrent = 1;
	    OODValue = 0;
	    maxValue = 0;
		maxIndex = 0;
		loyaltyBonus = 0;


     }//end for

     System.out.println();

   }//method setOOD

   public int calculateSingleOOD (Player player1, Player player2, int playerID, int targetID) {


      int relCount = 0;
      int selfishPenalty = 0;
      int loyaltyBonus = 0;
      int relationshipDeterrent = 0;
      int OODPenalty = 0;

      //element of randomness added to the interaction
      int randomFactor = 0;

      //the random Factor may be positive or negative; this var determines that
      int randomSign = 0;

      //finally, the OOD value
      int OODValue = 0;

      if (players[playerID].OOD_ID == targetID)
         OODPenalty = -10;


      //if current player is in a relationship, then increse rel count
      if (players[playerID].getDatingPartner() != null)
         relCount++;

  	  //if target player is in a relationship with someone other than the curr player, then increase rel count again
  	  if (players[targetID].getDatingPartner() != null && targetID != players[playerID].datingPartnerID)
  	     relCount++;

      //if the player is a romantic, then a potential in a relationship
      //will actually be more desireable. For all others, less desireable

  	  if (players[playerID].getDominantTrait() == 3) {

  	     relationshipDeterrent = -1;

  	  }//end if

  	  //if the target player is selfish (with a threshold of 90, then this will reduce his/her desireability
  	  //for all other players

  	  if (players[targetID].outingTraits[4] > 90) {

  	     selfishPenalty -= 10;

  	  }//end if


  	  if (players[targetID].getDominantTrait() == 4) {

  	     selfishPenalty -= 10;

  	  }//end if

  	  if (players[playerID].outingTraits[5] > 90 && targetID == players[playerID].datingPartnerID) {

  	     loyaltyBonus += 10;

  	  }//end if


  	  if (players[playerID].getDominantTrait() == 5 && targetID == players[playerID].datingPartnerID) {

  	     loyaltyBonus += 10;

  	  }//end if

  	  //finally determine random factor, which will more accurately depict the randomness of interaction in
      //conversations

      Random rfGen = new Random();
      Random signGen = new Random();

      int signVal = 0;

      //determine signGen value

      if (signGen.nextInt(2) == 0)
         signVal = 1;
      else signVal = -1;

      randomFactor = signVal * (rfGen.nextInt(15));
      //randomFactor = 0;


     OODValue = (int)((players[playerID].socialBonds[targetID] -
                (Math.abs(players[playerID].getJob().getTier() - players[targetID].getJob().getTier()) * 10) -
                (relationshipDeterrent * relCount * 10) + players[targetID].getSocialCharm() - selfishPenalty + OODPenalty + loyaltyBonus +
                randomFactor) / 2);

     return OODValue;

   }//method calculateSingleOOD


    public String idToName(int id) {

       return players[id].getPlayerName();

    }//method idToName


    public gameNode[] getSuccessors(gameNode currentNode, int playerID) {


       //there will always be 6 successors for each move, and no premature
       //terminal nodes. Also, each move will have a consequence expressed as a
       //numeric value that gets added (or subtracted) to the relevant entries
       //in the game state matrix. Just as with OOD calculations, much of this will depend upon
       //the social bond value, social charm, job similarities, and individual quirks of personality
       //there are some differences however. There is a group dynamic that will divide the points
       //Also, there is a higher degree of randomness involved -- it is possible that each
       //action by a player could be received positively or negatively, or somewhat neutrally.

       gameNode[] succStates = new gameNode[(int)Math.pow(2.0, (double)(numberOfPlayers - 1))];
       byte[][] currGameState = currentNode.getGameState();

       Random groupGen = new Random();
       float groupMult = 0;

       if (groupGen.nextInt(2) == 1)
          groupMult = (float)1.01;
       else
          groupMult = (float).98;




       for (int i = 0; i < succStates.length; i++)  {

          succStates[i] = new gameNode(numberOfPlayers);

       }//end for


       //here, it is assumed that we can talk to any of the other players individually.
	   //Determine the odds of a successful interaction
       //for each

       int[] socialBenefit = new int[numberOfPlayers];

       for (int i = 0; i < numberOfPlayers; i++)  {

	      //calculate the resulting benefit of this player talking to player i
	      //individually. This value will be a function of social bond strength
	      //plus a degree of randomness that will make things more interesting
	      //the value will be nonnegative

	      if (playerID != i) {

	          socialBenefit[i] = calculateSingleOOD(players[playerID], players[i], playerID, i);

	        //need to alter the currentState
            byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

            //perform a deep copy of currGameState to newState
            for (int x = 0; x < newState.length; x++) {

		       for(int y = 0; y < newState[x].length; y++) {

                  newState[x][y] = currGameState[x][y];

		  	   }//end for

		    }//end for

            //add social benefit here
            newState[playerID][i] = (byte)socialBenefit[i];

            //assign to relevant gameNode object
            succStates[i].setGameState(newState);

            //assign players associated with this node
            succStates[i].setSourceMarker(new Integer(i).toString());

	     }//end if


	   }//end for


	   //for 3 person interactions, I will merely take the calculated social benefits for each individual interaction
	   //and multiply by .75. For 4 person interactions, the multiplier will be .65.

       //for the pairs in a 4 or 5 player game, I will use a nested loop to cycle through all of them
       //but first, calculate new social benefit values

       int currGameStateCnt = numberOfPlayers;

       if (playerID != 1 && playerID != 2) {

           //need to alter the currentState
           byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

           //perform a deep copy of currGameState to newState
           for (int x = 0; x < newState.length; x++) {

		      for(int y = 0; y < newState[x].length; y++) {

                 newState[x][y] = currGameState[x][y];

			  }//end for

		   }//end for


          newState[playerID][1] = (byte)(groupMult * socialBenefit[1]);
          newState[playerID][2] = (byte)(groupMult * socialBenefit[2]);
          succStates[currGameStateCnt].setGameState(newState);

          //assign players associated with this node
          String src = "1-2";
          succStates[currGameStateCnt].setSourceMarker(src);

          currGameStateCnt++;

       }//end if

       if (playerID != 1 && playerID != 3) {

		   //need to alter the currentState
		    byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		    //perform a deep copy of currGameState to newState
		    for (int x = 0; x < newState.length; x++) {

		       for(int y = 0; y < newState[x].length; y++) {

		          newState[x][y] = currGameState[x][y];

		       }//end for

		   }//end for

		   newState[playerID][1] = (byte)(groupMult * socialBenefit[1]);
	       newState[playerID][3] = (byte)(groupMult * socialBenefit[3]);
		   succStates[currGameStateCnt].setGameState(newState);

		   //assign players associated with this node
		   String src = "1-3";
           succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

      }//end if


       if (playerID != 0 && playerID != 1) {

	      //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		  //perform a deep copy of currGameState to newState
		  for (int x = 0; x < newState.length; x++) {

		     for(int y = 0; y < newState[x].length; y++) {

		        newState[x][y] = currGameState[x][y];

		     }//end for

		  }//end for

		  newState[playerID][0] = (byte)(groupMult * socialBenefit[0]);
		  newState[playerID][1] = (byte)(groupMult * socialBenefit[1]);
		  succStates[currGameStateCnt].setGameState(newState);

		  //assign players associated with this node
		  String src = "0-1";
          succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

       }//end if


       if (playerID != 0 && playerID != 2) {

	      //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		  //perform a deep copy of currGameState to newState
		  for (int x = 0; x < newState.length; x++) {

		        for(int y = 0; y < newState[x].length; y++) {

		           newState[x][y] = currGameState[x][y];

		        }//end for

		    }//end for

		    newState[playerID][0] = (byte)(groupMult * socialBenefit[0]);
		    newState[playerID][2] = (byte)(groupMult * socialBenefit[2]);
		    succStates[currGameStateCnt].setGameState(newState);

		    //assign players associated with this node
			 String src = "0-2";
             succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

       }//end if



       if (playerID != 0 && playerID != 3) {

	      //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		  //perform a deep copy of currGameState to newState
		  for (int x = 0; x < newState.length; x++) {

		     for(int y = 0; y < newState[x].length; y++) {

		        newState[x][y] = currGameState[x][y];

		     }//end for

		  }//end for

		  newState[playerID][0] = (byte)(groupMult * socialBenefit[0]);
		  newState[playerID][3] = (byte)(groupMult * socialBenefit[3]);
		  succStates[currGameStateCnt].setGameState(newState);

		  //assign players associated with this node
		  String src = "0-3";
          succStates[currGameStateCnt].setSourceMarker(src);

		  currGameStateCnt++;

       }//end if


       if (playerID != 2 && playerID != 3) {

	       //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	      //perform a deep copy of currGameState to newState
	      for (int x = 0; x < newState.length; x++) {

	         for(int y = 0; y < newState[x].length; y++) {

		         newState[x][y] = currGameState[x][y];

		      }//end for

		   }//end for

		   newState[playerID][2] = (byte)(groupMult * socialBenefit[2]);
		   newState[playerID][3] = (byte)(groupMult * socialBenefit[3]);
		   succStates[currGameStateCnt].setGameState(newState);

		   //assign players associated with this node
		   String src = "2-3";
           succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

      }//end if

        //special cases for 5 players

       if (playerID != 0 && playerID != 4 && numberOfPlayers == 5) {

	       //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	      //perform a deep copy of currGameState to newState
	      for (int x = 0; x < newState.length; x++) {

	         for(int y = 0; y < newState[x].length; y++) {

		         newState[x][y] = currGameState[x][y];

		      }//end for

		   }//end for

		   newState[playerID][0] = (byte)(groupMult * socialBenefit[0]);
		   newState[playerID][4] = (byte)(groupMult * socialBenefit[4]);
		   succStates[currGameStateCnt].setGameState(newState);

		   //assign players associated with this node
		   String src = "0-4";
           succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

       }//end if

       if (playerID != 1 && playerID != 4 && numberOfPlayers == 5) {

	       //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	      //perform a deep copy of currGameState to newState
	      for (int x = 0; x < newState.length; x++) {

	         for(int y = 0; y < newState[x].length; y++) {

		         newState[x][y] = currGameState[x][y];

		      }//end for

		   }//end for

		   newState[playerID][1] = (byte)(groupMult * socialBenefit[1]);
		   newState[playerID][4] = (byte)(groupMult * socialBenefit[4]);
		   succStates[currGameStateCnt].setGameState(newState);

		   //assign players associated with this node
		   String src = "1-4";
           succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

       }//end if

        if (playerID != 2 && playerID != 4 && numberOfPlayers == 5) {

	   	       //need to alter the currentState
	   		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	   	      //perform a deep copy of currGameState to newState
	   	      for (int x = 0; x < newState.length; x++) {

	   	         for(int y = 0; y < newState[x].length; y++) {

	   		         newState[x][y] = currGameState[x][y];

	   		      }//end for

	   		   }//end for

	   		   newState[playerID][2] = (byte)(groupMult * socialBenefit[2]);
	   		   newState[playerID][4] = (byte)(groupMult * socialBenefit[4]);
	   		   succStates[currGameStateCnt].setGameState(newState);

	   		   //assign players associated with this node
	   		   String src = "2-4";
	              succStates[currGameStateCnt].setSourceMarker(src);

	   		   currGameStateCnt++;

	          }//end if

	    if (playerID != 3 && playerID != 4 && numberOfPlayers == 5) {

	       //need to alter the currentState
		  byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	      //perform a deep copy of currGameState to newState
	      for (int x = 0; x < newState.length; x++) {

	         for(int y = 0; y < newState[x].length; y++) {

		         newState[x][y] = currGameState[x][y];

		      }//end for

		   }//end for

		   newState[playerID][3] = (byte)(groupMult * socialBenefit[3]);
		   newState[playerID][4] = (byte)(groupMult * socialBenefit[4]);
		   succStates[currGameStateCnt].setGameState(newState);

		   //assign players associated with this node
		   String src = "3-4";
           succStates[currGameStateCnt].setSourceMarker(src);

		   currGameStateCnt++;

       }//end if


      //Finally, account for situation where a player talks to the whole group
      //in this case, the social benefit is now only .66 of what it once was
      //for each individual. There are 4 separate triple values

      if (playerID != 0 && playerID != 2 && playerID != 3) {

	     //need to alter the currentState
	     byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	     //perform a deep copy of currGameState to newState
	     for (int x = 0; x < newState.length; x++) {

	        for(int y = 0; y < newState[x].length; y++) {

	           newState[x][y] = currGameState[x][y];

	        }//end for

	     }//end for

	     newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
	     newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
	     newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
	     succStates[currGameStateCnt].setGameState(newState);

	     //assign players associated with this node
		 String src = "0-2-3";
         succStates[currGameStateCnt].setSourceMarker(src);

      }//end if


      if (playerID != 0 && playerID != 1 && playerID != 3) {

	     //need to alter the currentState
	     byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	     //perform a deep copy of currGameState to newState
	     for (int x = 0; x < newState.length; x++) {

	        for(int y = 0; y < newState[x].length; y++) {

	           newState[x][y] = currGameState[x][y];

	        }//end for

	     }//end for

	     newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
	     newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
	     newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
	     succStates[currGameStateCnt].setGameState(newState);

	     //assign players associated with this node
		 String src = "0-1-3";
		 succStates[currGameStateCnt].setSourceMarker(src);


	 }//end if


     if (playerID != 0 && playerID != 1 && playerID != 2) {

	    //need to alter the currentState
	    byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	    //perform a deep copy of currGameState to newState
	    for (int x = 0; x < newState.length; x++) {

	       for(int y = 0; y < newState[x].length; y++) {

	          newState[x][y] = currGameState[x][y];

	       }//end for

	    }//end for

	    newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
	    newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
	    newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
	    succStates[currGameStateCnt].setGameState(newState);

	    //assign players associated with this node
	    String src = "0-1-2";
	    succStates[currGameStateCnt].setSourceMarker(src);


	}//end if

	 if (playerID != 1 && playerID != 2 && playerID != 3) {

	   //need to alter the currentState
	   byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	   //perform a deep copy of currGameState to newState
	   for (int x = 0; x < newState.length; x++) {

	      for(int y = 0; y < newState[x].length; y++) {

	         newState[x][y] = currGameState[x][y];

	      }//end for

	   }//end for

	   newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
	   newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
	   newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
	   succStates[currGameStateCnt].setGameState(newState);

	   //assign players associated with this node
	   String src = "1-2-3";
	   succStates[currGameStateCnt].setSourceMarker(src);


	}//end if

	//special cases for 5 players

	 if (numberOfPlayers == 5 && playerID != 0 && playerID != 1 && playerID != 4) {

		     //need to alter the currentState
		     byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		     //perform a deep copy of currGameState to newState
		     for (int x = 0; x < newState.length; x++) {

		        for(int y = 0; y < newState[x].length; y++) {

		           newState[x][y] = currGameState[x][y];

		        }//end for

		     }//end for

		     newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
		     newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
		     newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
		     succStates[currGameStateCnt].setGameState(newState);

		     //assign players associated with this node
			 String src = "0-1-4";
	         succStates[currGameStateCnt].setSourceMarker(src);

	      }//end if


       if (numberOfPlayers == 5 && playerID != 0 && playerID != 2 && playerID != 4) {

	  		     //need to alter the currentState
	  		     byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

	  		     //perform a deep copy of currGameState to newState
	  		     for (int x = 0; x < newState.length; x++) {

	  		        for(int y = 0; y < newState[x].length; y++) {

	  		           newState[x][y] = currGameState[x][y];

	  		        }//end for

	  		     }//end for

	  		     newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
	  		     newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
	  		     newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
	  		     succStates[currGameStateCnt].setGameState(newState);

	  		     //assign players associated with this node
	  			 String src = "0-2-4";
	  	         succStates[currGameStateCnt].setSourceMarker(src);

	  	      }//end if

	  	 if (numberOfPlayers == 5 && playerID != 0 && playerID != 3 && playerID != 4) {

		     //need to alter the currentState
		     byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		     //perform a deep copy of currGameState to newState
		     for (int x = 0; x < newState.length; x++) {

		        for(int y = 0; y < newState[x].length; y++) {

		           newState[x][y] = currGameState[x][y];

		        }//end for

		     }//end for

		     newState[playerID][0] = (byte)(.90 * socialBenefit[0]);
		     newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
		     newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
		     succStates[currGameStateCnt].setGameState(newState);

		     //assign players associated with this node
			 String src = "0-3-4";
	         succStates[currGameStateCnt].setSourceMarker(src);

	      }//end if

	      if (numberOfPlayers == 5 && playerID != 1 && playerID != 2 && playerID != 4) {

		      //need to alter the currentState
		      byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		      //perform a deep copy of currGameState to newState
		      for (int x = 0; x < newState.length; x++) {

		         for(int y = 0; y < newState[x].length; y++) {

		            newState[x][y] = currGameState[x][y];

		         }//end for

		      }//end for

		  	    newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
		  	    newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
		  	    newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
		  	    succStates[currGameStateCnt].setGameState(newState);

		  	    //assign players associated with this node
		  	    String src = "1-2-4";
		  	    succStates[currGameStateCnt].setSourceMarker(src);

		  }//end if

            if (numberOfPlayers == 5 && playerID != 1 && playerID != 3 && playerID != 4) {

		        //need to alter the currentState
		        byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		        //perform a deep copy of currGameState to newState
		        for (int x = 0; x < newState.length; x++) {

		           for(int y = 0; y < newState[x].length; y++) {

		              newState[x][y] = currGameState[x][y];

		           }//end for
	  	      }//end for

		      newState[playerID][1] = (byte)(.90 * socialBenefit[1]);
		      newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
		      newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
		      succStates[currGameStateCnt].setGameState(newState);

		      //assign players associated with this node
		      String src = "1-3-4";
		      succStates[currGameStateCnt].setSourceMarker(src);

		  }//end if


             if (numberOfPlayers == 5 && playerID != 2 && playerID != 3 && playerID != 4) {

		        //need to alter the currentState
		         byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		        //perform a deep copy of currGameState to newState
		         for (int x = 0; x < newState.length; x++) {

		            for(int y = 0; y < newState[x].length; y++) {

		               newState[x][y] = currGameState[x][y];

		            }//end for
		  	      }//end for

		        newState[playerID][2] = (byte)(.90 * socialBenefit[2]);
		        newState[playerID][3] = (byte)(.90 * socialBenefit[3]);
		        newState[playerID][4] = (byte)(.90 * socialBenefit[4]);
		        succStates[currGameStateCnt].setGameState(newState);

		        //assign players associated with this node
		        String src = "2-3-4";
		        succStates[currGameStateCnt].setSourceMarker(src);

		    }//end if


                if (numberOfPlayers == 5 && playerID != 0 && playerID != 1 && playerID != 2 && playerID != 3) {

		   		   //need to alter the currentState
		   		   byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

		   		   //perform a deep copy of currGameState to newState
		   		   for (int x = 0; x < newState.length; x++) {

		   		      for(int y = 0; y < newState[x].length; y++) {

		   		         newState[x][y] = currGameState[x][y];

		   		       }//end for
		   		    }//end for

		   		    newState[playerID][0] = (byte)(.85 * socialBenefit[0]);
		   		    newState[playerID][1] = (byte)(.85 * socialBenefit[1]);
		   		    newState[playerID][2] = (byte)(.85 * socialBenefit[2]);
		   		    newState[playerID][3] = (byte)(.85 * socialBenefit[3]);
		   		    succStates[currGameStateCnt].setGameState(newState);

		   		   //assign players associated with this node
		   		   String src = "0-1-2-3";
		   		   succStates[currGameStateCnt].setSourceMarker(src);

		       }//end if

		            if (numberOfPlayers == 5 && playerID != 0 && playerID != 1 && playerID != 2 && playerID != 4) {

			   	   //need to alter the currentState
			   	   byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

			   	   //perform a deep copy of currGameState to newState
			   	   for (int x = 0; x < newState.length; x++) {

			   	      for(int y = 0; y < newState[x].length; y++) {

			   	         newState[x][y] = currGameState[x][y];

			   	       }//end for
			   	    }//end for

			   	    newState[playerID][0] = (byte)(.85 * socialBenefit[0]);
			   	    newState[playerID][1] = (byte)(.85 * socialBenefit[1]);
			   	    newState[playerID][2] = (byte)(.85 * socialBenefit[2]);
			   	    newState[playerID][4] = (byte)(.85 * socialBenefit[4]);
			   	    succStates[currGameStateCnt].setGameState(newState);

			   	   //assign players associated with this node
			   	   String src = "0-1-2-4";
			   	   succStates[currGameStateCnt].setSourceMarker(src);

		       }//end if

		       if (numberOfPlayers == 5 && playerID != 0 && playerID != 1 && playerID != 3 && playerID != 4) {

			      //need to alter the currentState
			      byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

			      //perform a deep copy of currGameState to newState
			      for (int x = 0; x < newState.length; x++) {

			         for(int y = 0; y < newState[x].length; y++) {

			            newState[x][y] = currGameState[x][y];

			          }//end for
			       }//end for

			       newState[playerID][0] = (byte)(.85 * socialBenefit[0]);
			       newState[playerID][1] = (byte)(.85 * socialBenefit[1]);
			       newState[playerID][3] = (byte)(.85 * socialBenefit[3]);
			       newState[playerID][4] = (byte)(.85 * socialBenefit[4]);
			       succStates[currGameStateCnt].setGameState(newState);

			      //assign players associated with this node
			      String src = "0-1-3-4";
			      succStates[currGameStateCnt].setSourceMarker(src);

		       }//end if


		       if (numberOfPlayers == 5 && playerID != 0 && playerID != 2 && playerID != 3 && playerID != 4) {

			      //need to alter the currentState
			      byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

			      //perform a deep copy of currGameState to newState
			      for (int x = 0; x < newState.length; x++) {

			         for(int y = 0; y < newState[x].length; y++) {

			            newState[x][y] = currGameState[x][y];

			          }//end for
			       }//end for

			       newState[playerID][0] = (byte)(.85 * socialBenefit[0]);
			       newState[playerID][2] = (byte)(.85 * socialBenefit[2]);
			       newState[playerID][3] = (byte)(.85 * socialBenefit[3]);
			       newState[playerID][4] = (byte)(.85 * socialBenefit[4]);
			       succStates[currGameStateCnt].setGameState(newState);

			      //assign players associated with this node
			      String src = "0-2-3-4";
			      succStates[currGameStateCnt].setSourceMarker(src);

			   }//end if

			   if (numberOfPlayers == 5 && playerID != 1 && playerID != 2 && playerID != 3 && playerID != 4) {

			   	   //need to alter the currentState
			   	   byte[][] newState = new byte[numberOfPlayers][numberOfPlayers];

			   	   //perform a deep copy of currGameState to newState
			   	   for (int x = 0; x < newState.length; x++) {

			   	      for(int y = 0; y < newState[x].length; y++) {

			   	         newState[x][y] = currGameState[x][y];

			   	       }//end for
			   	    }//end for

			   	    newState[playerID][1] = (byte)(.85 * socialBenefit[1]);
			   	    newState[playerID][2] = (byte)(.85 * socialBenefit[2]);
			   	    newState[playerID][3] = (byte)(.85 * socialBenefit[3]);
			   	    newState[playerID][4] = (byte)(.85 * socialBenefit[4]);
			   	    succStates[currGameStateCnt].setGameState(newState);

			   	   //assign players associated with this node
			   	   String src = "1-2-3-4";
			   	   succStates[currGameStateCnt].setSourceMarker(src);

			   }//end if


      //we have created all of our successors, so return those nodes to maximizeFunction
      return succStates;


    }//method getSuccessors


   //this is the method where the game tree is constructed and all game states are determined

   public int[] maximizeValue(int playerID, gameNode currentNode, int moveLevel) {

      //for the dating game, for the default of 4 players, there are 6 possible conversational directions to take
      //3 consists of talking to the others individually, 2 consists of pairs, and the last consists of the entire group

      //determine if this node has at least 1 legal move to make
	  if (!outingOver(moveLevel)) {


         //grab successors of this state
         gameNode[] successorNodes = getSuccessors(currentNode, playerID);

         totalNodes += 7;


	     //these successors will also be the link references for the currentNode
	     currentNode.links = successorNodes;

	     moveLevel++;


         //explore each successor using DFS
         for (int k = 0; k < successorNodes.length; k++) {

             //skip over zero successor

			 if (k != playerID) {

               //make recursive call here. If currentNode is a max node, then....
               currentNode.valueArray = vectorMaximum(maximizeValue ((playerID + 1) % numberOfPlayers, successorNodes[k], moveLevel), currentNode.valueArray, playerID);

		     }//end if

         }//end for


	 } else {

	     //return utility value of this terminal node
	     //we need to determine if a player won
	     //in this case, the second param indicates
	     //that there are no more legal moves remaining

	     currentNode.valueArray = getUtilityValue(currentNode);

	     return (currentNode.valueArray);


	 }//end if

	 //this only happens at the root of the game tree, it returns the utility value for this node
     return currentNode.valueArray;

   }//method maximizeValue


   public int[] vectorMaximum(int[] val1, int[] val2, int playerID) {

      //since we are dealing with maximum values for integer arrays, we need to determine the max value
      //between the corresponding entires of the 2 arrays, depending upon the current playerID value

      if (val1[playerID] >= val2[playerID])
         return val1;
      else
         return val2;


   }//method maxValue



   //determines if outing is over based on number of moves made.


   public boolean outingOver(int moveLvl) {

      return (moveLvl == maxMoves);

   }//method gameOver


   public int[] getUtilityValue(gameNode currentNode) {


      //here, I simply need to calculate the highest value for each player, and take these values and put
      //them into an array, which will represent the value of for each game tree node

      int[] valueVector = new int[numberOfPlayers];

      byte[][] state = currentNode.getGameState();

      int currentValue = 0;
      int maxValue = 0;

      for (int i = 0; i < numberOfPlayers; i++) {

        for (int j = 0; j < numberOfPlayers; j++) {

           if (i != j) {

              //get value for this current person-person interaction history based on this outing
              currentValue = state[i][j];

              if (currentValue > maxValue && players[i].getGender() != players[j].getGender()) {

                 maxValue = currentValue;

		      }//end if

	       }//end if

        }//end for

        //assign next value to valueVector
        valueVector[i] = maxValue;

        //reset variables
        currentValue = 0;
        maxValue = 0;

     }//end for


     return valueVector;



   }//method getUtilityValue


    public gameNode traverseGameTree (gameNode currNode, int moveLevel, int playerID, String outingLocation) {

        //this method traverses the game tree just generated by using the link references of each gameNode
        //along with the values of the children for a given gameNode. We store each child in a PriorityQueue
        //instance variable and then return the highest valued

        if (currNode == null || currNode.links == null) {

    	    //System.out.println("Reached bottom of tree!");
    	    return currNode;

        }//end if

        //I can use the state being held by the current node to determine who the current
        //player talked to last. I will then add a deterrent for talking to that individual.
        //the deterrent does not apply towards groups, for the sake of simplicity

        //PriorityQueue object that holds all successor nodes of a given state
   	 //it is used in the tree traversal method once the game tree has been generated
   	 //and its nodes have been assigned utility values

   	 //first,set the proper ordering criteria for nodes in the PQ
   	 //String ordering = " ";


   	   PriorityQueue PQ = new PriorityQueue((int)(Math.pow(2.0, (double)(numberOfPlayers - 1))));

   	   for (int k = 0; k < PQ.getCapacity(); k++) {

           PQ.insert(currNode.links[k]);

        }//end for

        //System.out.println("current player move is: " + playerID);


        //return most desired successor. This is the highest valued node for the current playerID value
        gameNode chosenSuccessor = null;
        int tknValue = 0;
        StringTokenizer st = null;

        //now I need to add a deterrent which prevents a player from choosing to talk to another player 2 straight plies.

        byte[][] thisState = currNode.getGameState();
        int justTalkedTo = 0;
        int sizeOfAudience = 0;

        for (int m = 0; m < numberOfPlayers; m++) {

           if (thisState[playerID][m] != 0) {

              justTalkedTo = m;
              sizeOfAudience++;

	       }//end if

	       thisState[playerID][m] = 0;

	    }//end for

	    //add rezeroed state to current node
	    currNode.setGameState(thisState);

	    //System.out.println("Just print all zeroes for this state");
	    //currNode.printState();

        while (chosenSuccessor == null) {

           chosenSuccessor = PQ.remove(playerID);

           totalChoice++;


           st = new StringTokenizer(chosenSuccessor.getSourceMarker(), "- ");

           while (st.hasMoreTokens()) {

              tknValue = Integer.parseInt(st.nextToken());


			  if (players[playerID].OOD_ID == tknValue)
                 OODChoice++;

              //check to see if this player has just talked to this person
			  //if so, then we must begin the process again
			  if (sizeOfAudience == 1 && justTalkedTo == tknValue && PQ.size() > 1) {

     		     //this indicates that we have just talked to this person
			     System.out.println("We just talked to this person, lets choose another");

			     chosenSuccessor = null;

	          }//end if

              if (players[tknValue].getGender() == players[playerID].getGender() && (sizeOfAudience == 1) && PQ.size() > 1) {

                //it has been determined that the person being talked to is of the same gender
                System.out.println("This person is of the same gender. Try again.");
                chosenSuccessor = null;
               // break;

		      }//end if

	       }//end while

	    }//end while


        StringTokenizer convoST = new StringTokenizer(chosenSuccessor.getSourceMarker(), "-");
        int currPerson = 0;
        String andStr = " ";

        String dialogueStr = players[playerID].getPlayerName() + " is talking to";

        while (convoST.hasMoreTokens()) {

           currPerson = Integer.parseInt(convoST.nextToken());

           dialogueStr += andStr + players[currPerson].getPlayerName();

           andStr = " and ";

	    }//end if

        //finish up dialogue using Language class and outingLocation
        dialogueStr += Language.getDialogue(outingLocation);

        //print dialogue
        System.out.println(dialogueStr);
        System.out.println();

         //System.out.println("Successor chosen: \n");
        //chosenSuccessor.printState();

        //System.out.println("What will be the response??\n");

        //increase moveLevel
        moveLevel++;

        //make recursive call
        gameNode bottomNode = traverseGameTree(chosenSuccessor, moveLevel, (playerID + 1) % numberOfPlayers, outingLocation);

        return bottomNode;


     }//method traverseGame Tree


     public void printOODFreq() {

        System.out.println("OOD was chosen: " + OODChoice + " times out of " + totalChoice);
        System.out.println();
        System.out.println();


     }//method printOODFreq



}//class datingSim