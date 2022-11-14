package biblehw3;
import java.lang.Math;

public class biblehw3 {
	public static long convertAll(long[] totalDisciples) {
		long madeChristian = 0;
		for(int i = 0; i < totalDisciples.length; i++) {
			madeChristian = totalDisciples[i] + madeChristian;
		}
		return madeChristian;
	}
	public static boolean allConverted(long[] numpeople, long[] numofDisciples) {
		long numPeople = 0;
		long totalDisciples = 0;
		for(int i = 0; i < numpeople.length; i++) {
			numPeople = numpeople[i] + numPeople;
			totalDisciples = numofDisciples[i] + totalDisciples;
		}
		return(numPeople == totalDisciples);
	}
	public static int numYears(long[] numPeople) {
		long[] totalDisciples = new long[numPeople.length];
		int year = 0;
		totalDisciples[18] = 13;
		while(!allConverted(numPeople, totalDisciples) && (year < 5000000000L)) {
			year++;
			
			for(int i = numPeople.length - 1; i > 0; i--) {
				numPeople[i] = numPeople[i - 1];
				totalDisciples[i] = totalDisciples[i - 1];
			}
			long disciples = convertAll(totalDisciples);
			
			if(disciples == 0) {
				break;
			}
			long madeChristian = (long)(disciples * 2 * .001);
			int age = 18;
			if(year % 3 == 0) {
				while(madeChristian > 0 && age <= 50) {
					long available = numPeople[age] - totalDisciples[age];
					if(madeChristian < available) {
						totalDisciples[age] = madeChristian + totalDisciples[age];
						madeChristian = 0;
					}else { 
						totalDisciples[age] = available + totalDisciples[age];
						madeChristian = madeChristian - available;
					}
					age++;
				}
			}	
			numPeople[0] = numPeople[30];
			for(int j = 0; j < totalDisciples.length; j++) {
				totalDisciples[j] = Math.round(totalDisciples[j] - totalDisciples[j] * 0.01);
			}
		}
		
		return year;
	}
	
	
//main	
	
	public static void main(String[] args) {
		long[] numPeople = new long[50];
		numPeople[18] = 7700000000L;
		
		System.out.println("It will take " + numYears(numPeople) + " years to convert everyone in the world to Christianity.");
	}
}