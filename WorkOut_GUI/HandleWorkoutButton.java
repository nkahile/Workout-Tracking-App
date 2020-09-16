import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class HandleWorkoutButton implements ActionListener {

	private JFrame mainFrame;
	private ArrayList<WorkoutData> workoutData;
	private String workoutType;
	private InvidualWorkoutFrame invWorkFrame;

	public HandleWorkoutButton(JFrame mainFrame, ArrayList<WorkoutData> workoutData, String workoutType) {
		this.mainFrame = mainFrame;
		this.workoutData = workoutData;
		this.workoutType = workoutType;
		this.invWorkFrame = new InvidualWorkoutFrame(this.mainFrame, this.workoutData, this.workoutType);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.invWorkFrame.start();
	}

}
