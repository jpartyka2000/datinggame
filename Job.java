package datingGame;

import java.util.*;

class Job {

   String [][] tierjobs = {{"Data Entry Clerk", "Phone Operator", "Tech Support Specialist"},
                         {"Web Designer", "Computer Programmer", "Video Game Programmer"},
                         {"Software Engineer", "Database Administrator", "Department Manager"},
                         {"Chief Technology Officer(CTO)", "Fortune 500 IT Consultant", "President of the Company"}};

   //name of the job
   String jobName;

   //the tier of the job, with values from 1-4
   int jobTier = 0;


   public Job() {

      setJob(jobTier);

   }//constructor Job


   //method that assigns job and tier. This only occurs when first creating players

   public void setJob(int currTier) {

      //the probability of landing a tier1 job is slim, and each subsequent tier become more likely.
	  //first, choose a tier, then from that tier, choose a job. Both choices are random

	  Random tierGen = new Random();
      int tierVal = currTier;

	  while (currTier == tierVal) {

	     tierVal = tierGen.nextInt(100);

         //there is only a 1% chance of grabbing a tier1 job initially.
		 //there is a 10% chance of grabbing a tier2 job
		 //there is a 50% chance of grabbing tier3 job
         //there is a 39% chance of having a tier4 job

	     if (tierVal == 1) {

            jobTier = 3;

        } else if (tierVal < 12) {

	        jobTier = 2;

	    } else if (tierVal < 63) {

		    jobTier = 1;

	    } else jobTier = 0;


      }//end while

       //set actual job name
      jobName = setJobName();


   }//method setJob


   public void setNewJob(int newTier) {


      //based on the new tier, we set a new job

      //a better job
      if (newTier > jobTier) {

         if (newTier > 3)
            newTier = 3;

     }//end if


     //a worse job

      if (newTier < jobTier) {

	     if (newTier < 0)
	        newTier = 0;

     }//end if

     //set job tier
     jobTier = newTier;

     //set new job name
     jobName = setJobName();


   }//method setNewJob


   private String setJobName() {

      //based on the job tier

      Random jobGen = new Random();


      int jobVal = jobGen.nextInt(3);

      return tierjobs[jobTier][jobVal];

   }//method setJobName


   public String getJobName() {

      return jobName;

   }//method getJobName


   public int getTier() {

      return jobTier;

   }//method getTier




}//class Job