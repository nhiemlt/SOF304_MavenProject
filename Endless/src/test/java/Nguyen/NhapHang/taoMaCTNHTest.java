package Nguyen.NhapHang;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import model.NhanVien;
import util.Auth;
import util.NhanVienDAO;

public class taoMaCTNHTest {
	
	@BeforeClass
	public void setStatus() {
		NhanVien nv = new NhanVienDAO().selectById("NV001");
		Auth.user = nv;
	}
	
	@Test(description = "Kiểm tra khi danh sách là null")
    public void TC_TAO_MA_CTNH_01() {
        String maDN = "DN001";
        List<model.ChiTietNhapHang> list = null;
        String expectedResult = "DN001-1";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách là rỗng")
    public void TC_TAO_MA_CTNH_02() {
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        String maDN = "DN002";
        String expectedResult = "DN002-1";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng và chưa có dữ liệu")
    public void TC_TAO_MA_CTNH_03() {
        String maDN = "DN003";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        list.add(new model.ChiTietNhapHang());
        String expectedResult = "DN003-1";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng và đã có dữ liệu")
    public void TC_TAO_MA_CTNH_04() {
        String maDN = "DN004";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        model.ChiTietNhapHang ctnh = new model.ChiTietNhapHang();
        ctnh.setMaCTDN("DN004-1");
        list.add(ctnh);
        String expectedResult = "DN004-2";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi số thứ tự vượt quá 999")
    public void TC_TAO_MA_CTNH_05() {
        String maDN = "DN005";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        model.ChiTietNhapHang ctnh = new model.ChiTietNhapHang();
        ctnh.setMaCTDN("DN005-999");
        list.add(ctnh);
        String expectedResult = "DN005-1000";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã đơn nhập chứa ký tự đặc biệt")
    public void TC_TAO_MA_CTNH_06() {
        String maDN = "DN@#$";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        String expectedResult = "DN@#$-1";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi số thứ tự là 0")
    public void TC_TAO_MA_CTNH_07() {
        String maDN = "DN007";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        model.ChiTietNhapHang ctnh = new model.ChiTietNhapHang();
        ctnh.setMaCTDN("DN007-0");
        list.add(ctnh);
        String expectedResult = "DN007-1";
        String actualResult = new view.NhapHang().taoMaCTNH_Test(maDN, list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi số thứ tự là âm")
    public void TC_TAO_MA_CTNH_08() {
        String maDN = "DN008";
        List<model.ChiTietNhapHang> list = new ArrayList<>();
        model.ChiTietNhapHang ctnh = new model.ChiTietNhapHang();
        ctnh.setMaCTDN("DN008--1");
        list.add(ctnh);
        String expectedResult = "DN008-0";
        try {
         new view.NhapHang().taoMaCTNH_Test(maDN, list);
		} catch (Exception e) {
			expectedResult = e+"";
		}
        Assert.assertTrue(expectedResult.contains("NumberFormatException"));
    }
}
