package UI.Customer.Other;

import Obj.Data.Item;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CustomerShoppingItem 
{
    //==========================================Variable==========================================
    private Item item;
    private JButton button;
    private JLabel priceLabel;

    //========================================Constructor=========================================
    public CustomerShoppingItem() 
    {
        this.item = null;
        this.button = new JButton();
        this.priceLabel = new JLabel();
    }

    //============================================Get=============================================
    public Item getItem() { return this.item; }
    public JButton getButton() { return this.button; }
    public JLabel getPriceLabel() { return this.priceLabel; }

    //============================================Set=============================================
    public void setItem(Item item)
    {
        this.item = item;
        this.button.setText(item.getName());
        this.priceLabel.setText("Price: $" + item.getPrice());
    }
}
