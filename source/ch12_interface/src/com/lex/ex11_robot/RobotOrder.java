package com.lex.ex11_robot;
// RobotOrder oder - new RobotOrder();
// order.action(drawRobot형 객체)
public class RobotOrder {
	public void action(IRobot robot) {
		if(robot instanceof SingRobot) {
			((SingRobot)robot).sing();
		}else if(robot instanceof DanceRobot) {
			((DanceRobot)robot).dance();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot)robot).draw();
		}else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요");
		}
	}
}
