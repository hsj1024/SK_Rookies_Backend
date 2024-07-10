package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import example.Client;
import example.Client2;
import sample.MemberPrinter;
import sample.MemberSummaryPrinter;
import sample.VersionPrinter;

@Configuration
@ComponentScan(basePackages = { "sample" , "example"})
public class AppCtx {
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}

	@Bean
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(1);
		return versionPrinter;
	}

	// @Bean
	public Client client() {
		Client c = new Client();
		c.setHost("www.test.com");
		return c;
	}
	
	@Bean(initMethod="connect", destroyMethod="close")
	public Client2 client2() {
		Client2 c = new Client2();
		c.setHost("www.test.com");
		return c;
	}

}
