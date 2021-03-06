package com.demo.domain.service;

import com.demo.domain.dto.PostBoardRequestDto;
import com.demo.domain.entity.BoardEntity;
import com.demo.domain.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    Logger logger = LoggerFactory.getLogger(BoardService.class);

    @Override
    public List<BoardEntity> selectBoardList() throws Exception {
        return boardRepository.findAll();
    }
    @Override
    public BoardEntity selectBoardDetail(long id) throws Exception {
//        Optional<BoardEntity> optional = boardRepository.findById(id);
        Optional<BoardEntity> optional = boardRepository.findById(id);
        if (optional.isPresent()) {
            logger.info("==========================");
            BoardEntity boardEntity = optional.get();
            boardEntity.setHitcnt(boardEntity.getHitcnt()+1);
            boardRepository.save(boardEntity);
//            PostBoardRequestDto  board = new PostBoardRequestDto();
//            logger.info(boardEntity.getHitcnt()+"");
//            count 증가
//            board.setId(boardEntity.getId());
//            board.setHitcnt(boardEntity.getHitcnt()+1);
//            boardRepository.save(board.toEntity());
//            logger.info(boardEntity.getHitcnt()+"");
//            boardEntity.setHitcnt(boardEntity.getHitcnt()+1);
            logger.info("==========================");

            return boardEntity;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void saveBoard(BoardEntity board) throws Exception {
        logger.info("board log");
        logger.info("====================");
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(long id) {
        boardRepository.deleteById( id);
    }

    @Override
    public void deleteAll(){ boardRepository.deleteAll();};
}


