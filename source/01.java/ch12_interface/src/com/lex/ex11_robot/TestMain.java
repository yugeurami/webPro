package com.lex.ex11_robot;

public class TestMain {

	public static void main(String[] args) {
		IRobot[] robots = {	new SingRobot(),
							new DanceRobot(),
							new DrawRobot()};
		RobotOrder order = new RobotOrder();
		for(IRobot robot : robots) {
			order.action(robot);
		}
	}

}
