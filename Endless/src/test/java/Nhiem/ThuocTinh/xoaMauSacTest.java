package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.NhanVien;
import util.Auth;
import view.ThuocTinh;

public class xoaMauSacTest {
	
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

	@Test(description = "Xóa màu sắc thành công với quyền của người quản lý")
	public void TC_XMS_01() {
		setAdmin();
		String maMauSac = "MS001"; // Mã màu sắc tồn tại
		String result = form.XoaMauSac_Test(maMauSac);
		Assert.assertEquals(result, "Xóa thành công!");
	}

	@Test(description = "Xóa màu sắc thất bại do người dùng không có quyền")
	public void TC_XMS_02() {
		setUser();
		String maMauSac = "MS001"; // Mã màu sắc tồn tại
		String result = form.XoaMauSac_Test(maMauSac);
		Assert.assertEquals(result, "Bạn không có quyền xóa thuộc tính màu sắc !");
	}

	@Test(description = "Xóa màu sắc thất bại do mã màu sắc rỗng")
	public void TC_XMS_03() {
		setAdmin();
		String maMauSac = ""; // Mã màu sắc rỗng
		String result = form.XoaMauSac_Test(maMauSac);
		Assert.assertEquals(result, "Lỗi mã màu rỗng");
	}

	@Test(description = "Xóa màu sắc thất bại do mã màu sắc không tồn tại")
	public void TC_XMS_04() {
		setAdmin();
		String maMauSac = "MS999"; // Mã màu sắc không tồn tại
		String result = form.XoaMauSac_Test(maMauSac);
		Assert.assertEquals(result, "Mã màu không tồn tại");
	}

}
