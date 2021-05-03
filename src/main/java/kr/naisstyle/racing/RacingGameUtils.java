package kr.naisstyle.racing;

import java.io.Serializable;

public class RacingGameUtils implements Serializable {

	public static boolean invalideCarName(String carName) {
		return carName == null || carName.isEmpty() || carName.length() > 5;
	}
}
