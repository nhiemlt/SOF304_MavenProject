package Nhiem.SanPham;

import view.SanPham;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.ChiTietSanPham;

public class taoMaCTSPTest {
	
	SanPham form = new SanPham();

    @Test(description = "Kiểm tra khi danh sách là null")
    public void TC_TAOMACTSP_01() {
        List<ChiTietSanPham> list = null;
        String expectedResult = null;
        String actualResult = form.taoMaCTSP_Test("", list);
        Assert.assertNull(actualResult);
    }

    @Test(description = "Kiểm tra khi danh sách là rỗng")
    public void TC_TAOMACTSP_02() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String expectedResult = "SP001-0";
        String actualResult = form.taoMaCTSP_Test("", list);
        Assert.assertNull(actualResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng")
    public void TC_TAOMACTSP_03() {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp= new ChiTietSanPham();
        ctsp.setMaCTSP("SP002-1");
        list.add(ctsp);
        String expectedResult = "SP002-2";
        String actualResult = form.taoMaCTSP_Test("SP002", list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi tham số MaSP là null")
    public void TC_TAOMACTSP_04() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String actualResult = form.taoMaCTSP_Test(null, list);
        Assert.assertNull(actualResult);
    }

    @Test(description = "Kiểm tra khi danh sách có một phần tử")
    public void TC_TAOMACTSP_05() {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCTSP("SP003-999");
        list.add(ctsp);
        String expectedResult = "SP003-1000";
        String actualResult = form.taoMaCTSP_Test("SP003", list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách có nhiều hơn một phần tử")
    public void TC_TAOMACTSP_06() {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp1 = new ChiTietSanPham();
        ctsp1.setMaCTSP("SP008-1");
        list.add(ctsp1);
        ChiTietSanPham ctsp2 = new ChiTietSanPham();
        ctsp2.setMaCTSP("SP008-3");
        list.add(ctsp2);
        String expectedResult = "SP008-4";
        String actualResult = form.taoMaCTSP_Test("SP008", list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách có một phần tử")
    public void TC_TAOMACTSP_07() {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCTSP("SP009-5");
        list.add(ctsp);
        String expectedResult = "SP009-6";
        String actualResult = form.taoMaCTSP_Test("SP009", list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách rỗng")
    public void TC_TAOMACTSP_08() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String expectedResult = "SP010-1";
        String actualResult = form.taoMaCTSP_Test("SP010", list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách rỗng")
    public void TC_TAOMACTSP_09() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String expectedResult = "SP012-1";
        String actualResult = form.taoMaCTSP_Test("SP012", list);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
