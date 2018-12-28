package unit;

public class DichVu {
	private String maDV, tenDV;
	private Double gia;
public DichVu(String maDV, String tenDv,double gia) {
	this.maDV = maDV;
	this.tenDV = tenDv;
	this.gia = gia;
}
public String getMaDV() {
	return maDV;
}
public void setMaDV(String maDV) {
	this.maDV = maDV;
}
public String getTenDV() {
	return tenDV;
}
public void setTenDV(String tenDV) {
	this.tenDV = tenDV;
}
public Double getGia() {
	return gia;
}
public void setGia(Double gia) {
	this.gia = gia;
}

}
