package sample.junit;

import static org.junit.Assert.*;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Calculator_multiplyTest {

	/**
	 * フィクスチャ
	 *
	 * パラメータ群を1つのオブジェクトにまとめたもの。
	 */
	static class Fixture {
		int x;
		int y;
		int expected;

		Fixture(int x, int y, int expected) {
			this.x = x;
			this.y = y;
			this.expected = expected;
		}
	}

	/**
	 * 正常ケース試験クラス
	 */
	@RunWith(Theories.class)
	public static class CalculatorTest {
		/** 供試体 */
		Calculator calculator = new Calculator();

		/** 入力値・規格値の読込 */
		@DataPoints
		public static Fixture[] createFixture() {
			Fixture[] DATAS = {
					new Fixture(3, 4, 12),
					new Fixture(5, 7, 35)};
			return DATAS;
		}

		/** 試験実行 */
		@Theory
		public void test(Fixture fx) {
			// 実行
			int actual = calculator.multiply(fx.x, fx.y);
			System.out.println(fx.x + " + " + fx.y + " = " + actual);

			// 検証
			assertEquals(fx.expected, actual);
		}
	}
}