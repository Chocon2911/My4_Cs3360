package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffMainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton infoButton;
    private JButton depositCustomerButton;
    private JButton customerRequestButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public StaffMainUI()
    {
        super("Staff.Main");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Staff");

        // Information Button
        this.infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.infoButton);

        // DepositCustomer Button
        this.depositCustomerButton = guiUtil.createButton("Deposit Customer", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.depositCustomerButton);

        // CustomerRequest Button
        this.customerRequestButton = guiUtil.createButton("Customer Request", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.customerRequestButton);

        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.depositCustomerButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.customerRequestButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getDepositCustomerButton() { return this.depositCustomerButton; }
    public JButton getCustomerRequestButton() { return this.customerRequestButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
