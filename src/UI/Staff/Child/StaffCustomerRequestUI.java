package UI.Staff.Child;

import Obj.Data.CustomerRequest;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StaffCustomerRequestUI extends JFrame
{
    //==========================================Variable==========================================
    // Frame
    private JPanel customerReqsPanel = new JPanel();
    private JButton backButton;
    
    // customerReqsPanel
    private List<JButton> customerReqButtons = new ArrayList<>();
    private List<CustomerRequest> customerReqs = new ArrayList<>();
    private CustomerRequest chosenCustomerReq;

    //========================================Constructor=========================================
    public StaffCustomerRequestUI() 
    {
        super("Staff.Main.CustomerRequest");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setLayout(new BorderLayout());



        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Customer Request");
        
        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.customerReqsPanel);
        panel.add(Box.createVerticalGlue());

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Back Button===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.backButton);

        // ===Display===
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }

    //============================================Set=============================================
    public void setCustomerReqsPanel(List<CustomerRequest> customerReqs)
    {
        this.customerReqsPanel.removeAll();
        GuiUtil guiUtil = GuiUtil.getInstance();
        for (CustomerRequest customerReq : customerReqs)
        {
            // Button
            if (customerReq != null) 
            {
                System.out.println("setCsPanel(): A customerRequest is null");
                continue;
            }

            JButton customerReqButton = guiUtil.createButton(
                customerReq.getRequestedCustomer().getName() + " - " + customerReq.getId(), 
                guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);

            // Panel
            this.customerReqsPanel.add(customerReqButton);
            this.customerReqsPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));

            this.customerReqButtons.add(customerReqButton);
            this.customerReqs.add(customerReq);
        }
    }
}
