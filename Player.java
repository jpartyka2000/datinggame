package datingGame;

import java.util.*;

class Player {

   //player ID of this player, from 0-(n-1) number of players
   int playerID;


   //the total number of personality points this player has
   int personalityPoints;

   //name of Player, determined randomly using language class
   String playerName;

   //this is an array of player personality traits. These are the traits that determine what a player likes or dislikes
   //during an outing. There are six of these qualities: (1: Humor (2: Seriousness (3: Professionalism (4: Escapist/Romantic
   //(5: Self-absorbed (6: Selfless

   int[] outingTraits;

   //this is an array of attractiveness values. Some of these values are correlated with the outingTraits, others are not.
   //these values are used to evaluate who the object of desire for a particular player may be. The closer these values
   //are for 2 players, the more likely they are to be Objects of Desire (OOD) for each other.
   //The following values only represent 3 of the 6 factors determining OOD viability. The other 3 are listed below.

   int[] attractionValues;

   //this variable determines whether the player is in a relationship or not, and if so, who that special someone is.
   //if it is null, that means that the player is single

   String datingPartner;

   //this variable represents the numeric id value of the dating partner
   int datingPartnerID;

   //this variable represents the player's current job. Each job has a different prestige level. The description of each
   //job and their respective prestige levels are explained in the code for the Job class.

   Job currentJob;

   //This an array of integers representing the strength of social bonds between one player and another. The cumulative
   //total of all of these bonds yields a social charm value, which is defined below this array. A current question is:
   //is the strength of A-B necessarily the same as B-A for the purposes of this program?

   int[] socialBonds;

   //this is a computed composite value of a player's social bonds
   int socialCharm;

   //this is a variable that represents the player's object of desire at the moment
   int OOD_ID;

   //the specific value of the OOD corresponding to the OOD_ID
   int OOD_Value;

   //the gender of the player: 0 for male, 1 for female
   int gender;

   //the total number of players in the game
   int numberOfPlayers;

   public Player(int playID, int numOfPlayers, int gend) {

      //assign playerID
      playerID = playID;

      //assign gender
	  gender = gend;

	  numberOfPlayers = numOfPlayers;


      //use Language class to determine playerName
      playerName = Language.createPlayerName(gender);

      //determine various player characteristics. I could make it such that these characteristics are totally random,
      //but what I will do is to start off with a certain number of points(which is itself randomly generated) for
      //this player, and then distribute these points across the various personal characteristics. Therefore,
      //all players will not be created equal.

      outingTraits = setOutingTraits();

      //now we set attraction values

      attractionValues = setAttractionValues();

      //whether or not a player is currently in a relationship cannot be determined right now, because
      //we need to make that determination with respect to the other players. Now I will assign the current job

      currentJob = new Job();


      //social bonds and the OOD_ID can only be determined when considering the traits of all other players.
      //for now, give default values

      datingPartner = null;
      datingPartnerID = -1;
      socialBonds = new int[numOfPlayers];
      socialCharm = 0;

      OOD_ID = 0;
      OOD_Value = 0;


   }//constructor player

   //this method effectively determines the public personality of each player

   public int[] setOutingTraits() {

	   //the traits to be returned
	   int[] traits = new int[6];

      //personalityPoints will be distributed across the 6 traits. However, the total number of points will not be equal
      //among the players. However, a range between [360-520] points will be considered.

      Random personalityGen = new Random();

      personalityPoints = personalityGen.nextInt(160) + 360;

      //now that we have our personality points, we need to distribute these across the characteristics
      //the minimum score for any given trait is 50, the max is 100. I need to keep track of the points that have been dispersed
      //so far, so that I distribute the exact amount of personality points

      Random traitGen = new Random();
      int pointTotal = 0;

      //first, use a for loop to ensure that every trait gets some personality points
      for (int p = 0; p < traits.length; p++) {

         traits[p] = traitGen.nextInt(50) + 50;
         pointTotal += traits[p];

      }//end for


      //because not all personality points have been dispersed, we need to distribute the rest
      //they will be assigned randomly to the traits until the pointTotal matches the personalityPoints total

      Random traitSelectGen = new Random();
      Random pointSelectGen = new Random();
      int ts = 0;

      int pointRemainder = personalityPoints - pointTotal;
      int pointVar = 0;

      while (pointTotal < personalityPoints) {

         ts = traitSelectGen.nextInt(6);

         //select a number of points. If the number of points exceeds pointRemainder, or if
         //the points added exceeds 100 for any trait total, then we need to do another round

         pointVar = pointSelectGen.nextInt(pointRemainder);

         if (traits[ts] + pointVar <= 100) {

            traits[ts] += pointVar;
            pointTotal += pointVar;

	     }//end if


      }//end while

      //we are done, return traits
      return traits;

   } //method setOutingTraits


