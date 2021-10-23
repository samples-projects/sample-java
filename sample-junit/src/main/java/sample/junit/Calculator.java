package sample.junit;

import lombok.extern.slf4j.Slf4j;

/**
 * 計算機
 */
@Slf4j
public class Calculator {
	/**
	 * 掛け算
	 * 
	 * @param x 第1オペラント
	 * @param y 第2オペラント
	 * @return x x y
	 */
	private int times(final int x, final int y) {
		int result = x * y;
		log.info("times: {} x {} = {}", x, y, result);
		return result;
	}

	/**
	 * 掛け算
	 * 
	 * @param x 第1オペラント
	 * @param y 第2オペラント
	 * @return x x y
	 */
	public int multiply(final int x, final int y) {
		int result = times(x, y);
		log.info("multiply: {} x {} = {}", x, y, result);
		return result;
	}

	/**
	 * 割り算
	 * 
	 * @param x 第1オペラント
	 * @param y 第2オペラント
	 * @return x / y
	 * @throws IllegalArgumentException ゼロ割
	 */
	public float divide(final int x, final int y) throws IllegalArgumentException {
		if (y == 0) {
			log.error("Can't calculate y = {}", y);
			throw new IllegalArgumentException();
		}

		float result = (float) x / (float) y;
		log.info("divide: {} / {} = {}", x, y, result);
		return result;
	}

	/**
	 * 2乗
	 * 
	 * @param x オペラント
	 * @return x ^ 2
	 */
	public int square(final int x) {
		int result = times(x, x);
		log.info("square: {} ^2 = {}", x, result);
		return result;
	}

	/**
	 * 環境変数取得
	 * 
	 * @return 環境変数
	 */
	public String getEnv() {
		String env = System.getenv("AWESOME_ENV_VAL");
		log.info("AWESOME_ENV_VAL = {}", env);
		return env;
	}
}
