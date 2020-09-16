import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PullUps implements WorkoutBottons {
	private String workoutName = "Pull Ups";
	private JFrame mainFrame;
	private ArrayList<WorkoutData> workoutData;
	
	public PullUps(JFrame frame, ArrayList<WorkoutData> data) {
		this.mainFrame=frame;
		this.workoutData=data;
	}
	
	@Override
	public JButton getButton() {
		JButton button = new JButton(this.workoutName);
		button.addActionListener(new HandleWorkoutButton(this.mainFrame, this.workoutData, this.workoutName));
		return button;
	}

}