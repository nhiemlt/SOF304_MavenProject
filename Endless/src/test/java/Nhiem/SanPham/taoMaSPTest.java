package Nhiem.SanPham;

import view.SanPham;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class taoMaSPTest {
	SanPham form = new SanPham();

	@Test(description = "Kiểm tra khi danh sách là null")
	public void TC_TAOMASP_01() {
		String result = form.taoMaSP_Test(null);
		assertEquals(result, "SP001");
	}

	@Test(description = "Kiểm tra khi danh sách là rỗng")
	public void TC_TAOMASP_02() {
		List<model.SanPham> emptyList = new ArrayList<>();
		String result = form.taoMaSP_Test(emptyList);
		assertEquals(result, "SP001");
	}

	@Test(description = "Kiểm tra khi danh sách không rỗng")
	public void TC_TAOMASP_03() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP100");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		assertEquals(result, "SP101");
	}

	@Test(description = "Kiểm tra khi MaSP ngắn hơn 3 ký tự")
	public void TC_TAOMASP_04() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP1");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		assertEquals(result, "SP002");
	}

	@Test(description = "Kiểm tra khi MaSP dài hơn 5 ký tự")
	public void TC_TAOMASP_05() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP10000");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		assertEquals(result, "SP10001");
	}

	@Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
	public void TC_TAOMASP_06() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP999");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		assertEquals(result, "SP1000");
	}

	@Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
	public void TC_TAOMASP_07() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP999");
		list.add(sp);

		for (int i = 0; i < 1000; i++) {
			model.SanPham sanpham = new model.SanPham();
			String maSP = form.taoMaSP_Test(list);
			sanpham.setMaSP(maSP);
			list.add(sanpham);
		}

		String result = form.taoMaSP_Test(list);
		assertEquals(result, "SP2000");
	}

	@Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaSP")
	public void TC_TAOMASP_08() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP@#$");
		list.add(sp);
		try {
			String result = form.taoMaSP_Test(list);
			Assert.assertTrue(false);
		} catch (Exception e) {
			String err = e+"";
			assertTrue(err.contains("NumberFormatException"));
		}
		
		
	}

	@Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
	public void TC_TAOMASP_09() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("SP001");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		Assert.assertEquals(result, "SP002");
	}

	@Test(description = "Kiểm tra khi sử dụng số âm làm ID")
	public void TC_TAOMASP_10() {
		List<model.SanPham> list = new ArrayList<>();
		model.SanPham sp = new model.SanPham();
		sp.setMaSP("-100");
		list.add(sp);

		String result = form.taoMaSP_Test(list);
		Assert.assertEquals(result, "SP001");
	}

	@Test(description = "Kiểm tra khi sử dụng danh sách lớn")
	public void TC_TAOMASP_11() {
		List<model.SanPham> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			model.SanPham sp = new model.SanPham();
			sp.setMaSP("SP" + (i + 1));
			list.add(sp);
		}

		String result = form.taoMaSP_Test(list);
		Assert.assertEquals(result, "SP1001");
	}
}
