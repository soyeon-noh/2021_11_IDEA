package com.callor.jc.repository;

import com.callor.jc.models.BookVO;
import com.callor.jc.repository.sql.BookSQL;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface BookDao {

    @Select("SELECT * FROM tbl_members")
    public List<BookVO> selectAll();

    @Insert(BookSQL.book_insert_sql)
    public int insert(BookVO bookVO);

    // BookSQL이라는 클래스에 있는 book_update_sql method가 return한 코드를 사용하여 update하라
    @UpdateProvider(type = BookSQL.class, method = "book_upate_sql")
    public int update(BookVO bookVO);

    @Delete("DELETE FROM tbl_members WHERE username= #{isbn}")
    public int delete(String isbn);

}