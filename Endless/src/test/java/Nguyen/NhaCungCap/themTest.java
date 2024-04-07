package Nguyen.NhaCungCap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class themTest {
	
	@Test(description = "Kiểm tra khi thêm nhà cung cấp thành công")
    public void TC_THEM_01() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nguyễn Văn Mi");
        ncc.setSDT("0157456786");
        ncc.setDiaChi("123 Đường Z, Q1, TP.HCM");
        ncc.setEmail("an113gg1@gmail.com");
        String expectedResult = "Thêm thành công!";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi thiếu thông tin tên nhà cung cấp")
    public void TC_THEM_02() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setSDT("0123456789");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Lỗi để trống tên nhà cung cấp";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi thiếu thông tin: Số điện thoại")
    public void TC_THEM_03() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp A");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Lỗi để trống SDT";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi thiếu thông tin địa chỉ")
    public void TC_THEM_04() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp A");
        ncc.setSDT("0123456789");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Lỗi để trống địa chỉ";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi tên nhà cung cấp chứa ký tự đặc biệt")
    public void TC_THEM_05() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp A!");
        ncc.setSDT("0123456789");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Lỗi tên nhà cung cấp chứa kí tự";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi SDT không đúng định dạng")
    public void TC_THEM_06() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp F");
        ncc.setSDT("12345"); // SDT không đúng định dạng
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("an111@gmail.com");
        String expectedResult = "Lỗi sai định dạng SDT";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test(description = "Kiểm tra khi để trống email")
    public void TC_THEM_07() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp F");
        ncc.setSDT("0123456789");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("");
        String expectedResult = "Lỗi để trống email";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test(description = "Kiểm tra khi email sai định dạng")
    public void TC_THEM_08() {
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setTenNCC("Nhà cung cấp A");
        ncc.setSDT("0123456789");
        ncc.setDiaChi("123 Đường XYZ, Q1, TP.HCM");
        ncc.setEmail("abc.gmail.com");
        String expectedResult = "Lỗi sai định dạng email";
        String actualResult = new view.NhaCungCap().Them_Test(ncc);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
