package kr.naisstyle.racing.utils;

import java.io.Serializable;

public class RacingGameUtils implements Serializable {
	public static int MIN_LENGTH = 1;
	public static int MAX_LENGTH = 5;

	public static boolean validCarName(String carName) {
		return !(carName == null || carName.isEmpty() || carName.trim().length() < MIN_LENGTH || carName.trim().length() > MAX_LENGTH);
	}

	public static boolean validTotalTryCount(String inputTryCount) {
		try {
			int tryCount = Integer.parseInt(inputTryCount);
			return tryCount > 0;
		} catch (NumberFormatException ignored) {
			return false;
		}
	}
}
