package Nguyen.NhaCungCap;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.NhaCungCapDAO;
import view.NhaCungCap;

public class capNhatTest {
	
	NhaCungCapDAO nccDAO = new NhaCungCapDAO();
	
	view.NhaCungCap form = new NhaCungCap();
	// Test case kiểm tra lỗi khi tên nhà cung cấp trống
    @Test
    public void TC_CAPNHAT_01() {
        model.NhaCungCap ncc = nccDAO.selectByID("NCC30");
        ncc.setTenNCC("");
        String expectedResult = "Lỗi để trống tên nhà cung cấp";
        String actualResult = form.KiemLoi_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra lỗi khi tên nhà cung cấp chứa ký tự đặc biệt
    @Test
    public void TC_CAPNHAT_02() {
        model.NhaCungCap ncc = nccDAO.selectByID("NCC30");
        ncc.setTenNCC("Nhà cung cấp A!");
        String expectedResult = "Lỗi tên nhà cung cấp chứa kí tự";
        String actualResult = form.KiemLoi_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra lỗi khi SDT không đúng định dạng
    @Test
    public void TC_CAPNHAT_03() {
        model.NhaCungCap ncc = nccDAO.selectByID("NCC30");
        ncc.setSDT("12345");
        String expectedResult = "Lỗi sai định dạng SDT";
        String actualResult =  form.KiemLoi_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra cập nhật thành công khi không có lỗi
    @Test
    public void TC_CAPNHAT_04() {
        model.NhaCungCap ncc = nccDAO.selectByID("NCC30");
        ncc.setTenNCC("Nhà cung cấp A");
        ncc.setSDT("0122334455");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Cập nhật thành công";
        String actualResult = form.CapNhat_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra lỗi khi cập nhật không thành công
    @Test
    public void TC_CAPNHAT_05() {
        model.NhaCungCap ncc = nccDAO.selectByID("NCC30");
        ncc.setTenNCC("");
        String actualResult = form.CapNhat_Test(ncc);
        String expectedResult = "Lỗi để trống tên nhà cung cấp";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
