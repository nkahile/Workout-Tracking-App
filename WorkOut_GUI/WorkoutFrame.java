import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkoutFrame {

	private JFrame mainFrame;
	private ArrayList<WorkoutBottons> workouts;
	private ArrayList<WorkoutData> workoutData;

	public WorkoutFrame(JFrame frame) {
		this.mainFrame = frame;
		this.workouts = new ArrayList<WorkoutBottons>();
		this.workoutData = new ArrayList<WorkoutData>();

		// fill list
		this.workouts.add(new Squat(this.mainFrame, this.workoutData));
		this.workouts.add(new BenchPress(this.mainFrame, this.workoutData));
		this.workouts.add(new PullUps(this.mainFrame, this.workoutData));
		this.workouts.add(new OverheadPress(this.mainFrame, this.workoutData));
		this.workouts.add(new Curls(this.mainFrame, this.workoutData));
		this.workouts.add(new ShoulderPress(this.mainFrame, this.workoutData));
		this.workouts.add(new TricepExtensions(this.mainFrame, this.workoutData));
		this.workouts.add(new Thrusters(this.mainFrame, this.workoutData));
		
		this.loadPreviousWorkoutData();
	}

	public void start() {
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("Welcome Back! Choose your workout!");
		topPanel.add(topLabel, BorderLayout.CENTER);
		
		JPanel grid = this.createGrid();

		JPanel bottomPanel = this.createButtomPanel();

		this.mainFrame.add(bottomPanel, BorderLayout.SOUTH);
		this.mainFrame.add(grid, BorderLayout.CENTER);
		this.mainFrame.add(topPanel, BorderLayout.NORTH);
	}
	
	private void loadPreviousWorkoutData() {
		String row = "";
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader("./workoutLog.txt"));
			while ((row = fileReader.readLine()) != null) {
				this.workoutData.add(new WorkoutData(row));
			}

			fileReader.close();
			System.out.println("Workout Data Succussfully Loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JPanel createGrid() {
		JPanel panel = new JPanel();
		GridLayout buttonGrid = new GridLayout(4, 2);

		panel.setLayout(buttonGrid);

		// Set up components preferred size
		JButton b = new JButton("Just fake button");
		Dimension buttonSize = b.getPreferredSize();
		panel.setPreferredSize(
				new Dimension((int) (buttonSize.getWidth() * 1.5) + 20, (int) (buttonSize.getHeight() * 1.5) + 40));

		for (int i = 0; i < this.workouts.size(); i++) {
			panel.add(this.workouts.get(i).getButton());
		}

		return panel;
	}

	private JPanel createButtomPanel() {

		JPanel panel = new JPanel();
		JPanel rightPanel = new JPanel();

		JButton saveButton =new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File workoutLog = new File("./workoutLog.txt");
					FileWriter workoutLogWriter = new FileWriter(workoutLog);
					for (int i=0;i<workoutData.size();i++) {
						String data = workoutData.get(i).getTotalString();
						workoutLogWriter.append(data);
						workoutLogWriter.append('\n');
					}

					workoutLogWriter.flush();
					workoutLogWriter.close();
				} catch (IOException error) {
					// TODO Auto-generated catch block
					error.printStackTrace();
				}
				System.out.println("Workout Data Saved");
				System.exit(0);
			}
		});
		
		
		JButton exitButton =new JButton("Exit(without saving)");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		rightPanel.add(saveButton, BorderLayout.EAST);
		rightPanel.add(exitButton, BorderLayout.WEST);
		
		JButton workOutLogButton =new JButton("Track Workouts");
		workOutLogButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WorkoutLog workoutLog = new WorkoutLog(mainFrame, workoutData);
				workoutLog.start();
			}
		});
		
		panel.add(workOutLogButton, BorderLayout.WEST);
		panel.add(rightPanel, BorderLayout.EAST);
		return panel;

	}

}