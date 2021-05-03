package kr.naisstyle.racing.domain;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Serializable {

	private final String carName;

	private AtomicInteger moveCount;

	public Car(String carName) {
		this.carName = carName;
		this.moveCount = new AtomicInteger();
	}

	public String getCarName() {
		return carName;
	}

	public AtomicInteger getMoveCount() {
		return moveCount;
	}
}
