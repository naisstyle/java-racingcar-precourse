package kr.naisstyle.racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 객체 생성")
	void newCar() {
		assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
	}
}