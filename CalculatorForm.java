import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorForm {
    private JTextField displayField;
    private JPanel calculatorView;
    private JButton buttonMinusPlus;
    private JButton buttonCE;
    private JButton buttonDot;
    private JButton buttonCLS;
    private JButton buttonEqual;
    private JButton buttonDivide;
    private JButton buttonMultiply;
    private JButton buttonSub;
    private JButton buttonAdd;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    enum CalcOP {NONE, ADD, SUB, MULTIPLY, DIVIDE};
    private boolean isDigitalEnterMode = false;
    private String displayString = "";
    private double result = 0; private CalcOP lastOP = CalcOP.NONE;


    public CalculatorForm()
    {
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterDigit("9");
            }
        });

        //OPPERATION

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.ADD);
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.SUB);
            }
        });
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.MULTIPLY);
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.DIVIDE);
            }
        });
        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evalLastOP(CalcOP.NONE);
            }
        });
        buttonCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isDigitalEnterMode = false;
                displayField.setText("0");
            }
        });
        buttonCLS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result = 0;
                lastOP = CalcOP.NONE;
                isDigitalEnterMode = false;
                displayField.setText("0.0");
            }
        });
        buttonMinusPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = displayField.getText();
                if(text == "0.0")
                    return;
                char fist_c = text.charAt(0);
                if(fist_c == '-')
                    displayField.setText(text.substring(1));
                else
                    displayField.setText("-"+text);
            }
        });
    }

    public void testClick(String button) throws Exception
    {
        switch (button)
        {
            case "+":
                buttonAdd.doClick();
                break;
            case "-":
                buttonSub.doClick();
                break;
            case "×":
                buttonMultiply.doClick();
                break;
            case "÷":
                buttonDivide.doClick();
                break;
            case ".":
                buttonDot.doClick();
                break;
            case "=":
                buttonEqual.doClick();
                break;
            case "±":
                buttonMinusPlus.doClick();
                break;
            case "CE":
                buttonCE.doClick();
                break;
            case "CLEAR":
                buttonCLS.doClick();
                break;
            case "0":
                button0.doClick();
                break;
            case "1":
                button1.doClick();
                break;
            case "2":
                button2.doClick();
                break;
            case "3":
                button3.doClick();
                break;
            case "4":
                button4.doClick();
                break;
            case "5":
                button5.doClick();
                break;
            case "6":
                button6.doClick();
                break;
            case "7":
                button7.doClick();
                break;
            case "8":
                button8.doClick();
                break;
            case "9":
                button9.doClick();
                break;
            default:
                throw new Exception("Error! No button" + button);
        }
    }

    private void enterDigit(String digit)
    {
        if (!isDigitalEnterMode)
        {
            if (digit == ".")
                displayString = "0.";
            else
                displayString = digit;
            isDigitalEnterMode = true;
        }
        else
        {
            if (displayString == "0" && digit != ".")
                return;
            displayString += digit;
        }
        displayField.setText(displayString);
    }

    private void evalLastOP(CalcOP currOP)
    {
        double value = Double.parseDouble(displayField.getText());
        try
        {
            switch (lastOP)
                {
                    case ADD : result += value; break;
                    case SUB : result -= value; break;
                    case MULTIPLY : result *= value; break;
                    case DIVIDE : result /= value; break;
                    default: result = value; break;
                }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog( null, e.getMessage());
        }

        displayField.setText(Double.toString(result));
        isDigitalEnterMode = false;
        lastOP = currOP;
    }

    public void showWindow()
    {
        JFrame frame = new JFrame("CALCULATOR");
        frame.setContentPane(new CalculatorForm().calculatorView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public double getResult()
    {
        return result;
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("CalculatorForm");
        frame.setContentPane(new CalculatorForm().calculatorView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
