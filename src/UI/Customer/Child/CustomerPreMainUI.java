package UI.Customer.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class CustomerPreMainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton infoButton;
    private JButton joinShopButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public CustomerPreMainUI()
    {
        super("Customer.PreMain");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        this.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        this.setResizable(true);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Customer");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));

        // Infomation Button
        this.infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.infoButton);

        // JoinShop Button
        this.joinShopButton = guiUtil.createButton("Join Shop", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.joinShopButton);

        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.joinShopButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());

        this.add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getJoinShopButton() { return this.joinShopButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
