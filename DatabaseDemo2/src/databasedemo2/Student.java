
public class Student {
	private String id;
	private String name;
	private double point;
	
	public Student() { }

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

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Student(String id, String name, double point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
}
