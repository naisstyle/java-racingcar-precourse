package kr.naisstyle.racing.domain;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import kr.naisstyle.racing.RacingGameUtils;
import kr.naisstyle.racing.enums.CarStatus;

public class Car implements Serializable {

	private final String carName;

	private final AtomicInteger moveCount;

	private final Random random;

	public Car(String carName) {
		if(RacingGameUtils.invalidCarName(carName)){
			throw new IllegalArgumentException("자동차 이름은 1~5자리");
		}

		this.carName = carName.trim();
		this.moveCount = new AtomicInteger();
		this.random = new Random();
	}

	public String getCarName() {
		return carName;
	}

	public AtomicInteger getMoveCount() {
		return moveCount;
	}

	public CarStatus getCarStatus() {
		return this.random.nextInt(9) >= 4 ? CarStatus.GO : CarStatus.STOP;
	}

	public void goAndStop(CarStatus carStatus) {
		if(carStatus.isGo()) {
			moveCount.incrementAndGet();
		}
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

	public void racing() {
		this.goAndStop(this.getCarStatus());
		this.printRacingProgress();
	}

	public boolean isWinner(int maxMove) {
		return this.moveCount.get() == maxMove;
	}
}
