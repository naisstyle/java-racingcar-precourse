package kr.naisstyle.racing.enums;

public enum CarStatus {
	GO, STOP;

	public boolean isGo() {
		return GO == this;
	}

	public boolean isStop() {
		return STOP == this;
	}
}

