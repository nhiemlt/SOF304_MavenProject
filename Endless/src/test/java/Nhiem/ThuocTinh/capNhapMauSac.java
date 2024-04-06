package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.MauSac;
import view.ThuocTinh;

public class capNhapMauSac {
	
	 ThuocTinh form = new ThuocTinh();

	 @Test(description = "Cập nhật màu sắc thành công")
	    public void TC_CNM_01() {
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS001");
	        ms.setTenMauSac("Đen");
	        ms.setMoTa("Màu cơ bản, tạo sự sang trọng và tinh tế.");
	        String result = form.CapNhatMauSac_Test(ms);
	        Assert.assertEquals(result, "Cập nhật màu sắc thành công");
	    }

	    @Test(description = "Cập nhật màu sắc thất bại do màu không tồn tại")
	    public void TC_CNM_02() {
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS99999");
	        ms.setTenMauSac("Màu không tồn tại");
	        ms.setMoTa("Mô tả màu không tồn tại");
	        String result = form.CapNhatMauSac_Test(ms);
	        Assert.assertEquals(result, "Mã màu không tồn tại");
	    }

	    @Test(description = "Cập nhật màu sắc thất bại do mã màu rỗng")
	    public void TC_CNM_03() {
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("");
	        ms.setTenMauSac("Trắng");
	        ms.setMoTa("Màu trung tính, phù hợp với nhiều phong cách và dễ kết hợp với các màu khác.");
	        String result = form.CapNhatMauSac_Test(ms);
	        Assert.assertEquals(result, "Cập nhật màu sắc thất bại!");
	    }

	    @Test(description = "Cập nhật màu sắc thành công với mô tả màu trống")
	    public void TC_CNM_04() {
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS001");
	        ms.setTenMauSac("Trắng");
	        ms.setMoTa("");
	        String result = form.CapNhatMauSac_Test(ms);
	        Assert.assertEquals(result, "Cập nhật màu sắc thành công");
	    }

	    @Test(description = "Cập nhật màu sắc thất bại do mô tả màu không hợp lệ")
	    public void TC_CNM_05() {
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS003");
	        ms.setTenMauSac("Đỏ");
	        ms.setMoTa(null);
	        String result = form.CapNhatMauSac_Test(ms);
	        Assert.assertEquals(result, "Cập nhật màu sắc thành công");
	    }

}
