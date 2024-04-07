package Nguyen.NhapHang;

import java.util.ArrayList;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import model.NhanVien;
import util.Auth;
import util.NhanVienDAO;



public class taoMaNHTest {
	
	@BeforeClass
	public void setStatus() {
		NhanVien nv = new NhanVien();
		nv.setVaiTro(true);
		Auth.user = nv;
	}
	
	@Test(description = "Kiểm tra khi danh sách là null")
	public void TC_TAO_MA_DN_01() {
		NhanVien nv = new NhanVienDAO().selectById("NV001");
        List<model.NhapHang> list = null;
        String expectedResult = "DN001";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách là rỗng")
    public void TC_TAO_MA_DN_02() {
        List<model.NhapHang> list = new ArrayList<>();
        String expectedResult = "DN001";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng")
    public void TC_TAO_MA_DN_03() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN100");
        list.add(nh);
        String expectedResult = "DN101";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi MaMD ngắn hơn 3 ký tự")
    public void TC_TAO_MA_DN_04() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN1");
        list.add(nh);
        String expectedResult = "DN002";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi MaMS dài hơn 5 ký tự")
    public void TC_TAO_MA_DN_05() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN10000");
        list.add(nh);
        String expectedResult = "DN10001";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
    public void TC_TAO_MA_DN_06() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN999");
        list.add(nh);
        String expectedResult = "DN1000";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
    public void TC_TAO_MA_DN_07() {
        List<model.NhapHang> list = new ArrayList<>();
        // Thêm 1000 đối tượng NhapHang với ID tuần tự

        for (int i = 0; i < 1999; i++) {
            model.NhapHang nh = new model.NhapHang();
            nh.setMaDN(new view.NhapHang().taoMaNH_Test(list));
            list.add(nh);
        }

        // Kết quả mong đợi là DN2000 (lần thứ 1001)
        String expectedResult = "DN2000";
        // Lấy ID của đối tượng cuối cùng
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaDN")
    public void TC_TAO_MA_DN_08() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN@#$");
        list.add(nh);
        String expectedResult = "";
        try {
        	new view.NhapHang().taoMaNH_Test(list);
		} catch (Exception e) {
			expectedResult = e+"";
		}
        Assert.assertTrue(expectedResult.contains("NumberFormatException"));
        
    }

    @Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
    public void TC_TAO_MA_DN_09() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("DN001");
        list.add(nh);
        String expectedResult = "DN002";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số âm làm ID")
    public void TC_TAO_MA_DN_10() {
        List<model.NhapHang> list = new ArrayList<>();
        model.NhapHang nh = new model.NhapHang();
        nh.setMaDN("-100");
        list.add(nh);
        String expectedResult = "DN001";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng danh sách lớn")
    public void TC_TAO_MA_DN_11() {
        List<model.NhapHang> list = new ArrayList<>();
        // Thêm 1000 đối tượng NhapHang với các ID tuần tự
        for (int i = 0; i < 1000; i++) {
        	model.NhapHang nh = new model.NhapHang();
            nh.setMaDN(new view.NhapHang().taoMaNH_Test(list));
            list.add(nh);
        }
        String expectedResult = "DN1001";
        String actualResult = new view.NhapHang().taoMaNH_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
