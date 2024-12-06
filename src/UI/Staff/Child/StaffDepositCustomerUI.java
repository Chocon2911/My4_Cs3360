package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffDepositCustomerUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField amountTextField;
    
    // Button
    private JButton cancelButton;
    private JButton applyButton;
    
    //========================================Constructor=========================================
    public StaffDepositCustomerUI()
    {
        super("Staff.Main.Deposit");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);

        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Deposit Customer");



        // ===Amount Panel===
        // Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(panel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel amountLabel = guiUtil.getSmallLabel("Amount: $");

        // TextField
        this.amountTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        amountPanel.add(Box.createHorizontalGlue());
        amountPanel.add(amountLabel);
        amountPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        amountPanel.add(this.amountTextField);
        amountPanel.add(Box.createHorizontalGlue());


        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(panel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldWidth);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldWidth);

        // Apply Button
        this.applyButton = guiUtil.createButton("Apply", guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldWidth);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.applyButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(amountPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
    }

    //============================================Get=============================================
    // TextField
    public JTextField getAmountTextField() { return this.amountTextField; }

    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getApplyButton() { return this.applyButton; }
}
