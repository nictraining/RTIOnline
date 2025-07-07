// antika 

package nic.rti.master.dao;

import java.util.List;
import java.util.Map;

public interface PendingRequestRepository {
    List<Map<String, Object>> getUnderProcess(String applId, int limit, int offset);
    List<Map<String, Object>> getCommentCpio(String applId, int limit, int offset);
    List<Map<String, Object>> getModify(String applId, int limit, int offset);
    List<Map<String, Object>> getNew(String applId, int limit, int offset);
    List<Map<String, Object>> getPending20Days(String applId, int limit, int offset);
}
