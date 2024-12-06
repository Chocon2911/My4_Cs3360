package UI.Staff;

import UI.Staff.Child.*;

public class StaffUI 
{
    //==========================================Variable==========================================
    private StaffPreMainUI preMainUI;
    private StaffMainUI mainUI;
    private StaffInfoUI infoUI;
    private StaffDepositCustomerUI depositCustomerUI;
    private StaffCustomerRequestUI customerRequestUI;
    private StaffCustomerRequestInfoUI customerRequestInfoUI;

    //========================================Constructor=========================================
    public StaffUI()
    {
        this.preMainUI = new StaffPreMainUI();
        this.mainUI = new StaffMainUI();
        this.infoUI = new StaffInfoUI();
        this.depositCustomerUI = new StaffDepositCustomerUI();
        this.customerRequestUI = new StaffCustomerRequestUI();
        this.customerRequestInfoUI = new StaffCustomerRequestInfoUI();
    }

    //============================================Get=============================================
    public StaffPreMainUI getPreMainUI() { return this.preMainUI; }
    public StaffMainUI getMainUI() { return this.mainUI; }
    public StaffInfoUI getInfoUI() { return this.infoUI; }
    public StaffDepositCustomerUI getDepositCustomerUI() { return this.depositCustomerUI; }
    public StaffCustomerRequestUI getCustomerRequestUI() { return this.customerRequestUI; }
    public StaffCustomerRequestInfoUI getCusteomRequestInfoUI() { return this.customerRequestInfoUI; }
}
