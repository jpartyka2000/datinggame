package datingGame;

import java.util.*;

public final class Language {


   //this is a static class which contains various definitions for text-related
   //purposes in the program


  static String [] maleNames = {"Mike","John", "Jeff", "Antoine", "Eric", "Cecil", "Fabian", "Pete", "Alex", "T.C.", "Cal", "George", "Antonio",
                         "Julio", "Victor", "Dave", "Miles", "Doug", "Brian", "Patrick"};

  static String [] femaleNames = {"Erica", "Kimberly", "Jen", "April", "Carol", "Jessica", "Lisa", "Melissa", "Michelle", "Kathy", "Lorraine",
                           "Jameka", "Sun", "Claire", "Kelly", "Barbara", "Audrey", "Tadvana", "Mary", "Laura"};

   public static String createPlayerName(int gender) {

      Random nameGen = new Random();

      //the name depends upon the gender
      if (gender == 0) {

         return maleNames[nameGen.nextInt(maleNames.length)];

      } else {

        return femaleNames[nameGen.nextInt(femaleNames.length)];

      }//end if


   } //method createPlayerName


   public static String setOutingLocation(String playerNm) {


      Random outingGen = new Random();

      int hangout = outingGen.nextInt(12) + 1;
      String outingLoc = null;

      switch (hangout) {

	     case 1:
	        outingLoc = "Barnes and Noble Bookstore";
	        break;

	     case 2:
	        outingLoc = "The Olive Garden, Italian Restaurant";
	        break;

	     case 3:
	        outingLoc = "Lucky Cheng's Bar and Nightclub";
	        break;

	     case 4:
	        outingLoc = "Yankee Stadium, featuring NY Yankees Baseball";
	        break;

		 case 5:
		    outingLoc = "KFC -- Kentucky Fried Chicken";
	        break;

     	 case 6:
		    outingLoc = "Tonic, a local Jazz Club";
		    break;

	     case 7:
		    outingLoc = "Richardson Multiplex Cinemas";
		    break;

         case 8:
		    outingLoc = "Szechuan Garden, a Chinese Restaurant";
			break;

	     case 9:
		    outingLoc = "The Mall of Texas, featuring over 500 department stores";
			break;

		 case 10:
		 	outingLoc = "A Picnic in a small nearby park";
			break;

		 case 11:
			outingLoc = playerNm + "'s house";
			break;

		 case 12:
		    outingLoc = "Hiking on the nearby Chisolm Trail";
			break;


      }//end switch


      return outingLoc;


   }//method setOutingLocation


