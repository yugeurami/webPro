package strategy1.step2;
// Robot을 상속받을 클래스 : SuperRobot, StandardRobot, LowRobot
public class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다");
	}
	public void shape() {
		String classname = getClass().getName(); // strategy1.step2.SuperRobot
		int idx = classname.lastIndexOf('.'); //맨 마지막 '.'이 있는 위치
		String name = classname.substring(idx+1); //idx+1번째 글씨부터 끝까지
		System.out.println(name+"외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
}
