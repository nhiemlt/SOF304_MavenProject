package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.MauSac;
import view.ThuocTinh;

public class themMauSacTest {
	
	ThuocTinh form = new ThuocTinh();

	@Test(description = "Kiểm tra khi tên màu rỗng")
    public void TC_TMS_01() {
        MauSac ms = new MauSac();
        ms.setTenMauSac("");
        ms.setMoTa("Mô tả màu đen");
        String result = form.ThemMauSac_Test(ms);
        Assert.assertEquals(result, "Tên màu không được bỏ trống");
    }

    @Test(description = "Kiểm tra khi tên màu hợp lệ")
    public void TC_TMS_02() {
        MauSac ms = new MauSac();
        ms.setTenMauSac("Xám");
        ms.setMoTa("Mô tả màu xám");
        String result = form.ThemMauSac_Test(ms);
        Assert.assertEquals(result, "Thêm màu sắc thành công!");
    }

    @Test(description = "Kiểm tra khi gặp lỗi khi thêm màu vào cơ sở dữ liệu")
    public void TC_TMS_03() {
        MauSac ms = new MauSac();
        ms.setMaMauSac("MS001");
        ms.setTenMauSac("Đen");
        ms.setMoTa("Mô tả màu đen");
        String result = form.ThemMauSac_Test(ms);
        Assert.assertEquals(result, "Thêm màu sắc thất bại!");
    }

    @Test(description = "Kiểm tra khi thêm màu mới thành công vào cơ sở dữ liệu")
    public void TC_TMS_04() {
        MauSac ms = new MauSac();
        ms.setTenMauSac("Xám");
        ms.setMoTa("Mô tả màu xám");
        String result = form.ThemMauSac_Test(ms);
        Assert.assertEquals(result, "Thêm màu sắc thành công!");
    }

}
