package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffPreMainUI extends JFrame
{
    //==========================================Variable==========================================
    private final JButton infoButton;
    private final JButton joinShopButton;
    private final JButton quitButton;

    //========================================Constructor=========================================
    public StaffPreMainUI() 
    {
        super("Staff.PreMain");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Staff");

        // Information Button
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
        panel.add(Box.createVerticalGlue());
        panel.add(this.infoButton);
        panel.add(Box.createVerticalGlue());
        panel.add(this.joinShopButton);
        panel.add(Box.createVerticalGlue());
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getJoinShopButton() { return this.joinShopButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
