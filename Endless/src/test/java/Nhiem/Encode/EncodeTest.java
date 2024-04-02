package Nhiem.Encode;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import util.Encode;
public class EncodeTest {
	
	Encode ec = new Encode();

    @Test(description = "Kiểm tra khi tạo mật khẩu mới với đầu vào hợp lệ")
    public void TC_HASH_01() {
        String plainPassword = "Password123!";
        String hashedPassword = ec.hashPassword(plainPassword);
        assertNotNull(hashedPassword);
    }

    @Test(description = "Kiểm tra khi có lỗi xảy ra khi tạo mật khẩu mới")
    public void TC_HASH_02() {
        String plainPassword = "123456";
        try {
            String hashedPassword = ec.hashPassword(plainPassword);
            assertNull(hashedPassword);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test(description = "Kiểm tra khi mật khẩu nhập vào khớp với mật khẩu đã mã hóa")
    public void TC_CHECK_01() {
        String plainPassword = "Password123!";
        String hashedPassword = ec.hashPassword(plainPassword);
        assertTrue(ec.checkPassword(plainPassword, hashedPassword));
    }

    @Test(description = "Kiểm tra khi mật khẩu nhập vào không khớp với mật khẩu đã mã hóa")
    public void TC_CHECK_02() {
        String plainPassword = "123456";
        String hashedPassword = ec.hashPassword("Password123!");
        assertFalse(ec.checkPassword(plainPassword, hashedPassword));
    }

}
