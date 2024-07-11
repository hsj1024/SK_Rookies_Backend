package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import assembler.Assembler;
import config.AppCtx;
import sample.ChangePasswordService;
import sample.DuplicateMemberException;
import sample.MemberRegisterService;
import sample.RegisterRequest;

public class MainForSpring {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}

			if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			
			printHelp();
		}

	}
	
	// private static Assembler assembler = new Assembler();

	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		
		// ChangePasswordService pswSvc = assembler.getPwdSvc();
		ChangePasswordService pswSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			pswSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("패스워드를 변경했습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void processNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail(args[1]);
		regReq.setName(args[2]);
		regReq.setPassword(args[3]);
		regReq.setConfirmPassword(args[4]);
		if (!regReq.isPasswordEqualToConfirmPassword()) {
			System.out.println("패스워드가 일치하지 않습니다.");
			return;
		}
		
		// MemberRegisterService regSvc = assembler.getRegSvc();
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
 		try {
			regSvc.regist(regReq);
			System.out.println("정상적으로 등록되었습니다.");
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.");
		}		
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 명령어 사용법을 확인하고 다시 시도해 주세요.");
		System.out.println("new 이메일 이름 패스워드 패스워드확인");
		System.out.println("change 이메일 현재패스워드 새패스워드");
		System.out.println("exit");
	}

}
