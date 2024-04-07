package Nhu.KhachHang;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;
import view.KhachHang;

public class TaoMaKHTest {
	KhachHang form = new KhachHang();

	@Test(description = "Kiểm tra khi danh sách là null")
	public void TC_TAOMAKH_01() {
		String result = form.taoMaKH_test(null);
		assertEquals(result, "KH001");
	}

	@Test(description = "Kiểm tra khi danh sách là rỗng")
	public void TC_TAOMAKH_02() {
		List<model.KhachHang> emptyList = new ArrayList<>();
		String result = form.taoMaKH_test(emptyList);
		assertEquals(result, "KH001");
	}

	@Test(description = "Kiểm tra khi danh sách không rỗng")
	public void TC_TAOMAKH_03() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH100");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		assertEquals(result, "KH101");
	}

	@Test(description = "Kiểm tra khi MaSP ngắn hơn 3 ký tự")
	public void TC_TAOMAKH_04() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH1");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		assertEquals(result, "KH002");
	}

	@Test(description = "Kiểm tra khi MaKH dài hơn 5 ký tự")
	public void TC_TAOMAKH_05() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH10000");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		assertEquals(result, "KH10001");
	}

	@Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
	public void TC_TAOMAKH_06() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH999");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		assertEquals(result, "KH1000");
	}

	@Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
	public void TC_TAOMAKH_07() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH999");
		list.add(sp);

		for (int i = 0; i < 1000; i++) {
			model.KhachHang khachhang = new model.KhachHang();
			String maSP = form.taoMaKH_test(list);
			khachhang.setMaKH(maSP);
			list.add(khachhang);
		}

		String result = form.taoMaKH_test(list);
		assertEquals(result, "KH2000");
	}

	@Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaSP")
	public void TC_TAOMAKH_08() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH@#$");
		list.add(sp);
		try {
			String result = form.taoMaKH_test(list);
			Assert.assertTrue(false);
		} catch (Exception e) {
			String err = e + "";
			assertTrue(err.contains("NumberFormatException"));
		}

	}

	@Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
	public void TC_TAOMAKH_09() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("KH001");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		Assert.assertEquals(result, "KH002");
	}

	@Test(description = "Kiểm tra khi sử dụng số âm làm ID")
	public void TC_TAOMAKH_10() {
		List<model.KhachHang> list = new ArrayList<>();
		model.KhachHang sp = new model.KhachHang();
		sp.setMaKH("-100");
		list.add(sp);

		String result = form.taoMaKH_test(list);
		Assert.assertEquals(result, "KH001");
	}

	@Test(description = "Kiểm tra khi sử dụng danh sách lớn")
	public void TC_TAOMAKH_11() {
		List<model.KhachHang> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			model.KhachHang sp = new model.KhachHang();
			sp.setMaKH("KH" + (i + 1));
			list.add(sp);
		}

		String result = form.taoMaKH_test(list);
		Assert.assertEquals(result, "KH1001");
	}
}
