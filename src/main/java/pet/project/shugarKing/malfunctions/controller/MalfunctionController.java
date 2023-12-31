package pet.project.shugarKing.malfunctions.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.malfunctions.dto.MalfunctionResponseDto;
import pet.project.shugarKing.malfunctions.dto.NewMalfunction;
import pet.project.shugarKing.malfunctions.dto.NewMalfunctionDto;
import pet.project.shugarKing.malfunctions.mapper.MalfunctionMapper;
import pet.project.shugarKing.malfunctions.model.Malfunctions;
import pet.project.shugarKing.malfunctions.service.MalfunctionService;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("users/{userId}/malfunction")
public class MalfunctionController {

    public final MalfunctionService service;

    @PostMapping
    public MalfunctionResponseDto createMalfunction(@PathVariable long userId, @Valid @RequestBody NewMalfunctionDto newMalfunctionDto) {
        Malfunctions malfunctions = service.createMalfunction(userId, newMalfunctionDto.getCarNumber(),
                MalfunctionMapper.toMalfunction(newMalfunctionDto.getMal()));
        return MalfunctionMapper.toMalfunctionResponseDto(malfunctions);
    }

    @GetMapping("/{malId}")
    public MalfunctionResponseDto getMalfunction(@PathVariable long userId, @PathVariable long malId) {
        Malfunctions malfunctions = service.getMalfunction(userId, malId);
        return MalfunctionMapper.toMalfunctionResponseDto(malfunctions);
    }

    @GetMapping("/all")
    public List<MalfunctionResponseDto> getAllMalfunction(@PathVariable long userId) {
        List<Malfunctions> list = service.getAllMalfunction(userId);
        return MalfunctionMapper.toListMalfunctionResponseDto(list);
    }

    @DeleteMapping("/{malId}")
    public String deleteMalfunction(@PathVariable long userId, @PathVariable long malId) {
        return service.deleteMalfunction(userId, malId);
    }

    @DeleteMapping("/all")
    public String deleteAllMalfunctions(@PathVariable long userId) {
        return service.deleteAllMalfunctions(userId);
    }
}
