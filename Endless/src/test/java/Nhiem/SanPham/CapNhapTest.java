package Nhiem.SanPham;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import view.SanPham;

public class CapNhapTest {
    SanPham form = new SanPham();

    @Test(description = "Cập nhật thông tin sản phẩm thành công")
    public void TC_CAPNHAT_01() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP001");
        sp.setTenSP("Giày thể thao");
        sp.setDonGiaNhap(950000);
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Cập nhật thành công";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với giá nhập <= 0")
    public void TC_CAPNHAT_02() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP002");
        sp.setDonGiaNhap(0);
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi giá nhập <=0";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với giá bán <= 0")
    public void TC_CAPNHAT_03() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP003");
        sp.setDonGiaBan(0);
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi giá bán <=0Lỗi giá bán nhỏ hơn giá nhập";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với giá bán nhỏ hơn giá nhập")
    public void TC_CAPNHAT_04() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP004");
        sp.setDonGiaNhap(500000);
        sp.setDonGiaBan(400000);
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi giá bán nhỏ hơn giá nhập";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với tên sản phẩm chứa số")
    public void TC_CAPNHAT_05() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP005");
        sp.setTenSP("Giày chạy bộ 123");
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Tên sản phẩm không được chứa số";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã vạch chứa ký tự đặc biệt và chữ cái")
    public void TC_CAPNHAT_06() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP006");
        sp.setMaVach("ABCD@123");
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Mã vạch không được chứa ký tự đặc biệt và chữ cái";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật sản phẩm không tồn tại")
    public void TC_CAPNHAT_07() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP999");
        sp.setTenSP("Giày mới");
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi sản phẩm không tồn tại";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã khuyến mãi không tồn tại")
    public void TC_CAPNHAT_08() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP007");
        sp.setMaKM("KM999");
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi mã KM không tồn tại";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với mã loại giày không tồn tại")
    public void TC_CAPNHAT_09() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP008");
        sp.setMaLoaiGiay("LG999");
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi mã LG không tồn tại";
        assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Cập nhật với thiếu dữ liệu")
    public void TC_CAPNHAT_10() {
        model.SanPham sp = new util.SanPhamDAO().selectById("SP009");
        sp.setTenSP(null);
        String actualResult = form.CapNhat_Test(sp);
        String expectedResult = "Lỗi nhập thiếu dữ liệu";
        assertEquals(actualResult, expectedResult);
    }
}
