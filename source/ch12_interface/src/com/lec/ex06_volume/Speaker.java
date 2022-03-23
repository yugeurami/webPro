package com.lec.ex06_volume;
// Speaker s = new Speaker(3);
public class Speaker implements IVolume {
	private int volumeLevel;
	private static final byte SPEAKER_MAX_VOLUME = 100;
	private static final byte SPEAKER_MIN_VOLUME = 0;
	
	public Speaker() {
	}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUp() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("스피커 볼륨을 1올려 현재 "+volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최대치여서 올리지 못했습니다");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel+level <= SPEAKER_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("스피커 볼륨을"+level+"올려 현재 "+volumeLevel);
		} else { // level만큼 못 올릴 경우 ex.현재 볼륨45 level 10 => 몇만큼 올릴지 계산, 볼륨은 50
			int temp = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못올리고"+temp+"만큼 올려 최대치"+SPEAKER_MAX_VOLUME);
		}
	}

	@Override
	public void volumeDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("스피커 볼륨을 1내려 현재 "+volumeLevel);
		} else {
			System.out.println("스피커 볼륨이 최소치여서 내리지 못했습니다");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel-level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("스피커 볼륨을"+level+"내려 현재 "+volumeLevel);
		} else { 
			int temp = volumeLevel;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못내리고"+temp+"만큼 올려 최소치"+SPEAKER_MIN_VOLUME);
		}
	}

}
