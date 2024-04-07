package Nhu.KhachHang;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.KhachHang;

public class ThemTest {
	KhachHang khachhang = new KhachHang();

	@Test(description = "Điền đầy đủ thông tin hợp lệ")
	public void TC_THEM_01() {
		// Tạo đối tượng KhachHang với thông tin hợp lệ
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("Nguyen Van C");
		kh.setSDT("0358123114");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Thêm thành công!");
	}

	@Test(description = "Kiểm tra sau khi thêm tên khách hàng")
	public void TC_THEM_02() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("");
		kh.setSDT("0358456789");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Tên khách hàng không được để trống");
	}

	@Test(description = "Kiểm tra sau khi thêm tên khách hàng")
	public void TC_THEM_03() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("12312312");
		kh.setSDT("0358456782");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Tên khách hàng không được chứa kí tự số");
	}

	@Test(description = "Kiểm tra sau khi thêm số điện thoại không được để trống")
	public void TC_THEM_04() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("Nguyen Van A");
		kh.setSDT("");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Số điện thoại không được để trống");
	}

	@Test(description = "Kiểm tra sau khi thêm tên khách hàng không chứa kí tự đặc biệt")
	public void TC_THEM_05() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("Nguyen! Van A");
		kh.setSDT("0123456789");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Tên khách hàng không chứa kí tự đặt biệt");
	}

	@Test(description = "Số điện thoại không đúng định dạng")
	public void TC_THEM_06() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("Nguyen Van A");
		kh.setSDT("01234567"); // Số điện thoại không đủ 10 số
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Số điện thoại chưa đúng định dạng");
	}

	@Test(description = "Kiểm tra địa chỉ khách hàng")
	public void TC_THEM_07() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH("Nguyễn Minh Nhu");
		kh.setSDT("0358094548");
		kh.setDiaChi("");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Địa chỉ khách hàng không được để trống");
	}

	@Test(description = "Kiểm tra tên khách hàng")
	public void TC_THEM_08() {
		model.KhachHang kh = new model.KhachHang();
		kh.setTenKH(
				"Nguyễn Thị Thanh Hằng là một một một một một một một một một một một một  sinh viên đại học sống tại thành phố Hồ Chí Minh yêu thích du lịch và thích khám phá những nơi mới Cô thường xuyên tham gia các hoạt động tình nguyện và mong muốn góp phần xây dựng một cộng đồng tốt đẹp hơn đó");
		kh.setSDT("0358094518");
		kh.setDiaChi("123 Đường ABC, Q1, TP.HCM");

		String result = khachhang.Them_test(kh);
		Assert.assertEquals(result, "Tên khách hàng không được vượt quá 255 kí tự");
	}

}
