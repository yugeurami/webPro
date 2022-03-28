package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

// 5단계 : 기능을 부품화 ->유지보수를 간편하게 
public class TestMain {
	public static void main(String[] args) {
		Robot    superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot      lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot robot : robots) {
//			robot.shape();
//			robot.actionWalk();
//			robot.actionRun();
//			robot.actionFly();
//			robot.actionMissile();
//			robot.actionKnife();
//		}
		superR.setFly(new FlyHigh()); 
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
	}
}












