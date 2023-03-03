package org.msy.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 11612
 * @date 2023/3/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuzzyQuery {
    private String fuzzyName;
    private String fuzzyPhone;
    private String fuzzyCpcOrigin;
    private String fuzzyParty;
    private String fuzzyCpcWorkType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date endDate;
}
