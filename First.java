import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

class First extends Frame implements ActionListener {

    Button b = new Button("Division");
    Label l1 = new Label("Enter the first number");
    TextField t1 = new TextField();
    Label l2 = new Label("Enter the second number");
    TextField t2 = new TextField();
    Label ans = new Label("Answer");
    TextField result = new TextField("Click button for answer");

    Dialog d = new Dialog(new Frame(),"Error dialog", true);
    TextField errText = new TextField();

    First() {
        b.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b);
        add(ans);
        add(result);
        setSize(400, 400);
        setLayout(new GridLayout(7, 1));
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);

        b.setBackground(Color.darkGray);

        d.add(errText);
        d.setSize(350, 350);

        // close the window on clicking cross
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // hide dialog box on clicking cross
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                d.setVisible(false);
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        try {
            final int i = Integer.parseInt(t1.getText());
            final int j = Integer.parseInt(t2.getText());
            result.setText(String.valueOf(i / j));
        } catch (NumberFormatException err) {
            errText.setText("Please enter numbers in the text-boxes");
            d.setVisible(true);
        } catch (ArithmeticException err) {
            errText.setText("Please enter a non-zero number in the second text-box");
            d.setVisible(true);
        }
    }

    public static void main(String args[]) {

        new First();

    }
}