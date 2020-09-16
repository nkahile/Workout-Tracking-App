import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Workout Tracker");
		frame.setSize(550, 250);
		WorkoutFrame wf = new WorkoutFrame(frame);
		wf.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}