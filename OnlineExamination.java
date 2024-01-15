package Assignments_Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineExamination extends JFrame {
    private int currentQuestionIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;

    private String[][] questions = {
            {"What is the capital of France?", "Berlin", "London", "Paris", "Madrid", "Paris"},
            {"Which programming language is used for Android development?", "Java", "Python", "C++", "Swift", "Java"},
            {"What is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus", "Blue Whale"}
            // Add more questions as needed
    };

    public OnlineExamination() {
        setTitle("Online Examination System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();

        displayQuestion();

        setVisible(true);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", JLabel.CENTER);
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].addActionListener(new OptionSelectedListener());
            optionsGroup.add(options[i]);
            optionsPanel.add(options[i]);
        }

        add(optionsPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        add(nextButton, BorderLayout.SOUTH);
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex][0]);

            for (int i = 0; i < 4; i++) {
                options[i].setText(questions[currentQuestionIndex][i + 1]);
                options[i].setSelected(false);
            }
        } else {
            showResult();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Exam completed. Your score: " + score);
        System.exit(0);
    }

    private class OptionSelectedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton selectedOption = (JRadioButton) e.getSource();
            String selectedAnswer = selectedOption.getText();

            if (selectedAnswer.equals(questions[currentQuestionIndex][5])) {
                score++;
            }
        }
    }

    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentQuestionIndex++;
            displayQuestion();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OnlineExamination());
    }
}

