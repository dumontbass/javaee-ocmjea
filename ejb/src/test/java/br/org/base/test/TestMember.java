package br.org.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.org.base.model.Member;
import br.org.base.service.MemberRegistration;


@RunWith(JUnit4.class)
public class TestMember {
	
	@Test
	public void create() {
		MemberRegistration memberRegistration = new MemberRegistration();
		Member member = new Member();
		member.setEmail("aasdiu.c");
		member.setName("adsasd");
		member.setPhoneNumber("1231231221");
		try {
			memberRegistration.register(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
