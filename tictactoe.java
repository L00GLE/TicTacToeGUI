import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.*;
import java.util.Random;

public class tictactoe extends JFrame
{
    private JFrame mainFrame;

    Random rand = new Random();

    private int randomOneOrZero = rand.nextInt(2);
    private int xo = randomOneOrZero;

    private JButton b[][] = {{new JButton("00"), new JButton("01"), new JButton("02")},
            {new JButton("10"), new JButton("11"), new JButton("12")},
            {new JButton("20"), new JButton("21"), new JButton("22")},
    };

    public tictactoe()
    {
        mainFrame = new JFrame("Tic-Tac-Toe");

        Container c = mainFrame.getContentPane();

        c.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                c.add(b[i][j]);
            }
        }

        mainFrame.setSize(600, 350);

        mainFrame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)    {System.exit(0);}
        });

        ButtonsHandler bh = new ButtonsHandler();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                b[i][j].addActionListener(bh);
            }
        }

        mainFrame.setVisible(true);
    }

    class ButtonsHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int counteri = 0;
            int counterj = 0;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (e.getSource() == b[i][j])
                    {
                        counteri = i;
                        counterj = j;
                    }
                }
            }

            if (xo == 1)
            {
                if (b[counteri][counterj].getIcon() == null || b[counteri][counterj].getIcon().toString() != "O.png")
                {
                    b[counteri][counterj].setIcon(new ImageIcon("x.png"));
                    b[counteri][counterj].setText("");
                    xo = 0;
                }
            }

            else if (xo == 0)
            {
                if (b[counteri][counterj].getIcon() == null || b[counteri][counterj].getIcon().toString() != "x.png")
                {
                    b[counteri][counterj].setIcon(new ImageIcon("O.png"));
                    b[counteri][counterj].setText("");
                    xo = 1;
                }
            }

            for (int i = 0; i < 3; i++)
            {
                if (b[i][0].getIcon() != null && b[i][1].getIcon() != null)
                {
                    if(b[i][0].getIcon().toString() == b[i][1].getIcon().toString()
                        && b[i][1].getIcon().toString() == b[i][2].getIcon().toString())
                    {
                        System.out.print("We have a winner!");
                        if (b[i][2].getIcon().toString() == "x.png")
                        {
                            System.out.println("X Wins!");
                            System.exit(0);
                        }
                        if (b[i][2].getIcon().toString() == "O.png")
                        {
                            System.out.println("O Wins!");
                            System.exit(0);
                        }
                    }
                }
            }

            for (int i = 0; i < 3; i++)
            {
                if (b[0][i].getIcon() != null && b[1][i].getIcon() != null && b[2][i].getIcon() != null)
                {
                    if (b[0][i].getIcon().toString() == b[1][i].getIcon().toString()
                    && b[1][i].getIcon().toString() == b[2][i].getIcon().toString())
                    {
                        System.out.println("X Wins!");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("O Wins!");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new tictactoe();
    }
}
