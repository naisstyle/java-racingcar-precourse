package kr.naisstyle.racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import kr.naisstyle.racing.domain.Car;
import kr.naisstyle.racing.service.RacingGameService;

public class RacingGame {

	public static void main(String[] args) {
		RacingGameService racingGameService = new RacingGameService();
		racingGameService.createRacingCars();
		racingGameService.setTryCount();
		racingGameService.play();
	}
}
