package singleton2;

public class SingletoneClass {
	private int i=10;
	private static SingletoneClass INSTANCE = new SingletoneClass();
	public static SingletoneClass getINSTACE() {
		return INSTANCE;
	}
	private SingletoneClass() {}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
