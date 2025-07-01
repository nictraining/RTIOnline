
 INTO users (user_id, username, password, role, public_authority, login_active) VALUES
('adminUser', 'admin', '$2a$10$w/sB.6yI3bL6o.c.B.4Q3u.mQ5C.gG.1F.l.c.0R.0Q.1X.b.x.9', 'Admin', 'General Administration (AR)', 'Y'), -- password: admin123 (BCrypt hash)
('PIO001', 'pio', '$2a$10$P1W5eG.wK/p3J.c.D.5I.9u.2B.v.T.7J.x.Y.g.7X.n.w.3X.q.6', 'PIO', 'Tripura Public Service Commission', 'Y'), -- password: pio123 (BCrypt hash)
('NODAL001', 'nodal', '$2a$10$Q4X7h.mO8g.t.r.s.C.0E.2D.v.T.6L.x.Z.k.2Y.o.4Z.r.7', 'Nodal', 'Tripura Public Service Commission', 'Y'), -- password: nodal123 (BCrypt hash)
('FAA001', 'faa', '$2a$10$S9Z3f.jP2a.x.y.w.A.1E.7V.u.X.z.k.3P.c.r.t.4V.o.9X.s.8', 'FAA', 'Agriculture', 'Y'), -- password: faa123 (BCrypt hash)
('citizenUser', 'citizen', '$2a$10$V8N1g.kH7p.o.j.i.L.4U.0X.q.W.e.x.2M.v.B.u.7P.z.2S.t.1', 'Citizen', 'N/A', 'Y'); -- password: citizen123 (BCrypt hash)
9
        -- Insert dummy PIO Details (for 'PioDetails' entity)
-- Note: 'pio_id' in this table should match a 'user_id' from the 'users' table for PIO roles.
INSERT INTO pio_details (pio_id, pio_code, pio_name, active_idle) VALUES
('PIO001', 'PIOCD001', 'Shri ABC PIO', 'Y'),
        ('PIO002', 'PIOCD002', 'Smt. XYZ PIO', 'Y');

        -- Insert dummy RTI Applications
INSERT INTO rti_applications (registration_no, applicant_name, gender, address, pincode, state, district, country, educational_status, phone_number, mobile_number, email_id, citizenship, below_poverty_line, amount_paid, concerns_life_or_liberty, text_for_rti_request, supporting_document_url, public_authority_department, type_of_receipt, language, request_status, current_action_status, pio_id, recvd_date, entry_date, closing_date, response_details, reply_document_url, document_id) VALUES
('RTI/2025/00001', 'Ravi Kumar', 'Male', '123 Gandhi Marg', '799001', 'Tripura', 'West Tripura', 'India', 'Graduate', '9876543210', '9876543210', 'ravi.k@example.com', 'Indian', FALSE, 10.0, FALSE, 'Details on public health initiatives.', NULL, 'Health Department', 'Online', 'English', 'N', '4L', 'PIO001', '2025-06-01', '2025-06-01 10:00:00', NULL, NULL, NULL, 'DOC001'),
        ('RTI/2025/00002', 'Priya Sharma', 'Female', '456 Nehru Road', '799002', 'Tripura', 'North Tripura', 'India', 'Literate', '9988776655', '9988776655', 'priya.s@example.com', 'Indian', TRUE, 0.0, FALSE, 'Information about local road construction.', NULL, 'Public Works Department', 'Manual', 'English', 'P', '4C', 'PIO001', '2025-05-10', '2025-05-10 11:00:00', NULL, NULL, NULL, 'DOC002'),
        ('RTI/2025/00003', 'Alok Mehta', 'Male', '789 Lake View', '799003', 'Tripura', 'South Tripura', 'India', 'Illiterate', FALSE, 10.0, FALSE, 'Data on recent government procurements.', '9000000000', '9000000000', 'alok.m@example.com', 'Indian', FALSE, 10.0, FALSE, 'Data on recent government procurements.', NULL, 'Finance Department', 'Online', 'Hindi', 'D', '4D', 'PIO001', '2025-04-20', '2025-04-20 09:00:00', '2025-05-15 14:30:00', 'Information provided as per records.', 'http://localhost:8080/files/reply_RTI202500003.pdf', NULL),
        ('RTI/2025/00004', 'Kavita Singh', 'Female', '101 MG Road', '799001', 'Tripura', 'West Tripura', 'India', 'Graduate', '9123456789', '9123456789', 'kavita.s@example.com', 'Indian', FALSE, 10.0, FALSE, 'Details regarding school admission policies.', NULL, 'Education Department', 'Online', 'English', 'P', '4M', 'PIO002', '2025-06-10', '2025-06-10 12:00:00', NULL, NULL, NULL, NULL),
        ('RTI/2025/00005', 'Sameer Khan', 'Male', '22B Airport Road', '799004', 'Tripura', 'Dhalai', 'India', 'Post Graduate', FALSE, 10.0, FALSE, 'Information on smart city project progress.', '8899887766', '8899887766', 'sameer.k@example.com', 'Indian', FALSE, 10.0, FALSE, 'Information on smart city project progress.', NULL, 'Urban Development', 'Online', 'English', 'P', '30', 'PIO002', '2025-05-01', '2025-05-01 09:30:00', NULL, NULL, NULL, NULL);

        -- Insert dummy RTI Appeals
