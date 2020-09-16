import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkoutData {
	private Date date;
	private String workoutType;
	private int sets;
	private int reps;
	private Double weight;
	private SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-yyyy");
	
	public WorkoutData(Date date, String workoutType, int sets, int reps, Double weight) {
		this.date = date;
		this.workoutType = workoutType;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
	}
	
	public WorkoutData(String data) {
		this.setUpData(data);
	}

	private void setUpData(String data) {
		String[] splitData = data.split("%");
		try {
			this.date = dateForm.parse(splitData[0]);
			this.workoutType = splitData[1];
			this.sets = Integer.parseInt(splitData[2]);
			this.reps = Integer.parseInt(splitData[3]);
			this.weight = Double.parseDouble(splitData[4]);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	public Date getDate() {
		return date;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public int getSets() {
		return sets;
	}

	public int getReps() {
		return reps;
	}

	public Double getWeight() {
		return weight;
	}
	
	public String getTotalString() {
		return dateForm.format(this.date)+"%"+this.workoutType+"%"+this.sets+"%"+this.reps+"%"+this.weight;
	}
}
