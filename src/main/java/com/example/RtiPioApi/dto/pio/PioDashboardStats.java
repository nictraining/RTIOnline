package com.example.RtiPioApi.dto.pio;

public class PioDashboardStats {
    private Integer appealsRaised;
    private Integer rtiRequestsUnderProcess;
    private Integer pendingForDisposedOff; // Sum of <=10 Days and <=5 Days from general dashboard section
    private Integer pendingMoreThan20Days; // Specific to "PENDING FOR DISPOSED OFF" widget in PIO_Dashboard_API_Documentation
    private Integer toBeDisposedWithin5Days; // Specific to "PENDING FOR DISPOSED OFF" widget in PIO_Dashboard_API_Documentation
    private Integer disposed;
    private Integer newRequests;
    private Integer additionalPaymentDemanded;
    private Integer additionalPaymentReceived;
    private Integer thirdPartyInfoRequired;
    private Integer documentsCalled;
    private Integer documentsReceived;
    private Integer forwardedToDpio;
    private Integer repliesFromDpio;
    private Integer newAcknowledgementsFromDpio;
    private Integer commentsSoughtByAa;
    private Integer commentsGivenByPio;
    private Integer totalRequests;
    private Integer totalRequestsDisposed;
    private Integer totalRequestsPending;
    private Integer totalAppealsRaised;
    private Integer totalAppealsDisposed;


    public PioDashboardStats() {

        this.appealsRaised = 0;
        this.rtiRequestsUnderProcess = 0;
        this.pendingForDisposedOff = 0;
        this.pendingMoreThan20Days = 0;
        this.toBeDisposedWithin5Days = 0;
        this.disposed = 0;
        this.newRequests = 0;
        this.additionalPaymentDemanded = 0;
        this.additionalPaymentReceived = 0;
        this.thirdPartyInfoRequired = 0;
        this.documentsCalled = 0;
        this.documentsReceived = 0;
        this.forwardedToDpio = 0;
        this.repliesFromDpio = 0;
        this.newAcknowledgementsFromDpio = 0;
        this.commentsSoughtByAa = 0;
        this.commentsGivenByPio = 0;
        this.totalRequests = 0;
        this.totalRequestsDisposed = 0;
        this.totalRequestsPending = 0;
        this.totalAppealsRaised = 0;
        this.totalAppealsDisposed = 0;
    }

    // Getters and Setters for all fields
    public Integer getAppealsRaised() {
        return appealsRaised;
    }

    public void setAppealsRaised(Integer appealsRaised) {
        this.appealsRaised = appealsRaised;
    }

    public Integer getRtiRequestsUnderProcess() {
        return rtiRequestsUnderProcess;
    }

    public void setRtiRequestsUnderProcess(Integer rtiRequestsUnderProcess) {
        this.rtiRequestsUnderProcess = rtiRequestsUnderProcess;
    }

    public Integer getPendingForDisposedOff() {
        return pendingForDisposedOff;
    }

    public void setPendingForDisposedOff(Integer pendingForDisposedOff) {
        this.pendingForDisposedOff = pendingForDisposedOff;
    }

    public Integer getDisposed() {
        return disposed;
    }

    public void setDisposed(Integer disposed) {
        this.disposed = disposed;
    }

    public Integer getNewRequests() {
        return newRequests;
    }

    public void setNewRequests(Integer newRequests) {
        this.newRequests = newRequests;
    }

    public Integer getPendingMoreThan20Days() {
        return pendingMoreThan20Days;
    }

    public void setPendingMoreThan20Days(Integer pendingMoreThan20Days) {
        this.pendingMoreThan20Days = pendingMoreThan20Days;
    }

    public Integer getToBeDisposedWithin5Days() {
        return toBeDisposedWithin5Days;
    }

    public void setToBeDisposedWithin5Days(Integer toBeDisposedWithin5Days) {
        this.toBeDisposedWithin5Days = toBeDisposedWithin5Days;
    }

    public Integer getAdditionalPaymentDemanded() {
        return additionalPaymentDemanded;
    }

    public void setAdditionalPaymentDemanded(Integer additionalPaymentDemanded) {
        this.additionalPaymentDemanded = additionalPaymentDemanded;
    }

    public Integer getAdditionalPaymentReceived() {
        return additionalPaymentReceived;
    }

    public void setAdditionalPaymentReceived(Integer additionalPaymentReceived) {
        this.additionalPaymentReceived = additionalPaymentReceived;
    }

    public Integer getThirdPartyInfoRequired() {
        return thirdPartyInfoRequired;
    }

    public void setThirdPartyInfoRequired(Integer thirdPartyInfoRequired) {
        this.thirdPartyInfoRequired = thirdPartyInfoRequired;
    }

    public Integer getDocumentsCalled() {
        return documentsCalled;
    }

    public void setDocumentsCalled(Integer documentsCalled) {
        this.documentsCalled = documentsCalled;
    }

    public Integer getDocumentsReceived() {
        return documentsReceived;
    }

    public void setDocumentsReceived(Integer documentsReceived) {
        this.documentsReceived = documentsReceived;
    }

    public Integer getForwardedToDpio() {
        return forwardedToDpio;
    }

    public void setForwardedToDpio(Integer forwardedToDpio) {
        this.forwardedToDpio = forwardedToDpio;
    }

    public Integer getRepliesFromDpio() {
        return repliesFromDpio;
    }

    public void setRepliesFromDpio(Integer repliesFromDpio) {
        this.repliesFromDpio = repliesFromDpio;
    }

    public Integer getNewAcknowledgementsFromDpio() {
        return newAcknowledgementsFromDpio;
    }

    public void setNewAcknowledgementsFromDpio(Integer newAcknowledgementsFromDpio) {
        this.newAcknowledgementsFromDpio = newAcknowledgementsFromDpio;
    }

    public Integer getCommentsSoughtByAa() {
        return commentsSoughtByAa;
    }

    public void setCommentsSoughtByAa(Integer commentsSoughtByAa) {
        this.commentsSoughtByAa = commentsSoughtByAa;
    }

    public Integer getCommentsGivenByPio() {
        return commentsGivenByPio;
    }

    public void setCommentsGivenByPio(Integer commentsGivenByPio) {
        this.commentsGivenByPio = commentsGivenByPio;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Integer totalRequests) {
        this.totalRequests = totalRequests;
    }

    public Integer getTotalRequestsDisposed() {
        return totalRequestsDisposed;
    }

    public void setTotalRequestsDisposed(Integer totalRequestsDisposed) {
        this.totalRequestsDisposed = totalRequestsDisposed;
    }

    public Integer getTotalRequestsPending() {
        return totalRequestsPending;
    }

    public void setTotalRequestsPending(Integer totalRequestsPending) {
        this.totalRequestsPending = totalRequestsPending;
    }

    public Integer getTotalAppealsRaised() {
        return totalAppealsRaised;
    }

    public void setTotalAppealsRaised(Integer totalAppealsRaised) {
        this.totalAppealsRaised = totalAppealsRaised;
    }

    public Integer getTotalAppealsDisposed() {
        return totalAppealsDisposed;
    }

    public void setTotalAppealsDisposed(Integer totalAppealsDisposed) {
        this.totalAppealsDisposed = totalAppealsDisposed;
    }
}
