package app;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import domain.CollectionDate;
import domain.CollectionDay;
import domain.Garbage;
import service.GarbageCollectionScheduleService;

public class GarbageScheduler {

	public static void main(String[] args) {
		
		var scheduler = new GarbageCollectionScheduleService(createGarbageList());
		var schedule = scheduler.getScheduleByMonth(YearMonth.now());
		
		for(Entry<LocalDate, List<Garbage>> day : schedule.entrySet()) {
			System.out.print(day.getKey() + ": ");
			for(Garbage garbage : day.getValue()) {
				System.out.print(garbage.getName() + " ");
			}
			System.out.print("\n");
		}
		
	}

	/* ゴミの日は以下のように設定する
	 * --------------------------------
	 * 燃えるゴミ: 毎週火曜日と金曜日
	 * 燃えないゴミ: 第1/第3/第5金曜日
	 * 資源ゴミ: 毎週水曜日と第2/第4火曜日
	 * 金属ゴミ: 15日/30日と第1/第3土曜日
	 */
	private static List<Garbage> createGarbageList() {
		var burnableGarbage = new Garbage(1, "燃えるゴミ", new CollectionDay(DayOfWeek.TUESDAY), new CollectionDay(DayOfWeek.FRIDAY));
		var unburnableGarbage = new Garbage(2, "燃えないゴミ", new CollectionDay(DayOfWeek.FRIDAY, 1, 3, 5));
		var recycableGarbage = new Garbage(3, "資源ゴミ", new CollectionDay(DayOfWeek.WEDNESDAY), new CollectionDay(DayOfWeek.TUESDAY, 2, 4));
		var largeGarbage = new Garbage(4, "金属ゴミ", new CollectionDate(15, 30), new CollectionDay(DayOfWeek.SATURDAY, 1, 3));
		List<Garbage> garbageList = new ArrayList<>();
		garbageList.add(burnableGarbage);
		garbageList.add(unburnableGarbage);
		garbageList.add(recycableGarbage);
		garbageList.add(largeGarbage);
		return garbageList;
	}
	
}
