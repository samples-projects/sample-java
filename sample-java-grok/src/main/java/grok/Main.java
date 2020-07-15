package grok;

import java.util.Map;

import io.thekraken.grok.api.Grok;
import io.thekraken.grok.api.Match;
import io.thekraken.grok.api.exception.GrokException;

//https://qiita.com/rmiyayama/items/75bcdf98aa67534d1b5d
//https://github.com/logstash-plugins/logstash-patterns-core
public class Main {

	private Main() {
	}

	public static void main(String[] args) throws GrokException {
		Grok grok = new Grok();

		// パターン登録
		grok.addPatternFromFile(Thread.currentThread().getContextClassLoader().getResource("logstash-patterns-core/patterns/grok-patterns").getFile());

		// パターンの組み合わせで、キャプチャするためのパターンをコンパイル
		grok.compile("%{SYSLOGTIMESTAMP:time} %{GREEDYDATA:restof}");

		// 対象の文字列とマッチ
		Match match = grok.match("Apr 23 10:17:01 oya1ELK02 CRON[3732]: (root) CMD (   cd / && run-parts --report /etc/cron.hourly)");
		match.captures();

		// Mapとして取得可能
		Map<String, Object> map = match.toMap();
		System.out.println(map);
	}
}

