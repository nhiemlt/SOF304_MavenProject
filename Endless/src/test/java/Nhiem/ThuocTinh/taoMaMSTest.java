package Nhiem.ThuocTinh;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.MauSac;
import view.ThuocTinh;

public class taoMaMSTest {

	 ThuocTinh form = new ThuocTinh();

	    @Test(description = "Kiểm tra khi danh sách là null")
	    public void TC_TAOMAMS_01() {
	        String actualResult = form.taoMaMS_Test(null);
	        String expectedResult = "MS001";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi danh sách là rỗng")
	    public void TC_TAOMAMS_02() {
	        List<MauSac> list = new ArrayList<>();
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS001";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi danh sách không rỗng")
	    public void TC_TAOMAMS_03() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS001");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS002";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi MaMS ngắn hơn 3 ký tự")
	    public void TC_TAOMAMS_04() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS002";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi MaMS dài hơn 5 ký tự")
	    public void TC_TAOMAMS_05() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS10000");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS10001";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
	    public void TC_TAOMAMS_06() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS999");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS1000";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
	    public void TC_TAOMAMS_07() {
	        List<MauSac> list = new ArrayList<>();
	        for (int i = 0; i < 1000; i++) {
	            MauSac ms = new MauSac();
	            ms.setMaMauSac("MS" + i);
	            list.add(ms);
	        }
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS1000";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaMS")
	    public void TC_TAOMAMS_08() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS@#$");
	        list.add(ms);
	        String expectedResult = "";
	        try {
	        	form.taoMaMS_Test(list);
			} catch (Exception e) {
				expectedResult = e+"";
			}
	       Assert.assertTrue(expectedResult.contains("NumberFormatException"));
	    }

	    @Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
	    public void TC_TAOMAMS_09() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("MS001");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS002";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi sử dụng số âm làm ID")
	    public void TC_TAOMAMS_10() {
	        List<MauSac> list = new ArrayList<>();
	        MauSac ms = new MauSac();
	        ms.setMaMauSac("-100");
	        list.add(ms);
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS001";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

	    @Test(description = "Kiểm tra khi sử dụng danh sách lớn")
	    public void TC_TAOMAMS_11() {
	        List<MauSac> list = new ArrayList<>();
	        for (int i = 0; i < 1000; i++) {
	            MauSac ms = new MauSac();
	            ms.setMaMauSac(form.taoMaMS_Test(list));
	            list.add(ms);
	        }
	        String actualResult = form.taoMaMS_Test(list);
	        String expectedResult = "MS1001";
	        Assert.assertEquals(actualResult, expectedResult);
	    }

}
