package Nhiem.SanPham;

import view.SanPham;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import model.ChiTietSanPham;

public class taoMaCTSPTest {
	
	SanPham form = new SanPham();

    @Test
    public void test_TC_TAOCTSP_01() {
        List<ChiTietSanPham> emptyList = new ArrayList<>();
        String maSP = "SP001";
        String maCTSPMoi = form.taoMaCTSP_Test(maSP, emptyList);
        assertEquals("SP001-1", maCTSPMoi);
    }

    @Test
    public void test_TC_TAOCTSP_02() {
    	List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCTSP("SP001-1");
        list.add(ctsp);
        String maSP = "SP001";
        String maCTSPMoi = form.taoMaCTSP_Test(maSP, list);
        assertEquals("SP001-2", maCTSPMoi);
    }

    @Test
    public void test_TC_TAOCTSP_03() {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCTSP("SP001-999");
        list.add(ctsp);
        String maSP = "SP001";
        String maCTSPMoi = form.taoMaCTSP_Test(maSP, list);
        assertEquals("SP001-1000", maCTSPMoi);
    }

}
