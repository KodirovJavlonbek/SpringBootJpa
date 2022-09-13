package com.ridemoon.week03.service;

import com.ridemoon.week03.domain.Memo;
import com.ridemoon.week03.domain.MemoRepository;
import com.ridemoon.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;


    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo= memoRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("없는 id")
        );
        memo.update(requestDto);
        return id;

    }

}
