package cn.luischen.service.book.impl;

import cn.luischen.dao.BookMapper;
import cn.luischen.model.Book;
import cn.luischen.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述：
 * Author: 符伟荣 【wr.fu@vdyoo.com】
 * Date: 2018/9/3
 */
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

//    @Autowired
//    private BookMapper bookService;

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }
}
