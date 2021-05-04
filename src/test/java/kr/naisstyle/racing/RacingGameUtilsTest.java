package kr.naisstyle.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.naisstyle.racing.utils.RacingGameUtils;

class RacingGameUtilsTest {

	@Test
	@DisplayName("자동차_이름_검증")
	void racingCarNameValidation() {
		assertThat(RacingGameUtils.validCarName("1")).isTrue();
		assertThat(RacingGameUtils.validCarName("AAA")).isTrue();

		//null
		assertThat(RacingGameUtils.validCarName(null)).isFalse();
		//빈 공백
		assertThat(RacingGameUtils.validCarName("")).isFalse();
		// 입력값 초과
		assertThat(RacingGameUtils.validCarName("AAAAAA")).isFalse();
	}

	@Test
	@DisplayName("시도_횟수_검증")
	void totalTryCountValidation() {
		assertThat(RacingGameUtils.validTotalTryCount("1")).isTrue();
		assertThat(RacingGameUtils.validTotalTryCount("5")).isTrue();

		assertThat(RacingGameUtils.validTotalTryCount("z")).isFalse();
		assertThat(RacingGameUtils.validTotalTryCount("0")).isFalse();
		assertThat(RacingGameUtils.validTotalTryCount("-1")).isFalse();
	}
}