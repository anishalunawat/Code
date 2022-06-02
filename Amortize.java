import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.lang.Math;
class Amortize{
	public static int getDays(LocalDate date) {
		int month = date.getMonth().getValue();
		int year = date.getYear();
		switch (month) {
            case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
            case 2:
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                   return 29;
                } else {
                   return 28;
                }
        }
		return 0;
         
	}

	public static void main(String args[]) {
		int amortAmount = 1200;
		LocalDate startDate = LocalDate.of(2020, Month.AUGUST, 15);
		LocalDate endDate = LocalDate.of(2020, Month.AUGUST, 16);
        
		Period period = Period.between(startDate, endDate);
		int years = period.getYears();
		int months = ((period.getMonths() == 0)?((startDate.getMonth().getValue() == endDate.getMonth().getValue())?1:2):period.getMonths())+ 12*years;
		if(months == 1) {
		   System.out.println(amortAmount);
		   return;
		} 
		months = months-2;
	   
		// total number of days is start month and end month
		double startMontDays = getDays(startDate);
		double endMonthDays = getDays(endDate);
	   
		double startMonthR=1, endMonthR=1;
		startMonthR = (startMontDays - startDate.getDayOfMonth()+1)/startMontDays;
		endMonthR = endDate.getDayOfMonth()/endMonthDays;
	   
		double totalRatio = months+startMonthR+endMonthR;
	   
		double amount = amortAmount/totalRatio;
		int[] result = new int[months+2];
	   
		for(int i=1; i<=months; i++) {
			result[i] = (int)amount; 
			amortAmount = amortAmount - result[i];
		}
		result[0] = (int)(amount * startMonthR);
		amortAmount = amortAmount - result[0];
		result[months+1] = (int)(amount * endMonthR);
		amortAmount = amortAmount - result[months+1];
		result[0] =  result[0]+(int)Math.ceil(amortAmount/2);
		result[months+1] =  result[months+1]+(int)Math.floor(amortAmount/2);
	   
		for(int i=0; i<months+2; i++) {
			System.out.println(result[i]);
		}	
	}
}