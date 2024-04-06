package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.KichThuoc;
import view.ThuocTinh;

public class themKichThuocTest {

	ThuocTinh form = new ThuocTinh();
	
	@Test(description = "Kiểm tra khi tên kích thước rỗng")
    public void TC_TKT_01() {
        KichThuoc kt = new KichThuoc();
        kt.setTenKichThuoc("");
        kt.setMoTa("Phù hợp cho chân có kích thước 160mm");
        String result = form.ThemKichThuoc_Test(kt);
        Assert.assertEquals(result, "Tên kích thước không được bỏ trống");
    }

    @Test(description = "Kiểm tra khi thêm kích thước mới vào cơ sở dữ liệu")
    public void TC_TKT_02() {
        KichThuoc kt = new KichThuoc();
        kt.setTenKichThuoc("30");
        kt.setMoTa("Phù hợp cho chân có kích thước 165mm");
        String result = form.ThemKichThuoc_Test(kt);
        Assert.assertEquals(result, "Thêm kích thước thành công!");
    }

    @Test(description = "Kiểm tra khi thêm kích thước đã tồn tại trong cơ sở dữ liệu")
    public void TC_TKT_03() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT001");
        kt.setTenKichThuoc("30");
        kt.setMoTa("Phù hợp cho chân có kích thước 160mm");
        String result = form.ThemKichThuoc_Test(kt);
        Assert.assertEquals(result, "Thêm kích thước thất bại!");
    }

    @Test(description = "Kiểm tra khi chiều dài kích thước âm")
    public void TC_TKT_04() {
        KichThuoc kt = new KichThuoc();
        kt.setTenKichThuoc("-30");
        kt.setMoTa("Phù hợp cho chân có kích thước 170mm");
        String result = form.ThemKichThuoc_Test(kt);
        Assert.assertEquals(result, "Thêm kích thước thất bại!");
    }

    @Test(description = "Kiểm tra khi mô tả kích thước trống")
    public void TC_TKT_05() {
        KichThuoc kt = new KichThuoc();
        kt.setTenKichThuoc("31");
        kt.setMoTa("");
        String result = form.ThemKichThuoc_Test(kt);
        Assert.assertEquals(result, "Thêm kích thước thành công!");
    }

}
