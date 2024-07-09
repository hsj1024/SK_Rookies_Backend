package test;

public class Greeter {
	private String format;
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String greet(String name) {
		return String.format(format, name);
	}
}
