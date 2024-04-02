package Nhiem.SanPham;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import view.SanPham;

public class CapNhapTest {
    SanPham form = new SanPham();

    @Test
    public void TC_CAPNHAT_01() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP001"); 
	    sp.setTenSP("Giày thể thao Adidas Ultraboost");
	    sp.setMaLoaiGiay("LG001");
	    sp.setMaVach("00000"+Math.round(Math.random()*100));
	    sp.setDonGiaNhap(900000.00);
	    sp.setDonGiaBan(1100000.00);
	    sp.setGiaKhuyenMai(0.00);
	    sp.setHinhAnh("Sneaker1.jpg");

        form.CapNhat_Test(sp);
    }

    @Test
    public void TC_CAPNHAT_02() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP088"); 
	    sp.setTenSP("Giày thể thao Adidas Ultraboost");
	    sp.setMaLoaiGiay("LG001");
	    sp.setMaVach("00000"+Math.round(Math.random()*100));
	    sp.setDonGiaNhap(900000.00);
	    sp.setDonGiaBan(1100000.00);
	    sp.setGiaKhuyenMai(0.00);
	    sp.setHinhAnh("Sneaker1.jpg");

        try {
        	form.CapNhat_Test(sp);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("Cập nhật thất bại!" + e);
        }
    }

    @Test
    public void TC_CAPNHAT_03() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP088"); 
        sp.setTenSP("");

        try {
        	form.CapNhat_Test(sp);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("Cập nhật thất bại!" + e);
        }
    }

    @Test
    public void TC_CAPNHAT_04() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP004"); 
        sp.setTenSP("Giày đá banh");
        sp.setMaLoaiGiay("LG002");
        sp.setMaVach("00000"+Math.round(Math.random()*100));
        sp.setDonGiaNhap(800000.00);
        sp.setDonGiaBan(1000000.00);
        sp.setGiaKhuyenMai(200000.00); 
        sp.setHinhAnh("Sneaker4.jpg");

        try {
            form.CapNhat_Test(sp);
            assertTrue(false); 
        } catch (Exception e) {
            System.out.println("Cập nhật thất bại!" + e);
        }
    }

    @Test
    public void TC_CAPNHAT_05() {
        model.SanPham sp = new model.SanPham();
        sp.setMaSP("SP005"); 
        sp.setTenSP("Giày tập luyện đa năng");
        sp.setMaLoaiGiay("LG003");
        sp.setMaVach("00000"+Math.round(Math.random()*100));
        sp.setDonGiaNhap(700000.00);
        sp.setDonGiaBan(900000.00);
        sp.setGiaKhuyenMai(0.00);
        sp.setHinhAnh("Sneaker5_new.jpg");

        try {
            form.CapNhat_Test(sp);
            assertTrue(true); 
        } catch (Exception e) {
            System.out.println("Cập nhật thất bại!" + e);
        }
    }
}
