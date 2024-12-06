package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Customer.Child.*;
import UI.Customer.CustomerUI;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CustomerCtrl extends AbstractObjCtrl
{
    private CustomerUI customerUI;

    //========================================Constructor=========================================
    public CustomerCtrl()
    {
        super();
        this.customerUI = new CustomerUI();

        this.defaultPreMainUI();
        this.defaultInfoUI();
        this.defaultMainUI();
        this.defaultJoinShopUI();
        this.defaultAdd2CartUI();
        this.defaultItemInfoUI();
        this.defaultRequestCartUI();
        this.defaultUnReqItemInfoUI();
    }

    public CustomerCtrl(String id)
    {
        super(id);
        this.customerUI = new CustomerUI();

        this.defaultPreMainUI();
        this.defaultInfoUI();
        this.defaultMainUI();
        this.defaultJoinShopUI();
        this.defaultAdd2CartUI();
        this.defaultItemInfoUI();
        this.defaultRequestCartUI();
        this.defaultUnReqItemInfoUI();
    }

    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info) 
    { 
        return CustomerDb.getInstance().insertCustomerData((Customer)info); 
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Customer queryInfo()
    {
        if (this.id == null) return null;
        Customer customer = CustomerDb.getInstance().queryCustomerData(id);

        // Get CustomerRequests of Customer From Db
        List<CustomerRequest> crs = new ArrayList<>();
        for (CustomerRequest cr : customer.getCustomerRequests())
        {
            CustomerRequest newCr = CustomerRequestDb.getInstance().queryCustomerRequestData(cr.getId());
            List<RequestedItem> ris = new ArrayList<>();
            // Get RequestedItems of CustomerRequest From Db
            for (RequestedItem ri : newCr.getRequestedItems())
            {
                RequestedItem newRi = RequestedItemDb.getInstance().queryRequestedItemData(ri.getId());
                ris.add(newRi);
            }
            
            newCr.setRequestedItems(ris);
            crs.add(newCr);
        }
        
        customer.setCustomerRequests(crs);
        return customer;
    }

    @Override
    protected <T> String updateInfo(T info)
    {
        return CustomerDb.getInstance().updateCustomerData((Customer)info);
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //=========================================PreMain UI=========================================
    private void defaultPreMainUI()
    {
        CustomerPreMainUI preMainUI = this.customerUI.getPreMainUI();
        this.setDefaultClose(preMainUI);

        // Info Button
        preMainUI.getInfoButton().addActionListener((ActionEvent e) -> 
        {
            preMainUI.setVisible(false);
            this.customerUI.getInfoUI().setVisible(true);
        });

        // JoinShop Button
        preMainUI.getJoinShopButton().addActionListener((ActionEvent e) -> 
        {
            preMainUI.setVisible(false);
            this.customerUI.getJoinShopUI().setVisible(true);
        });

        // Quit Button
        preMainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            if (!logout())
            {
                System.out.println("Log out failed");
            }

            System.exit(0);
        });
    }

    //==========================================Info UI===========================================
    private void defaultInfoUI()
    {
        CustomerInfoUI infoUI = this.customerUI.getInfoUI();
        this.setDefaultClose(infoUI);

        // Back Button
        infoUI.getBackButton().addActionListener((ActionEvent e) -> 
        {
            infoUI.setVisible(false);
            int backButtonPressed = this.backButtonPressed();
            if (backButtonPressed == 1) this.customerUI.getMainUI().setVisible(true); // Test
            else if (backButtonPressed == 2) this.customerUI.getPreMainUI().setVisible(true);
            else if (backButtonPressed == 0) this.customerUI.getMainUI().setVisible(true);
        });
    }

    //========================================JoinShop UI=========================================
    private void defaultJoinShopUI()
    {
        CustomerJoinShopUI joinShopUI = this.customerUI.getJoinShopUI();
        this.setDefaultClose(joinShopUI);

        // Join Button
        joinShopUI.getJoinButton().addActionListener((ActionEvent e) -> 
        {
            System.out.println("//=========================================Join Shop==========================================");

            String checkInCode = joinShopUI.getCheckInCode();

            int joinShop = this.joinShop(checkInCode);
            if (joinShop == 1) // Wrong CheckInCode
            {
                System.out.println("joinShop(): Wrong CheckInCode: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode!");
            }
            else if (joinShop == 2) // Shop is not online
            {
                System.out.println("joinShop(): Shop is not online: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode");
            } 
            else // Success
            {
                JOptionPane.showMessageDialog(null, "Join Shop successfully");
                joinShopUI.setVisible(false);
                this.customerUI.getPreMainUI().setVisible(true);
            }
        });

        // Cancel Button
        joinShopUI.getCancelButton().addActionListener((ActionEvent e) -> 
        {
            joinShopUI.setVisible(false);
            this.customerUI.getPreMainUI().setVisible(true);
        });
    }

    //==========================================Main UI===========================================
    private void defaultMainUI()
    {
        CustomerMainUI mainUI = this.customerUI.getMainUI();
        this.setDefaultClose(mainUI);

        // Info Button
        mainUI.getInfoButton().addActionListener((ActionEvent e) -> 
        {
            mainUI.setVisible(false);
            this.customerUI.getInfoUI().setVisible(true);
        });

        // Add2Cart Button
        mainUI.getAdd2CartButton().addActionListener((ActionEvent e) -> 
        {
            mainUI.setVisible(false);
            this.customerUI.getAdd2CartUI().setVisible(true);
        });

        // Cart Button
        mainUI.getCartButton().addActionListener((ActionEvent e) -> 
        {
            mainUI.setVisible(false);
            this.customerUI.getRequestCartUI().setVisible(true);
        });

        // Quit Button
        mainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            if (!logout())
            {
                System.out.println("Log out failed");
            }

            System.exit(0);
        });
    }

    //========================================Add2Cart UI=========================================
    private void defaultAdd2CartUI()
    {
        CustomerAdd2CartUI add2CartUI = this.customerUI.getAdd2CartUI();
        this.setDefaultClose(add2CartUI);

        // Back Button
        add2CartUI.getBackButton().addActionListener((ActionEvent e) -> 
        {
            add2CartUI.setVisible(false);
            this.customerUI.getMainUI().setVisible(true);
        });

        // item Buttons
        for (JButton itemButton : add2CartUI.getItemButtons())
        {
            itemButton.addActionListener((ActionEvent e) -> 
            {
                add2CartUI.setVisible(false);
                this.customerUI.getItemInfoUI().setVisible(true);
            });
        }
    }

    //========================================ItemInfo UI=========================================
    private void defaultItemInfoUI()
    {
        
    }

    //=======================================RequestCart UI=======================================
    private void defaultRequestCartUI()
    {

    }

    //=======================================UnReqItemInfo========================================
    private void defaultUnReqItemInfoUI()
    {

    }



    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================

    //========================================Information=========================================
    private int backButtonPressed()
    {
        Customer customer = this.queryInfo();
        if (customer == null) // Customer not found
        {
            System.out.println("backButton(): Customer not found");
            return 1;
        }
        else if (customer.getShop() == null) // Doesn't join Shop yet
        {
            System.out.println("backButton(): Doesn't join Shop");
            return 2;
        }

        return 0; // Joined Shop
    }

    //=========================================Join Shop==========================================
    private int joinShop(String checkInCode) 
    { 
        Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkInCode);
        if (shop == null) return 1; // No Shop with CheckInCode 
        else if (!shop.getIsLogin()) return 2; // Shop is not online yet
        else return 0; // Joined Shop success 
    }

    //===========================================Other============================================
    private boolean logout()
    {
        Customer customer = this.queryInfo();
        if (customer == null)
        {
            System.out.println("logout(): Error: Customer not found");
            return false;
        }

        customer.setIsLogin(false);
        this.updateInfo(customer);
        return true;
    }
    
    private void setDefaultClose(JFrame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (!logout())
                {
                    System.out.println("Log out failed");
                }

                System.exit(0);
            }
        });
    }

    //============================================Test============================================
    public static void main(String[] args)
    {
        new CustomerCtrl().customerUI.getMainUI().setVisible(true);
    }
}
