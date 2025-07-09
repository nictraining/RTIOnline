package nic.rti.master.entity;

import java.io.Serializable;
import java.util.Objects;

public class ActionHistoryId implements Serializable {

    private String registrationNo;
    private Integer actionSrno;

    // equals and hashCode required for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionHistoryId)) return false;
        ActionHistoryId that = (ActionHistoryId) o;
        return Objects.equals(registrationNo, that.registrationNo) &&
                Objects.equals(actionSrno, that.actionSrno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNo, actionSrno);
    }

    // Required: Getters and Setters (or use Lombok @Data if allowed)
}
