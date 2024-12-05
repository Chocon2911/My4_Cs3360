package UI.Customer.Child;

import Util.GuiUtil;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerMainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton infoButton;
    private JButton add2CartButton;
    private JButton cartButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public CustomerMainUI()
    {
        super("Customer.Main");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        this.setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameHeight);
        this.setResizable(false);

        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Welcome to Shop");

        // Information Button
        this.infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.infoButton);

        // Add2Cart Button
        this.add2CartButton = guiUtil.createButton("Add2Cart", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.add2CartButton);

        // Cart Button
        this.cartButton = guiUtil.createButton("Cart", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.cartButton);

        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);
        
        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.add2CartButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.cartButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());
        
        this.add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getAdd2CartButton() { return this.add2CartButton; }
    public JButton getCartButton() { return this.cartButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
