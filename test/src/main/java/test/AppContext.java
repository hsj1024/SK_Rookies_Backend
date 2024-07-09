package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.*;
// Ctrl + Shift + O 단축키를 누르면 관련 패키지를 자동으로 import 할 수 있음

@Configuration					// 해당 클래스를 스프링 설정 클래스로 지정
public class AppContext {
	@Bean					// 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요.");
		return g;
	}
}
