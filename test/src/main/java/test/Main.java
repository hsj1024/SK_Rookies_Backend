package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		{
			Greeter g = new Greeter();
			g.setFormat("%s, 안녕하세요.");
			String msg = g.greet("스프링");
			System.out.println(msg);
			
			Greeter g2 = new Greeter();
			g2.setFormat("%s, 안녕하세요.");
			String msg2 = g2.greet("Spring");
			System.out.println(msg2);
			
			System.out.println("g = " + g);
			System.out.println("g2 = " + g2);			// ⇐ g와 g2가 다른 인스턴스이므로
			System.out.println("g == g2 " + (g == g2));		// ⇐ false 
		}
		
		{
			// 자바 설정에서 정보를 읽어와 빈 객체를 생성하고 관리
			AnnotationConfigApplicationContext ctx 
				= new AnnotationConfigApplicationContext(AppContext.class);
			
			// 생성한 빈 객체를 검색할 때 사용 
			Greeter g = ctx.getBean("greeter", Greeter.class);
			String msg = g.greet("스프링");
			System.out.println(msg);
			
			Greeter g2 = ctx.getBean("greeter", Greeter.class);
			String msg2 = g2.greet("Spring");
			System.out.println(msg2);

			System.out.println("g = " + g);
			System.out.println("g2 = " + g2);			// ⇐ g와 g2가 동일 인스턴스이므로
			System.out.println("g == g2 " + (g == g2));		// ⇐ true를 반환

			ctx.close();
		}
	}

}

