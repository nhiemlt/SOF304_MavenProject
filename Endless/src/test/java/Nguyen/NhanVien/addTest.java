package Nguyen.NhanVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.NhanVien;

public class addTest {
	
	view.NhanVien form = new view.NhanVien();
	
	@Test(description = "Kiểm tra khi thông tin nhân viên hợp lệ")
    public void TC_ADD_NV_01() {
        model.NhanVien nv = new model.NhanVien();
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("nguyenTeo111@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonvv0902");
        nv.setMatKhau("Tteo1^?%%4@*");
     // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000"); // Thay thế bằng ngày sinh thực tế của bạn
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);
        nv.setSDT("0933368187");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        String expectedResult = "pass";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, expectedResult);
    }
	
	@Test(description = "Kiểm tra khi không nhập tên nhân viên")
    public void TC_ADD_NV_02() {
        model.NhanVien nv = new model.NhanVien();
        nv.setTenNV(""); // Tên rỗng
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv123@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv123");
        nv.setMatKhau("Tteo1234@^");
        nv.setSDT("0939028299");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi để trống tên nhân viên");
    }
	
	@Test(description ="Kiểm tra khi nhập sai định dạng tên nhân viên")
    public void TC_ADD_NV_03() {
        model.NhanVien nv = new model.NhanVien();
        nv.setTenNV("nguyen văn 35&&"); // Tên rỗng
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv123@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv123");
        nv.setMatKhau("Tteo1234@^");
        nv.setSDT("0939028299");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi sai định dạng tên nhân viên");
    }

    @Test(description = "Kiểm tra khi ngày sinh dưới 18 tuổi")
    public void TC_ADD_NV_04() {
        model.NhanVien nv = new model.NhanVien();
        // Thiết lập ngày sinh dưới 18 tuổi
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2014"); // Dưới 18 tuổi
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv12273@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv111123");
        nv.setMatKhau("Tteo12&4@^");
        nv.setSDT("0939028729");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi ngày sinh dưới 18 tuổi");
    }
    
    @Test(description = "Kiểm tra khi để trống ngày sinh")
    public void TC_ADD_NV_05() {
        model.NhanVien nv = new model.NhanVien();
        Date ngaySinhDate = null;
        nv.setNgaySinh(ngaySinhDate);
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv123@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv123");
        nv.setMatKhau("Tteo1234@^");
        nv.setSDT("0939028299");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi để trống ngày sinh");
    }
       
    @Test(description = "Kiểm tra khi trống số điện thoại")
    public void TC_ADD_NV_06() {
        model.NhanVien nv = new model.NhanVien();
        nv.setSDT(""); // Số điện thoại trống
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv123@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv123");
        nv.setMatKhau("Tteo1234@^");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi để trống SDT");
    }

    @Test(description = "kiểm tra nhập sai định dạng số điện thoại")
    public void TC_ADD_NV_07() {
        model.NhanVien nv = new model.NhanVien();
        nv.setSDT("72810^^abc"); // Số điện thoại không hợp lệ
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv18193@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv12770");
        nv.setMatKhau("Tteo3%4(*$^");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi sai định dạng SDT");
    }
    
    @Test(description = "Kiểm tra khi nhập sai định dạng email")
    public void TC_ADD_NV_08() {
        model.NhanVien nv = new model.NhanVien();

        // Thiết lập thông tin nhân viên không có email
        nv.setEmail("checkemail");

        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv1873");
        nv.setMatKhau("Tteo8#94@^");
        nv.setSDT("0919193802");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        // Kiểm tra khi không có email
        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi sai định dạng email");
    }

    @Test(description = "Kiểm tra khi để trống email")
    public void TC_ADD_NV_09() {
        model.NhanVien nv = new model.NhanVien();
        // Thiết lập thông tin nhân viên với email sai định dạng
        nv.setEmail("");
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonv113");
        nv.setMatKhau("Tteo1^*4@^");
        nv.setSDT("0939888299");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        // Kiểm tra khi nhập sai định dạng email
        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi để trống email");
    }
    
    @Test(description = "Kiểm tra khi để trống tài khoản")
    public void TC_ADD_NV_10() {
        model.NhanVien nv = new model.NhanVien();
        nv.setMaTK(""); // Tài khoản trống
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv123@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMatKhau("Tteo1234@^");
        nv.setSDT("0939028299");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertNotEquals(actualResult, "pass");
        Assert.assertTrue(actualResult.contains("trống tài khoản"));
    }
    
    @Test(description = "Kiểm tra khi nhập sai định dạng tài khoản")
    public void TC_ADD_NV_11() {
        model.NhanVien nv = new model.NhanVien();
        nv.setMaTK("invalid...account"); // Tài khoản không hợp lệ
        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonvv924@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMatKhau("Tteot13&4@^");
        nv.setSDT("0919781800");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi nhập sai định dạng tài khoản");
    }

    @Test(description = "Kiểm tra nhập sai định dạng mật khẩu")
    public void TC_ADD_NV_12() {
        model.NhanVien nv = new model.NhanVien();
        nv.setMatKhau("weakpassword1561"); // Mật khẩu yếu

        // Thiết lập các thông tin khác
        nv.setDiaChi("Cần Thơ");
        nv.setEmail("teonv12553@gmail.com");
        nv.setGioiTinh(true);
        nv.setHinh("anhteo.png");
        nv.setMaNV(form.taoMaNV());
        nv.setMaTK("Teonvv12381");
        nv.setSDT("0939178229");
        nv.setTenNV("Nguyễn Văn Tèo");
        nv.setVaiTro(false);
        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinhDate = null;
        try {
            ngaySinhDate = dateFormat.parse("10/03/2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nv.setNgaySinh(ngaySinhDate);

        // Kiểm tra mật khẩu không hợp lệ
        String expectedResult = "fail";
        String actualResult = form.Add_Test(nv);
        Assert.assertEquals(actualResult, "Lỗi nhập sai định dạng mật khẩu");
    }

}