   public int[] setAttractionValues() {


      //the traits to be returned
	  int[] quals = new int[3];

	   //attractionPoints will be distributed across the 3 quals. However, the total number of points will not be equal
	   //among the players. However, a range between [160-290] points will be considered.

	   Random attractionGen = new Random();

	   int attractionPoints = attractionGen.nextInt(160) + 130;

	   //now that we have our attraction points, we need to distribute these across the characteristics
	   //the minimum score for any given quality is 50, the max is 100. I need to keep track of the points that have been dispersed
	   //so far, so that I distribute the exact amount of attraction points

	   Random attGen = new Random();
	   int pointTotal = 0;

	   //first, use a for loop to ensure that every qual gets some personality points
	   for (int p = 0; p < quals.length; p++) {

	      quals[p] = attGen.nextInt(50) + 50;
	      pointTotal += quals[p];

	   }//end for


	   //because not all personality points have been dispersed, we need to distribute the rest
	   //they will be assigned randomly to the traits until the pointTotal matches the personalityPoints total

	   Random qualSelectGen = new Random();
	   Random pointSelectGen = new Random();
	   int ts = 0;

	   int pointRemainder = attractionPoints - pointTotal;
	   int pointVar = 0;

	   while (pointTotal < attractionPoints) {

	      ts = qualSelectGen.nextInt(3);

	      //select a number of points. If the number of points exceeds pointRemainder, or if
	      //the points added exceeds 100 for any trait total, then we need to do another round

	      pointVar = pointSelectGen.nextInt(pointRemainder);

	      if (quals[ts] + pointVar <= 100) {

	         quals[ts] += pointVar;
	         pointTotal += pointVar;

	    }//end if


	   }//end while

	   //we are done, return traits
	   return quals;


    }//method setAttractionValues


    public void setDatingPartner(String newPartner) {

       datingPartner = newPartner;

    }//method setDatingPartner



    public String getDatingPartner () {


	   return datingPartner;


    }///method getDatingPartner


   public int getGender() {

      return gender;

   }//method getGender


   public void setSocialBond(Player otherPlayer) {


     //this method determines a mutual social bond between 2 players. The social bond strength is determined by
     //the similarities between 2 players regarding their personality traits and attraction qualities. It does not
     //take into account job, social charm, or monetary value

     //the formula for computing this is the sum of the absolute value of all the difference between the traits.
     //this cumulative difference is then divided by the total number of points possessed by both players. This value
     //is then subtracted from 100, and the final result is the social bond strength


     int cumulativeDifference = 0;


     //first, find cumulative difference for outing traits

     for (int i = 0; i < outingTraits.length; i++) {

        cumulativeDifference += Math.abs(this.outingTraits[i] - otherPlayer.outingTraits[i]);

     }//end for

     //next, do the same for attraction qualities

     for (int j = 0; j < attractionValues.length; j++) {

        cumulativeDifference += Math.abs(this.attractionValues[j] - otherPlayer.attractionValues[j]);

     }//end for

     //divide total number of personalityPoints for both players combined by the cumulativeDifference
     //and multiply by 100 to obtain the percent difference

     float percentDiff = (((float)cumulativeDifference / (float)personalityPoints)) * 100;

     //finally, set the mutual social bond strength value by subtracting percentDiff from 100
     this.socialBonds[otherPlayer.getPlayerID()] = otherPlayer.socialBonds[playerID] = (int)(100 - percentDiff);

     //if (playerID == 0 && otherPlayer.getPlayerID() == 3) {

     //   System.out.println("Calculated social bond value from function for [3]: " + this.socialBonds[3]);


     //}//end if


  }//method setSocialBond


