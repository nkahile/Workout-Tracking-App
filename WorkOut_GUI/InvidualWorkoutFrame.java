import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvidualWorkoutFrame {

	private JFrame mainFrame;
	private ArrayList<WorkoutData> workoutData;
	private String workoutType;
	private JFrame currentFrame;
	

	// workout options
	private JTextField sets;
	private JTextField reps;
	private JTextField weight;

	public InvidualWorkoutFrame(JFrame mainFrame, ArrayList<WorkoutData> workoutData, String workoutType) {
		this.mainFrame = mainFrame;
		this.workoutData = workoutData;
		this.workoutType = workoutType;

	}

	public void start() {
		this.mainFrame.setVisible(false);
		// create the indvidualFrame
		this.currentFrame = new JFrame(this.workoutType.toUpperCase());
		this.currentFrame.setSize(500, 300);

		this.createFrameInner();

		this.currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.currentFrame.setVisible(true);
	}

	private void createFrameInner() {
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("Time to do some : " + this.workoutType);
		topPanel.add(topLabel, BorderLayout.CENTER);

		JPanel centerPanel = this.getInputFields();
		JPanel buttonPanel = this.addActionButtons();

		this.currentFrame.add(topPanel, BorderLayout.NORTH);
		this.currentFrame.add(centerPanel, BorderLayout.CENTER);
		this.currentFrame.add(buttonPanel, BorderLayout.SOUTH);
	}

	private JPanel getInputFields() {
		JPanel overallPanel = new JPanel();
		
		JPanel topText = new JPanel();
		JLabel setsLabel = new JLabel("Enter number of Sets:       ");
		this.sets = new JTextField(20);
		topText.add(setsLabel);
		topText.add(this.sets);
		
		JPanel middleText = new JPanel();
		JLabel repsLabel = new JLabel("Enter number of Reps:       ");
		this.reps = new JTextField(20);
		middleText.add(repsLabel);
		middleText.add(this.reps);
		
		JPanel bottomText = new JPanel();
		JLabel weightLabel = new JLabel("Enter the Weight you would like to do:       ");
		this.weight=new JTextField(12);
		bottomText.add(weightLabel);
		bottomText.add(this.weight);

		overallPanel.add(topText,BorderLayout.NORTH);
		overallPanel.add(middleText,BorderLayout.CENTER);
		overallPanel.add(bottomText,BorderLayout.SOUTH);
		return overallPanel;
	}

	private JPanel addActionButtons() {
		JPanel panel = new JPanel();

		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!sets.getText().equals("") && !reps.getText().equals("") && !weight.getText().equals("")) {
					workoutData.add(new WorkoutData(new Date(), workoutType, Integer.parseInt(sets.getText()),
							Integer.parseInt(reps.getText()), Double.parseDouble(weight.getText())));
				}

				mainFrame.setVisible(true);
				currentFrame.dispose();
			}
		});

		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(true);
				currentFrame.dispose();

			}
		});

		panel.add(exit);
		panel.add(save);
		return panel;
	}

}
