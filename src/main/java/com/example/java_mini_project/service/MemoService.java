package com.example.java_mini_project.service;

import com.example.java_mini_project.domain.Memo;
import com.example.java_mini_project.domain.MemoRepository;
import com.example.java_mini_project.model.MemoRequestDto;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.View;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public Memo create(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto.getUsername(), requestDto.getContents());

        return this.memoRepository.save(memo);
    }

    public List<Memo> findAllMemo() {
        return this.memoRepository.findAll();
    }

    @Transactional
    public Memo update(Long id, MemoRequestDto requestDto) {
        Memo memo = this.memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        memo.update(requestDto);

        return this.memoRepository.save(memo);
    }

    public boolean delete(Long id) {
        this.memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        this.memoRepository.deleteById(id);
        return true;
    }

}
