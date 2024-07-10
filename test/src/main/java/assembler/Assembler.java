package assembler;

import sample.ChangePasswordService;
import sample.MemberDAO;
import sample.MemberRegisterService;

public class Assembler {
	private MemberDAO memberDAO;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		this.memberDAO = new MemberDAO();
		//this.regSvc = new MemberRegisterService(this.memberDAO);
		//this.pwdSvc = new ChangePasswordService(this.memberDAO);
	}

	public MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}
	
}

