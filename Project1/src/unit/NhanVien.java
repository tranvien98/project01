package unit;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String chucVu;
	private Double luong;
	private String ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String chuThich;
	public NhanVien(String maNV, String tenNV, String chucVu, Double luong, String ngaySinh, String gioiTinh,String diaChi, String chuThich) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.chucVu = chucVu;
		this.luong = luong;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.chuThich = chuThich;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public Double getLuong() {
		return luong;
	}
	public void setLuong(Double luong) {
		this.luong = luong;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
}
