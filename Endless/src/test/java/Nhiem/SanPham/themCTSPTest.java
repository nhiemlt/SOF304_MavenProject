package Nhiem.SanPham;

import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ChiTietSanPham;
import view.SanPham;

public class themCTSPTest {
	SanPham form = new SanPham();
	 @Test
	    public void TC_THEMCTSP_01() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "pass";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_02() {
	        String maSP = "";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi bỏ trống mã SP";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_03() {
	        String maSP = "SP999";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP999");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi sản phẩm không tồn tại";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_04() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi bỏ trống mã màu";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_05() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("MS999");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi mã màu không tồn tại";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_06() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi bỏ trống mã kích thước";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_07() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("KT999");
	        ctsp.setSoLuong(100);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi mã kích thước không tồn tại";
	        Assert.assertEquals(result, expectedResult);
	    }

	    @Test
	    public void TC_THEMCTSP_08() {
	        String maSP = "SP001";
	        ChiTietSanPham ctsp = new ChiTietSanPham();
	        ctsp.setMaSP("SP001");
	        ctsp.setMaMau("MS006");
	        ctsp.setMaKT("KT011");
	        ctsp.setSoLuong(0);
	        String result = form.ThemCTSP_Test(ctsp);
	        String expectedResult = "Lỗi số lượng <0 ";
	        Assert.assertEquals(result, expectedResult);
	    }

}
