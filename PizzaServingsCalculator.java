package pizzaservingscalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaServingsCalculator extends JFrame {

    private final JPanel contentPane; 
    private final JLabel lblTitle; 
    private final JPanel inputPanel; 
    private final JLabel lblUsrInstruction; 
    private JTextField txtUsrInput; 
    private final JButton btnCalculate; 
    private final JLabel lblServingsResult; 

    public PizzaServingsCalculator() {

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(4, 1));
        setContentPane(contentPane);

        // Title Properties
        lblTitle = new JLabel("Pizza Servings Calculator");
        lblTitle.setForeground(Color.RED);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // Jpanel Setup
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        contentPane.add(inputPanel);

        
        lblUsrInstruction = new JLabel("Enter the size of the pizza in inches: ", 4);
        lblUsrInstruction.setFont(new Font("Arial", Font.BOLD, 11));

        // Input Field
        txtUsrInput = new JTextField();
        txtUsrInput.setColumns(5);

        // calculator Logic         
        btnCalculate = new JButton("Calculate Servings");
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 11));        
        btnCalculate.addActionListener(new ActionListener() {

            @Override 
            public void actionPerformed(ActionEvent e) {
                double size = Double.parseDouble(txtUsrInput.getText()); 
                if (size < 0) {                     
                    JOptionPane.showMessageDialog(contentPane, "Did you mean " + (int)(-1*size) + " inches?");                    
                    size = -1 * size;                    
                }
                double servings = Math.pow((size / 8.0), 2);
                lblServingsResult.setText(String.format("A %.0f inch pizza will serve %.2f people.", size, servings));
            }
        });
        lblServingsResult = new JLabel("");
        lblServingsResult.setFont(new Font("Arial", Font.BOLD, 11));
        lblServingsResult.setHorizontalAlignment(SwingConstants.CENTER);

        // adding all the UI components to Grid
        contentPane.add(lblTitle); 
        contentPane.add(inputPanel); 
        inputPanel.add(lblUsrInstruction);
        inputPanel.add(txtUsrInput);
        contentPane.add(btnCalculate); 
        contentPane.add(lblServingsResult); 
    }
    
    //main method
    public static void main(String args[]) {

        PizzaServingsCalculator PSCalculatorFrame = new PizzaServingsCalculator();

        //Frame SetUp
        PSCalculatorFrame.setTitle("Pizza Servings Calculator");
        PSCalculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PSCalculatorFrame.setVisible(true);
        PSCalculatorFrame.setSize(350, 300);
    }
}
