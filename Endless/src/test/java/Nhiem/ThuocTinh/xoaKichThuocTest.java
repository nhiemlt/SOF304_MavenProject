package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.NhanVien;
import util.Auth;
import view.ThuocTinh;

public class xoaKichThuocTest {

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
	
	ThuocTinh form = new ThuocTinh();

	@Test(description = "Xóa kích thước thành công với quyền của người quản lý")
	public void TC_XKT_01() {
		setAdmin();
		String maKichThuoc = "KT001"; // Mã kích thước tồn tại
		String result = form.XoaKichThuoc_Test(maKichThuoc);
		Assert.assertEquals(result, "Xóa thành công!");
	}

	@Test(description = "Xóa kích thước thất bại do người dùng không có quyền")
	public void TC_XKT_02() {
		setUser();
		String maKichThuoc = "KT001"; // Mã kích thước tồn tại
		String result = form.XoaKichThuoc_Test(maKichThuoc);
		Assert.assertEquals(result, "Bạn không có quyền xóa thuộc tính kích thước !");
	}

	@Test(description = "Xóa kích thước thất bại do mã kích thước rỗng")
	public void TC_XKT_03() {
		setAdmin();
		String maKichThuoc = ""; // Mã kích thước rỗng
		String result = form.XoaKichThuoc_Test(maKichThuoc);
		Assert.assertEquals(result, "Lỗi mã màu rỗng");
	}

	@Test(description = "Xóa kích thước thất bại do mã kích thước không tồn tại")
	public void TC_XKT_04() {
		setAdmin();
		String maKichThuoc = "KT999"; // Mã kích thước không tồn tại
		String result = form.XoaKichThuoc_Test(maKichThuoc);
		Assert.assertEquals(result, "Mã kích thước không tồn tại");
	}

}
