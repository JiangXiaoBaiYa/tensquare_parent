package entity;

/**
 * @Author: 姜光明
 * @Date: 2019/8/14 22:22
 */

import java.util.List;

/**
 * 分页结果类
 *
 * @param <T>
 */
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
