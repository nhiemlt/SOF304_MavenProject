package Nhiem.ThuocTinh;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.KichThuoc;
import view.ThuocTinh;

public class capNhapKichThuocTest {

    ThuocTinh form = new ThuocTinh();

    @Test(description = "Cập nhật kích thước thành công")
    public void TC_CNKT_01() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT001");
        kt.setTenKichThuoc("Size M");
        kt.setMoTa("Phù hợp cho chân có kích thước 170mm");
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Cập nhật kích thước thành công");
    }

    @Test(description = "Cập nhật kích thước thất bại do kích thước không tồn tại")
    public void TC_CNKT_02() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT999");
        kt.setTenKichThuoc("Size M");
        kt.setMoTa("Phù hợp cho chân có kích thước 170mm");
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Mã kích thước không tồn tại");
    }

    @Test(description = "Cập nhật kích thước thành công với mô tả kích thước trống")
    public void TC_CNKT_03() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT002");
        kt.setTenKichThuoc("Size L");
        kt.setMoTa("");
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Cập nhật kích thước thành công");
    }

    @Test(description = "Cập nhật kích thước thất bại do tên kích thước rỗng")
    public void TC_CNKT_04() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT003");
        kt.setTenKichThuoc("");
        kt.setMoTa("Phù hợp cho chân có kích thước 170mm");
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Tên kích thước không được bỏ trống");
    }

    @Test(description = "Cập nhật kích thước thành công với tên kích thước mới")
    public void TC_CNKT_05() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT004");
        kt.setTenKichThuoc("Size XL");
        kt.setMoTa("Phù hợp cho chân có kích thước 175mm");
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Cập nhật kích thước thành công");
    }

    @Test(description = "Cập nhật kích thước thất bại do mô tả kích thước null")
    public void TC_CNKT_06() {
        KichThuoc kt = new KichThuoc();
        kt.setMaKichThuoc("KT005");
        kt.setTenKichThuoc("Size XXL");
        kt.setMoTa(null);
        String result = form.CapNhatKichThuo_Test(kt);
        Assert.assertEquals(result, "Cập nhật kích thước thành công");
    }

}
