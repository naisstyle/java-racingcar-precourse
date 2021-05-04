package kr.naisstyle.racing;

import java.io.Serializable;

public class RacingGameUtils implements Serializable {
	public static int MIN_LENGTH = 1;
	public static int MAX_LENGTH = 5;

	public static boolean invalidCarName(String carName) {
		return carName == null || carName.isEmpty() || carName.trim().length() < MIN_LENGTH || carName.trim().length() > MAX_LENGTH;
	}
}
