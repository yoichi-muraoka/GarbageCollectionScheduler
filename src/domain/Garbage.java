package domain;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Garbage {
	
	private Integer id;
	private String name;
	private List<CollectingDays> collectionDays; // 収集日
	
	public Garbage(Integer id, String name, CollectingDays... collectingDays) {
		this.id = id;
		this.name = name;
		setCollectingDays(collectingDays);
	}
	
	public void setCollectingDays(CollectingDays... collectingDays) {
		this.collectionDays = Arrays.stream(collectingDays).collect(Collectors.toList());
	}
	
	// 与えられた日付(年月日)が収集日か?
	public boolean isCollectionDay(LocalDate date) {
		for(CollectingDays day : collectionDays) {
			if(day.isCollectingDay(date)) return true;
		}
		return false;
	}
	
	// 与えられた月(年と月)の回収日リスト
	public List<LocalDate> getCollectionDaysOfMonth(YearMonth yearMonth) {
		List<LocalDate> collectionDaysOfMonth = new ArrayList<>();
		for(CollectingDays day : collectionDays) {
			collectionDaysOfMonth.addAll(day.getCollectingDaysOfMonth(yearMonth));
		}
		return collectionDaysOfMonth;
	}

}
