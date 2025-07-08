package nic.rti.master.dto;
import lombok.Data;

@Data
public class PaginationDTO {
    private Integer limit;
    private Integer offset;
    private Long totalCount;
    private Boolean hasMore;

    //constructor
    public PaginationDTO(Integer limit, Integer offset, Long totalCount, Boolean hasMore) {
        this.limit = limit;
        this.offset = offset;
        this.totalCount = totalCount;
        this.hasMore = hasMore;
    }

}
