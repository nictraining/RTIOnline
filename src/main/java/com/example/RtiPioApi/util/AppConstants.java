package com.example.RtiPioApi.util;

public class AppConstants {


    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_PIO = "PIO";
    public static final String ROLE_NODAL = "NODAL";
    public static final String ROLE_FAA = "FAA";
    public static final String ROLE_CITIZEN = "CITIZEN";


    public static final String REQUEST_STATUS_NEW = "N"; // New
    public static final String REQUEST_STATUS_PENDING = "P"; // Pending
    public static final String REQUEST_STATUS_ON_HOLD = "H"; // On Hold
    public static final String REQUEST_STATUS_COMPLIANCE = "C"; // Compliance
    public static final String REQUEST_STATUS_FORWARDED = "F"; // Forwarded
    public static final String REQUEST_STATUS_DISPOSED_OFF = "D"; // Disposed Off (using 'D' as a general disposed status)



    public static final String CURRENT_ACTION_STATUS_NEW_L = "4L";
    public static final String CURRENT_ACTION_STATUS_REJECTED = "4C";
    public static final String CURRENT_ACTION_STATUS_DISPOSED = "4D";
    public static final String CURRENT_ACTION_STATUS_READY_FOR_DISPOSE = "30";
    public static final String CURRENT_ACTION_STATUS_THIRD_PARTY_INFO = "4M";
    public static final String CURRENT_ACTION_STATUS_DOC_CALL = "4C";
    public static final String CURRENT_ACTION_STATUS_DOC_RECEIVED = "4E";


    public static final String PIO_ACTIVE_STATUS_Y = "Y";


    public static final String PAYMENT_PAID_Y = "Y";
    public static final String PAYMENT_PAID_N = "N";


    public static final String DPIO_FLAG_NEW = "N"; // New entry
    public static final String DPIO_FLAG_FORWARDED_SENT = "S"; // Forwarded/Sent to DPIO
    public static final String DPIO_FLAG_REPLY_RECEIVED = "R"; // Reply received from DPIO


    public static final String COMMENTS_FLAG_SOUGHT = "S"; // Comments sought by Appellate Authority
    public static final String COMMENTS_FLAG_REPLIED = "R"; // Comments replied by PIO


    public static final String RECORD_TYPE_PENDING_20_DAYS = "PENDING_20_DAYS";
    public static final String RECORD_TYPE_NEW = "NEW";
    public static final String RECORD_TYPE_UNDER_PROCESS = "UNDER_PROCESS";
    public static final String RECORD_TYPE_DISPOSED_IN_5_DAYS = "DISPOSED_IN_5_DAYS";
    public static final String RECORD_TYPE_ADDITIONAL_PAYMENT_DEMANDED = "ADDITIONAL_PAYMENT_DEMANDED";
    public static final String RECORD_TYPE_ADDITIONAL_PAYMENT_RECEIVED = "ADDITIONAL_PAYMENT_RECEIVED";
    public static final String RECORD_TYPE_THIRD_PARTY_INFO_REQUIRED = "THIRD_PARTY_INFO_REQUIRED";
    public static final String RECORD_TYPE_DOC_CALL = "DOC_CALL";
    public static final String RECORD_TYPE_DOC_RECVD = "DOC_RECVD";
    public static final String RECORD_TYPE_FORWARDED_DPIO = "FORWARDED_DPIO";
    public static final String RECORD_TYPE_REPLY_DPIO = "REPLY_DPIO";
    public static final String RECORD_TYPE_ACK_DPIO = "ACK_DPIO";
    public static final String RECORD_TYPE_COMMENTS_SOUGHT_BY_AA = "COMMENTS_SOUGHT_BY_AA";
    public static final String RECORD_TYPE_COMMENTS_GIVEN_BY_PIO = "COMMENTS_GIVEN_BY_PIO";


    private AppConstants() {
        // Utility class
    }
}
