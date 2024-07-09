package sample;

public class ChangePasswordService {

	private MemberDAO memberDAO;
	
	public ChangePasswordService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public void changePassword(String email, String oldPass, String newPass) {
		Member member = memberDAO.selectByEmail(email);
		if (member == null) {
			throw new RuntimeException("등록된 회원이 없습니다.");
		}
		
		member.changePassword(oldPass, newPass);
		memberDAO.update(member);
	}
}