    public static String getDialogue(String outingLoc) {


       Random convoGen = new Random();
       int convo = convoGen.nextInt(5) + 1;


       if (outingLoc.indexOf("Bookstore") > -1) {

          if (convo == 1)
		     return	 " about the superiority of Starbucks coffee" ;

          if (convo == 2)
		     return	 " about the very eccentric intellectuals sitting behind them";

		  if (convo == 3)
		     return  " about the complexity and ultimate reward of relationships";

		  if (convo == 4)
		     return	 " about annoying people at work" ;

		  if (convo == 5)
		     return	 " and relating the plot of a popular and current book. And no, it is not a Harry Potter book :-)" ;

       }//end if

      if (outingLoc.indexOf("Olive") > -1) {

          if (convo == 1)
		     return	 " about the exquisite lasagna that this restaurant serves" ;

          if (convo == 2)
		     return	 " about who will have dessert and who will not.";

		  if (convo == 3)
		     return  " about the complexity and ultimate pointlessness of relationships";

		  if (convo == 4)
		     return	 " about annoying people at work" ;

		  if (convo == 5)
		     return	 " and relating the panic of getting hopelessly lost in Venice." ;

       }//end if

       if (outingLoc.indexOf("Lucky") > -1) {

          if (convo == 1)
		     return	 " about if anyone can hear over this LOUD music!" ;

          if (convo == 2)
		     return	 " about the prospect of going to White Castle for some burgers afterwards";

		  if (convo == 3)
		     return " about all of the attractive men and women at the bar";

		  if (convo == 4)
		     return	 " about skipping out of work on Monday." ;

		  if (convo == 5)
		     return	 " and relating the story of dancing for the first time at a nightclub -- and getting lauged at in the process:-)" ;

       }//end if

        if (outingLoc.indexOf("Baseball") > -1) {

	       if (convo == 1)
	          return " about how passionate and exciting the Yankee stadium crowd is" ;

	       if (convo == 2)
	   		  return " about whether the Yankees can win this baseball game";

	   	   if (convo == 3)
	   	      return " about whether the Yankees will beat the Red Sox in the playoffs";

	   	   if (convo == 4)
	   	      return " about trying to forget work for the sake of enjoying the game" ;

	   	   if (convo == 5)
	          return " and relating the story of running onto the field during the game and being ejected from the stadium" ;

	          }//end if

        if (outingLoc.indexOf("Kentucky") > -1) {

	       if (convo == 1)
	          return " about how great the fried chicken is here.";

	       if (convo == 2)
	   		  return " about why KFC mysteriously stopped serving Sweet and Sour Sauce with the chicken";

	   	   if (convo == 3)
	   	      return " about not wanting to know the enormous fat content the food probably contains";

	   	   if (convo == 4)
	   	      return " about being forced to pick up chicken from another KFC for ungrateful co-workers" ;

	   	   if (convo == 5)
	          return " and relating the scary and hilarious story of what actually happens while preparing food in the kitchen of a KFC" ;

	    }//end if

	      if (outingLoc.indexOf("Jazz") > -1) {

		     if (convo == 1)
		        return " about how amazingly talented the performers playing tonight are" ;

		     if (convo == 2)
		  	    return " about how amazingly inept the performers playing tonight are";

			 if (convo == 3)
			    return " and lamenting the extremely high cover charge for attending this show";

			 if (convo == 4)
			    return " about how an annoying co-worker happens to be just a few feet to the right of the group" ;

		     if (convo == 5)
		        return " and discussing the funny story of falling down while playing saxophone while in high school marching band" ;

		  }//end if

         if (outingLoc.indexOf("Multiplex") > -1) {

		     if (convo == 1)
		        return " about how completely absorbing and dramatic this movie is" ;

		     if (convo == 2)
		  	    return " about how totally mind-numbing and boring this movie is";

			 if (convo == 3)
			    return " and complaining about the very tall guy blocking the view of the screen";

			 if (convo == 4)
			    return " about the difference between Jujjifruits, Dots, and Chuckles" ;

		     if (convo == 5)
		        return " and discussing the funny story of sneaking into an R-rated movie at the age of 12" ;

		  }//end if

           if (outingLoc.indexOf("Chinese") > -1) {

		     if (convo == 1)
		        return " about the perfect blend of spices and vegetables in this food" ;

		     if (convo == 2)
		  	    return " about how there is always too much Chinese food to eat all at once, but never enough to make you full.";

			 if (convo == 3)
			    return " and asking if the food contains MSG, even if they say there is none";

			 if (convo == 4)
			    return " about the delicious and juicy duck this restaurant serves" ;

		     if (convo == 5)
		        return " and discussing the cook and the amazing knife twirling exhibitions he gives for the patrons" ;

		  }//end if


          if (outingLoc.indexOf("Mall") > -1) {

		     if (convo == 1)
		        return " about the wonderful selection of electronics that the mall has to offer" ;

		     if (convo == 2)
		  	    return " about the poor selection of glassware and fine china that the mall has to offer";

			 if (convo == 3)
			    return " and asking if it would be OK to return a defective article of clothing right now";

			 if (convo == 4)
			    return " about how busy the mall gets on weekends" ;

		     if (convo == 5)
		        return " and discussing the amount of money someone can earn if he took all the pennies from the fountain every day" ;

		  }//end if

          if (outingLoc.indexOf("Picnic") > -1) {

		     if (convo == 1)
		        return " about what a beautiful day that it is to be having a picnic!" ;

		     if (convo == 2)
		  	    return " and being proud of remembering to bring an umbrella in case it starts raining";

		 	 if (convo == 3)
		 	    return " about once having a picnic with a very annoying co-worker";

		 	 if (convo == 4)
		        return " and arguing about whether picnics are high pressure dating situations" ;

		     if (convo == 5)
		        return " and discussing the story of how the picnic basket was once raided by a hungry bear" ;

		  }//end if

           if (outingLoc.indexOf("house") > -1) {

		      if (convo == 1)
		         return " about throwing a wild, spontaneous party" ;

		      if (convo == 2)
		         return " about starting an XBox video game tournament for money";

		      if (convo == 3)
		         return " about the simplicity and questionable worth of relationships";

		      if (convo == 4)
		         return " and arguing about the exact contents of a fuzzy navel" ;

		      if (convo == 5)
		         return " and discussing the prospect of starting a rock band and rehearsing in the basement of this house" ;

		  }//end if

          if (outingLoc.indexOf("Chisolm") > -1) {

		      if (convo == 1)
		         return " about how it must have been to talk on this trail during the old cattle drives of the 1800s" ;

		      if (convo == 2)
		         return " and asking how much longer everyone needs to walk on this boring trail";

		      if (convo == 3)
		         return " and wondering if it would be easier to drive the length of the trail as opposed to walking";

		      if (convo == 4)
		         return " about relationships and their likeness to a long, straight path towards a final destination" ;

		      if (convo == 5)
		         return " and telling the funny story of how they all got lost walking this same trail the last time" ;

		  }//end if

          return "none returned";


    }//method getDialogue


