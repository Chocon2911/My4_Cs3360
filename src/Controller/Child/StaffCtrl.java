package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Staff.StaffUI;

public class StaffCtrl extends AbstractObjCtrl
{
    private StaffUI staffUI;

    //========================================Constructor=========================================
    public StaffCtrl() { super(); }
    public StaffCtrl(String id) { super(id); }

    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info)
    {
        return new StaffDb().insertStaffData((Staff)info);
    }
    @Override
    @SuppressWarnings("unchecked")
    public final Staff queryInfo()
    {
        return new StaffDb().queryStaffData(id);
    }
    @Override 
    protected <T> String updateInfo(T info)
    {
        return new StaffDb().updateStaffData((Staff)info);
    }
}
