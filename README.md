# 概要
- 今月のゴミ収集日を表示させるテキストアプリ
- 収集日は以下のように設定されている(src/app/GarbageScheduler.java内)

| ゴミの種類 | 収集日 |
| --- | --- |
| 可燃ゴミ | 毎週火・金曜日 |
| 不燃ゴミ | 第1・3・5金曜日 |
| 資源ゴミ | 毎週水曜と第2・4火曜日 |
| 金属ゴミ | 15・30日と第1・第3土曜日 |

## アプリケーションの起動
- src/app/GarbageScheduler.javaのmainメソッドを実行する


# クラス
## domainパッケージ
| クラス | 説明 |
| --- | --- |
| CollectingDays | 収集日のインターフェース<br>与えられた日付が収集日か判断するメソッドと指定された月の収集日のリストを返すメソッドをもつ |
| CollectionDay | CollectingDaysの実装<br>収集日の情報を曜日と第何週かの形式で保持する |
| CollectionDate | CollectingDaysの実装<br>収集日の情報を日付で保持する |
| Garbage | ゴミの種類名と収集日(CollectingDays)のリストを保持する<br>与えられた日付が収集日か判断するメソッドと指定された月の収集日リストを返すメソッドをもつ |
| DomainTest | CollectionDayのテスト |

## serviceパッケージ
| クラス | 説明 |
| --- | --- |
| GarbageCollectionScheduleService | ゴミ(Garbage)のリストを保持し、指定された月のゴミ収集日スケジュールを返すメソッドをもつ |

## appパッケージ
| クラス | 説明 |
| --- | --- |
| GarbageScheduler | メインメソッドをもつクラス<br>今月のゴミ収集日スケジュールを表示する |
