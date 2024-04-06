package Nhiem.SanPham;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ChiTietSanPham;

public class capNhapCTSPTest {

	view.SanPham form = new view.SanPham();
	

    @Test(description = "Cập nhật thành công")
    public void TC_CAPNHATCTSP_01() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setMaSP("SP006");
        ctsp.setMaMau("MS014");
        ctsp.setMaKT("KT001");
        ctsp.setSoLuong(120);
        ctsp.setMoTa("Size 30 - Màu tím trắng");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Cập nhật thành công";
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test(description = "Cập nhật với dữ liệu trống")
    public void TC_CAPNHATCTSP_02() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        // Không thiết lập giá trị cho ctsp ở đây để gây ra lỗi "Lỗi nhập thiếu dữ liệu"
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String notExpectedResult = "Cập nhật thành công!";
        Assert.assertNotEquals(actualResult, notExpectedResult);
    }

    @Test(description = "Cập nhật khi sản phẩm không tồn tại")
    public void TC_CAPNHATCTSP_03() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaSP("SP999");
        ctsp.setMaMau("MS010");
        ctsp.setMaKT("KT005");
        ctsp.setSoLuong(90);
        ctsp.setMoTa("Size 34 - Màu nâu");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi sản phẩm không tồn tại";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với dữ liệu chứa ký tự đặc biệt")
    public void TC_CAPNHATCTSP_04() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setMaSP("SP009");
        ctsp.setMaMau("MS013");
        ctsp.setMaKT("KT007");
        ctsp.setSoLuong(210);
        ctsp.setMoTa("Size 38 - Màu đỏ đậm @");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Cập nhật thành công";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với số lượng bằng 0")
    public void TC_CAPNHATCTSP_05() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setSoLuong(0);
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi số lượng <0";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với số lượng lớn hơn 0")
    public void TC_CAPNHATCTSP_06() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setSoLuong(500);
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Cập nhật thành công";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã sản phẩm rỗng")
    public void TC_CAPNHATCTSP_7() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setMaSP("");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi bỏ trống mã SP";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với số lượng âm")
    public void TC_CAPNHATCTSP_8() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setSoLuong(-10);
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi số lượng <0";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã màu rỗng")
    public void TC_CAPNHATCTSP_9() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0001-1");
        ctsp.setMaMau("");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi bỏ trống mã màu";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã kích thước rỗng")
    public void TC_CAPNHATCTSP_10() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0004-1");
        ctsp.setMaKT("");
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Lỗi bỏ trống mã kích thước";
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test(description = "Cập nhật với mô tả null")
    public void TC_CAPNHATCTSP_11() {
        ChiTietSanPham ctsp = new util.ChiTietSanPhamDAO().selectById("SP0004-1");
        ctsp.setMoTa(null);
        String actualResult = form.CapNhatCTSP_Test(ctsp);
        String expectedResult = "Cập nhật thành công";
        Assert.assertEquals(actualResult, expectedResult);
    }

}
