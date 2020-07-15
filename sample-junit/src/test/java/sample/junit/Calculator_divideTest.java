package sample.junit;

import static org.junit.Assert.*;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Calculator_divideTest {

	/**
	 * フィクスチャ
	 *
	 * パラメータ群を1つのオブジェクトにまとめたもの。
	 */
	static class Fixture {
		int x;
		int y;
		float expected;

		Fixture(int x, int y, float expected) {
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
					new Fixture(0, 2, 0),
					new Fixture(2, 4, 0.5F),
					new Fixture(4, 2, 2)
					};
			return DATAS;
		}

		@Theory
		public void test(Fixture fx) {
			// 実行
			float actual = calculator.divide(fx.x, fx.y);
			System.out.println(fx.x + " + " + fx.y + " = " + actual);

			// 検証
			assertEquals(fx.expected, actual, 0);
		}
	}

	/**
	 * 異常ケース試験クラス
	 */
	@RunWith(Theories.class)
	public static class Calculator_IllegalArgumentTest {
		/** 供試体 */
		Calculator calculator = new Calculator();

		/** 入力値・規格値の読込 */
		@DataPoints
		public static Fixture[] createFixture() {
			Fixture[] DATAS = {
					new Fixture(2, 0, 0)
					};
			return DATAS;
		}

		/** 試験実行 */
		@Theory
		public void test(Fixture fx) {
			try {
				// 実行
				calculator.divide(fx.x, fx.y);
				// 検証
				fail();
			} catch (IllegalArgumentException e) {
			} finally {
			}
		}
	}
}