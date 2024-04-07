package Nhu.DoiMatKhau;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.DoiMatKhau;

public class DoiMatKhauTest {

	DoiMatKhau doiMatKhau = new DoiMatKhau();

	@Test(description = "Kiểm tra khi username bỏ trống")
	public void TC_01() {
		String result = doiMatKhau.doiMatKhau_Test("", "123", "123", "123");
		Assert.assertEquals(result, "Vui lòng nhập tên người dùng");
	}

	@Test(description = "Kiểm tra khi mật khẩu cũ bỏ trống")
	public void TC_02() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "", "123", "123");
		Assert.assertEquals(result, "Vui lòng nhập mật khẩu cũ");
	}

	@Test(description = "Kiểm tra khi mật khẩu mới bỏ trống")
	public void TC_03() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "123", "", "123");
		Assert.assertEquals(result, "Vui lòng nhập mật khẩu mới");
	}

	@Test(description = "Kiểm tra khi xác nhận mật khẩu mới bỏ trống")
	public void TC_04() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "123", "123", "");
		Assert.assertEquals(result, "Vui lòng nhập lại mật khẩu mới");
	}

	@Test(description = "Kiểm tra khi username không tồn tại")
	public void TC_05() {
		String result = doiMatKhau.doiMatKhau_Test("admin_khongtoitai", "matkhau", "matkhau_moi", "matkhau_moi");
		Assert.assertEquals(result, "Username không tồn tại");
	}

	@Test(description = "Kiểm tra khi mật khẩu cũ không hợp lệ")
	public void TC_06() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "1231", "matkhau_moi", "matkhau_moi");
		Assert.assertEquals(result, "Mật khẩu cũ không khớp");
	}

	@Test(description = "Kiểm tra khi xác nhận mật khẩu mới không khớp")
	public void TC_07() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "123", "123", "1231");
		Assert.assertEquals(result, "Xác nhận mật khẩu mới không khớp");
	}

	@Test(description = "Đổi mật khẩu thành công")
	public void TC_08() {
		String result = doiMatKhau.doiMatKhau_Test("admin", "123", "123", "123");
		Assert.assertEquals(result, "Đổi mật khẩu thành công!");
	}

	@Test(description = "Kiểm tra khi username nhập vào là null")
	public void TC_09() {
		String result = doiMatKhau.doiMatKhau_Test(null, "matkhau", "matkhau_moi", "matkhau_moi");
		Assert.assertEquals(result, "Username không tồn tại");
	}

}
