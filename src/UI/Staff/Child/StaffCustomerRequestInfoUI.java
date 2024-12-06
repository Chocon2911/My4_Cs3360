package UI.Staff.Child;

import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import Util.GuiUtil;
import java.awt.BorderLayout;
import javax.swing.*;

public class StaffCustomerRequestInfoUI extends JFrame
{
    //==========================================Variable==========================================
    private CustomerRequest chosenCustomerRequest;

    //========================================Constructor=========================================
    public StaffCustomerRequestInfoUI() 
    {
        super("Staff.Main.CustomerRequest.Info");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setLayout(new BorderLayout());



        // ===Panel===
        // Panel
        JPanel panel = guiUtil.getMainPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Request Information");

        // Customer Request Info
        if (this.chosenCustomerRequest != null)
        {
            if (this.chosenCustomerRequest.getRequestedItems() != null)
            {
                for (RequestedItem reqItem : this.chosenCustomerRequest.getRequestedItems())
                {
                    if (reqItem == null) continue;

                    // Item Name Label
                }
            }
        }

        // Display

        

        // ===Button Panel===
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        // Delete Button
        JButton deleteButton = guiUtil.createButton("Delete", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(deleteButton);

        // Accept Button
        JButton acceptButton = guiUtil.createButton("Accept", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(acceptButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
    }

    //============================================Get=============================================
}
