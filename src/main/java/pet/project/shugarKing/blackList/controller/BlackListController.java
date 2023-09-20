package pet.project.shugarKing.blackList.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pet.project.shugarKing.blackList.model.BlackList;
import pet.project.shugarKing.blackList.service.BlackListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users/blackList")
public class BlackListController {

    private final BlackListService service;

    @PostMapping
    public BlackList createBlock(@RequestBody BlackList blackList) {
        BlackList block = service.createBlock(blackList);
        return block;
    }

    @DeleteMapping("/{userId}/unBlock/{bookedId}")
    public String deleteBlock(@PathVariable long userId, @PathVariable long bookedId) {
        return service.deleteBlock(userId, bookedId);
    }

    @GetMapping("/{userId}")
    public List<BlackList> getList(@PathVariable long userId) {
        List<BlackList> list = service.getList(userId);
        return list;
    }

}
