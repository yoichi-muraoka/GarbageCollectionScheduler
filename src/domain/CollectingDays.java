package domain;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface CollectingDays {
	
	// 与えられた日付(年月日)が収集日か?
	 boolean isCollectingDay(LocalDate date);
	 
	// 与えられた月(年と月)の回収日リストを返す
	 List<LocalDate> getCollectingDaysOfMonth(YearMonth yearMonth);

}
