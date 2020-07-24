package main;

import java.util.*;

import dao.*;
import dto.*;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDTO dto = new UserDTO();
		UserDAO udi = new UserDAOimpl();
		System.out.println("회원가입");
		System.out.println("email입력: ");
		String email = sc.next();
		dto.setEmail(email);	
		String id = email.substring(0, email.indexOf("@"));
		dto.setId(id);
		System.out.println("pw입력: ");
		String pw = sc.next();
		dto.setPw(pw);
		System.out.println("폰 번호 입력: ");
		String phone = sc.next();
		if (phone.length()== 11) {
		dto.setPhone(phone.replaceFirst("([0-9]{3})([0-9]{4})([0-9]{4})$", "$1-$2-$3"));
		udi.insert(dto);
		}
		else if (phone.length() == 10) {
			dto.setPhone(phone.replaceFirst("([0-9]{2})([0-9]{4})([0-9]{4})$", "$1-$2-$3"));
			udi.insert(dto);
		}
		
	}

}
