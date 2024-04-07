package Nguyen.QuenMatKhau;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.SendEmailSMTP;
import view.QuenMatKhau;

public class sendOTPTest {

	private long lastSendTime;
	private String otp;
	
	QuenMatKhau form = new QuenMatKhau();

	@BeforeMethod
	public void setUp() {
		// Thiết lập thời gian cuối cùng gửi OTP là 0 để bắt đầu
		lastSendTime = 0;
	}

	@Test(description = "Kiểm tra khi gửi OTP thành công")
	public void TC_SEND_OTP_01() {
		long currentTime = System.currentTimeMillis();

		if (currentTime - lastSendTime < 30 * 1000) {
			Assert.fail("Chưa đủ 30 giây kể từ lần gửi OTP trước đó.");
		} else {
			SendEmailSMTP sm = new SendEmailSMTP();
			otp = form.sendOTP_Test("nguyenvttpc05404@fpt.edu.vn", sm);
			String expectedResult = sm.getNumberOTP();
			Assert.assertEquals(otp, expectedResult);
			lastSendTime = currentTime;
		}
	}

	@Test(description = "Kiểm tra khi gửi lại OTP sau 30 giây")
	public void TC_SEND_OTP_02() {
		SendEmailSMTP sm = new SendEmailSMTP();
		String expectedResult = "Vui lòng đợi 30 giây trước khi gửi lại OTP.";
		String actualResult = form.sendOTP_Test("nguyenvttpc05404@fpt.edu.vn", sm);
		actualResult = form.sendOTP_Test("nguyenvttpc05404@fpt.edu.vn", sm);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(description = "Kiểm tra khi nhập email không hợp lệ")
	public void TC_SEND_OTP_03() {
		SendEmailSMTP sm = new SendEmailSMTP();
		String expectedResult = "Email chưa đúng định dạng!";
		String actualResult = form.sendOTP_Test("invalid.email", sm);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(description = "Kiểm tra khi gửi OTP lần đầu tiên")
	public void TC_SEND_OTP_04() {
		SendEmailSMTP sm = new SendEmailSMTP();
		lastSendTime = System.currentTimeMillis() - 40 * 1000; // Giả sử gửi OTP cách đây 40 giây
		String actualResult = form.sendOTP_Test("nguyenvttpc05404@fpt.edu.vn", sm);
		String expectedResult = sm.getNumberOTP();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(description = "Kiểm tra khi không có email")
	public void TC_SEND_OTP_05() {
		SendEmailSMTP sm = new SendEmailSMTP();
		String actualResult = form.sendOTP_Test("", sm);
		Assert.assertEquals(actualResult, "Email chưa đúng định dạng!");
	}

}
