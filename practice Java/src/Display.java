import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Display implements ActionListener
{
  private JFrame disp;

  private JPanel top_panel, mid_panel, bottom_panel;

  private JLabel msg_lbl;

  private JLabel parent_lbl, parent_suit_lbl, parent_no_lbl;

  private JLabel child_lbl, child_suit_lbl, child_no_lbl;

  private JButton btn_high, btn_low;

  private Player parent, child;

  public Display( Player prn, Player chl )
  {

    parent = prn;
    child = chl;

    disp = new JFrame("HIGH & LOW ");
    disp.setSize(480, 280);
    disp.setLocationRelativeTo(null);
    disp.setDefaultCloseOperation(JFrame.EaIT_ON_CLOSE);
    disp.setResizeable(false);

    top_panel = new JPanel();
    setPanel(top_panel, Color.ORANGE, null new Dimension(480, 50));
    disp.add( top_panel, BorderLayout.NORTH );

    msg_lbl = new JLabel("一発勝負!HIGHかLOWか当ててください。");
    top_panel.add(msg_lbl);
    setLabelFont(msg_lbl, Color.BLACK, 0, 15, 480, 20, 20, false);

     //ミドルパネルの表示設定

    mid_panel = new JPanel();
    setPanel(mid_panel, Color.CYAN, null, new Dimension(480, 180 ));
    disp.add( mid_panel, BorderLayout.CENTER );

  }
}