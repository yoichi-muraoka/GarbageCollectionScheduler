package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class DomainTest {
	
	public static void main(String[] args) {
		var collectionDay1 = new CollectionDay(DayOfWeek.SUNDAY, 2, 4); //第２,４日曜日
		var collectionDay2 = new CollectionDay(DayOfWeek.MONDAY); //毎週月曜日
		
		var list1 = collectionDay1.getCollectingDaysOfMonth(YearMonth.now());
		var list2 = collectionDay2.getCollectingDaysOfMonth(YearMonth.now());
		
		System.out.println("今月の第２,４日曜日 -------------");
		for(LocalDate date : list1) {
			System.out.println(date);
		}
		
		System.out.println("\n今月の月曜日 -------------------");
		for(LocalDate date : list2) {
			System.out.println(date);
		}
		
		System.out.println("\n\n========================\n\n");
		
		System.out.println("今月の燃えるゴミの日 -------------------");
		var garbage = new Garbage(1, "燃えるゴミ", collectionDay1, collectionDay2);
		for(LocalDate date : garbage.getCollectionDaysOfMonth(YearMonth.now())) {
			System.out.println(date);
		}
	}

}
