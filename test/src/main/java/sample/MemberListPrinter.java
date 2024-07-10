package sample;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	@Qualifier("printer")
	private MemberPrinter memberPrinter;
	
	public void printAll() {
		Collection<Member> members = memberDAO.selectAll();
		members.forEach(member -> memberPrinter.print(member));
	}
}

