// Hello.java --(������ javac Hello.java)--> Hello.class --(���� java Hello Hong Jang go)--> ���
public class Hello {
	public static void main(String[] args) {
		System.out.print("�ȳ��ϼ���");
		for(int idx = 0 ; idx<args.length ; idx++) {
			System.out.print(", " + args[idx]);
		}
	}

}
