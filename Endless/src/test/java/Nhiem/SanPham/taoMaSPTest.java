package Nhiem.SanPham;

import view.SanPham;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class taoMaSPTest {
	 SanPham form = new SanPham();

	    @Test
	    public void TC_TAOMASP_01() {
	        List<model.SanPham> emptyList = new ArrayList<>();
	        String maSPMoi = form.taoMaSP_Test(emptyList);
	        assertEquals("SP001", maSPMoi);
	    }

	    @Test
	    public void TC_TAOMASP_02() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP001");
	        list.add(sp);
	        String maSPMoi = form.taoMaSP_Test(list);
	        assertEquals("SP002", maSPMoi);
	    }

	    @Test
	    public void C_TAOMASP_03() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP9999");
	        list.add(sp);
	        String maSPMoi = form.taoMaSP_Test(list);
	        assertEquals("SP10000", maSPMoi);
	    }

}
