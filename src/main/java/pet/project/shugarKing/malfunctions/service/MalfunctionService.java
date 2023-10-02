package pet.project.shugarKing.malfunctions.service;

import pet.project.shugarKing.car.dto.NewCarDto;
import pet.project.shugarKing.malfunctions.model.Malfunctions;

import java.util.List;

public interface MalfunctionService {
    Malfunctions createMalfunction(long userId, NewCarDto carNumber, Malfunctions malfunction);

    Malfunctions getMalfunction(long userId, long malId);

    List<Malfunctions> getAllMalfunction(long userId);

    String deleteMalfunction(long userId, long malId);

    String deleteAllMalfunctions(long userId);
}
