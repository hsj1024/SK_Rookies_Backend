package sample;
class Parent {
	public void method1() {
		System.out.println("Parent.method1()");
	}
	
	public void method2() {
		System.out.println("Parent.method2()");
	}
}
class Child1 extends Parent {
	public void method1() {
		System.out.println("Child1.method1()");
	}
}
class Child2 extends Parent {
	public void method2() {
		System.out.println("Child2.method2()");
	}
}
public class Main {
	public static void main(String[] args) {
		System.out.println("\nParent p = new Parent();");
		Parent p = new Parent();
		p.method1();
		p.method2();
		
		System.out.println("\nChild1 c1 = new Child1();");
		
		Child1 c1 = new Child1();
		c1.method1();
		c1.method2();
		
		System.out.println("\nChild2 c2 = new Child2();");
		
		Child2 c2 = new Child2();
		c2.method1();
		c2.method2();
		System.out.println("\nParent p1 = new Child1();");
		
		Parent p1 = new Child1();
		p1.method1();
		p1.method2();
		
		System.out.println("\nParent p2 = new Child2();");
		
		Parent p2 = new Child2();
		p2.method1();
		p2.method2();
	}
}
