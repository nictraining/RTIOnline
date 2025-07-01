package com.example.RtiPioApi.dto.pio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class DisposeRequestDTO {
    @NotBlank(message = "Response details cannot be empty")
    @Size(max = 2000, message = "Response details must be less than or equal to 2000 characters")
    private String responseDetails;


    private String replyDocumentUrl;

    public String getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public String getReplyDocumentUrl() {
        return replyDocumentUrl;
    }

    public void setReplyDocumentUrl(String replyDocumentUrl) {
        this.replyDocumentUrl = replyDocumentUrl;
    }
}

