package sample.junit;

public class Calculator {
	private int times(int x, int y) {
		return x * y;
	}

	public int multiply(int x, int y) {
		return times(x, y);
	}

	public float divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException();
		return (float) x / (float) y;
	}

	public int square(int x) {
		System.out.println(x + "^2");
		return times(x, x);
	}

	public String getEnv() {
		String env = System.getenv("AWESOME_ENV_VAL");
		System.out.println("AWESOME_ENV_VAL=" + env);
		return env;
	}
}
