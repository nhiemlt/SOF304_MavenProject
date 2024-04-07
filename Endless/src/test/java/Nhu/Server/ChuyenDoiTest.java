package Nhu.Server;

import org.testng.Assert;
import org.testng.annotations.Test;

import view.chuyenServer;

public class ChuyenDoiTest {

	chuyenServer chuyenDoi = new chuyenServer();

	@Test (description = "Kiểm tra với đầu vào hợp lệ 1")
	public void TC_CHUYENDOI_01() {
		String result = chuyenDoi.chuyenDoi_Test("172.16.24.80", "Endless");
		Assert.assertEquals(result, "Đã lưu sever và database vào file sever.txt");
	}

	@Test (description = "Kiểm tra với đầu không hợp lệ. Cụ thể là lỗi bỏ trống sever")
	public void TC_CHUYENDOI_02() {
		String result = chuyenDoi.chuyenDoi_Test("", "testDatabase");
		Assert.assertEquals(result, "Lỗi bỏ trống sever vào file sever.txt");
	}

	@Test (description = "Kiểm tra với đầu không hợp lệ. Cụ thể là lỗi bỏ trống database")
	public void TC_CHUYENDOI_03() {
		String result = chuyenDoi.chuyenDoi_Test("testSever", "");
		Assert.assertEquals(result, "Lỗi bỏ trống database vào file sever.txt");
	}

	@Test  (description = "Kiểm tra với đầu không hợp lệ. Cụ thể là lỗi Sever chứa kí tự")
	public void TC_CHUYENDOI_04() {
		String result = chuyenDoi.chuyenDoi_Test("test^$Server", "testDatabase");
		Assert.assertEquals(result, "Lỗi: Sever không được chứa ký tự đặc biệt");
	}

	@Test  (description = "Kiểm tra với đầu không hợp lệ. Cụ thể là lỗi Database chứa kí tự")
	public void TC_CHUYENDOI_05() {
		String result = chuyenDoi.chuyenDoi_Test("testServer", "test$Database");
		Assert.assertEquals(result, "Lỗi: Database không được chứa ký tự đặc biệt");
	}
 
	@Test (description = "Kiểm tra với đầu vào hợp lệ 2")
	public void TC_CHUYENDOI_06() {
		String result = chuyenDoi.chuyenDoi_Test("locohost:111", "testDatabase");
		Assert.assertEquals(result, "Đã lưu sever và database vào file sever.txt");
	}

	@Test (description = "Kiểm tra với đầu vào hợp lệ 3")
	public void TC_CHUYENDOI_07() {
		String result = chuyenDoi.chuyenDoi_Test("testServer", "testDatabase");
		Assert.assertEquals(result, "Đã lưu sever và database vào file sever.txt");
	}

}
