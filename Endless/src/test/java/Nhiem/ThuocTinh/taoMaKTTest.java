package Nhiem.ThuocTinh;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.KichThuoc;
import view.ThuocTinh;

public class taoMaKTTest {
	ThuocTinh form = new ThuocTinh();

    @Test(description = "Kiểm tra khi danh sách là null")
    public void TC_TAO_MAKT_01() {
        String actualResult = form.taoMaKT_Test(null);
        String expectedResult = "KT001";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách là rỗng")
    public void TC_TAO_MAKT_02() {
        List<KichThuoc> list = new ArrayList<>();
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT001";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng")
    public void TC_TAO_MAKT_03() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT001");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT002";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi MaKT ngắn hơn 3 ký tự")
    public void TC_TAO_MAKT_04() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT002";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi MaKT dài hơn 5 ký tự")
    public void TC_TAO_MAKT_05() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT10000");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT10001";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
    public void TC_TAO_MAKT_06() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT999");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT1000";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
    public void TC_TAO_MAKT_07() {
        List<KichThuoc> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            KichThuoc kt = new KichThuoc();
            kt.setMaKichThuoc("KT" + i);
            list.add(kt);
        }
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT1000";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaKT")
    public void TC_TAO_MAKT_08() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT@#$");
        list.add(kt);
        String expectedResult = "";
        try {
            form.taoMaKT_Test(list);
        } catch (Exception e) {
            expectedResult = e + "";
        }
        Assert.assertTrue(expectedResult.contains("NumberFormatException"));
    }

    @Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
    public void TC_TAO_MAKT_09() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT001");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT002";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số âm làm ID")
    public void TC_TAO_MAKT_10() {
        List<KichThuoc> list = new ArrayList<>();
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("-100");
        list.add(kt);
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT001";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng danh sách lớn")
    public void TC_TAO_MAKT_11() {
        List<KichThuoc> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            KichThuoc kt = new KichThuoc();
            kt.setMaKichThuoc(form.taoMaKT_Test(list));
            list.add(kt);
        }
        String actualResult = form.taoMaKT_Test(list);
        String expectedResult = "KT1001";
        Assert.assertEquals(actualResult, expectedResult);
    }
}

