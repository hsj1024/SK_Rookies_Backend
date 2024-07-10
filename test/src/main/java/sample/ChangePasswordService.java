package sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDAO memberDAO;
	
	public void changePassword(String email, String oldPass, String newPass) {
		Member member = memberDAO.selectByEmail(email);
		if (member == null) {
			throw new RuntimeException("등록된 회원이 없습니다.");
		}
		
		member.changePassword(oldPass, newPass);
		memberDAO.update(member);
	}
}
