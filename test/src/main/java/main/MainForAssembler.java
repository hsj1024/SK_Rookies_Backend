package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import sample.ChangePasswordService;
import sample.DuplicateMemberException;
import sample.MemberDAO;
import sample.MemberRegisterService;
import sample.RegisterRequest;

public class MainForAssembler {

	// new ==> 새로운 회원 데이터를 추가
	// change ==> 회원 패스워드를 변경
	// exit ==> 프로그램 종료
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if (command.startsWith("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			// new 이메일 이름 패스워드 패스워드확인
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			}

			// change 이메일 현재패스워드 새패스워드
			if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			
			// 사용법(도움말) 출력
			printHelp();
		}

	}
	
	private static Assembler assembler = new Assembler();

	private static void processChangeCommand(String[] args) {
		if (args.length != 4) {
			printHelp();
			return;
		}
		
		/*
		MemberDAO memberDAO = new MemberDAO();
		ChangePasswordService pswSvc = new ChangePasswordService(memberDAO);
		*/
		// Assembler assembler = new Assembler();
		ChangePasswordService pswSvc = assembler.getPwdSvc();
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
		
		/*
		MemberDAO memberDAO = new MemberDAO();
		MemberRegisterService regSvc = new MemberRegisterService(memberDAO);
		*/
		// Assembler assembler = new Assembler();
		MemberRegisterService regSvc = assembler.getRegSvc();
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