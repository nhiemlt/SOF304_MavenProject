package Nguyen.LoaiGiay;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.LoaiGiay;

public class themTest {
	view.LoaiGiay form = new LoaiGiay();
	
	@Test(description = "Kiểm tra khi tên loại giày trống")
    public void TC_THEM_LOAI_GIAY_01() {
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setTenLoaiGiay("");
        String expectedResult = "Lỗi bỏ trống tên loại giày";
        String actualResult = form.ThemLoaiGiay_Test(lg);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi thêm loại giày thành công")
    public void TC_THEM_LOAI_GIAY_02() {
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setTenLoaiGiay("One New Shoes");
        String expectedResult = "Thêm loại giày thành công!";
        String actualResult = form.ThemLoaiGiay_Test(lg);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
