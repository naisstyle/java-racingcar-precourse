package kr.naisstyle.racing.domain;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import kr.naisstyle.racing.RacingGameUtils.*;

public class Car implements Serializable {

	private final String carName;

	private final AtomicInteger moveCount;

	private final Random random;

	public Car(String carName) {
		this.carName = carName;
		this.moveCount = new AtomicInteger();
		this.random = new Random();
	}

	public String getCarName() {
		return carName;
	}

	public AtomicInteger getMoveCount() {
		return moveCount;
	}

	public CAR_STATUS getCarStatus() {
		return this.random.nextInt(9) >= 4 ? CAR_STATUS.MOVE : CAR_STATUS.STOP;
	}

	public int getMoveCount(CAR_STATUS carStatus) {
		return CAR_STATUS.MOVE == carStatus ? moveCount.addAndGet(1) : moveCount.get();
	}

	public void printRacingProgress() {
		StringBuilder progress = new StringBuilder();
		progress.append(this.carName);
		progress.append(" : ");
		for (int i = 0; i < this.moveCount.get(); i++) {
			progress.append('-');
		}
		System.out.println(progress);
	}
}
