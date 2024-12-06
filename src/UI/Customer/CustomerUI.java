package UI.Customer;

import UI.Customer.Child.*;

public class CustomerUI 
{
    //==========================================Variable==========================================
    private CustomerPreMainUI preMainUI;
    private CustomerInfoUI infoUI;
    private CustomerMainUI mainUI;
    private CustomerJoinShopUI joinShopUI;
    private CustomerAdd2CartUI add2CartUI;
    private CustomerItemInfoUI itemInfoUI;
    private CustomerRequestCartUI requestCartUI;
    private CustomerUnReqItemInfoUI unReqItemInfoUI;

    //========================================Constructor=========================================
    public CustomerUI()
    {
        this.preMainUI = new CustomerPreMainUI();
        this.infoUI = new CustomerInfoUI();
        this.mainUI = new CustomerMainUI();
        this.joinShopUI = new CustomerJoinShopUI();
        this.add2CartUI = new CustomerAdd2CartUI();
        this.itemInfoUI = new CustomerItemInfoUI();
        this.requestCartUI = new CustomerRequestCartUI();
        this.unReqItemInfoUI = new CustomerUnReqItemInfoUI();
    }

    //============================================Get=============================================
    public CustomerPreMainUI getPreMainUI() { return this.preMainUI; }
    public CustomerInfoUI getInfoUI() { return this.infoUI; }
    public CustomerMainUI getMainUI() { return this.mainUI; }
    public CustomerJoinShopUI getJoinShopUI() { return this.joinShopUI; }
    public CustomerAdd2CartUI getAdd2CartUI() { return this.add2CartUI; }
    public CustomerItemInfoUI getItemInfoUI() { return this.itemInfoUI; }
    public CustomerRequestCartUI getRequestCartUI() { return this.requestCartUI; }
    public CustomerUnReqItemInfoUI getUnReqItemInfoUI() { return this.unReqItemInfoUI; }
}
