package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")		
public class MemberInfoPrinter {	
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDAO.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 회원정보가 없습니다.");
			return;
		}
		printer.print(member);
	}
}

