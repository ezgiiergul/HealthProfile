import java.util.Scanner;

public class HealthProfile {

	public static void main1(String[] args) {
	}

	private String firstName;

	private String lastName;

	private String gender;

	private int birthDay;

	private int birthMonth;

	private int birthYear;

	private double height;

	private double weight;

	public HealthProfile(String firstName, String lastName, String gender, double height, double weight, int birthDay,
			int birthMonth, int birthYear) {

		this.firstName = firstName;

		this.lastName = lastName;

		this.gender = gender;

		this.birthDay = birthDay;

		this.birthMonth = birthMonth;

		this.birthYear = birthYear;

		this.height = height;

		this.weight = weight;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getDateOfBirth() {
		return String.format("%d/%d/%d", birthDay, birthMonth, birthYear);
	}

	public int getAge() {
		return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - birthYear;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getMaximumHeartRate() {
		return 220 - getAge();
	}

	public double getMaximumTargetHeartRate() {
		return .85 * getMaximumHeartRate();
	}

	public double getBMI() {
		return (getWeight()) / (getHeight() * getHeight());
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter your first name: ");
		String firstName = input.nextLine();

		System.out.print("Please enter your last name: ");
		String lastName = input.nextLine();

		System.out.print("Please enter your gender--> male/female: ");
		String gender = input.nextLine();

		System.out.print("Please enter your weight in kilograms: ");
		double weight = input.nextDouble();

		System.out.print("Please enter your height in metres: ");
		double height = input.nextDouble();

		System.out.print("Please enter your date of birth dd mm yyyy: ");
		int[] dob = new int[3];

		for (int i = 0; i < 3; i++) {
			dob[i] = input.nextInt();
		}

		HealthProfile person = new HealthProfile(firstName, lastName, gender, height, weight, dob[0], dob[1], dob[2]);

		PrintInfo(person);

		input.close();
	}

	private static void PrintInfo(HealthProfile person) {
		System.out.printf("First Name : %s%n", person.getFirstName());
		System.out.printf("Last Name : %s%n", person.getLastName());
		System.out.printf("Gender: %s%n", person.getGender());
		System.out.printf("Date of Birth : %s%n", person.getDateOfBirth());
		System.out.printf("Age : %d%n", person.getAge());
		System.out.printf("Max Heart Rate : %d%n", person.getMaximumHeartRate());
		System.out.printf("Target Heart Rate Range: %s%n", person.getMaximumTargetHeartRate());
		System.out.printf(" Your BMI: %f%n ", person.getBMI());

		if (person.getBMI() < 18.5)
			System.out.println("You are underweight.");

		else if (person.getBMI() >= 18.5 && person.getBMI() <= 24.9)
			System.out.println("You are normal.");

		else if (person.getBMI() >= 25 && person.getBMI() <= 29.9)
			System.out.println("You are overweight.");

		else
			System.out.println("You are obese.");

	}

}
