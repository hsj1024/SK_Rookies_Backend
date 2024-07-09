package sample;

import java.time.LocalDateTime;

public class Member {

	private Long id;		// 내부적으로 회원관리를 위해서 사용하는 값
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {	// Member 객체는 회원 정보를 담고 있는 객체로 ID 생성 규칙을 포함할 수 없음
		this.id = id;				// Member 객체를 사용하는 외부에서 생성한 ID를 설정하기 위해 setter를 정의 
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!this.password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}	
}

