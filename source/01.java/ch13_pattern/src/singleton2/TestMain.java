package singleton2;

public class TestMain {

	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletoneClass singObj = SingletoneClass.getINSTACE();
		System.out.println("Main 함수에서 싱글톤 객채의 i값 : "+singObj.getI());
	}

}
