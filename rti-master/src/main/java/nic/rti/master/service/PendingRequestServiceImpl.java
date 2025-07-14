package nic.rti.master.service;

import nic.rti.master.dao.RequestRepository;
import nic.rti.master.dto.PendingRequestsDTO;
import nic.rti.master.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Function;

@Service
public class PendingRequestServiceImpl implements PendingRequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Page<PendingRequestsDTO> getPendingRequests(int orgCode, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "entry_date"));

        Page<Request> requests = requestRepository.findAllRequestThatArePendingYet(orgCode,pageable);

        return requests.map(toDTO());
    }

    @Override
    public Request saveRequest(Request dto) {
         return requestRepository.save(dto);
    }

    private Function<Request, PendingRequestsDTO> toDTO() {
        return req -> {
            PendingRequestsDTO dto = new PendingRequestsDTO();
            dto.setRegistrationNo(req.getRegistrationNo());
            dto.setName(req.getName());
            dto.setReceivedDate(req.getRecvdDate().toLocalDate());
            dto.setEntryDate(req.getEntryDate());
            return dto;

        };
    }
}
