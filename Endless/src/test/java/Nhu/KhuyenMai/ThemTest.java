package Nhu.KhuyenMai;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.KhuyenMai;
import model.SanPham;
import util.KhuyenMaiDAO;
import util.SanPhamDAO;

public class ThemTest {

	public Date formatDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private KhuyenMaiDAO kmDAO;
	private SanPhamDAO spDAO;
	private view.KhuyenMai form;

	@BeforeClass
	public void setUp() {
		kmDAO = new KhuyenMaiDAO();
		spDAO = new SanPhamDAO();
		form = new view.KhuyenMai();

	}

	@Test(description = "Thêm thành công với 0 sản phẩm")
	public void TC_THEMKM_01() {
		KhuyenMai km = new KhuyenMai();

		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(10); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Thêm thành công với 0 sản phẩm");
	}

	@Test(description = "Thêm thành công với danh sách sản phẩm không null")
	public void TC_THEMKM_02() {
		List<model.SanPham> list = new ArrayList<SanPham>();
		model.SanPham sp = new model.SanPham();

		sp.setMaSP("SP001");
		sp.setTenSP("Giày thể thao");
		sp.setMaLoaiGiay("LG001");

		list.add(sp);

		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(15); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, list);
		Assert.assertEquals(result, "Thêm thành công với 1 sản phẩm");
	}

	// Mã tự tăng
	@Test(description = "Thêm thất bại với khuyến mãi null")
	public void TC_THEMKM_03() {
		String result = form.them_Test(null, null);
		Assert.assertEquals(result, "Thêm thất bại!");
	}

	@Test(description = "Thêm thất bại với tên khuyến mãi null")
	public void TC_THEMKM_04() {
		KhuyenMai km = new KhuyenMai();
		km.setMucGiamGia(20); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Thêm thất bại!");
	}

	@Test(description = "Thêm thất bại với mức giảm giá không hợp lệ")
	public void TC_THEMKM_05() {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(-5); // Đặt mức giảm giá không hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Mức giảm giá phải lớn hơn 0");
	}

	@Test(description = "Thêm thất bại với ngày kết thúc trước ngày bắt đầu")
	public void TC_THEMKM_06() {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(20); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(formatDate("02-01-2020"));
		km.setNgayKetThuc(formatDate("01-01-2020")); // Đặt ngày kết thúc trước ngày bắt đầu

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Ngày kết thúc không được trước ngày bắt đầu");
	}

	@Test(description = "Thêm thất bại với danh sách sản phẩm rỗng")
	public void TC_THEMKM_07() {
		List<model.SanPham> emptyList = new ArrayList<SanPham>();

		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(20); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, emptyList);
		Assert.assertEquals(result, "Thêm thành công với 0 sản phẩm");
	}
	
	@Test(description = "Thêm thất bại với mức giảm giá không hợp lệ")
	public void TC_THEMKM_08() {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(99); // Đặt mức giảm giá không hợp lệ
		km.setNgayBatDau(new Date());
		km.setNgayKetThuc(new Date());

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Mức giảm giá không được lớn hơn 90");
	}
	
	@Test(description = "Thêm thất bại với ngày kết thúc trước ngày bắt đầu")
	public void TC_THEMKM_09() {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(20); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(formatDate(""));
		km.setNgayKetThuc(formatDate("01-01-2020")); // Đặt ngày kết thúc trước ngày bắt đầu

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Ngày bắt đầu không được để trống");
	}
	@Test(description = "Thêm thất bại với ngày kết thúc trước ngày bắt đầu")
	public void TC_THEMKM_10() {
		KhuyenMai km = new KhuyenMai();
		km.setTenKM("Khuyến mãi test");
		km.setMucGiamGia(20); // Đặt mức giảm giá hợp lệ
		km.setNgayBatDau(formatDate("01-01-2020"));
		km.setNgayKetThuc(formatDate("")); // Đặt ngày kết thúc trước ngày bắt đầu

		String result = form.them_Test(km, null);
		Assert.assertEquals(result, "Ngày kết thúc không được để trống");
	}

}
