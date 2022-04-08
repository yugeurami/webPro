package singleton2;

public class FirstClass {
	public FirstClass() {
		SingletoneClass singletonObject = SingletoneClass.getINSTACE();
		System.out.println("싱글톤 객체의 i값 : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("싱글톤 객체의 i값 수정후 : "+singletonObject.getI());
	}
}
