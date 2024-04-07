package Nguyen.NhaCungCap;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class taoMaNCCTest {
	
	view.NhaCungCap form = new view.NhaCungCap();
	
	@Test(description = "Kiểm tra khi không có nhà cung cấp nào trong cơ sở dữ liệu")
    public void TC_TAO_MA_NV_01() {
        List<model.NhaCungCap> emptyList = new ArrayList<>();
        String expectedResult = "NCC001";
        String actualResult = form.taoMaNCC_Test(emptyList);
        Assert.assertEquals(actualResult, expectedResult);
    }
	
    @Test(description = "Kiểm tra khi danh sách không rỗng")
    public void TC_TAO_MA_NCC_02() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC001");
        list.add(ncc);
        String expectedResult = "NCC002";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng đủ 3 ký tự")
    public void TC_TAO_MA_NCC_03() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC999");
        list.add(ncc);
        String expectedResult = "NCC1000";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng thiếu 1 ký tự")
    public void TC_TAO_MA_NCC_04() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC999");
        list.add(ncc);
        String expectedResult = "NCC1000";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng thiếu 2 ký tự")
    public void TC_TAO_MA_NCC_05() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC99");
        list.add(ncc);
        String expectedResult = "NCC100";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng là số thứ tự lớn nhất")
    public void TC_TAO_MA_NCC_06() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC030");
        list.add(ncc);
        String expectedResult = "NCC031";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng là số thứ tự lớn nhất và bắt đầu bằng 0")
    public void TC_TAO_MA_NCC_07() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC099");
        list.add(ncc);
        String expectedResult = "NCC100";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã nhà cung cấp chứa ký tự đặc biệt")
    public void TC_TAO_MA_NCC_08() {
    	String maNCC = "NCC~~%@";
        List<model.NhaCungCap> list = new ArrayList<>();
        String expectedResult = "NCC001";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã nhà cung cấp cuối cùng không hợp lệ")
    public void TC_TAO_MA_NCC_09() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("NCC999");
        list.add(ncc);
        String expectedResult = "NCC1000";
        String actualResult = form.taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test(description = "Kiểm tra khi mã của nhà cung cấp cuối cùng đạt đến giới hạn")
    public void TC_TAO_MA_NCC_10() {
        List<model.NhaCungCap> list = new ArrayList<>();
        // Tạo danh sách nhà cung cấp đến giới hạn
        for (int i = 1; i <= 999; i++) {
        	model.NhaCungCap ncc = new model.NhaCungCap();
        	ncc.setMaNCC(new view.NhaCungCap().taoMaNCC_Test(list));
        	list.add(ncc);
        }
        // Tính toán kỳ vọng
        String expectedResult = "NCC1000";
        // Gọi phương thức và lấy kết quả thực tế
        String actualResult = form.taoMaNCC_Test(list);
        // So sánh kết quả
        Assert.assertEquals(actualResult, expectedResult);
    }
    
    @Test(description = "Kiểm tra khi sử dụng số âm làm ID")
    public void TC_TAO_MA_NCC_11() {
        List<model.NhaCungCap> list = new ArrayList<>();
        model.NhaCungCap ncc = new model.NhaCungCap();
        ncc.setMaNCC("-100");
        list.add(ncc);
        String expectedResult = "NCC001";
        String actualResult = new view.NhaCungCap().taoMaNCC_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
