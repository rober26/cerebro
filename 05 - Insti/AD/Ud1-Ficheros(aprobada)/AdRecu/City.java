
public class City {
	private String name;
	private String countryCode;
	private String state;
	private String timeZone;
	private double latitude;
	private double longitude;


	public City(String name, String countryCode, String state, String timeZone, double latitude, double longitude) {
		this.name = name;
		this.countryCode = countryCode;
		this.state = state;
		this.timeZone = timeZone;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "City{" +
				"name='" + name + '\'' +
				", countryCode='" + countryCode + '\'' +
				", state='" + state + '\'' +
				", timeZone='" + timeZone + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}

	public String getName() {
		return name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getState() {
		return state;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
