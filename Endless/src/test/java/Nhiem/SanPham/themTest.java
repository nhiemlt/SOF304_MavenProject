package Nhiem.SanPham;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.SanPham;

public class themTest {

	SanPham form = new SanPham();
	@Test
	public void TC_THEM_01() {
	    model.SanPham sp = new model.SanPham();
	    
	    sp.setMaSP(form.taoMaSP()); 
	    sp.setTenSP("Giày thể thao Adidas Ultraboost");
	    sp.setMaLoaiGiay("LG001");
	    sp.setMaVach("00000"+Math.round(Math.random()*100));
	    sp.setDonGiaNhap(900000.00);
	    sp.setDonGiaBan(1100000.00);
	    sp.setGiaKhuyenMai(0.00);
	    sp.setHinhAnh("Sneaker1.jpg");
	    
	    try {
	        form.Them_Test(sp);
	    } catch (Exception e) {
	        e.printStackTrace();
	       
	    }
	}

	@Test
	public void TC_THEM_02() {
	    model.SanPham sp = new model.SanPham();
	    sp.setMaSP("SP002");
	    sp.setTenSP("Giày thể thao Nike Air Max");
	    sp.setMaLoaiGiay("LG002");
	    sp.setMaVach(null);
	    sp.setDonGiaNhap(800000.00);
	    sp.setDonGiaBan(1000000.00);
	    sp.setGiaKhuyenMai(0.00);
	    sp.setHinhAnh("Sneaker2.jpg");

	    try {
	        form.Them_Test(sp);
	        assertTrue(false);
	    } catch (Exception e) {
	    	System.out.println("Them that bai!"+e);
	    }
	}

	@Test
	public void TC_THEM_03() {
	    model.SanPham sp = new model.SanPham();
	    sp.setMaSP("");
	    sp.setMaLoaiGiay("LG003");

	    try {
	        form.Them_Test(sp);
	        assertTrue(false);
	    } catch (Exception e) {
	    	System.out.println("Them that bai!"+e);
	    }
	}

}
