package jdbcdemo;

import java.util.HashMap;

public class ShowIdtoHmap {
   public HashMap<String, HashMap<Integer, Integer>> showIdtohmap(int showid) {
	   SeatbookingForShows sbfs = new SeatbookingForShows();
	   if (showid == 1) {
		   return sbfs.seatmap1;
	   }else if (showid == 2) {
		   return sbfs.seatmap2;
	   }else if (showid == 3) {
		   return sbfs.seatmap3;
	   }else if (showid == 4) {
		   return sbfs.seatmap4;
	   }else if (showid == 5) {
		   return sbfs.seatmap5;
	   }else if (showid == 6) {
		   return sbfs.seatmap6;
	   }else if (showid == 7) {
		   return sbfs.seatmap7;
	   }else if (showid == 8) {
		   return sbfs.seatmap8;
	   }else if (showid == 9) {
		   return sbfs.seatmap9;
	   }else if (showid == 10) {
		   return sbfs.seatmap10;
	   }else if (showid == 11) {
		   return sbfs.seatmap11;
	   }else if (showid == 12) {
		   return sbfs.seatmap12;
	   }else if (showid == 13) {
		   return sbfs.seatmap13;
	   }else if (showid == 14) {
		   return sbfs.seatmap14;
	   }else if (showid == 15) {
		   return sbfs.seatmap15;
	   }else{
		   return sbfs.seatmap1;
	   }
	  
	   
   }
}
