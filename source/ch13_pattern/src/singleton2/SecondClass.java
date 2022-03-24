package singleton2;

public class SecondClass {
	public SecondClass() {
		SingletoneClass singletonObject = SingletoneClass.getINSTACE();
		System.out.println("SecondClass 생성자 실행중");
		System.out.println("싱글톤 객체의 i값 : "+singletonObject.getI());
		System.out.println("SecondClass 생성자 끝");
	}
}
