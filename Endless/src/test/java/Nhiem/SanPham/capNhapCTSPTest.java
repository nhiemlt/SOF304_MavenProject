package Nhiem.SanPham;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import view.SanPham;

public class capNhapCTSPTest {

	SanPham form = new SanPham();
	
	@Test
	public void TC_CAPNHATCTSP_01() {
	    model.ChiTietSanPham ctsp = new model.ChiTietSanPham();
	    ctsp.setMaCTSP("SP0001-1");
	    ctsp.setMaSP("SP001");
	    ctsp.setMaMau("MS001");
	    ctsp.setMaKT("KT001");
	    ctsp.setSoLuong(150);

	    try {
	        form.CapNhatCTSP_Test(ctsp);
	    } catch (Exception e) {
	        System.out.println("Cập nhật chi tiết sản phẩm thất bại: " + e.getMessage());
	    }
	}

	@Test
	public void TC_CAPNHATCTSP_02() {
	    model.ChiTietSanPham ctsp = new model.ChiTietSanPham();
	    ctsp.setMaCTSP("SP0002-1");
	    ctsp.setMaSP("SP002");
	    ctsp.setMaMau("MS001");
	    ctsp.setMaKT("KT002");
	    ctsp.setSoLuong(-50);

	    try {
	        form.CapNhatCTSP_Test(ctsp);
	        assertFalse(true);
	    } catch (Exception e) {
	        System.out.println("Cập nhật chi tiết sản phẩm thất bại: " + e.getMessage());
	    }
	}

	@Test
	public void TC_CAPNHATCTSP_03() {
	    model.ChiTietSanPham ctsp = new model.ChiTietSanPham();
	    ctsp.setMaCTSP("SP0003-1");
	    ctsp.setMaSP(null);
	    ctsp.setMaMau("MS001");
	    ctsp.setMaKT("KT003");
	    ctsp.setSoLuong(100);

	    try {
	        form.CapNhatCTSP_Test(ctsp);
	        assertFalse(true);
	    } catch (Exception e) {
	        System.out.println("Cập nhật chi tiết sản phẩm thất bại: " + e.getMessage());
	    }
	}

	@Test
	public void TC_CAPNHATCTSP_04() {
	    model.ChiTietSanPham ctsp = new model.ChiTietSanPham();
	    ctsp.setMaCTSP("SP0004-1");
	    ctsp.setMaSP("SP006");
	    ctsp.setMaMau("MS001");
	    ctsp.setMaKT("KT004");
	    ctsp.setSoLuong(200);

	    try {
	        form.CapNhatCTSP_Test(ctsp);
	    } catch (Exception e) {
	        System.out.println("Cập nhật chi tiết sản phẩm thất bại: " + e.getMessage());
	    }
	}

	@Test
	public void TC_CAPNHATCTSP_05() {
	    model.ChiTietSanPham ctsp = new model.ChiTietSanPham();
	    ctsp.setMaCTSP("SP0005-1");
	    ctsp.setMaSP("SP010");
	    ctsp.setMaMau("MS001");
	    ctsp.setMaKT("KT005");
	    ctsp.setSoLuong(100);
	    ctsp.setMaCTSP("Mới");

	    try {
	        form.CapNhatCTSP_Test(ctsp);
	        assertTrue(true);
	    } catch (Exception e) {
	        System.out.println("Cập nhật chi tiết sản phẩm thất bại: " + e.getMessage());
	        assertFalse(true);
	    }
	}


}
