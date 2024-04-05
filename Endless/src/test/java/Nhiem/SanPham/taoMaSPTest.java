package Nhiem.SanPham;

import view.SanPham;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class taoMaSPTest {
	 SanPham form = new SanPham();

	 @Test
	    public void TC_TAOMASP_01() {
	        String result = form.taoMaSP_Test(null);
	        Assert.assertEquals(result, "SP001");
	    }

	    @Test
	    public void TC_TAOMASP_02() {
	        List<model.SanPham> emptyList = new ArrayList<>();
	        String result = form.taoMaSP_Test(emptyList);
	        Assert.assertEquals(result, "SP001");
	    }

	    @Test
	    public void TC_TAOMASP_03() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP100");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP101");
	    }

	    @Test
	    public void TC_TAOMASP_04() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP1");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP002");
	    }

	    @Test
	    public void TC_TAOMASP_05() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP10000");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP10001");
	    }

	    @Test
	    public void TC_TAOMASP_06() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP999");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP1000");
	    }

	    @Test
	    public void TC_TAOMASP_07() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP999");
	        list.add(sp);

	        for (int i = 0; i < 1000; i++) {
	            form.taoMaSP_Test(list);
	        }

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP1999");
	    }

	    @Test
	    public void TC_TAOMASP_08() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP@#$");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP001");
	    }

	    @Test
	    public void TC_TAOMASP_09() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("SP001");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP002");
	    }

	    @Test
	    public void TC_TAOMASP_10() {
	        List<model.SanPham> list = new ArrayList<>();
	        model.SanPham sp = new model.SanPham();
	        sp.setMaSP("-100");
	        list.add(sp);

	        String result = form.taoMaSP_Test(list);
	        Assert.assertEquals(result, "SP001");
	    }

	    @Test
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
