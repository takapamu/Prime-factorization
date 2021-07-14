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

    mid_panel = new JPanel();
    setPanel(mid_panel, Color.CYAN, null, new Dimension(480, 180 ));
    disp.add( mid_panel, BorderLayout.CENTER );

    setLabelFont(parent_lbl, Color.EHITE, 90, 10, 150, 20, 14, false);
    setLabelFont(parent_suit_lbl, Color.WHITE, 100, 10, 80, 100, 16, false);
    setLabelFont(parent_no_lbl, Color.WHITE, 100, 35, 80, 100, 16, true);

    child_lbl = new JLabel("あなたのカード");
    child_suit_lbl = new JLabel("");
    child_no_lbl = new JLabel("？");

    mid_panel.add(child_lbl);
    mid_panel.add(child_suit_lbl);
    mid_panel.add(child_no_lbl);

    setLabelFont(child_lbl, Color.EHITE, 265, 10, 150, 20, 14, false);
    setLabelFont(child_suit_lbl, Color.LIGHT_GRAY, 300, 10, 80, 100, 16, false);
    setLabelFont(child_no_lbl, Color.LIGHT_GRAY, 300, 35, 80, 100, 16, true);

    bottom_panel = new JPanel();
    setPanel( bottom_panel, Color.LIGHT_GRAY, new BorderLayout(), new Dimension(480, 50));
    disp.add(bottom_panel, BorderLayout.SOUTH);

    btn_high = new JButton("HIGH");
    setButton( btn_high, this, 240, 50, 20 );
    bottom_panel.add( btn_high, BorderLayout.WEST );

    btn_low = new JButton("LOW");
    setButton( btn_low, this, 240, 50, 20 );
    bottom_panel.add( btn_low, BorderLayout.EAST );

    disp.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    String cmd = e.getActionCommand();
    int parent_no = parent.GetNo();
    int child_no = child.GetNo();
    int child_suit = child.GetSuit();

    child_no_lbl.setBackground(Color.WHITE);
    child_no_lbl.setText( getNoStr( child.GetNo()));
    child_suit_lbl.setBackground(Color.WHITE);
    child_suit_lbl.ssetIcon( getSuitIcon( child_suit ));

    if ( cmd.equals("HIGH"))
    {

      btn_high.setBackground(Color.GREEN);

      if( parent_no < child_no )
        msg_lbl.setText("大正解、あなたの勝ちです！");
      else if (child_no < parent_no )
       msg_lbl.setText("不正解、あなたの負けです！");
      else
        msg_lbl.setText("奇遇ですね。引き分けです！");
    }
    else if ( cmd.equals("LOW"))
    {
      btn_low.setBackground(Color.GREEN);
      
      if( parent_no < child_no )
        msg_lbl.setText("大正解、あなたの勝ちです！");
      else if (child_no < parent_no )
        msg_lbl.setText("不正解、あなたの負けです！");
      else
        msg_lbl.setText("奇遇ですね。引き分けです！");

    }
      return;
  }


  //パネルのフォント設定を行う
}