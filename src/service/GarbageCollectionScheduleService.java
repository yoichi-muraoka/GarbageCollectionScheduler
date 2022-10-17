package service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Garbage;

public class GarbageCollectionScheduleService {
	
	private List<Garbage> garbageList;
	
	public GarbageCollectionScheduleService(List<Garbage> garbageList) {
		this.garbageList = garbageList;
	}
	
	public GarbageCollectionScheduleService(Garbage... garbageList) {
		this.garbageList = Arrays.stream(garbageList).collect(Collectors.toList());
	}
	
	// 月のゴミ収集日スケジュールを返す
	public Map<LocalDate, List<Garbage>> getScheduleByMonth(YearMonth yearMonth) {
		Map<LocalDate, List<Garbage>> schedule = new LinkedHashMap<>();
		int endOfMonth = yearMonth.atEndOfMonth().getDayOfMonth();
		for(int d = 1; d <= endOfMonth; d++) {
			schedule.put(yearMonth.atDay(d), getGarbageListByDate(yearMonth.atDay(d)));
		}
		
		return schedule;
	}
	
	// 指定された年月日に該当する収集ゴミのリストを返す
	private List<Garbage> getGarbageListByDate(LocalDate date) {
		List<Garbage> garbageListOfDate = new ArrayList<>();
		for(Garbage garbage : garbageList) {
			if(garbage.isCollectionDay(date)) garbageListOfDate.add(garbage);
		}
		
		return garbageListOfDate;
	}

}
