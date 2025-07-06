package com.rtimis.dashboardapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "appeal", schema = "rtimis")
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userCode;

    private LocalDate recvdDate;

    private String astatus;

    private LocalDate closingDate;

    private LocalDate dispatchDate;

    // Getters and Setters
}

