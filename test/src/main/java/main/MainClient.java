package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import example.Client2;

public class MainClient {

	public static void main(String[] args) {
		System.out.println("#1");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		System.out.println("#2");
		Client2 c = ctx.getBean(Client2.class);
		System.out.println("#3");
		c.send();
		System.out.println("#4");
		ctx.close();
		System.out.println("#5");
	}

}
