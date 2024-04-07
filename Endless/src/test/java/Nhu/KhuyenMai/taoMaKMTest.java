package Nhu.KhuyenMai;

import view.KhuyenMai;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class taoMaKMTest {
	KhuyenMai form = new KhuyenMai();

	@Test(description = "Kiểm tra khi danh sách là null")
	public void TC_TAOMAKM_01() {
		String result = form.taoMaKM_Test(null);
		assertEquals(result, "KM001");
	}

	@Test(description = "Kiểm tra khi danh sách là rỗng")
	public void TC_TAOMAKM_02() {
		List<model.KhuyenMai> emptyList = new ArrayList<>();
		String result = form.taoMaKM_Test(emptyList);
		assertEquals(result, "KM001");
	}

	@Test(description = "Kiểm tra khi danh sách không rỗng")
	public void TC_TAOMAKM_03() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM100");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		assertEquals(result, "KM101");
	}

	@Test(description = "Kiểm tra khi MaKM ngắn hơn 3 ký tự")
	public void TC_TAOMAKM_04() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM1");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		assertEquals(result, "KM002");
	}

	@Test(description = "Kiểm tra khi MaKM dài hơn 5 ký tự")
	public void TC_TAOMAKM_05() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM10000");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		assertEquals(result, "KM10001");
	}

	@Test(description = "Kiểm tra khi sử dụng số lớn nhất cho ID")
	public void TC_TAOMAKM_06() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM999");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		assertEquals(result, "KM1000");
	}

	@Test(description = "Kiểm tra khi sử dụng số vượt quá giới hạn")
	public void TC_TAOMAKM_07() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM999");
		list.add(km);

		for (int i = 0; i < 1000; i++) {
			model.KhuyenMai khuyenmai = new model.KhuyenMai();
			String maKM = form.taoMaKM_Test(list);
			khuyenmai.setMaKM(maKM);
			list.add(khuyenmai);
		}

		String result = form.taoMaKM_Test(list);
		assertEquals(result, "KM2000");
	}

	@Test(description = "Kiểm tra khi sử dụng ký tự đặc biệt trong MaKM")
	public void TC_TAOMAKM_08() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM@#$");
		list.add(km);
		try {
			String result = form.taoMaKM_Test(list);
			Assert.assertTrue(false);
		} catch (Exception e) {
			String err = e + "";
			assertTrue(err.contains("NumberFormatException"));
		}

	}

	@Test(description = "Kiểm tra khi sử dụng số 0 dẫn đầu cho ID")
	public void TC_TAOMAKM_09() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("KM001");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		Assert.assertEquals(result, "KM002");
	}

	@Test(description = "Kiểm tra khi sử dụng số âm làm ID")
	public void TC_TAOMAKM_10() {
		List<model.KhuyenMai> list = new ArrayList<>();
		model.KhuyenMai km = new model.KhuyenMai();
		km.setMaKM("-100");
		list.add(km);

		String result = form.taoMaKM_Test(list);
		Assert.assertEquals(result, "KM001");
	}

	@Test(description = "Kiểm tra khi sử dụng danh sách lớn")
	public void TC_TAOMAKM_11() {
		List<model.KhuyenMai> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			model.KhuyenMai km = new model.KhuyenMai();
			km.setMaKM("KM" + (i + 1));
			list.add(km);
		}

		String result = form.taoMaKM_Test(list);
		Assert.assertEquals(result, "KM1001");
	}
}
