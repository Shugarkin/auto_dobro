package pet.project.shugarKing.malfunctions;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pet.project.shugarKing.malfunctions.dto.NewMalfunctionDto;

@RestController
@Validated
public class MalfunctionController {



    @GetMapping("/test")
    public void test(@RequestBody NewMalfunctionDto newMalfunctionDto) {

        NewMalfunctionDto asd = newMalfunctionDto;
    }
}
