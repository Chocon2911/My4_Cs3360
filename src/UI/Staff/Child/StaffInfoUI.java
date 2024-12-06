package UI.Staff.Child;

import Obj.Data.Staff;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;

public class StaffInfoUI extends JFrame
{
    //==========================================Variable==========================================
    private final JPanel infoPanel = new JPanel();
    private final JButton backButton;

    //========================================Constructor=========================================
    public StaffInfoUI()
    {
        super("Staff.Main.Infomation");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setLayout(new BorderLayout());



        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Information");

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoPanel);
        panel.add(Box.createVerticalGlue());



        // ===BackButton===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        // ===Display===
        add(panel, BorderLayout.CENTER);
        add(this.backButton, BorderLayout.WEST);

        setVisible(true);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }

    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setInfoPanel(Staff staff)
    {
        this.infoPanel.removeAll();
        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        if (staff == null) return;

        // Name Label
        JLabel nameLabel = GuiUtil.getInstance().getNormalLabel("Name: " + staff.getName());

        // UserName Label
        JLabel userNameLabel = GuiUtil.getInstance().getNormalLabel("User Name: " + staff.getUserName());

        // Password Label
        JLabel passwordLabel = GuiUtil.getInstance().getNormalLabel("Password: " + staff.getPassword());

        // ShopName Label
        JLabel shopNameLabel = GuiUtil.getInstance().getNormalLabel("Doesn't join Shop yet!");
        if (staff.getShop() != null)
        {
            shopNameLabel = GuiUtil.getInstance().getNormalLabel("Shop Name: " + staff.getShop().getName());
        }

        // Display
        this.infoPanel.add(nameLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(userNameLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(passwordLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(shopNameLabel);
    }
}
