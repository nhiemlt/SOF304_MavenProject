package Nguyen.LoaiGiay;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.LoaiGiay;

public class taoMaLGTest {
	
	view.LoaiGiay form = new LoaiGiay();
	
	@Test(description = "Kiểm tra khi không có loại giày nào trong cơ sở dữ liệu")
    public void TC_TAO_MA_LG_01() {
        List<model.LoaiGiay> list = new ArrayList<>();
        String expectedResult = "LG001";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi danh sách không rỗng")
    public void TC_TAO_MA_LG_02() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG001");
        list.add(lg);
        String expectedResult = "LG002";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng đủ 3 ký tự")
    public void TC_TAO_MA_LG_03() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG999");
        list.add(lg);
        String expectedResult = "LG1000";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng thiếu 1 ký tự")
    public void TC_TAO_MA_LG_04() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG999");
        list.add(lg);
        String expectedResult = "LG1000";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng thiếu 2 ký tự")
    public void TC_TAO_MA_LG_05() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG99");
        list.add(lg);
        String expectedResult = "LG100";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng là số thứ tự lớn nhất")
    public void TC_TAO_MA_LG_06() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG005");
        list.add(lg);
        String expectedResult = "LG006";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng là số thứ tự lớn nhất và bắt đầu bằng 0")
    public void TC_TAO_MA_LG_07() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("LG099");
        list.add(lg);
        String expectedResult = "LG100";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi mã của loại giày cuối cùng đạt đến giới hạn")
    public void TC_TAO_MA_LG_08() {
        List<model.LoaiGiay> list = new ArrayList<>();
        // Tạo danh sách loại giày đến giới hạn
        for (int i = 1; i <= 9999; i++) {
            model.LoaiGiay lg = new model.LoaiGiay();
            lg.setMaLoaiGiay(new view.LoaiGiay().taoMaLG_Test(list));
            list.add(lg);
        }
        // Tính toán kỳ vọng
        String expectedResult = "LG10000";
        // Gọi phương thức và lấy kết quả thực tế
        String actualResult = form.taoMaLG_Test(list);
        // So sánh kết quả
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "Kiểm tra khi sử dụng số âm làm mã loại giày")
    public void TC_TAO_MA_LG_09() {
        List<model.LoaiGiay> list = new ArrayList<>();
        model.LoaiGiay lg = new model.LoaiGiay();
        lg.setMaLoaiGiay("-100");
        list.add(lg);
        String expectedResult = "LG001";
        String actualResult = form.taoMaLG_Test(list);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
