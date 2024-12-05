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
    public CustomerPreMainUI getPreMainUI() { return preMainUI; }
    public CustomerInfoUI getInfoUI() { return infoUI; }
    public CustomerMainUI getMainUI() { return mainUI; }
    public CustomerJoinShopUI getJoinShopUI() { return joinShopUI; }
    public CustomerAdd2CartUI getAdd2CartUI() { return add2CartUI; }
    public CustomerItemInfoUI getItemInfoUI() { return itemInfoUI; }
    public CustomerRequestCartUI getRequestCartUI() { return requestCartUI; }
    public CustomerUnReqItemInfoUI getUnReqItemInfoUI() { return unReqItemInfoUI; }
}
