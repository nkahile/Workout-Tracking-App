import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WorkoutLog {

	private JFrame mainFrame;
	private ArrayList<WorkoutData> workoutData;
	private JFrame currentFrame;
	public WorkoutLog(JFrame mainFrame, ArrayList<WorkoutData> workoutData) {
		super();
		this.mainFrame = mainFrame;
		this.workoutData = workoutData;
	}

	public void start() {
		this.mainFrame.setVisible(false);
		// create the indvidualFrame
		this.currentFrame = new JFrame("Workout Log");
		this.currentFrame.setSize(500, 300);

		this.createFrameInner();

		this.currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.currentFrame.setVisible(true);
	}

	private void createFrameInner() {
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("Track Your Workouts!");
		topPanel.add(topLabel, BorderLayout.CENTER);

		JPanel buttonPanel = this.addActionButtons();

		JPanel centerPanel = this.createAndPopulateTable();
		

		this.currentFrame.add(topPanel, BorderLayout.NORTH);
		this.currentFrame.add(centerPanel,BorderLayout.CENTER);
		this.currentFrame.add(buttonPanel, BorderLayout.SOUTH);
	}

	private JPanel createAndPopulateTable() {
		JPanel panel = new JPanel();
		String[] columnNames = { "Date", "Workout", "Sets","Reps", "Weight"};
		String[][] data = new String[this.workoutData.size()][columnNames.length];
		
		for(int i=0;i<this.workoutData.size();i++) {
			String tempWorkoutString = this.workoutData.get(i).getTotalString();
			String[] tempArray = tempWorkoutString.split("%");
//			for(int j=0;j<tempArray.length;j++) {
//				data[i][j]=tempArray[j];
//			}
			data[i]=tempArray;
		}
	
		
		JTable table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(450,175));
        table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);
		return panel;
	}

	private JPanel addActionButtons() {
		JPanel panel = new JPanel();
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(true);
				currentFrame.dispose();

			}
		});

		panel.add(returnButton);
		return panel;
	}
}
