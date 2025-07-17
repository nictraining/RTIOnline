package nic.rti.master.dao;

import nic.rti.master.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = """
        SELECT * FROM "Request" r
        WHERE r.org_code = :orgCode
          AND (r.pio_id IS NULL OR r.pio_id = 0)
          AND r.request_status = 'N'
          AND (r.current_action_status = '4M' OR r.current_action_status = '00' OR r.current_action_status IS NULL)
          AND r.closing_date IS NULL
          AND SUBSTRING(r.registration_no, 14, 1) <> '7'
    """, nativeQuery = true)
    Page<Request> findAllRequestThatArePendingYet(@Param("orgCode") Integer orgCode, Pageable pageable);
}
