package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample.ChangePasswordService;
import sample.MemberDAO;
import sample.MemberRegisterService;

@Configuration
public class AppCtx {

	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDAO());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDAO());
	}
}

