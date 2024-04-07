package Nguyen.NhanVien;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Encode;
import view.NhanVien;

public class updateTest {

	view.NhanVien form = new NhanVien();
	Encode en = new Encode();
	 // Test case kiểm tra khi thông tin nhân viên hợp lệ
    @Test(description = "Kiểm tra khi thông tin nhân viên hợp lệ")
    public void TC_UPDATE_01() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        nv.setTenNV("Vo Thi Thao Nguyen");
        nv.setMatKhau("A12345aA@");
        nv.setEmail("nguyenvttpc05404@fpt.edu.vn");
        String expectedResult = "Cập nhật thành công";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

 // Test case kiểm tra khi không nhập tên nhân viên
    @Test(description = "Kiểm tra khi không nhập tên nhân viên")
    public void TC_UPDATE_02() {
    	model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Bỏ qua việc thiết lập tên nhân viên để kiểm tra lỗi
        nv.setTenNV("");
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi để trống tên nhân viên";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }
    
 // Test case kiểm tra khi tên nhân viên không hợp lệ
    @Test(description = "Kiểm tra khi tên nhân viên không hợp lệ")
    public void TC_UPDATE_03() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Thiết lập tên nhân viên không hợp lệ (chứa ký tự đặc biệt)
        nv.setTenNV("Nguyễn Văn !@#$%");
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi sai định dạng tên nhân viên";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra khi email không hợp lệ
    @Test(description = "Kiểm tra khi email không hợp lệ")
    public void TC_UPDATE_04() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Đặt email không hợp lệ
        nv.setEmail("invalid.email");
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi sai định dạng email";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }
    

    // Test case kiểm tra khi ngày sinh dưới 18 tuổi
    @Test(description = "Kiểm tra khi ngày sinh dưới 18 tuổi")
    public void TC_UPDATE_05() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Đặt ngày sinh dưới 18 tuổi
        nv.setNgaySinh(java.sql.Date.valueOf("2010-05-03"));
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi ngày sinh dưới 18 tuổi";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra khi số điện thoại trống
    @Test(description = "Kiểm tra khi số điện thoại trống")
    public void TC_UPDATE_06() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Đặt số điện thoại trống
        nv.setSDT("");
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi để trống SDT";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra khi tài khoản không hợp lệ
    @Test(description = "Kiểm tra khi tài khoản không hợp lệ")
    public void TC_UPDATE_07() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Đặt tài khoản không hợp lệ
        nv.setMaTK("invalid_account!");
        nv.setMatKhau("A12345aA@");
        String expectedResult = "Lỗi nhập sai định dạng tài khoản";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Test case kiểm tra khi mật khẩu không hợp lệ
    @Test(description = "Kiểm tra khi mật khẩu không hợp lệ")
    public void TC_UPDATE_08() {
        model.NhanVien nv = new util.NhanVienDAO().selectById("NV002");
        // Đặt mật khẩu không hợp lệ
        nv.setMatKhau("weakpassword");
        String expectedResult = "Lỗi nhập sai định dạng mật khẩu";
        String actualResult = form.Update_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
