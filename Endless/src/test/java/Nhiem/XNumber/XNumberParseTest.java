package Nhiem.XNumber;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.text.ParseException;

import org.testng.annotations.Test;

import util.XNumber;

public class XNumberParseTest {
    
    @Test(description = "Kiểm tra khi chuyển đổi chuỗi định dạng thành số thập phân")
    public void TC_PARSEDEC_01() throws ParseException {
        String formattedNumber = "1,234,567.89";
        double expected = 1234567.89;
        double result = XNumber.parseDecimal(formattedNumber);
        assertEquals(result, expected);
    }

    @Test(description = "Kiểm tra khi gặp lỗi khi chuyển đổi chuỗi không hợp lệ")
    public void TC_PARSEDEC_02() {
        String formattedNumber = "abcd";
        try {
            double result = XNumber.parseDecimal(formattedNumber);
            fail("ParseException expected but not thrown");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Test(description = "Kiểm tra khi chuyển đổi chuỗi định dạng thành số nguyên")
    public void TC_PARSEINT_01() throws ParseException {
        String formattedNumber = "1,234,567";
        int expected = 1234567;
        int result = XNumber.parseInt(formattedNumber);
        assertEquals(result, expected);
    }

    @Test(description = "Kiểm tra khi gặp lỗi khi chuyển đổi chuỗi không hợp lệ")
    public void TC_PARSEINT_02() {
        String formattedNumber = "abcd";
        try {
            int result = XNumber.parseInt(formattedNumber);
            fail("ParseException expected but not thrown");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
