package Nhiem.SanPham;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import model.ChiTietSanPham;
import view.SanPham;

public class themCTSPTest {
	SanPham form = new SanPham();
    @Test
    public void TC_THEMCTSP_01() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaMau("MS004");
        ctsp.setMaKT("KT001");
        ctsp.setSoLuong(50);

        form.ThemCTSP_Test("SP003", ctsp);
    }

    @Test
    public void TC_THEMCTSP_02() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaMau("MS009");
        ctsp.setMaKT("KT002");
        ctsp.setSoLuong(20);

        try {
        	form.ThemCTSP_Test("SP001", ctsp);
            assertFalse(true);
        } catch (Exception e) {
        	System.out.println("Them that bai!"+e);
        }
    }

    @Test
    public void TC_THEMCTSP_03() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaMau("MS004");
        ctsp.setMaKT("KT003");

        try {
        	form.ThemCTSP_Test("SP001", ctsp);
            assertFalse(true);
        } catch (Exception e) {
        	System.out.println("Them that bai!"+e);
        }
    }

}
