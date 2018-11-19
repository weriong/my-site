package cn.luischen.dao;

import cn.luischen.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    /**
     * 存入Book
     * @param record
     * @return
     */
    int insert(Book record);

    /**
     * 根据Book的Id来查询数据
     * @param id
     * @return
     */
    Book getBookById(@Param("id") String id);

    /**
     * 根据标题的模糊查询
     * @param title
     * @return
     */
    List<Book> findBookByLikeTitle(@Param("title") String title);

}