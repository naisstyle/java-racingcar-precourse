package kr.naisstyle.racing.utils;

import java.util.Random;

public class RandomNumber {
	public static int MIN_NUMBER = 0;
	public static int MAX_NUMBER = 9;

	public static int generateRandomNumber() {
		return new Random().nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER;
	}

}
