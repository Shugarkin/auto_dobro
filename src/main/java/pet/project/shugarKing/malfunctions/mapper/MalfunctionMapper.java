package pet.project.shugarKing.malfunctions.mapper;

import lombok.experimental.UtilityClass;
import pet.project.shugarKing.malfunctions.dto.MalfunctionResponseDto;
import pet.project.shugarKing.malfunctions.dto.NewMalfunction;
import pet.project.shugarKing.malfunctions.model.Malfunctions;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MalfunctionMapper {

    public Malfunctions toMalfunction(NewMalfunction malfunctionDto) {
        return Malfunctions.builder()
                .malfunction(malfunctionDto.getMalfunction())
                .type(malfunctionDto.getType())
                .build();
    }

    public MalfunctionResponseDto toMalfunctionResponseDto(Malfunctions malfunctions) {
        return  MalfunctionResponseDto.builder()
                .dateTime(malfunctions.getCreateOn())
                .malfunction(malfunctions.getMalfunction())
                .type(malfunctions.getType())
                .build();
    }

    public List<MalfunctionResponseDto> toListMalfunctionResponseDto(List<Malfunctions> list) {
        return list.stream().map(MalfunctionMapper::toMalfunctionResponseDto).collect(Collectors.toList());
    }
}
