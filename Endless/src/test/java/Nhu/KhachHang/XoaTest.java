package Nhu.KhachHang;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.NhanVien;
import util.Auth;
import view.KhachHang;

public class XoaTest {

	void setAdmin() {
		NhanVien nv = new NhanVien();
		nv.setVaiTro(true);
		Auth.user = nv;
	}

	void setUser() {
		NhanVien nv = new NhanVien();
		nv.setVaiTro(false);
		Auth.user = nv;
	}

	KhachHang khachhang = new KhachHang();

	@Test(description = "Xóa khách hàng thành công với quyền của người quản lý")
	public void TC_XOA_01() {
		setAdmin();
		String maKhachHang = "KH040";
		String result = khachhang.Xoa_Test(maKhachHang);
		Assert.assertEquals(result, "Xóa thành công!");

	}

	@Test(description = "Xóa khách hàng thất bại với quyền của người dùng")
	public void TC_XOA_02() {
		setUser();
		String maKH = "KH002";

		String result = khachhang.Xoa_Test(maKH);

		Assert.assertEquals(result, "Bạn không có quyền xóa khách hàng");
	}

	@Test(description = "Xóa khách hàng với mã rỗng")
	public void TC_XOA_03() {
		setAdmin();
		String maKH = "";

		String result = khachhang.Xoa_Test(maKH);

		Assert.assertEquals(result, "Mã khách hàng rỗng");
	}

	@Test(description = "Xóa khách hàng với mã không tồn tại")
	public void TC_XOA_04() {
		setAdmin();
		String maKH = "123123";

		String result = khachhang.Xoa_Test(maKH);

		Assert.assertEquals(result, "Mã khách hàng không tồn tại");
	}

}
