package pet.project.shugarKing.malfunctions.mapper;

import lombok.experimental.UtilityClass;
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

    public NewMalfunction toNewMalfunction(Malfunctions malfunctions) {
        return NewMalfunction.builder()
                .malfunction(malfunctions.getMalfunction())
                .type(malfunctions.getType())
                .build();
    }

    public List<NewMalfunction> toListNewMalfunction(List<Malfunctions> list) {
        return list.stream().map(MalfunctionMapper::toNewMalfunction).collect(Collectors.toList());
    }
}
