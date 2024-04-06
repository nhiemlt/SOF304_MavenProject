package Nguyen.Login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import view.login;

public class loginTest {
	
	login form = new login();
	
	@Test
		public void TC_Login_01() {
			String text;
			try {
				text = form.dangNhap_Test("admin", "123");
			} catch (Exception e) {
				text = e.toString();
			}
			try {
				assertEquals(text, "pass");
			} catch (Exception e) {
				System.out.println(text);
			}
			
		}
	
	@Test
	public void TC_Login_02() {
	    String text;
	    try {
	        text = form.dangNhap_Test("", "");
	    } catch (Exception e) {
	        text = e.toString();
	    }
	    try {
	        assertNotEquals(text, "Lỗi để trống tên đăng nhập\n"
	        		+ "Lỗi để trống mật khẩu\n");
	    } catch (Exception e) {
	        System.out.println(text);
	    }
	}
	
	@Test
	public void TC_Login_03() {
	    String text;
	    try {
	        text = form.dangNhap_Test("User001", "password"); // Thay "password" bằng một password không đúng
	    } catch (Exception e) {
	        text = e.toString();
	    }
	    try {
	        assertEquals(text, "Lỗi tên đăng nhập không tồn tại");
	    } catch (Exception e) {
	        System.out.println(text);
	    }
	}

	@Test
	public void TC_Login_04() {
	    String text;
	    try {
	        text = form.dangNhap_Test("admin", "Pass123"); // Thay "Pass123" bằng một password không đúng
	    } catch (Exception e) {
	        text = e.toString();
	    }
	    try {
	        assertEquals(text, "Lỗi sai mật khẩu");
	    } catch (Exception e) {
	        System.out.println(text);
	    }
	}

}
