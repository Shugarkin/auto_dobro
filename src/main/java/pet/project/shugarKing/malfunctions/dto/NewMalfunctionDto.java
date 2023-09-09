package pet.project.shugarKing.malfunctions.dto;

import lombok.Builder;
import lombok.Data;
import pet.project.shugarKing.malfunctions.type.AllMalfunction;
import pet.project.shugarKing.malfunctions.type.MalfunctionType;

@Data
@Builder
public class NewMalfunctionDto {

    private MalfunctionType type;

    private AllMalfunction malfunction;
}
