package kr.naisstyle.racing.domain;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Serializable {

	private String carName;

	private AtomicInteger moveCount;

	public String getCarName() {
		return carName;
	}

	public AtomicInteger getMoveCount() {
		return moveCount;
	}
}