  public int getSocialCharm() {

     return socialCharm;

  }//method getSocialCharm


  public void setSocialCharm(int sc) {

     socialCharm = sc;


  }//method setSocialCharm


 /* public void calculateSocialCharm() {

     //calculating the social charm value is simply a matter of taking the average
     //of all social bond strength values

     int charmTotal = 0;

     for (int j = 0; j < this.socialBonds.length; j++) {

        if (j != this.playerID)
           charmTotal += socialBonds[j];

     }//end for

     socialCharm = (int)(charmTotal / (socialBonds.length - 1));


  }//method calculateSocialCharm*/


  //sets the Object of desire for each player. This may change between outings

   public int getOOD() {

     return OOD_ID;

  }//method getOOD



  public void setOOD(int pID) {

     OOD_ID = pID;

  }//method setOOD


   public String getPlayerName() {

      return playerName;

   }//method getPlayerName


   public int getPlayerID() {

      return playerID;

   }//method getPlayerID


   public Job getJob() {

	   return currentJob;

   }//end if


   public int getDominantTrait() {

      //in order to determine the character of a player, I need to know what their dominant trait is
      //I need to determine the maximum between all of their traits

      int maxTraitValue = 0;
      int maxIndex = 0;

      for (int i = 0; i < outingTraits.length; i++) {

         if (outingTraits[i] > maxTraitValue) {

            maxTraitValue = outingTraits[i];
            maxIndex = i;

	     }//end if

      }//end for

      //return ID of dominant trait
      return maxIndex;


   }//method getDominantTrait


   public void setOODValue(int val) {

      OOD_Value = val;

   }//method setOODValue

   public int getOODValue() {

	   return OOD_Value;

   }//method getOODValue


  public void printPlayer() {

    //if (playerID == 0)
    //   System.out.println("Array social bond value: " + this.socialBonds[3]);

    System.out.println("Master profile for: " + playerName);
    System.out.println("*********************************");
    System.out.println();
    System.out.println("Gender: " + gender);
    System.out.println("Personality Points: " + personalityPoints);
    System.out.println("Humor: " + outingTraits[0]);
    System.out.println("Seriousness: " + outingTraits[1]);
    System.out.println("Professionalism: " + outingTraits[2]);
    System.out.println("Romantic/Escapist: " + outingTraits[3]);
    System.out.println("Selfish: " + outingTraits[4]);
    System.out.println("Selfless: " + outingTraits[5]);
    System.out.println("*********************************");
    System.out.println("Physical Attractiveness: " + attractionValues[0]);
    System.out.println("Mental Attractiveness: " + attractionValues[1]);
    System.out.println("Social Attractiveness: " + attractionValues[2]);
    System.out.println("*********************************");
    System.out.println("Overall Popularity: " + socialCharm);
	System.out.println("Current Job: " + currentJob.getJobName());
    System.out.println("Is Currently Dating: " + datingPartner);
    System.out.println("*********************************");
    System.out.println("Social Bond Strength 0 is: " + socialBonds[0]);
    System.out.println("Social Bond Strength 1 is: " + socialBonds[1]);
    System.out.println("Social Bond Strength 2 is: " + socialBonds[2]);
    System.out.println("Social Bond Strength 3 is: " + socialBonds[3]);

    if (numberOfPlayers == 5)
       System.out.println("Social Bond Strength 4 is: " + socialBonds[4]);

    System.out.println("*********************************");
    System.out.println("Object of Desire is: " + OOD_ID);
    System.out.println("OOD value is: " + OOD_Value);
    System.out.println();
    System.out.println();



  }//method printPlayer



}//class Player


















































