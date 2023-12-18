package com.ll.medium_mission.post.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PostResponse(
        Long id,
        String content,
        String title,
        String author,
        Long recommendCount,
        LocalDateTime createDate,
        LocalDateTime modifiedDate){
}
