package domain;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class CollectionDate implements CollectingDays {
	
	private List<Integer> collectingDates;
	
	public CollectionDate(Integer... dates) {
		setCollectingDates(dates);
	}
	
	public void setCollectingDates(Integer... dates) {
		this.collectingDates = Arrays.stream(dates).collect(Collectors.toList());
	}

	@Override
	public boolean isCollectingDay(LocalDate date) {
		int dayOfMonth = date.getDayOfMonth();
		return collectingDates.contains(dayOfMonth);
	}

	@Override
	public List<LocalDate> getCollectingDaysOfMonth(YearMonth yearMonth) {
		return collectingDates.stream()
			.map(date -> yearMonth.atDay(date))
			.collect(Collectors.toList());
	}

}
