package Nguyen.NhanVien;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class taoMaNVTest {
	
	view.NhanVien form = new view.NhanVien();
	
	@Test(description = "Kiểm tra khi không có nhân viên nào trong cơ sở dữ liệu")
    public void TC_TAO_MA_NV_01() {
        List<model.NhanVien> emptyList = new ArrayList<>();
        String expectedResult = "NV001";
        String actualResult = form.taoMaNV_Test(emptyList);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi có nhân viên trong cơ sở dữ liệu")
    public void TC_TAO_MA_NV_02() {
        List<model.NhanVien> list = new ArrayList<>();
        model.NhanVien nVien = new NhanVien();
        nVien.setMaNV("NV004");
        list.add(nVien);
        String expectedResult = "NV005";
        String actualResult = form.taoMaNV_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã NV đạt đến giới hạn")
    public void TC_TAO_MA_NV_03() {
        List<model.NhanVien> list = new ArrayList<>();
        model.NhanVien nVien = new NhanVien();
        nVien.setMaNV("NV999");
        list.add(nVien);
        String expectedResult = "NV1000";
        String actualResult = form.taoMaNV_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã NV chỉ có một chữ số")
    public void TC_TAO_MA_NV_04() {
        List<model.NhanVien> list = new ArrayList<>();
        model.NhanVien nVien = new NhanVien();
        nVien.setMaNV("NV001");
        list.add(nVien);        
        String expectedResult = "NV002";
        String actualResult = form.taoMaNV_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã NV có hai chữ số")
    public void TC_TAO_MA_NV_05() {
        List<model.NhanVien> list = new ArrayList<>();
        model.NhanVien nVien = new NhanVien();
        nVien.setMaNV("NV99");
        list.add(nVien);
        String expectedResult = "NV100";
        String actualResult = form.taoMaNV_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã NV có ba chữ số")
    public void TC_TAO_MA_NV_06() {
        List<model.NhanVien> list = new ArrayList<>();
        model.NhanVien nVien = new NhanVien();
        nVien.setMaNV("NV999");
        list.add(nVien);
        String expectedResult = "NV1000";
        String actualResult = form.taoMaNV_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách nhân viên là null")
    public void TC_TAO_MA_NV_07() {
        String expectedResult = "NV001";
        String actualResult = form.taoMaNV_Test(null);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
