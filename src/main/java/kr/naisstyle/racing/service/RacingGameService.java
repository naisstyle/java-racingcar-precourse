package kr.naisstyle.racing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kr.naisstyle.racing.domain.Car;
import kr.naisstyle.racing.utils.RacingGameUtils;

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
		List<String> carNames = Arrays.asList(scanner.nextLine().split(","));
		try {
			for (String carName : carNames) {
				carList.add(new Car(carName));
			}
		} catch (IllegalArgumentException e) {
			System.out.println("입렵값 오류 : " + e.getMessage());
			createRacingCars();
		}
	}

	public void inputTryCount() {
		System.out.println("시도 횟수는 몇회인가요?");

		String inputTryCount = scanner.nextLine();
		try {
			this.totalTryCount = this.convertTotalTryCount(inputTryCount);
		} catch (InputMismatchException | IllegalArgumentException e) {
			System.out.println("1이상의 숫자만 입력하세요!");
			inputTryCount();
		}
	}

	public int convertTotalTryCount(String inputTryCount) {
		if(!RacingGameUtils.validTotalTryCount(inputTryCount)) {
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(inputTryCount);
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
