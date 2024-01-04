package com.example.java_mini_project.controller;
import com.example.java_mini_project.domain.Memo;
import com.example.java_mini_project.domain.MemoRepository;
import com.example.java_mini_project.model.MemoRequestDto;
import com.example.java_mini_project.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        return this.memoService.create(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getAllMemo() {
        return this.memoService.findAllMemo();
    }

    @PutMapping("/api/memos/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return this.memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Boolean deleteMemo(@PathVariable Long id) {
        return this.memoService.delete(id);
    }
}
