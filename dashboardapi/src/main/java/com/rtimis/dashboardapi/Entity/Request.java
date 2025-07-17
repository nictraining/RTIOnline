package com.rtimis.dashboardapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request", schema = "rtimis")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userCode;

    private LocalDate recvdDate;

    private String requestStatus;

    private LocalDate closingDate;

    private LocalDate dispatchDate;

    // Getters and Setters
}
