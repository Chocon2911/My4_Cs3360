package UI.Customer.Child;

import Util.GuiUtil;
import javax.swing.*;

public class CustomerItemInfoUI extends JFrame
{
    //==========================================Variable==========================================
    private JPanel itemPanel = new JPanel();

    private JTextField amountTextField;
    private JButton cancelButton;
    private JButton addButton;

    //========================================Constructor=========================================
    public CustomerItemInfoUI()
    {
        super("Customer.AddToCart.ItemInfo");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        this.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        this.setResizable(true);

        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Item Information");



        // ===Amount Panel===
        // Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(panel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel amountLabel = guiUtil.getSmallLabel("Buy Amount: ");

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
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Add Button
        this.addButton = guiUtil.createButton("Add", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.addButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.addButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.itemPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(amountPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        // ===Scroll Pane===
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        this.add(scrollPane);
    }

    //============================================Get=============================================
    // TextField
    public String getAmount() { return this.amountTextField.getText(); }
    
    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getAddButton() { return this.addButton; }
}
