package Nhiem.SanPham;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.SanPham;


public class themTest {

    SanPham form = new SanPham();

    @Test(description = "Thêm sản phẩm mới thành công")
    public void TC_THEMSP_01() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP001");
        sp.setTenSP("Giày thể thao");
        sp.setMaLoaiGiay("LG001");
        sp.setMaVach("100001");
        sp.setDonGiaNhap(900000);
        sp.setDonGiaBan(1100000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("Sneaker1.jpg");
        String expectedResult = "PASS";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với mã sản phẩm trùng")
    public void TC_THEMSP_02() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP003");
        sp.setMaLoaiGiay("LG003");
        sp.setMaVach("000003");
        sp.setDonGiaNhap(700000);
        sp.setDonGiaBan(1000000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("BasketballShoes1.jpg");
        String expectedResult = "Lỗi nhập thiếu dữ liệu";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với dữ liệu thiếu")
    public void TC_THEMSP_03() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP005");
        sp.setTenSP("Giày tập luyện đa năng");
        sp.setMaLoaiGiay("LG007");
        sp.setMaVach("000004");
        sp.setDonGiaNhap(0);
        sp.setDonGiaBan(600000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("CrossTrainingShoes2.jpg");
        String expectedResult = "Lỗi giá nhập <=0";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với giá nhập và giá bán là 0")
    public void TC_THEMSP_04() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP006");
        sp.setTenSP("Giày golf");
        sp.setMaLoaiGiay("LG009");
        sp.setMaVach("000005");
        sp.setDonGiaNhap(0);
        sp.setDonGiaBan(0);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("GolfShoes2.jpg");
        String expectedResult = "Lỗi giá nhập <=0Lỗi giá bán <=0";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với giá bán nhỏ hơn giá nhập")
    public void TC_THEMSP_05() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP007");
        sp.setTenSP("Giày trượt patin");
        sp.setMaLoaiGiay("LG008");
        sp.setMaVach("000009");
        sp.setDonGiaNhap(600000);
        sp.setDonGiaBan(400000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("SkateShoes3.jpg");
        String expectedResult = "Lỗi giá bán nhỏ hơn giá nhập";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với tên sản phẩm chứa số")
    public void TC_THEMSP_06() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP008");
        sp.setTenSP("123 Giày");
        sp.setMaLoaiGiay("LG001");
        sp.setMaVach("000010");
        sp.setDonGiaNhap(800000);
        sp.setDonGiaBan(1000000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("TrailRunningShoes2.jpg");
        String expectedResult = "Tên sản phẩm không được chứa số";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với mã vạch chứa ký tự đặc biệt")
    public void TC_THEMSP_07() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP009");
        sp.setTenSP("Giày đấu vật");
        sp.setMaLoaiGiay("LG012");
        sp.setMaVach("@@001");
        sp.setDonGiaNhap(300000);
        sp.setDonGiaBan(500000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("WrestlingShoes1.jpg");
        String expectedResult = "Mã vạch không được chứa ký tự đặc biệt và chữ cái";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với mã khuyến mãi không tồn tại")
    public void TC_THEMSP_08() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP010");
        sp.setMaKM("KM006");
        sp.setTenSP("Giày leo núi");
        sp.setMaLoaiGiay("LG010");
        sp.setMaVach("000011");
        sp.setDonGiaNhap(300000);
        sp.setDonGiaBan(500000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("HikingShoes1.jpg");
        String expectedResult = "Lỗi mã KM không tồn tại";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Thêm sản phẩm với mã loại giày không tồn tại")
    public void TC_THEMSP_09() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP011");
        sp.setTenSP("Giày tennis");
        sp.setMaLoaiGiay("LG020");
        sp.setMaVach("000012");
        sp.setDonGiaNhap(400000);
        sp.setDonGiaBan(600000);
        sp.setGiaKhuyenMai(0);
        sp.setHinhAnh("TennisShoes1.jpg");
        String expectedResult = "Lỗi mã LG không tồn tại";
        String actualResult = form.Them_Test(sp);
        Assert.assertEquals(actualResult, expectedResult);
    } 
}