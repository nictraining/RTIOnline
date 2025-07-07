package nic.rti.master.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PendingRequestRepositoryImpl implements PendingRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, Object> tupleToMap(Tuple tuple) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (TupleElement<?> elem : tuple.getElements()) {
            map.put(elem.getAlias(), tuple.get(elem));
        }
        return map;
    }

    @SuppressWarnings("unchecked")
private List<Map<String, Object>> executeTupleQuery(String sql, Map<String, Object> params) {
    Query query = entityManager.createNativeQuery(sql, Tuple.class);
    params.forEach(query::setParameter);

    List<Tuple> tuples = (List<Tuple>) query.getResultList();

    return tuples.stream().map(this::tupleToMap).collect(Collectors.toList());
}


    @Override
    public List<Map<String, Object>> getUnderProcess(String applId, int limit, int offset) {
        String sql = """
            SELECT A.registration_no, A.name,
                   TO_CHAR(A.recvd_date, 'DD/MM/YYYY') as recvd_date,
                   A.entry_date
            FROM \"RTIMIS\".appeal A
            JOIN \"RTIMIS\".action_history AH ON A.registration_no = AH.registration_no
            WHERE AH.action_srno = (
                SELECT MAX(action_srno)
                FROM \"RTIMIS\".action_history
                WHERE registration_no = A.registration_no
            )
            AND AH.action_status IN ('70', '7A', '7D', '7C')
            AND A.closing_date IS NULL
            AND A.\"ApplID\" = :applId
            ORDER BY A.entry_date DESC
            LIMIT :limit OFFSET :offset
        """;
        return executeTupleQuery(sql, Map.of("applId", applId, "limit", limit, "offset", offset));
    }

    @Override
    public List<Map<String, Object>> getCommentCpio(String applId, int limit, int offset) {
        String sql = """
            SELECT C.registration_no, A.name,
                   TO_CHAR(A.recvd_date, 'DD/MM/YYYY') as recvd_date,
                   A.entry_date,
                   P.\"Name\" as Name,
                   TO_CHAR(C.comments_date, 'DD/MM/YYYY') as comments_date,
                   C.comments
            FROM \"RTIMIS\".\"commentsCPIO\" C
            JOIN \"RTIMIS\".appeal A ON C.registration_no = A.registration_no
            JOIN \"RTIMIS\".\"PIODetails\" P ON A.cpio_app = P.pio_id
            WHERE C.flag = 'R'
              AND P.\"ActiveIdle\" = 'Y'
              AND A.closing_date IS NULL
              AND A.\"ApplID\" = :applId
            ORDER BY A.entry_date DESC
            LIMIT :limit OFFSET :offset
        """;
        return executeTupleQuery(sql, Map.of("applId", applId, "limit", limit, "offset", offset));
    }

    @Override
    public List<Map<String, Object>> getModify(String applId, int limit, int offset) {
        String sql = """
            SELECT registration_no, name,
                   TO_CHAR(recvd_date, 'DD/MM/YYYY') as recvd_date,
                   document_id, entry_date
            FROM \"RTIMIS\".appeal
            WHERE closing_date IS NULL
              AND \"ApplID\" = :applId
              AND registration_no NOT IN (
                  SELECT registration_no
                  FROM \"RTIMIS\".app_assessment_details
              )
            ORDER BY entry_date DESC
            LIMIT :limit OFFSET :offset
        """;
        return executeTupleQuery(sql, Map.of("applId", applId, "limit", limit, "offset", offset));
    }

    @Override
    public List<Map<String, Object>> getNew(String applId, int limit, int offset) {
        return getModify(applId, limit, offset);
    }

    @Override
    public List<Map<String, Object>> getPending20Days(String applId, int limit, int offset) {
        String sql = """
            WITH ApplCodeCTE AS (
                SELECT \"ApplCode\" FROM \"RTIMIS\".\"Appellate\"
                WHERE \"ApplId\" = :applId AND \"ActiveIdle\" = 'Y'
                LIMIT 1
            )
            SELECT DISTINCT A.registration_no, A.name,
                   TO_CHAR(A.recvd_date, 'DD/MM/YYYY') as recvd_date,
                   A.entry_date
            FROM \"RTIMIS\".appeal A
            WHERE A.closing_date IS NULL
              AND A.\"ApplID\" = :applId
              AND (CURRENT_DATE - DATE(A.recvd_date)) > 20
              AND A.registration_no NOT IN (
                  SELECT registration_no
                  FROM \"RTIMIS\".action_history AH
                  WHERE AH.action_status = '7C'
                    AND CAST(AH.do_code AS INTEGER) = (SELECT \"ApplCode\" FROM ApplCodeCTE)
              )
            ORDER BY A.entry_date DESC
            LIMIT :limit OFFSET :offset
        """;
        return executeTupleQuery(sql, Map.of("applId", applId, "limit", limit, "offset", offset));
    }
} 