   public static String getNegativeJobChange(Job pJob, String playerName) {

      Random reasonGen = new Random();

      int jobFiring = reasonGen.nextInt(2);

      if (jobFiring == 0) {

	     return (playerName + " got fired from the job as a " + pJob.getJobName());

      } else if (jobFiring == 1) {

	     return (playerName + " got laid off from the job as a " + pJob.getJobName() + ", due to struggling corporate sales");

      } else {

		 return (playerName + " quit the job as a " + pJob.getJobName() + ", because the work was no longer exciting");

      }//end if


   }//method getNegativeJobChange


    //positive job change situation message. Note that the job parameter here is the player's new job
    //as opposed to his old job

    public static String getPositiveJobChange(Job pJob, String playerName) {

       return (playerName + " took a new job as a " + pJob.getJobName());

    }//method getNegativeJobChange



    public static String getPositiveAttMsg (int qualChanged, int amount, int gender, String playerName) {

       //the most any given quality can change between outings is by 10 points
       //here, the change is positive

       //change in physical attractiveness, we also need to know the gender involved

       if (qualChanged == 0) {

          //if this is a guy
          if (gender == 0) {


             //there are 3 different levels of change: small, moderate and large change.
             //1-3 is small, 4-7 is moderate, 8-10 is large

             if (amount < 8) {

                Random changeGen = new Random();
                int changeNum = changeGen.nextInt(3);


                if (changeNum == 0) {

                   return (playerName + " has started to run on the treadmill 3 days a week and is looking better." +
                    "His physical attractiveness has increased by " + amount + " points");

			    }//endif


                if (changeNum == 1) {

				   return (playerName + " has started to lift weights every other day, and says he can now benchpress 125 pounds! " +
				   "His physical attractiveness has increased by " + amount + " points");

			    }//endif


                if (changeNum == 2) {

			       return (playerName + " has started to dress more stylishly and sport a trendy haircut." +
			       "His physical attractiveness has increased by " + amount + " points");

			   }//endif


		     } else if (amount >= 8 && amount < 16) {

                   Random changeGen = new Random();
				   int changeNum = changeGen.nextInt(3);


				     if (changeNum == 0) {

				        return (playerName + " has started to run on the treadmill 5 days a week and is looks more like a track star every day." +
				         "His physical attractiveness has increased by " + amount + " points");

					  }//endif


				     if (changeNum == 1) {

					   return (playerName + " has started to lift weights almost every day, and says he can now benchpress 225 pounds!" +
					   "His physical attractiveness has increased by " + amount + " points");

					  }//endif


				     if (changeNum == 2) {

					     return (playerName + " is looking very sharp. Pretty soon, he could be on the cover of GQ magazine." +
					     "His physical attractiveness has increased by " + amount + " points");

					 }//endif


		     } else {

                   Random changeGen = new Random();
				   int changeNum = changeGen.nextInt(3);


				  	 if (changeNum == 0) {

				  	    return (playerName + " runs 10 miles every day, and looks ready to run the New York City Marathon." +
				  	     "His physical attractiveness has increased by " + amount + " points");

				  	  }//endif


				  	 if (changeNum == 1) {

				  	   return (playerName + " is becoming the most buff guy in town, and says he can even benchpress over 300 pounds. Look out Mr. Universe!" +
				  	   "His physical attractiveness has increased by " + amount + " points");

				  	  }//endif


				  	 if (changeNum == 2) {

				  	     return (playerName + " is thinking about becoming a male model. I hear that he has 2 photoshoots lined up, just for next week!" +
				  	     "His physical attractiveness has increased by " + amount + " points");

				     }//endif


		     }//end if


	     }//end if


	     //if this is a woman
	     if (gender == 1) {

              //there are 3 different levels of change: small, moderate and large change.
			   //1-3 is small, 4-7 is moderate, 8-10 is large

			   if (amount < 8) {

			      Random changeGen = new Random();
			      int changeNum = changeGen.nextInt(3);


			      if (changeNum == 0) {

			         return (playerName + " is practicing yoga and looks more fit and healthy." +
			          "Her physical attractiveness has increased by " + amount + " points");

			    }//endif


			      if (changeNum == 1) {

				   return (playerName + " has started jogging every other day, is looking better than a few weeks ago." +
				   "Her physical attractiveness has increased by " + amount + " points");

			    }//endif


			      if (changeNum == 2) {

			       return (playerName + " has started to dress more stylishly and now sports an attractive new hairstyle." +
			       "Her physical attractiveness has increased by " + amount + " points");

				   }//endif


		         } else if (amount >= 8 && amount < 16) {

			          Random changeGen = new Random();
				      int changeNum = changeGen.nextInt(3);


				       if (changeNum == 0) {

				          return (playerName + " appears to be getting more fit with each passing day." +
				          "Her physical attractiveness has increased by " + amount + " points");

					    }//endif


				       if (changeNum == 1) {

					       return (playerName + " has been jogging nearly every day, and she looks better all the time!" +
					       "Her physical attractiveness has increased by " + amount + " points");

					    }//endif


				      if (changeNum == 2) {

					      return (playerName + " is looking very good these days...She's becoming renowned for her beauty." +
					      "Her physical attractiveness has increased by " + amount + " points");

					   }//endif


				   } else {

			            Random changeGen = new Random();
				        int changeNum = changeGen.nextInt(3);


					  	 if (changeNum == 0) {

					  	    return (playerName + " is in incredible shape...She is the envy of other women.." +
					  	     "Her physical attractiveness has increased by " + amount + " points");

					  	  }//endif


					  	 if (changeNum == 1) {

					  	   return (playerName + " can run several miles a day, and is in fantastic shape!" +
					  	   "Her physical attractiveness has increased by " + amount + " points");

					  	  }//endif


					  	 if (changeNum == 2) {

					  	     return (playerName + " is thinking about becoming a female model. I hear that Ralph Lauren has contacted her the other day." +
					  	     "Her physical attractiveness has increased by " + amount + " points");

					     }//endif


					}//end if

	          }//end if

         }//end if


         //measures if mental attractiveness changed. This is gender independent

         if (qualChanged == 1) {

			   if (amount < 8) {

			      Random changeGen = new Random();
			      int changeNum = changeGen.nextInt(3);


			      if (changeNum == 0) {

			         return (playerName + " has stopped being a couch potato and is starting to read." +
			          "Mental attractiveness has increased by " + amount + " points");

			    }//endif


			      if (changeNum == 1) {

				   return (playerName + " has become interested in artificial intelligence and is writing some basic AI code." +
				     "Mental attractiveness has increased by " + amount + " points");

			    }//endif


			      if (changeNum == 2) {

			       return (playerName + " has become interested in increasing vocabulary and general verbal skills." +
			        "Mental attractiveness has increased by " + amount + " points");

				   }//endif


		         } else if (amount >= 8 && amount < 16) {

			          Random changeGen = new Random();
				      int changeNum = changeGen.nextInt(3);


				       if (changeNum == 0) {

				          return (playerName + " is now reading a book a week! Pretty impressive." +
				           "Mental attractiveness has increased by " + amount + " points");

					    }//endif


				       if (changeNum == 1) {

					       return (playerName + " is now writing some fairly complicated software agents that use FOL." +
					       "Mental attractiveness has increased by " + amount + " points");

					    }//endif


				      if (changeNum == 2) {

					      return (playerName + " is now regularly reading the New York Times Literature Review." +
					      "Mental attractiveness has increased by " + amount + " points");

					   }//endif


				   } else {

			            Random changeGen = new Random();
				        int changeNum = changeGen.nextInt(3);


					  	 if (changeNum == 0) {

					  	    return (playerName + " has become an incredibly avid reader and will start a new book club." +
					  	     "Mental attractiveness has increased by " + amount + " points");

					  	  }//endif


					  	 if (changeNum == 1) {

					  	   return (playerName + " has written an expert system that is garnering attention in the industrial and academic community!" +
					  	   "Mental attractiveness has increased by " + amount + " points");

					  	  }//endif


					  	 if (changeNum == 2) {

					  	     return (playerName + " has been called upon to write the occasional guest column in the Financial Times of London." +
					  	     "Mental attractiveness has increased by " + amount + " points");

					     }//endif


					}//end if



	     }//end if


	     //Did social attractiveness change?

	     if (qualChanged == 2) {

		 	   if (amount < 8) {

		 	      Random changeGen = new Random();
		 	      int changeNum = changeGen.nextInt(2);


		 	      if (changeNum == 0) {

		 	         return (playerName + " has stopped being a couch potato and is starting to go out to the city on the weekends" +
		 	          "Social attractiveness has increased by " + amount + " points");

		 	    }//endif


		 	       if (changeNum == 1) {

		 		      return (playerName + " is overcoming past shyness and is starting to converse randomly to individuals in public." +
		 		       "Social attractiveness has increased by " + amount + " points");

		 	       }//endif


		 	  } else if (amount >= 8 && amount < 16) {

		 	          Random changeGen = new Random();
		 		      int changeNum = changeGen.nextInt(2);


		 		       if (changeNum == 0) {

		 		          return (playerName + " is now going out 4 nights a week to the city, including Friday and Saturday nights!" +
		 		           "Social attractiveness has increased by " + amount + " points");

		 			    }//endif


		 		       if (changeNum == 1) {

		 			       return (playerName + " has become increasingly confident in public and now is comfortable in talking to groups of people at once." +
		 			       "Social attractiveness has increased by " + amount + " points");

		 			    }//endif


		 		   } else {

		 	            Random changeGen = new Random();
		 		        int changeNum = changeGen.nextInt(2);


		 			  	 if (changeNum == 0) {

		 			  	    return (playerName + " is an essential part of the night scene in the city, everyone important knows " + playerName +
		 			  	     " Social attractiveness has increased by " + amount + " points");

		 			  	  }//endif


		 			  	 if (changeNum == 1) {

		 			  	   return (playerName + " now is giving lessons to other people on how speak effectively and confidently in public to others" +
		 			  	     "Social attractiveness has increased by " + amount + " points");

		 			  	  }//endif


		 			}//end if


		 	     }//end if


		 	     //if we get down here, then nothing changed at all
		 	     return "Physical, Mental, and Social Attractiveness all remain unchanged";


   }//method getPositiveAttMsg


