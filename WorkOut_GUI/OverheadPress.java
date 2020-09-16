import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OverheadPress implements WorkoutBottons {
	private String workoutName = "Overhead Press";
	private JFrame mainFrame;
	private ArrayList<WorkoutData> workoutData;
	
	public OverheadPress(JFrame frame, ArrayList<WorkoutData> data) {
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