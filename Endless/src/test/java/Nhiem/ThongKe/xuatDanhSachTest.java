package Nhiem.ThongKe;

import java.io.File;

import javax.swing.JTable;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.ThongKe;

public class xuatDanhSachTest {
    ThongKe form = new ThongKe();

    @Test(description = "Kiểm tra việc xuất dữ liệu từ bảng có dữ liệu")
    public void testXuatDanhSachWithData() {
        Object[][] data = { { "Dữ liệu 1", 100, true }, { "Dữ liệu 2", 200, false }, { "Dữ liệu 3", 300, true } };
        String[] columns = { "Cột 1", "Cột 2", "Cột 3" };
        JTable table = new JTable(data, columns);

        File file = new File("test.xlsx");

        form.xuatDanhSach(table, file);

        Assert.assertTrue(file.exists());
        file.delete();
    }

    @Test(description = "Kiểm tra việc xuất dữ liệu từ bảng rỗng")
    public void testXuatDanhSachWithEmptyData() {
        JTable emptyTable = new JTable();
        File file = new File("test_empty.xlsx");

        form.xuatDanhSach(emptyTable, file);

        Assert.assertTrue(file.exists());
        file.delete();
    }

    @Test(description = "Kiểm tra xử lý khi đầu vào file là null")
    public void testXuLyKhiFileLaNull() {
        Object[][] data = { { "Dữ liệu 1", 100, true }, { "Dữ liệu 2", 200, false }, { "Dữ liệu 3", 300, true } };
        String[] columns = { "Cột 1", "Cột 2", "Cột 3" };
        JTable table = new JTable(data, columns);

        File nullFile = null;

        Assert.assertThrows(NullPointerException.class, () -> {
            form.xuatDanhSach(table, nullFile);
        });
    }
}
