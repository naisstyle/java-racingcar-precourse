package kr.naisstyle.racing;

import kr.naisstyle.racing.service.RacingGameService;

public class RacingGame {

	public static void main(String[] args) {
		RacingGameService racingGameService = new RacingGameService();
		racingGameService.createRacingCars();
		racingGameService.inputTryCount();
		racingGameService.play();
	}
}
