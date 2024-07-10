package sample;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {
	@Autowired
	private MemberDAO memberDAO;
	
	// public MemberRegisterService(MemberDAO memberDAO) {
	// 	this.memberDAO = memberDAO;
	// }
	
	public long regist(RegisterRequest req) {
		Member member = memberDAO.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}
		
		member = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDAO.insert(member);
		return member.getId();
	}
}
