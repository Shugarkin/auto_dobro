package pet.project.shugarKing.malfunctions.dto;

import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;
import pet.project.shugarKing.malfunctions.type.MalfunctionType;

import java.time.LocalDateTime;

@Data
@Builder
public class MalfunctionResponseDto {

    private LocalDateTime dateTime;

    private MalfunctionType type;

    private AllMalfunction malfunction;
}
