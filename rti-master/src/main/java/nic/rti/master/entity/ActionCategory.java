package nic.rti.master.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "action_codes")
public class ActionCategory {

    @Id
    @Column(name = "action_code", length = 2)
    private String actionCode;

    @Column(name = "action_name", length = 60)
    private String actionName;

    @Column(name = "show_action_name", length = 100)
    private String showActionName;

    @Column(name = "U_show_action_name", length = 100)
    private String uShowActionName;

    public String getActionCode() {
        return actionCode;
    }

    public String getActionName() {
        return actionName;
    }

    public String getShowActionName() {
        return showActionName;
    }

    public String getuShowActionName() {
        return uShowActionName;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setShowActionName(String showActionName) {
        this.showActionName = showActionName;
    }

    public void setuShowActionName(String uShowActionName) {
        this.uShowActionName = uShowActionName;
    }
}