   public static String getNegativeAttMsg (int qualChanged, int amount, int gender, String playerName) {

          //the most any given quality can change between outings is by 10 points
          //here, the change is negative

          //change in physical attractiveness, we also need to know the gender involved

          if (qualChanged == 0) {

             //if this is a guy
             if (gender == 0) {


                //there are 3 different levels of change: small, moderate and large change.
                //1-3 is small, 4-7 is moderate, 8-10 is large

                if (amount < 8) {

                   Random changeGen = new Random();
                   int changeNum = changeGen.nextInt(3);


                   if (changeNum == 0) {

                      return (playerName + " is not exercising on the treadmill every day like he used to." +
                       "His physical attractiveness has decreased by " + amount + " points");

   			    }//endif


                   if (changeNum == 1) {

   				   return (playerName + " has not lifted weights for a week now and is showing initial muscle flabbiness." +
   				   "His physical attractiveness has decreased by " + amount + " points");

   			    }//endif


                   if (changeNum == 2) {

   			       return (playerName + " has started to slip a little bit in his appearance and is looking a bit sloppy." +
   			       "His physical attractiveness has decreased by " + amount + " points");

   			   }//endif


   		     } else if (amount >= 8 && amount < 16) {

                      Random changeGen = new Random();
   				   int changeNum = changeGen.nextInt(3);


   				     if (changeNum == 0) {

   				        return (playerName + " barely ever runs on the treadmill anymore, and it shows." +
   				         "His physical attractiveness has decreased by " + amount + " points");

   					  }//endif


   				     if (changeNum == 1) {

   					   return (playerName + " almost never lifts weights anymore, and is starting to gain a lot of weight." +
   					   "His physical attractiveness has decreased by " + amount + " points");

   					  }//endif


   				     if (changeNum == 2) {

   					     return (playerName + " is looking slovenly these days. Why has he let his appearance go so quickly?" +
   					     "His physical attractiveness has decreased by " + amount + " points");

   					 }//endif


   		     } else {

                      Random changeGen = new Random();
   				   int changeNum = changeGen.nextInt(3);


   				  	 if (changeNum == 0) {

   				  	    return (playerName + " has regressed to being a couch potato....He never gets out of the house at all!" +
   				  	     "His physical attractiveness has decreased by " + amount + " points");

   				  	  }//endif


   				  	 if (changeNum == 1) {

   				  	   return (playerName + " has stopped lifting weights altogether and looks very, very unhealthy." +
   				  	   "His physical attractiveness has decreased by " + amount + " points");

   				  	  }//endif


   				  	 if (changeNum == 2) {

   				  	     return (playerName + " has become a total slob! He never even does his laundary anymore, it is disgusting." +
   				  	     "His physical attractiveness has decreased by " + amount + " points");

   				     }//endif


   		     }//end if


   	     }//end if


   	     //if this is a woman
   	     if (gender == 1) {

                 //there are 3 different levels of change: small, moderate and large change.
   			   //1-3 is small, 4-7 is moderate, 8-10 is large

   			   if (amount < 8) {

   			      Random changeGen = new Random();
   			      int changeNum = changeGen.nextInt(3);


   			      if (changeNum == 0) {

   			         return (playerName + " does not appear to be as healthy and shapely as she used to be." +
   			          "Her physical attractiveness has decreased by " + amount + " points");

   			    }//endif


   			      if (changeNum == 1) {

   				   return (playerName + " does not run as much as she used to, and she is starting to gain a little weight." +
   				   "Her physical attractiveness has decreased by " + amount + " points");

   			    }//endif


   			      if (changeNum == 2) {

   			       return (playerName + " has lost some of her stylish edge; she does not dress as well, and her hair is a bit messy." +
   			       "Her physical attractiveness has decreased by " + amount + " points");

   				   }//endif


   		         } else if (amount >= 8 && amount < 16) {

   			          Random changeGen = new Random();
   				      int changeNum = changeGen.nextInt(3);


   				       if (changeNum == 0) {

   				          return (playerName + " has really let herself go. She does not look nearly as good as in the past." +
   				          "Her physical attractiveness has decreased by " + amount + " points");

   					    }//endif


   				       if (changeNum == 1) {

   					       return (playerName + " almost never runs at all anymore, and she has continued to gain weight." +
   					       "Her physical attractiveness has decreased by " + amount + " points");

   					    }//endif


   				      if (changeNum == 2) {

   					      return (playerName + " has lost most of her stylish looks. And her hair is not even combed anymore!" +
   					      "Her physical attractiveness has decreased by " + amount + " points");

   					   }//endif


   				   } else {

   			            Random changeGen = new Random();
   				        int changeNum = changeGen.nextInt(3);


   					  	 if (changeNum == 0) {

   					  	    return (playerName + " has totally let herself go, she looks terrible these days." +
   					  	     "Her physical attractiveness has decreased by " + amount + " points");

   					  	  }//endif


   					  	 if (changeNum == 1) {

   					  	   return (playerName + " has become a couch potato..and it shows." +
   					  	   "Her physical attractiveness has decreased by " + amount + " points");

   					  	  }//endif


   					  	 if (changeNum == 2) {

   					  	     return (playerName + " wears sweat pants and work boots everywhere she goes. She looks like a member of a road construction crew." +
   					  	     "Her physical attractiveness has decreased by " + amount + " points");

   					     }//endif


   					}//end if

   	          }//end if

            }//end if


            //measures if mental attractiveness changed for the worse. This is gender independent

            if (qualChanged == 1) {

   			   if (amount < 8) {

   			      Random changeGen = new Random();
   			      int changeNum = changeGen.nextInt(2);


   			      if (changeNum == 0) {

   			         return (playerName + " does not read as much anymore and is starting to watch more TV." +
   			          "Mental attractiveness has decreased by " + amount + " points");

   			    }//endif


   			      if (changeNum == 1) {

   				   return (playerName + " has become less interested in Artificial Intelligence studies and is becoming more lethargic." +
   				     "Mental attractiveness has decreased by " + amount + " points");

   			    }//endif




   		         } else if (amount >= 8 && amount < 16) {

   			          Random changeGen = new Random();
   				      int changeNum = changeGen.nextInt(2);


   				       if (changeNum == 0) {

   				          return (playerName + " barely ever reads at all and spends too much time watching Seinfeld rereuns. " + "Mental attractiveness has decreased by " + amount + " points");

   					    }//endif


   				       if (changeNum == 1) {

   					       return (playerName + " has almost entirely stopped AI studies and is focused on more trivial hobbies. " + "Mental attractiveness has decreased by " + amount + " points");

   					    }//endif




   				   } else {

   			            Random changeGen = new Random();
   				        int changeNum = changeGen.nextInt(2);


   					  	 if (changeNum == 0) {

   					  	    return (playerName + " does not read anymore and prefers to watch TV day and night...it is quite sad." + "Mental attractiveness has decreased by " + amount + " points");

   					  	  }//endif


   					  	 if (changeNum == 1) {

   					  	   return (playerName + " has given up AI entirely and is now focused on bumming around with friends. " + "Mental attractiveness has decreased by " + amount + " points");

   					  	  }//endif



   					}//end if



   	     }//end if


   	     //Did social attractiveness change?

   	     if (qualChanged == 2) {

   		 	   if (amount < 8) {

   		 	      Random changeGen = new Random();
   		 	      int changeNum = changeGen.nextInt(2);


   		 	      if (changeNum == 0) {

   		 	         return (playerName + " does not go out that often anymore...I wonder if something is wrong." + "Social attractiveness has decreased by " + amount + " points");

   		 	    }//endif


   		 	       if (changeNum == 1) {

   		 		      return (playerName + " has become more reluctant around groups of people..I wonder if something is wrong." + "Social attractiveness has decreased by " + amount + " points");

   		 	       }//endif


   		 	  } else if (amount >= 8 && amount < 16) {

   		 	          Random changeGen = new Random();
   		 		      int changeNum = changeGen.nextInt(2);


   		 		       if (changeNum == 0) {

   		 		          return (playerName + " barely ever goes out anymore, and in the process has lost touch with many friends." + "Social attractiveness has decreased by " + amount + " points");

   		 			    }//endif


   		 		       if (changeNum == 1) {

   		 			       return (playerName + " seemingly has lost quite a bit of confidence talking to others in public and is becoming more shy every day." + "Social attractiveness has decreased by " + amount + " points");

   		 			    }//endif


   		 		   } else {

   		 	            Random changeGen = new Random();
   		 		        int changeNum = changeGen.nextInt(2);


   		 			  	 if (changeNum == 0) {

   		 			  	    return (playerName + " Never gets out of the house at all and has become the recluse of the neighborhood." + " Social attractiveness has decreased by " + amount + " points");

   		 			  	  }//endif


   		 			  	 if (changeNum == 1) {

   		 			  	   return (playerName + " is nervous when talking to people, and has no enjoyment whatsoever when talking to another human being." + "Social attractiveness has decreased by " + amount + " points");

   		 			  	  }//endif


   		 			}//end if


   		 	     }//end if


          return "nothing changed at all";

      }//method getNegativeAttMsg








}//class Language