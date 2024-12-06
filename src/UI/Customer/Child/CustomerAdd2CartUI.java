package UI.Customer.Child;

import Obj.Data.Item;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CustomerAdd2CartUI extends JFrame
{
    //==========================================Variable==========================================
    private final JPanel itemsPanel = new JPanel();
    private final JButton backButton;
    private final List<Item> items = new ArrayList<>();
    private final List<JButton> itemButtons = new ArrayList<>();
    private Item chosenItem;

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

        // Display
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        mainPanel.add(this.itemsPanel);
        mainPanel.add(Box.createVerticalGlue());



        // ===Scroll Pane===
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Back Button===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);

        // ===Display===
        this.add(this.backButton, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }
    public List<Item> getItems() { return this.items; }
    public List<JButton> getItemButtons() { return this.itemButtons; }

    //============================================Set=============================================
    public void setChosenItem(Item chosenItem)
    {
        this.chosenItem = chosenItem;
    }

    public void setItemsPanel(List<Item> items) 
    { 
        this.itemsPanel.removeAll();
        this.itemButtons.clear();

        for (Item item : items) 
        {
            JButton button = new JButton(item.getName());
            JLabel label = GuiUtil.getInstance().getNormalLabel("Price: $" + item.getPrice());
            
            this.itemsPanel.add(button);
            this.itemsPanel.add(label);
            this.itemsPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));

            this.itemButtons.add(button);
            this.items.add(item);
        }
    }
}
