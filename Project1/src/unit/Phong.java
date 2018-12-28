package unit;

public class Phong {
	private String maPhong;
	private String tenPhong;
	private String loaiPhong;
	private Double giaPhong;
	private String chuThich;
	private String tinhTrang;
	
	
	public Phong(String maPhong, String tenPhong, String loaiPhong,Double giaPhong,  String tinhTrang, String chuThich) {
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.tinhTrang = tinhTrang;
		this.chuThich = chuThich;
	
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public Double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(Double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


}
