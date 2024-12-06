package UI.Customer.Child;

import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

public class CustomerInfoUI extends JFrame 
{
    //==========================================Variable==========================================
    private JPanel infoPanel = new JPanel();
    private JButton backButton;

    //========================================Constructor=========================================
    public CustomerInfoUI()
    {
        super("Customer.Information");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        this.setSize(600, 700);
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Information");

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createHorizontalStrut(guiUtil.verticalStrut));
        panel.add(infoPanel);
        panel.add(Box.createVerticalGlue());


        
        // ===Back Panel===
        // Back Panel
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));

        // Back Button
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        // Display
        backPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        backPanel.add(this.backButton);



        // ===scrollPane===
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Display===
        this.add(backPanel, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }



    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setInfoPanel(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Private Info Panel===
        JPanel privateInfoPanel = this.displayPrivateInfo(customer);

        // ===CustomerRequest Info Panel===
        JPanel crInfoPanel = this.displayCustomerRequestInfo(customer);

        // ===UnRequestedItems Info Panel===
        JPanel unRisInfoPanel = this.displayUnRequestedItemsInfo(customer);

        // Display
        this.infoPanel.add(privateInfoPanel);
        this.infoPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        this.infoPanel.add(crInfoPanel);
        this.infoPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        this.infoPanel.add(unRisInfoPanel);
    }

    //========================================Private Info========================================
    private JPanel displayPrivateInfo(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Name Label
        JLabel nameLabel = guiUtil.getNormalLabel("Name: " + customer.getName());

        // UserName Label
        JLabel userNameLabel = guiUtil.getNormalLabel("UserName: " + customer.getUserName());

        // Password Label
        JLabel passwordLabel = guiUtil.getNormalLabel("Password: " + customer.getPassword());

        // ShopName Label
        JLabel shopNameLabel = guiUtil.getNormalLabel("Doesn't join Shop yet!");
        if (customer.getShop() != null)
        {
            shopNameLabel = guiUtil.getNormalLabel("ShopName: " + customer.getShop().getName());
        }

        // Display
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(userNameLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(passwordLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(shopNameLabel);

        return panel;
    }

    //====================================CustomerRequest Info====================================
    // Main
    private JPanel displayCustomerRequestInfo(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = this.getCustomerRequestsLabel();

        // CustomerRequests Panel
        JPanel crPanel = this.getCustomerRequestsPanel(customer);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(crPanel);

        return panel;
    }

    // Title Label
    private JLabel getCustomerRequestsLabel()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        JLabel titleLabel = new JLabel("Requests");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.normalTitleSize));

        return titleLabel;
    }

    // customerRequests Panel
    private JPanel getCustomerRequestsPanel(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // panel
        JPanel panel = guiUtil.getMainPanel();

        // Label
        int loop = 0;
        if (customer.getCustomerRequests() == null) return panel;
        for (CustomerRequest cr : customer.getCustomerRequests())
        {
            JLabel crLabel = guiUtil.getNormalLabel((loop + 1) + ". Name: " + cr.getName() + " - Total Money: " + cr.getTotalMoney());
            panel.add(crLabel);
            panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
            
            loop += 1;
        }

        return panel;
    }

    //====================================UnRequestedItem Info====================================
    // Panel
    private JPanel displayUnRequestedItemsInfo(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = this.getUnRequestedItemsLabel();

        // UnRequestedItems Panel
        JPanel unRequestedItemsPanel = this.getUnRequestedItemsPanel(customer);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(unRequestedItemsPanel);

        return panel;

    }

    // Title Label
    private JLabel getUnRequestedItemsLabel()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        JLabel titleLabel = new JLabel("UnRequestedItems");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.normalTitleSize));

        return titleLabel;
    }

    // UnRequestedItems Panel
    private JPanel getUnRequestedItemsPanel(Customer customer)
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // panel
        JPanel panel = guiUtil.getMainPanel();

        // Label
        int loop = 0;
        if (customer.getUnRequestedItems() == null) return panel;
        for (RequestedItem ri : customer.getUnRequestedItems())
        {
            JLabel itemLabel = guiUtil.getNormalLabel((loop + 1) + ". Name: " + ri.getItem().getName() + " - Price: " + ri.getTotalMoney());
            panel.add(itemLabel);
            panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
            loop++;
        }

        return panel;
    }
}
