package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class CollectionDay implements CollectingDays {
	
	private DayOfWeek dayOfWeek; // 曜日
	private List<Integer> collectingWeek; // 第何週

	public CollectionDay(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
		setCollectingWeek(1, 2, 3, 4, 5);
	}
	
	public CollectionDay(DayOfWeek dayOfWeek, Integer... weekNum) {
		this.dayOfWeek = dayOfWeek;
		setCollectingWeek(weekNum);
	}

	public void setCollectingWeek(Integer... weekNum) {
		this.collectingWeek = Arrays.stream(weekNum).collect(Collectors.toList());
	}
	
	@Override
	public boolean isCollectingDay(LocalDate date) {
		for(int weekNum : collectingWeek) {
			var adustedDate = date.with(TemporalAdjusters.dayOfWeekInMonth(weekNum, dayOfWeek));
			if(date.equals(adustedDate)) return true;
		}
		return false;
	}
	
	@Override
	public List<LocalDate> getCollectingDaysOfMonth(YearMonth yearMonth) {
		LocalDate date = yearMonth.atDay(1);
		return collectingWeek.stream()
			.map(weekNum -> date.with(TemporalAdjusters.dayOfWeekInMonth(weekNum, dayOfWeek)))
			.collect(Collectors.toList());
	}

}