INSERT INTO rti_appeals (registration_no, request_no, appeal_filing_date, appellant_name, status, ground_of_appeal, prayer_or_relief, closing_date, cpio_app, org_code) VALUES
('APP/2025/00001', 'RTI/2025/00003', '2025-05-20 10:00:00', 'Alok Mehta', 'Pending', 'Incomplete information provided.', 'Provide full details of all procurements.', NULL, 'PIOCD001', 'ORG001'),
        ('APP/2025/00002', 'RTI/2025/00001', '2025-06-10 14:00:00', 'Ravi Kumar', 'Pending', 'Response not received within stipulated time.', 'Provide the requested details immediately.', NULL, 'PIOCD001', 'ORG001');

        -- Insert dummy Additional Payments
INSERT INTO additional_payment (registration_no, amount_demanded, amount_received, demand_date, received_date, paid) VALUES
('RTI/2025/00002', 50.0, NULL, '2025-05-20 10:00:00', NULL, 'N'),
        ('RTI/2025/00004', 20.0, 20.0, '2025-06-15 11:00:00', '2025-06-18 10:00:00', 'Y');

        -- Insert dummy Comments CPIO
INSERT INTO comments_cpio (registration_no, flag, comment_date, comments) VALUES
('APP/2025/00001', 'S', '2025-05-25 09:00:00', 'Comments sought from PIO regarding appeal APP/2025/00001.'),
        ('APP/2025/00001', 'R', '2025-05-28 15:00:00', 'PIO has provided detailed comments for appeal APP/2025/00001.'),
        ('RTI/2025/00002', 'S', '2025-05-12 10:00:00', 'Comments sought by AA for RTI/2025/00002. ');

        -- Insert dummy Deemed PIO entries
INSERT INTO deemed_pio (registration_no, dpio_code, forward_date, flag, reply_date, reply_content, reply_filename) VALUES
('RTI/2025/00001', 'DPIO001', '2025-06-05 11:00:00', 'S', NULL, NULL, NULL),
        ('RTI/2025/00002', 'DPIO002', '2025-05-15 09:00:00', 'R', '2025-05-28 14:00:00', 'DPIO has provided the requested information.', 'dpio_reply_RTI202500002.pdf');

        -- Insert dummy Reminder DPIO entries
INSERT INTO reminder_dpio (registration_no, dpio_id, pio_id, reminder_date, reply) VALUES
('RTI/2025/00001', 'DPIO001', 'PIO001', '2025-06-15 10:00:00', 'Acknowledged receipt of reminder. Will reply soon.'),
        ('RTI/2025/00005', 'DPIO003', 'PIO002', '2025-05-10 11:00:00', 'Acknowledgment for query on smart city.');
