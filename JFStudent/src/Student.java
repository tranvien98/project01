
public class Student {
	private String id;
	private String name;
	private Double point;
	private String gender;
	public Student(String id, String name, Double point, String gender) {
		this.id = id;
		this.name = name;
		this.point = point;
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPoint() {
		return point;
	}
	public void setPoint(Double point) {
		this.point = point;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}				
}
