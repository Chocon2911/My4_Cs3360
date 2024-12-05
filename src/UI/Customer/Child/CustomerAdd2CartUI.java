package UI.Customer.Child;

import Util.GuiUtil;
import java.awt.BorderLayout;
import java.util.HashMap;
import javax.swing.*;

public class CustomerAdd2CartUI extends JFrame
{
    //==========================================Variable==========================================
    private HashMap<JButton, JLabel> button_Labels;
    
    private JButton backButton;

    //========================================Constructor=========================================
    public CustomerAdd2CartUI()
    {
        super("Customer.Add2Cart");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        this.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        this.setResizable(true);
        this.setLayout(new BorderLayout());



        // ===Main Panel===
        // Panel
        JPanel mainPanel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Item List");

        // Item Panel
        JPanel itemPanel = guiUtil.getMainPanel();
        for (JButton button : button_Labels.keySet())
        {
            itemPanel.add(button);
            itemPanel.add(button_Labels.get(button));
            itemPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        }

        // Display
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        mainPanel.add(itemPanel);
        mainPanel.add(Box.createVerticalGlue());



        // ===Scroll Pane===
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Back Button===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);

        // ===Display===
        this.add(backButton, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }

    //============================================Set=============================================
    public void setButton_Labels(HashMap<JButton, JLabel> button_Labels) { this.button_Labels = button_Labels; }
}
