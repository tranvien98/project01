package unit;


public class HoaDon {
	private String maHD;
	private String maNV;
	private String maKh;
	private String maPhong;
	private String maDdv;
	private String ngay;
	private Double giaHD; 
	private int tinhTrang;
	public HoaDon(String maHD, String maNV, String maKh, String maPhong, String maDdv, String ngay,Double giaHD, int tinhtrang) {
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKh = maKh;
		this.maPhong = maPhong;
		this.maDdv = maDdv;
		this.ngay = ngay;
		this.giaHD = giaHD;
		this.tinhTrang = tinhtrang;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaKh() {
		return maKh;
	}
	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaDdv() {
		return maDdv;
	}
	public void setMaDdv(String maDdv) {
		this.maDdv = maDdv;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public Double getGiaHD() {
		return giaHD;
	}
	public void setGiaHD(Double giaHD) {
		this.giaHD = giaHD;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
