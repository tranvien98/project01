package unit;

public class KhachHang {
	 private String maKH;
	 private String tenKH;
	 private String cmnd;
	 private String diaChi;
	 private String email;
	 private String gioiTinh;
	 private String sdt;
	 private String maPhong;
	 public KhachHang(String maKH, String tenKH, String cmnd, String diaChi, String email, String gioiTinh, String sdt, String maPhong) {
		 this.maKH = maKH;
		 this.tenKH = tenKH;
		 this.cmnd = cmnd;
		 this.diaChi = diaChi;
		 this.email = email;
		 this.gioiTinh = gioiTinh;
		 this.sdt = sdt;
		 this.maPhong = maPhong;
	 }
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
}