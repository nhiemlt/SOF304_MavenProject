package Nhiem.XNumber;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import util.XNumber;

public class XNumberFormatTest {
    
    @Test(description = "Kiểm tra khi định dạng một số thập phân thành chuỗi")
    public void TC_FORMATDEC_01() {
        double number = 1234567.89;
        String expected = "1,234,567.89"; // Sửa lại chuỗi kỳ vọng
        String result = XNumber.formatDecimal(number);
        assertEquals(result, expected);
    }

    @Test(description = "Kiểm tra khi định dạng một số thập phân âm thành chuỗi")
    public void TC_FORMATDEC_02() {
        double number = -9876543.21;
        String expected = "-9,876,543.21"; // Sửa lại chuỗi kỳ vọng
        String result = XNumber.formatDecimal(number);
        assertEquals(result, expected);
    }

    @Test(description = "Kiểm tra khi định dạng một số nguyên thành chuỗi")
    public void TC_FORMATINT_01() {
        int number = 1234567;
        String expected = "1,234,567";
        String result = XNumber.formatInt(number);
        assertEquals(result, expected);
    }

    @Test(description = "Kiểm tra khi định dạng một số nguyên âm thành chuỗi")
    public void TC_FORMATINT_02() {
        int number = -9876543;
        String expected = "-9,876,543";
        String result = XNumber.formatInt(number);
        assertEquals(result, expected);
    }
}
