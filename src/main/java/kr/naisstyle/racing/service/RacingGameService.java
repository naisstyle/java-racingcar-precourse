package kr.naisstyle.racing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.naisstyle.racing.domain.Car;

public class RacingGameService {
	Scanner scanner;

	List<Car> carList;

	Integer totalTryCount;
	Integer maxMoveCount;

	public RacingGameService() {
		this.scanner = new Scanner(System.in);
		this.carList = new ArrayList<>();
	}

	public void createRacingCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] carNames = scanner.nextLine().split(",");
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	public void setTryCount() {
		System.out.println("시도 횟수는 몇회인가요?");
		this.totalTryCount = scanner.nextInt();

		if (totalTryCount <= 0) {
			throw new IllegalArgumentException("시도 횟수 입력값 오류");
		}
	}

	public void play() {
		for (int tryCnt = 0; tryCnt < this.totalTryCount; tryCnt++) {
			this.carRacing();
			System.out.println();
		}

		printWinnerCars();
	}

	public void carRacing() {
		for (Car car : carList) {
			car.racing();
			maxMoveCount = maxMoveCount == null || maxMoveCount < car.getMoveCount().get() ? car.getMoveCount().get() : maxMoveCount;
		}
	}

	public void printWinnerCars() {
		List<String> winners = this.getWinnerCarNameList();

		System.out.print(String.join(", ", winners) + "가 최종 우승했습니다.");
	}

	public List<String> getWinnerCarNameList() {
		List<String> winnerCars = new ArrayList<>();
		for (Car car : carList) {
			this.setWinnerCarNameList(winnerCars, car);
		}
		return winnerCars;
	}

	public void setWinnerCarNameList(List<String> winnerCarList, Car car) {
		if(car.isWinner(this.maxMoveCount)) {
			winnerCarList.add(car.getCarName());
		}
	}
}
