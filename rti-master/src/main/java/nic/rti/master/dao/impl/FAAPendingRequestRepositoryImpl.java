package nic.rti.master.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.Data;
import nic.rti.master.dao.FAAPendingRequestRepository;
import nic.rti.master.dto.PendingRequestResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class FAAPendingRequestRepositoryImpl implements FAAPendingRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PendingRequestResponseDTO> fetchUnderProcess(Integer applId, Integer limit, Integer offset) {
        String sql = """
                SELECT a.registration_no,
                       a.name,
                       TO_CHAR(a.recvd_date,'DD/MM/YYYY') AS recv_date,
                       TO_CHAR(a.entry_date,'YY-MM-DD"T"HH24:MI:SS"Z"') AS entry_date
                FROM RTIMIS.appeal a
                JOIN (
                    SELECT registration_no, MAX(action_srno) AS max_srno
                    FROM RTIMIS.action_history
                    GROUP BY registration_no
                ) max_actions ON a.registration_no = max_actions.registration_no
                JOIN RTIMIS.action_history ah ON ah.registration_no = max_actions.registration_no
                                               AND ah.action_srno = max_actions.max_srno
                WHERE ah.action_status IN ('70','7A','7D','7C')
                  AND a.closing_date IS NULL
                  AND a.applid = :applId
                ORDER BY a.entry_date DESC
                LIMIT :limit OFFSET :offset
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        List<Object[]> rows = query.getResultList();
        List<PendingRequestResponseDTO> dtoList = new ArrayList<>();

        for (Object[] row : rows) {
            PendingRequestResponseDTO dto = new PendingRequestResponseDTO();
            dto.setRegistrationNo((String) row[0]);
            dto.setName((String) row[1]);
            dto.setRecvDate((String) row[2]);
            dto.setEntryDate((String) row[3]);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public long countUnderProcess(Integer applId) {
        String sql = """
                SELECT COUNT(*) 
                FROM RTIMIS.appeal a
                JOIN (
                    SELECT registration_no, MAX(action_srno) AS max_srno
                    FROM RTIMIS.action_history
                    GROUP BY registration_no
                ) max_actions ON a.registration_no = max_actions.registration_no
                JOIN RTIMIS.action_history ah ON ah.registration_no = max_actions.registration_no
                                               AND ah.action_srno = max_actions.max_srno
                WHERE ah.action_status IN ('70','7A','7D','7C')
                  AND a.closing_date IS NULL
                  AND a.applid = :applId
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }

    @Override
    public List<PendingRequestResponseDTO> fetchCommentCPIO(Integer applId, Integer limit, Integer offset) {
        String sql = """
                SELECT c.registration_no,
                       a.name,
                       TO_CHAR(a.recvd_date,'DD/MM/YYYY') AS recv_date,
                       TO_CHAR(a.entry_date,'YY-MM-DD"T"HH24:MI:SS"Z"') AS entry_date,
                       c.comments_date,
                       c.comments,
                       p."Name" AS pio_name
                FROM RTIMIS.commentsCPIO c
                JOIN RTIMIS.appeal a ON c.registration_no = a.registration_no
                JOIN RTIMIS.PIODetails p ON a.cpio_app = p.pio_id
                WHERE c.flag = 'R'
                  AND p."ActiveIdle" = 'Y'
                  AND a.closing_date IS NULL
                  AND a.applid = :applId
                ORDER BY a.entry_date DESC
                LIMIT :limit OFFSET :offset
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        List<Object[]> rows = query.getResultList();
        List<PendingRequestResponseDTO> result = new ArrayList<>();

        for (Object[] row : rows) {
            PendingRequestResponseDTO dto = new PendingRequestResponseDTO();
            dto.setRegistrationNo((String) row[0]);
            dto.setName((String) row[1]);
            dto.setRecvDate((String) row[2]);
            dto.setEntryDate((String) row[3]);
            dto.setCommentsDate(row[4] != null ? row[4].toString() : null);
            dto.setComments((String) row[5]);
            dto.setPioName((String) row[6]);
            result.add(dto);
        }

        return result;
    }

    @Override
    public long countCommentCPIO(Integer applId) {
        String sql = """
                SELECT COUNT(*)
                FROM RTIMIS.commentsCPIO c
                JOIN RTIMIS.appeal a ON c.registration_no = a.registration_no
                JOIN RTIMIS.PIODetails p ON a.cpio_app = p.pio_id
                WHERE c.flag = 'R'
                  AND p."ActiveIdle" = 'Y'
                  AND a.closing_date IS NULL
                  AND a.applid = :applId
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }

    @Override
    public List<PendingRequestResponseDTO> fetchModify(Integer applId, Integer limit, Integer offset) {
        String sql = """
            SELECT registration_no,
                   name,
                   TO_CHAR(recvd_date,'DD/MM/YYYY') AS recvd_date,
                   document_id,
                   TO_CHAR(entry_date,'YYYY-MM-DD"T"HH24:MI:SS"Z"') AS entry_date
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND registration_no NOT IN (
                  SELECT registration_no FROM RTIMIS.app_assessment_details
              )
            ORDER BY entry_date DESC
            LIMIT :limit OFFSET :offset
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        List<Object[]> rows = query.getResultList();
        List<PendingRequestResponseDTO> result = new ArrayList<>();

        for (Object[] row : rows) {
            PendingRequestResponseDTO dto = new PendingRequestResponseDTO();
            dto.setRegistrationNo((String) row[0]);
            dto.setName((String) row[1]);
            dto.setRecvDate((String) row[2]);
            dto.setDocumentId((String) row[3]);
            dto.setEntryDate((String) row[4]);
            result.add(dto);
        }

        return result;
    }

    @Override
    public long countModify(Integer applId) {
        String sql = """
            SELECT COUNT(*)
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND registration_no NOT IN (
                  SELECT registration_no FROM RTIMIS.app_assessment_details
              )
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }

    @Override
    public List<PendingRequestResponseDTO> fetchNew(Integer applId, Integer limit, Integer offset) {
        String sql = """
            SELECT registration_no,
                   name,
                   TO_CHAR(recvd_date, 'DD/MM/YYYY') AS recvd_date,
                   TO_CHAR(entry_date, 'YYYY-MM-DD"T"HH24:MI:SS"Z"') AS entry_date
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND registration_no NOT IN (
                  SELECT registration_no FROM RTIMIS.action_history
              )
            ORDER BY entry_date DESC
            LIMIT :limit OFFSET :offset
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        List<Object[]> rows = query.getResultList();
        List<PendingRequestResponseDTO> result = new ArrayList<>();

        for (Object[] row : rows) {
            PendingRequestResponseDTO dto = new PendingRequestResponseDTO();
            dto.setRegistrationNo((String) row[0]);
            dto.setName((String) row[1]);
            dto.setRecvDate((String) row[2]);
            dto.setEntryDate((String) row[3]);
            result.add(dto);
        }

        return result;
    }

    @Override
    public long countNew(Integer applId) {
        String sql = """
            SELECT COUNT(*)
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND registration_no NOT IN (
                  SELECT registration_no FROM RTIMIS.action_history
              )
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }

    @Override
    public List<PendingRequestResponseDTO> fetchPending20Days(Integer applId, Integer limit, Integer offset) {
        String sql = """
            SELECT registration_no,
                   name,
                   TO_CHAR(recvd_date, 'DD/MM/YYYY') AS recvd_date,
                   TO_CHAR(entry_date, 'YYYY-MM-DD"T"HH24:MI:SS"Z"') AS entry_date
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND entry_date <= NOW() - INTERVAL '20 days'
            ORDER BY entry_date DESC
            LIMIT :limit OFFSET :offset
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        query.setParameter("limit", limit);
        query.setParameter("offset", offset);

        List<Object[]> rows = query.getResultList();
        List<PendingRequestResponseDTO> result = new ArrayList<>();

        for (Object[] row : rows) {
            PendingRequestResponseDTO dto = new PendingRequestResponseDTO();
            dto.setRegistrationNo((String) row[0]);
            dto.setName((String) row[1]);
            dto.setRecvDate((String) row[2]);
            dto.setEntryDate((String) row[3]);
            result.add(dto);
        }

        return result;
    }

    @Override
    public long countPending20Days(Integer applId) {
        String sql = """
            SELECT COUNT(*)
            FROM RTIMIS.appeal
            WHERE closing_date IS NULL
              AND applid = :applId
              AND entry_date <= NOW() - INTERVAL '20 days'
            """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("applId", applId);
        Object result = query.getSingleResult();
        return ((Number) result).longValue();
    }
}
